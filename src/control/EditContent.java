package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EditContent")
public class EditContent extends HttpServlet {

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
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		String username = (String) session.getAttribute("username");
		if (username == null || username.equals("")) {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp?fb=").forward(req, resp);
		}

		else {
			String ten = (String) req.getParameter("ten");
			String idmn = (String) req.getParameter("idmn");
			String idsp = (String) req.getParameter("idsp");
			String idct = (String) req.getParameter("idct");
			req.getRequestDispatcher(
					"/WEB-INF/jsp/editcontent.jsp?"
					+ "ten="+ten
					+ "&idmn="+idmn
					+ "&idsp="+idsp
					+ "&idct="+idct)
					.forward(req, resp);
		}

	}

}