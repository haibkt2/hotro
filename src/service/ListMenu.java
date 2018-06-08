package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.Connect;
import model.content;
import model.menu;
import model.support;

public class ListMenu {
	public List<menu> listMenu(int id) {
		List<menu> listMenu = new ArrayList<menu>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select idmenu,menu from menu where idsupport = " + id;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				menu mn = new menu();
				int idmenu = rs.getInt(1);
				String menu = rs.getString(2);
				mn.setMenu(idmenu, menu);
				listMenu.add(mn);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listMenu;

	}
	public List<content> listContent(String md, String cd) {
		if (!cd.isEmpty())
			cd = md + " = '" + cd + "'";
		else cd = md;
		List<content> listContent = new ArrayList<content>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select idtin, ten, author, summary from content where " + cd;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idtin = rs.getInt(1);
				String ten = rs.getString(2);
				String author = rs.getString(3);
				String summary = rs.getString(4);
				content content = new content(idtin, ten, author, summary);
				listContent.add(content);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listContent;

	}
	
	public List<support> listSp() {
		List<support> listsupport = new ArrayList<support>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select * from support";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				support sport = new support();
				int idsp = rs.getInt(1);
				String sp = rs.getString(2);
				sport.setSupport(idsp, sp);
				listsupport.add(sport);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listsupport;

	}
	public List<menu> listMn() {
		List<menu> listmn = new ArrayList<menu>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select * from menu";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				menu mn = new menu();
				int idmn = rs.getInt(1);
				String mnu= rs.getString(2);
				mn.setIdmenu(idmn);
				mn.setMenu(mnu);
				listmn.add(mn);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listmn;

	}

	public List<Date> listDate() {
		List<Date> listDate = new ArrayList<Date>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "select day from content GROUP BY day DESC limit 0,3 ";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Date date = rs.getDate(1);
				listDate.add(date);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listDate;

	}

	public List<content> listCViewMax() {
		List<content> listCViewMax = new ArrayList<content>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select idtin, ten, countview from content ORDER BY countview DESC LIMIT 5 ";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idtin = rs.getInt(1);
				String ten = rs.getString(2);
				int countview = rs.getInt(3);
				content content = new content(idtin, ten, countview);
				listCViewMax.add(content);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listCViewMax;

	}

	public List<content> listContent() {
		List<content> listCViewMax = new ArrayList<content>();
		try {
			Connection connection = Connect.getConnection();
			String sql = "Select * from content";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idtin = rs.getInt(1);
				String ten = rs.getString(2);
				int countview = rs.getInt(3);
				content content = new content(idtin, ten, countview);
				listCViewMax.add(content);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listCViewMax;

	}

	public List<menu> listContentExportForDate(String f, String t) {
		List<menu> listContentExport = new ArrayList<menu>();
		try {
			
			Connection connection = Connect.getConnection();
			String sql = "SELECT content.ten, content.summary,content.author ,content.day,menu.menu "
					+ "FROM content JOIN menu ON content.idmenu = menu.idmenu "
					+ "WHERE content.day "
					+ "BETWEEN '"+f+"' AND '"+ t+"' "
					+ "ORDER BY menu.menu ";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				menu mn = new menu();
				String ten = rs.getString(1);
				String summary = rs.getString(2);
				String author = rs.getString(3);
				Date date = rs.getDate(4);
				String menu = rs.getString(5);
				mn.setMenu(menu);
				mn.addMenu(new content(ten, summary, author, date));
				listContentExport.add(mn);;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listContentExport;

	}
	public List<menu> listContentExport() {
		List<menu> listContentExport = new ArrayList<menu>();
		try {
			
			Connection connection = Connect.getConnection();
			String sql = "SELECT content.ten, content.summary,content.author ,content.day,menu.menu "
					+ "FROM content JOIN menu ON content.idmenu = menu.idmenu ORDER BY menu.menu";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				menu mn = new menu();
				String ten = rs.getString(1);
				String summary = rs.getString(2);
				String author = rs.getString(3);
				Date date = rs.getDate(4);
				String menu = rs.getString(5);
				mn.setMenu(menu);
				mn.addMenu(new content(ten, summary, author, date));
				listContentExport.add(mn);;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return listContentExport;

	}
	public menu contentFix(String idtin) {
		menu contentFix = new menu();
		try {
			
			Connection connection = Connect.getConnection();
			String sql = "SELECT content.ten, content.summary,content.noidung ,menu.menu ,content.file FROM content JOIN menu ON content.idmenu = menu.idmenu Where content.idtin = "+idtin;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String ten = rs.getString(1);
				String summary = rs.getString(2);
				String noidung = rs.getString(3);
				String menu = rs.getString(4);
				String file = rs.getString(5);
				contentFix.setMenu(menu);
				contentFix.setCt(new content(ten, summary, noidung,file));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return contentFix;

	}
	
}
