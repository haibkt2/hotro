package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Connect;

@WebServlet("/Register")
public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String name_login;
	private static String pass;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String register = req.getParameter("register");
		if (register == null || register.isEmpty()) {
			req.setAttribute("mes_reg", "");
			req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
		} else {
			name_login = req.getParameter("id");
			pass = req.getParameter("pass");
			try {
				req.setAttribute("mes_reg", addUser(pass, name_login));
				req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String addUser(String pass, String name_login)
			throws ClassNotFoundException, UnsupportedEncodingException {
		String mes_reg = "";
		Connection connect;
		try {
			connect = Connect.getConnection();
			PreparedStatement pst = connect.prepareStatement("insert into accout values (?,?,?,?)");
			pst.setString(1, idUserMax()+1);
			pst.setString(2, pass);
			pst.setString(3, name_login);
			pst.setString(4, "member");
			pst.executeUpdate();
			mes_reg = "Đăng ký thành công";
		} catch (SQLException e1) {
			mes_reg = "Đăng ký thất bại. Tên đăng ký đã tồn tại";
		}
		return mes_reg;
	}
	private String idUserMax() throws ClassNotFoundException, UnsupportedEncodingException, SQLException {
		String sql = "SELECT max(username) FROM accout";
		String max = "999";
		Connection con = Connect.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			max = rs.getString(1);
		}
		return max;
	}
}