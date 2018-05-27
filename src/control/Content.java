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

import database.Connect;
import model.content;

@WebServlet("/ListContent")
public class Content extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String viewDate = "day";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String md = "";
		String cd = "";
		String mdA = (String) req.getParameter("view_all");
		String mdD = (String) req.getParameter("lt");
		if (mdA != null) {
			md = "1";
		} else if (mdD != null) {
			md = viewDate;
			cd = mdD;
		}
		List<content> listContent = listContent(md, cd);
		req.setAttribute("listCon", listContent);
		req.getRequestDispatcher("/WEB-INF/jsp/content.jsp").forward(req, resp);
	}

	private List<content> listContent(String md, String cd) {
		if (!cd.isEmpty())
			cd = md + " = '" + cd + "'";
		else cd = md;
		List<content> listContent = new ArrayList<content>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select idtin, ten, author, summary from content where " + cd;
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
}
