package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.user.UserDao;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String country = request.getParameter("country");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		int save;
		UserDao dao = UserDao.getInstance();
		save = dao.createUser(username, password, name, email, phone, country, birth, gender);
		
		if(save != -1) {
			response.sendRedirect("/login");
		} else {
			response.sendRedirect("/join");
		}
		
	}

}
