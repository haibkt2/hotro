package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Connect;

@WebServlet("/Changepasswd")
public class Changepass extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		String change = (String) req.getParameter("change");
		if (change.isEmpty() || change == null) {
			req.getRequestDispatcher("/WEB-INF/jsp/changepassword.jsp").forward(req, resp);
		} else {
			String nameold = (String) session.getAttribute("hoten");
			String username = (String) session.getAttribute("username");
			String name_new = req.getParameter("username");
			String pass = req.getParameter("OldPassword");
			String passNew = req.getParameter("newpassword");
			Login lg = new Login();

			try {
				if (lg.Login(nameold, pass, session)) {
					req.setAttribute("mes_change", updateUser(username, name_new, passNew));
					session.setAttribute("hoten", name_new);
				} else
					req.setAttribute("mes_change", "Pass Nhập không đúng");
				req.getRequestDispatcher("/WEB-INF/jsp/changepassword.jsp").forward(req, resp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public String updateUser(String username, String name_new, String passNew)
			throws ClassNotFoundException, UnsupportedEncodingException {
		String mes_chp = "";
		Connection connect;
		try {
			connect = Connect.getConnection();
			PreparedStatement pst = connect
					.prepareStatement("update accout set hoten = ?, password = ? where username = ?");
			pst.setString(1, name_new);
			pst.setString(2, passNew);
			pst.setString(3, username);
			pst.executeUpdate();
			mes_chp = "Update thành công";
		} catch (SQLException e1) {
			mes_chp = "Update thất bại.";
		}
		return mes_chp;
	}

}