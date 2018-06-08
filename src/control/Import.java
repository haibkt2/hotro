package control;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import database.Connect;

@WebServlet("/Import")
public class Import extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "d:/server_reponsitory";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		String author = (String) ss.getAttribute("hoten");
		if (author == null)
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		else {
			req.setCharacterEncoding("UTF-8");
			String imp = "";
			imp = req.getParameter("import");
			if (imp == null || imp.equals("")) {
				req.getRequestDispatcher("/WEB-INF/jsp/import.jsp").forward(req, resp);
			} else {
				String idsp = req.getParameter("select");
				int idmenu = Integer.parseInt(req.getParameter("menu" + idsp));
				String contentName = req.getParameter("ten");
				String summary = req.getParameter("summary");
				String content = req.getParameter("nd");
				File uploadDir = new File(UPLOAD_DIRECTORY);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}

				String file = "";
				// List<FileItem> multiparts = new ServletFileUpload(new
				// DiskFileItemFactory()).parseRequest(req);
				Part part = req.getPart("file");
				if (part.getSize() != 0) {
					file = extractFileName(part);
					// refines the fileName in case it is an absolute path
					file = new File(file).getName();
					part.write(UPLOAD_DIRECTORY + File.separator + file);
				}
				// Part filePart = req.getPart("file");
				// if (filePart.getSize() != 0) {
				// // String fileName =
				// //
				// Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				// InputStream fileContent = filePart.getInputStream();
				// // ReadWord rw = new ReadWord();
				//
				// try {
				// XWPFDocument doc = new XWPFDocument(fileContent);
				// XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
				// text = extractor.getText();
				// extractor.close();
				// content = content + text;
				// } catch (Exception e1) {
				// }
				// }
				try {
					String addtin = req.getParameter("addtin");
					if (addtin == null) {
						req.setAttribute("mes_add",
								insertContent(idsp, idmenu, contentName, summary, content, author, file));

					} else {
						if (file.length() == 0)
							file = req.getParameter("fileold");
						req.setAttribute("mes_add", updateContent(Integer.parseInt(addtin), idmenu, contentName,
								summary, content, author, file));
					}
					req.getRequestDispatcher("/WEB-INF/jsp/addcontent.jsp").forward(req, resp);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	public String insertContent(String idsps, int idmenu, String contentName, String summary, String content,
			String author, String file) throws ClassNotFoundException, UnsupportedEncodingException {
		String mes_add = "";
		Connection connect;
		try {
			connect = Connect.getConnection();
			PreparedStatement pst = connect.prepareStatement(
					"insert into content(idtin,ten,summary,noidung,idmenu,author,day,countview,file) values (?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, idContentMax() + 1);
			pst.setString(2, contentName);
			pst.setString(3, summary);
			pst.setString(4, content);
			pst.setInt(5, idmenu);
			pst.setString(6, author);
			pst.setString(7, getDate());
			pst.setInt(8, 0);
			pst.setString(9, file);
			pst.executeUpdate();
			mes_add = "Thêm bài viết mới thành công.";
		} catch (SQLException e1) {
			mes_add = "Thêm bài viết mới thất bại.";
		}
		return mes_add;
	}

	public String updateContent(int idtin, int idmenu, String contentName, String summary, String content,
			String author, String file) throws ClassNotFoundException, UnsupportedEncodingException {
		String mes_edit = "";
		Connection connect;
		try {
			connect = Connect.getConnection();
			PreparedStatement pst = connect.prepareStatement(
					"update content set ten = ?,summary= ?,noidung = ?,idmenu = ?,author = ?,day = ?,file = ? where idtin = ?");
			pst.setString(1, contentName);
			pst.setString(2, summary);
			pst.setString(3, content);
			pst.setInt(4, idmenu);
			pst.setString(5, author);
			pst.setString(6, getDate());
			pst.setString(7, file);
			pst.setInt(8, idtin);
			pst.executeUpdate();
			mes_edit = "Cập nhật bài viết mới thành công.";
		} catch (SQLException e1) {
			mes_edit = "Cập nhật bài viết mới thất bại.";
		}
		return mes_edit;
	}

	public int idContentMax() throws ClassNotFoundException, UnsupportedEncodingException, SQLException {
		String sql = "SELECT max(idtin) FROM content";
		int max = 9999;
		Connection con = Connect.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			max = rs.getInt(1);
		}
		return max;
	}

	private String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

}