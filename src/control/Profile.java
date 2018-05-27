package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Connect;
import model.content;
import model.menu;
import service.ExportExcel;

@WebServlet("/Profile")
public class Profile extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private static Connection con;
	private static Statement st;
	private String remember;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String username = "";
		String id = "";
		String export = "ex";
		username = (String) session.getAttribute("username");
		id = (String) session.getAttribute("iduser");
		if (username == null || username.equals("")) {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}

		else {
				List<menu> listContentM = listContentM(username,id);

				export = (String) req.getParameter("export");
				if (export != null && export.equals("excel")) {
					// if (export.equals("excel")) {
					String from = (String) req.getParameter("date_fr");
					String to = (String) req.getParameter("date_to");
					if(from.isEmpty()) from="1970-01-01";
					if(to.isEmpty()) to ="9999-01-01";
					ExportExcel c = new ExportExcel();
					c.ExportFile(from,to);
					// }
				}
				req.setAttribute("listContM", listContentM);
				req.getRequestDispatcher("/WEB-INF/jsp/accout.jsp").forward(req, resp);
			}
		}

	private List<menu> listContentM(String username,String id) {
		String c = "";
		if (!username.equals("admin"))
			c = "JOIN accout ON content.author = accout.hoten where accout.username = '" + id + "' ";
		List<menu> listContM = new ArrayList<menu>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "SELECT content.idtin,menu.menu, menu.idsupport, menu.idmenu, content.summary,content.ten "
					+ "FROM menu JOIN content ON menu.idmenu = content.idmenu " + c;

			Statement st = connection.createStatement();
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
