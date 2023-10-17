package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDao;
import user.UserResponseDto;

/**
 * Servlet implementation class EditUserForm
 */
public class EditUserFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserFormAction() {
        super();
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
		
		UserDao dao = UserDao.getInstance();
		ArrayList<UserResponseDto> bind= dao.findAll();
		
		System.out.println("여기까진 도달");
		if(bind != null) {
			request.setAttribute("findAll", bind);
		}
		
		ServletContext app = this.getServletContext();
        RequestDispatcher dispatcher = app.getRequestDispatcher("/editUser");
        dispatcher.forward(request, response);
	}

}
