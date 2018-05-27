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

@WebServlet(urlPatterns = { "/ManageMenu" })
public class ManageMenu extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageMenu() {
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
		String add_sp = req.getParameter("add_sp");
		if(add_sp != null) 
			req.setAttribute("add_sp", add_sp);
		String mss_del = req.getParameter("mss_del");
		if(mss_del != null) 
			req.setAttribute("mss_del", mss_del);
		req.setAttribute("listSp", listSp());
		req.getRequestDispatcher("/WEB-INF/jsp/managemenu.jsp").forward(req, resp);
	}

	private List<support> listSp() {
		List<support> listSp = new ArrayList<support>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "SELECT menu.idmenu,menu.menu,support.support,support.idsupport FROM menu JOIN support ON menu.idsupport = support.idsupport";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idmn = rs.getInt(1);
				String mn = rs.getString(2);
				int idsp = rs.getInt(4);
				String sp = rs.getString(3);
				menu menu = new menu(idmn, mn);
				support sport = new support();
				sport.setSupport(sp);
				sport.setIdsupport(idsp);
				sport.addMenu(menu);
				listSp.add(sport);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listSp;

	}

}
