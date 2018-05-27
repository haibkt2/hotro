package control;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.Connect;

@WebServlet("/AddNewNotify")
public class AddNewNotify extends HttpServlet {

	/**
	 * 
	 */
	public AddNewNotify() {
		super();
	}

	private static final long serialVersionUID = 1L;
	public static String text;
	private static final String UPLOAD_DIRECTORY = "d:/server_reponsitory";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String add = req.getParameter("addNewNotify");
		String title = "";
		String content = "";
		if (add != null)
			req.getRequestDispatcher("/WEB-INF/jsp/addnotify.jsp").forward(req, resp);
		else {
			if (!ServletFileUpload.isMultipartContent(req)) {
				req.setAttribute("message", "Error: Form tag must has 'enctype=multipart/form-data' attribute");
			} else {
				File uploadDir = new File(UPLOAD_DIRECTORY);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}

				try {
					String file = "";
					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);

					for (FileItem item : multiparts) {
						// if (!item.isFormField()) {
						// String name = new File(item.getName()).getName();
						// item.write(new File(UPLOAD_DIRECTORY + File.separator
						// + name));
						// }

						if (!item.isFormField()) {
							String name = new File(item.getName()).getName();
							file = name;
							item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
							req.setAttribute("message", "File(s) uploaded successfully!");
						} else {
							String fieldname = item.getFieldName();
							String fieldvalue = item.getString();

							if (fieldname.equals("title")) {
								title = new String(fieldvalue.getBytes(StandardCharsets.ISO_8859_1),
										StandardCharsets.UTF_8);
								// new String (s.getBytes ("iso-8859-1"),
								// "UTF-8");
							} else if (fieldname.equals("content")) {
								// next logic goes here...
								content = new String(fieldvalue.getBytes(StandardCharsets.ISO_8859_1),
										StandardCharsets.UTF_8);
							}
						}

					}
					HttpSession ss = req.getSession();
					String author = (String) ss.getAttribute("hoten");
					getServletContext().getRequestDispatcher("/ManageNotify?add_nt="+insertNoti(title, content, author, file)).forward(req, resp);
				} catch (Exception e) {
					req.setAttribute("message", "File(s) upload failed due to " + e.getMessage() + "!");
				}

				// getServletContext().getRequestDispatcher("/WEB-INF/jsp/accout.jsp").forward(req,
				// resp);
			}
			// getServletContext().getRequestDispatcher("/message.jsp").forward(req,
			// resp);
		}
	}

	private String insertNoti(String title, String content, String au, String file)
			throws ClassNotFoundException, UnsupportedEncodingException {
		String mes_reg = "";
		Connection connect;

		try {
			connect = Connect.getConnection();
			PreparedStatement pst = connect.prepareStatement("insert into notify values (?,?,?,?,?,?)");
			pst.setInt(1, idNotifyMax() + 1);
			pst.setString(2, content);
			pst.setString(3, getDate());
			pst.setString(4, au);
			pst.setString(5, title);
			pst.setString(6, file);
			pst.executeUpdate();
			mes_reg = "Thêm mới thành công";
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			mes_reg = "Thêm mới thất bại.";
		}
		return mes_reg;
	}

	private int idNotifyMax() throws ClassNotFoundException, UnsupportedEncodingException, SQLException {
		String sql = "SELECT max(idNoti) FROM notify";
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
