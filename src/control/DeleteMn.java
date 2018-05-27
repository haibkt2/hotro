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

@WebServlet("/DeleteMenu")
public class DeleteMn extends HttpServlet {

	
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
		String idmn = req.getParameter("idmn");
        String sql = "DELETE FROM menu WHERE idmenu=" + idmn;
        try {
        	Connection connection = Connect.getConnection();
        	Statement st = connection.createStatement();
            st.executeUpdate(sql);
            req.getRequestDispatcher("/ManageMenu?mss_del=Xóa menu thành công").forward(req, resp);
        } catch (Exception e) {
        }
	}
}
