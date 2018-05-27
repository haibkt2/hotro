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

@WebServlet("/Menu")
public class Menu extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String menu = (String) req.getParameter("menu");
		List<content> listContM = listMenu(menu);
		req.setAttribute("listContM", listContM);
		req.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(req, resp);
	}

	private List<content> listMenu(String menu) {
		List<content> listContM = new ArrayList<content>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "SELECT content.idtin,content.ten, content.summary,content.author FROM content JOIN menu ON content.idmenu = menu.idmenu WHERE menu.menu = '"
					+ menu + "'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idtin = rs.getInt(1);
				String ten = rs.getString(2);
				String summary = rs.getString(3);
				String author = rs.getString(4);
				content content = new content(idtin, ten, author, summary);
				listContM.add(content);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listContM;

	}

}
