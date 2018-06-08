package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.content;
import service.pageauthor;

@WebServlet(name = "Searchauthor", urlPatterns = {"/Searchauthor"})
public class Searchauthor extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String Author = request.getParameter("Author");
        HttpSession sessionauthor = request.getSession();
        ArrayList<content> dsLoc = null;
		try {
			dsLoc = new pageauthor().locDanhSach(Author);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (Author.equals("") || Author == null) {
//			dsLoc=new pageauthor2().getDanhSach();
//			sessionauthor.setAttribute("list", dsLoc);
        	request.getRequestDispatcher("/WEB-INF/jsp/manageauthor2.jsp").forward(request, response);
        } else {
            sessionauthor.setAttribute("dsLoc", dsLoc);
            request.getRequestDispatcher("/WEB-INF/jsp/manageauthor2.jsp").forward(request, response);
        }
    }
}

