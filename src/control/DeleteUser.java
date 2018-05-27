package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Connect;

@WebServlet("/DeleteAccout")
public class DeleteUser extends HttpServlet {

	
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
		String username = req.getParameter("idac");
        String sql = "DELETE FROM accout WHERE username='" + username+"'";
        try {
        	Connection connection = Connect.getConnection();
        	Statement st = connection.createStatement();
            st.executeUpdate(sql);
            req.getRequestDispatcher("/ManageAccount?mss_del=Xóa user thành công").forward(req, resp);
        } catch (Exception e) {
        }
	}
}
