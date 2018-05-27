package control;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.SendMail;

@WebServlet("/SendFeedback")
public class FeebBack extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;
	public static String text;
	private static final String UPLOAD_DIRECTORY = "d:/server_reponsitory_mail";

	public void init() {
		// reads SMTP server setting from web.xml file
		host = "smtp.gmail.com";
		port = "587";

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		req.setCharacterEncoding("UTF-8");
		String send = req.getParameter("sendFb");
		System.out.println(send);
		if (send != null) {
			req.getRequestDispatcher("/WEB-INF/jsp/sendmail.jsp").forward(req, resp);
		} else {
			String subject = "";
			String content = "";
			String mss_send = "";
			String file = "";
			File directory = new File(UPLOAD_DIRECTORY);
		    if (! directory.exists()){
		        directory.mkdir();
		    }
			List<FileItem> multiparts = null;
			try {
				multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (FileItem item : multiparts) {
				// if (!item.isFormField()) {
				// String name = new File(item.getName()).getName();
				// item.write(new File(UPLOAD_DIRECTORY + File.separator
				// + name));
				// }

				if (!item.isFormField()) {
					String name = new File(item.getName()).getName();
					file = UPLOAD_DIRECTORY + File.separator + name;
					try {
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					req.setAttribute("message", "File(s) uploaded successfully!");
				} else {
					String fieldname = item.getFieldName();
					String fieldvalue = item.getString();

					if (fieldname.equals("summary")) {
						subject = new String(fieldvalue.getBytes(StandardCharsets.ISO_8859_1),
								StandardCharsets.UTF_8);
						// new String (s.getBytes ("iso-8859-1"),
						// "UTF-8");
					} else if (fieldname.equals("email")) {
						// next logic goes here...
						user = new String(fieldvalue.getBytes(StandardCharsets.ISO_8859_1),
								StandardCharsets.UTF_8);
					}
					else if (fieldname.equals("pass")) {
						pass = new String(fieldvalue.getBytes(StandardCharsets.ISO_8859_1),
								StandardCharsets.UTF_8);
						// new String (s.getBytes ("iso-8859-1"),
						// "UTF-8");
					} else if (fieldname.equals("nd")) {
						// next logic goes here...
						content = new String(fieldvalue.getBytes(StandardCharsets.ISO_8859_1),
								StandardCharsets.UTF_8);
					}
				}

			}
			try {
				SendMail.sendEmailWithAttachment(host, port, user, pass, subject, content, file);
				mss_send = "The e-mail was sent successfully";
			} catch (Exception ex) {
				mss_send = "Email hoặc Mật khẩu không đúng";
			} finally {
				req.setAttribute("mss_send", mss_send);
				getServletContext().getRequestDispatcher("/WEB-INF/jsp/sendmail.jsp").forward(req, resp);
			}
		}
	}

}