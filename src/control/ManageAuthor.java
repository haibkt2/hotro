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

@WebServlet(urlPatterns = { "/ManageAccount" })
public class ManageAuthor extends HttpServlet {

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
//		List<notify> listNotyfy;
//		listNotyfy = listNotify();
		String add_user = req.getParameter("add_user");
		if(add_user != null) 
			req.setAttribute("add_sp", add_user);
		String mess_del = req.getParameter("mss_del");
		if(mess_del != null) 
			req.setAttribute("mss_del", mess_del);
		req.setAttribute("listAc", listAc());
		req.getRequestDispatcher("/WEB-INF/jsp/manageauthor.jsp").forward(req, resp);
	}

	private List<account> listAc() {
		List<account> listAc = new ArrayList<account>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "SELECT username,hoten,role FROM accout";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString(1);
				String hoten = rs.getString(2);
				String role = rs.getString(3);
				account ac = new account(username, hoten,role);
				listAc.add(ac);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listAc;

	}

}
