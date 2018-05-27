package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Connect;
import model.*;

@WebServlet(urlPatterns = { "/Search" })
public class Search extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Search() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession ss = req.getSession();
		String nameCt = req.getParameter("ten");
		if (nameCt == null)
			nameCt = "";
		String idU = (String) ss.getAttribute("iduser");
		String user = (String) ss.getAttribute("username");
		String accout = req.getParameter("accout");
		
		List<menu> listContentM = null;
		if (accout != null) {
			if (accout.equals("search"))
				listContentM = listContentM(idU, nameCt,user);
			req.setAttribute("listContM", listContentM);
			req.getRequestDispatcher("/WEB-INF/jsp/accout.jsp").forward(req, resp);
		} else {
			String nt = req.getParameter("notify");
			// listNotyfy = listNotify();
			if (nt != null) {
				List<notify> listNt = listNotify(nameCt);
				req.setAttribute("listCon", listNt);
				req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
			} else {
				List<content> listContent = listContent(nameCt);
				req.setAttribute("listCon", listContent);
				req.getRequestDispatcher("/WEB-INF/jsp/content.jsp").forward(req, resp);
			}
		}
	}

	private List<content> listContent(String nameCt) {

		List<content> listContent = new ArrayList<content>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select idtin, ten, author, summary from content where"
					+ " (ten LIKE '%"+nameCt+"%')"
					+ " OR (author LIKE '%"+nameCt+"%')"
					+ " OR (summary LIKE '%"+nameCt+"%')";
			System.out.println(sql);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idtin = rs.getInt(1);
				String ten = rs.getString(2);
				String author = rs.getString(3);
				String summary = rs.getString(4);
				content content = new content(idtin, ten, author, summary);
				listContent.add(content);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listContent;
	}

	private List<notify> listNotify(String nameCt) {

		List<notify> listNotify = new ArrayList<notify>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "SELECT idNoti,content,notify.date,author,title,file FROM notify " + "WHERE (content LIKE '%"
					+ nameCt + "%') " + "OR (author LIKE '%" + nameCt + "%') " + "OR (date LIKE '%" + nameCt + "%') "
					+ "OR (title LIKE '%" + nameCt + "%') " + "OR (file LIKE '%" + nameCt + "%')";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idtin = rs.getInt(1);
				String content = rs.getString(2);
				Date date = rs.getDate(3);
				String author = rs.getString(4);
				String title = rs.getString(5);
				String file = rs.getString(6);
				notify nt = new notify(idtin, content, date, author, title, file);
				listNotify.add(nt);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listNotify;
	}

	private List<menu> listContentM(String id, String ser,String username) {
		String c = "";
		if (!username.equals("admin"))
			c = "SELECT content.idtin,menu.menu, menu.idsupport, menu.idmenu, content.summary,content.ten "
					+ "FROM menu JOIN content ON menu.idmenu = content.idmenu "
					+ "JOIN accout ON content.author = accout.hoten "
					+ "where (accout.username = '"+id+"') "
					+ "AND ((content.ten LIKE '%"+ser+"%') "
					+ "OR (menu.menu LIKE '%"+ser+"%') "
					+ "OR (content.summary LIKE '%"+ser+"%') "
					+ "OR (content.ten LIKE '%"+ser+"%')) ";
		else
			c = "SELECT content.idtin,menu.menu, menu.idsupport, menu.idmenu, content.summary,content.ten "
					+ "FROM menu JOIN content ON menu.idmenu = content.idmenu "
					+ "where (content.ten LIKE '%"+ser+"%') "
					+ "OR (menu.menu LIKE '%"+ser+"%') "
					+ "OR (content.summary LIKE '%"+ser+"%') "
					+ "OR (content.ten LIKE '%"+ser+"%') ";
		List<menu> listContM = new ArrayList<menu>();
		
		try {
			Connection connection = Connect.getConnection();
			String sql = c;

			Statement st = connection.createStatement();
			System.out.println(sql + ":sssssssss:" + ser);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				String menu = rs.getString(2);
				int idtin = rs.getInt(1);
				int idsp = rs.getInt(3);
				int idmn = rs.getInt(4);
				String summary = rs.getString(5);
				String ten = rs.getString(6);
				menu mn = new menu(menu, idsp, idmn);
				mn.addMenu(new content(idtin, summary, ten));
				listContM.add(mn);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listContM;

	}
}
