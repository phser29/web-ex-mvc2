package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.user.UserDao;
import model.user.UserResponseDto;

public class EditUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = UserDao.getInstance();
		ArrayList<UserResponseDto> bind= dao.findAll();
		
		if(bind != null) {
			request.setAttribute("findAll", bind);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/editUser");
		rd.forward(request, response);
	
	}

}
