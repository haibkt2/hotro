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

@WebServlet(urlPatterns = { "/ManageNotify" })
public class ManageNotify extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageNotify() {
		super();
	}

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
		String add_nt = req.getParameter("add_nt");
		if(add_nt != null) 
			req.setAttribute("add_sp", add_nt);
		String mss_del = req.getParameter("mss_del");
		if(mss_del != null) 
			req.setAttribute("mss_del", mss_del);
		req.setAttribute("listNt", listNt());
		req.getRequestDispatcher("/WEB-INF/jsp/managenotify.jsp").forward(req, resp);
	}

	private List<notify> listNt() {
		List<notify> listNt = new ArrayList<notify>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "SELECT idNoti,content,date,author,title,file FROM notify";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String ct = rs.getString(2);
				Date day = rs.getDate(3);
				String au = rs.getString(4);
				String title = rs.getString(5);
				String file = rs.getString(6);
				notify nt = new notify(id,ct,day,au,title,file);
				listNt.add(nt);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listNt;

	}

}
