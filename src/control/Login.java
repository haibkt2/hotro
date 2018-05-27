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
import javax.servlet.http.Cookie;

@WebServlet("/Login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private static Connection con;
	private static Statement st;
	private String remember;

	public boolean Login(String name, String pass, HttpSession session) throws SQLException {
		boolean check_login = true;
		String sql = "SELECT role,username,password,hoten FROM accout WHERE hoten = \"" + name + "\" && password = \"" + pass
				+ "\" ";
		ResultSet rs = st.executeQuery(sql);
		if (!rs.next()) {
			check_login = false;
		} else {
			session.setAttribute("username", rs.getString(1));
			session.setAttribute("hoten", rs.getString(4));
			session.setAttribute("iduser", rs.getString(2));

		}
		return check_login;
	}

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
		username = (String) session.getAttribute("username");
		if (username == null || username.equals("")) {
			try {
				con = Connect.getConnection();
				st = con.createStatement();
				username = req.getParameter("username");
				password = req.getParameter("password");
				if (!Login(username, password, session))
					req.setAttribute("messLg", "Tên đăng nhập hoặc mật khẩu không đúng");
				else {
					String re = req.getParameter("ghi");
					Cookie a = new Cookie("id", username);
					Cookie b = new Cookie("pw", password);
					if (re != null) {
						a.setMaxAge(20000);
						b.setMaxAge(20000);
					} else {
						a.setMaxAge(0);
						b.setMaxAge(0);
					}
					resp.addCookie(a);
					resp.addCookie(b);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		req.getRequestDispatcher("/Profile").forward(req, resp);
	}
}
