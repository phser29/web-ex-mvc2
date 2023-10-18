package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.board.BoardDao;

public class GetAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String auther = request.getParameter("auther");
		int aut = Integer.parseInt(auther);
		
		BoardDao dao = BoardDao.getInstance();
		request.setAttribute("get", dao.get(aut));
		
		response.sendRedirect("/board/get.jsp");
		
	}
	
}
