package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDao;

/**
 * Servlet implementation class JoinFormAction
 */
public class JoinFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao = UserDao.getInstance();
	
    /**
     * Default constructor. 
     */
    public JoinFormAction() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String country = request.getParameter("country");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		dao.createUser(null);
		
	}

}
