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

import database.Connect;
import model.*;

@WebServlet(urlPatterns = { "/Home" })
public class Main extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
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
		List<notify> listNotify;
		listNotify = listNotify();
		req.setAttribute("listCon", listNotify);
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

	private List<notify> listNotify() {
		List<notify> listContent = new ArrayList<notify>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select * from notify";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idtin = rs.getInt(1);
				String content = rs.getString(2);
				Date date = rs.getDate(3);
				String author = rs.getString(4);
				String title = rs.getString(5);
				String file = rs.getString(6);
				notify notify = new notify(idtin, content, date, author,title,file);
				listContent.add(notify);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listContent;

	}

}
