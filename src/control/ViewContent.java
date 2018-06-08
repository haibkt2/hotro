package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Connect;
import model.content;
import service.WriteWord;

@WebServlet("/ViewContent")
public class ViewContent extends HttpServlet {

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
		String idtin = (String) req.getParameter("idtin");
		content ctv = ctv(idtin);
		String exW = (String) req.getParameter("exWord");
		if(exW != null){
			WriteWord ww= new WriteWord();
			String mss = ww.WriteWord(ctv.getTen(),ctv.getNoidung());
		}
		req.setAttribute("ctv", ctv);
		try {
			updateView(idtin);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/jsp/detailcontent.jsp").forward(req, resp);
	}

	private content ctv(String id) {
		content ctv = new content();
		try {
			Connection connection = Connect.getConnection();
			String sql = "SELECT content.idtin,content.ten, content.noidung,content.author,content.file FROM content WHERE idtin = '"
					+ id + "'";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ctv.setIdtin(rs.getInt(1));
				ctv.setTen(rs.getString(2));
				ctv.setNoidung(rs.getString(3));
				ctv.setAuthor(rs.getString(4));
				ctv.setFile(rs.getString(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ctv;
	}

	private void updateView(String idtin) throws ClassNotFoundException {
		Connection connect;
		try {
			connect = Connect.getConnection();
			String sql1 = "Select countview from content where idtin = "+ idtin;
			Statement st1 = connect.createStatement();
			int countview = 0;
			ResultSet rs = st1.executeQuery(sql1);
			while (rs.next()) {
				countview = rs.getInt(1);
			}
			PreparedStatement pst = connect
					.prepareStatement("update content set countview = ? where idtin = ?");
			pst.setInt(1, countview + 1);
			pst.setInt(2, Integer.parseInt(idtin));
			pst.executeUpdate();
		} catch (SQLException e1) {
		}
		
	}
}
