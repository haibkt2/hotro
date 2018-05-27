package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Connect;
import service.ListMenu;

@WebServlet("/AddNewMenu")
public class EditMenu extends HttpServlet {

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
		String demomo = req.getParameter("demomo");
		System.out.println(demomo);
		String username = (String) session.getAttribute("username");
		if (username == null || username.equals("")) {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp?fb=").forward(req, resp);
		} else {
			String addNewMenu = (String) req.getParameter("addNewMenu");
			if (addNewMenu == null || addNewMenu.isEmpty()) {
				req.getRequestDispatcher("/WEB-INF/jsp/addmenu.jsp").forward(req, resp);
			} else {
				String add_sp = "";
				ListMenu lmn = new ListMenu();
				int size_sp = lmn.listSp().size();
				int size_mn = lmn.listMn().size();
				String menu = req.getParameter("menu");
				if (menu.isEmpty() || menu == null)
					add_sp = "Menu Trống";
				else {
					String sp_oll = req.getParameter("spoll");
					String sp_n = req.getParameter("spnew");
					if (!sp_n.isEmpty() || sp_n != null) {
						try {
							add_sp = insertNewSp(menu, sp_n,size_mn,size_sp);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else if (!sp_n.isEmpty() || sp_n != null) {

						try {
							add_sp = insertNewMenu(menu, sp_oll,size_mn);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else
						add_sp = "Error";
				}
				req.getRequestDispatcher("/ManageMenu?add_sp="+add_sp).forward(req, resp);
			}
		}
	}

	private String insertNewMenu(String mn, String sp,int index) throws ClassNotFoundException {
		String mes_reg = "";
		Connection connect;
		try {
			connect = Connect.getConnection();
			PreparedStatement pst = connect.prepareStatement("insert into menu values (?,?,?)");
			pst.setInt(1, index+1);
			pst.setString(2, mn);
			pst.setInt(3, Integer.parseInt(sp));
			pst.executeUpdate();
			mes_reg = "Đăng ký thành công";
		} catch (SQLException e1) {
			mes_reg = "Đăng ký thất bại. Tên đăng ký đã tồn tại";
		}
		return mes_reg;
	}

	private String insertNewSp(String mn, String sp,int index1, int index2) throws ClassNotFoundException {
		String mes_reg = "";
		Connection connect;
		try {
			connect = Connect.getConnection();
			PreparedStatement pst1 = connect.prepareStatement("insert into support values (?,?)");
			pst1.setInt(1, index2+1);
			pst1.setString(2, sp);
			pst1.executeUpdate();
			PreparedStatement pst = connect.prepareStatement("insert into menu values (?,?,?)");
			pst.setInt(1, index1+1);
			pst.setString(2, mn);
			pst.setInt(3, index2+1);
			pst.executeUpdate();
			mes_reg = "Đăng ký thành công";
		} catch (SQLException e1) {
			mes_reg = "Đăng ký thất bại. Tên đăng ký đã tồn tại";
		}
		return mes_reg;
	}

}