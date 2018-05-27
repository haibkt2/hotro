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

@WebServlet("/DeleteCt")
public class DeleteCt extends HttpServlet {

	
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
		String m = req.getParameter("idct");
        int id = Integer.parseInt(m);
        String sql = "DELETE FROM content WHERE idtin='" + id + "'";
        try {
        	Connection connection = Connect.getConnection();
        	Statement st = connection.createStatement();
            st.executeUpdate(sql);
            req.setAttribute("mss_del", "Xóa bài viết thành công");
            req.getRequestDispatcher("/Profile").forward(req, resp);
        } catch (Exception e) {
        }
	}
}
