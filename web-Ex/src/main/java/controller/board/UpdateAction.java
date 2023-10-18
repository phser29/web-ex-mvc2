package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.board.BoardDao;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String auther = request.getParameter("auther");
		
		int aut = Integer.parseInt(auther);
		
		BoardDao dao = BoardDao.getInstance();
		dao.update(title, content, aut);
		
		response.sendRedirect("/board/list.jsp");
		
	}

}
