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

@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {



	private static final long serialVersionUID = 1L;
	public static String text;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String add = req.getParameter("addNewUser");
		
		if (add != null)
			req.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp").forward(req, resp);
		else {
			String name_login = req.getParameter("id");
			String pass = req.getParameter("pass");
			String role = req.getParameter("role");
			try {
				req.getRequestDispatcher("/ManageAccount?add_user="+addUser(role, pass, name_login)).forward(req, resp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String addUser(String role, String pass, String name_login)
			throws ClassNotFoundException, UnsupportedEncodingException {
		String mes_reg = "";
		Connection connect;
		try {
			connect = Connect.getConnection();
			PreparedStatement pst = connect.prepareStatement("insert into accout values (?,?,?,?)");
			pst.setString(1, String.valueOf(idUserMax()));
			pst.setString(2, pass);
			pst.setString(3, name_login);
			pst.setString(4, role);
			pst.executeUpdate();
			mes_reg = "Đăng ký thành công";
		} catch (SQLException e1) {
			mes_reg = "Đăng ký thất bại. Tên đăng ký đã tồn tại";
		}
		return mes_reg;
	}
	private int idUserMax() throws ClassNotFoundException, UnsupportedEncodingException, SQLException {
		String sql = "SELECT max(username) FROM accout";
		int max = 999;
		Connection con = Connect.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			max = rs.getInt(1);
		}
		return max + 1;
	}
}
