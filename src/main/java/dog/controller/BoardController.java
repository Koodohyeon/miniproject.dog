package dog.controller;

import dog.entity.User;
import dog.service.BoardService;
import dog.service.UserService;
import dog.service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import dog.entity.Board;
import dog.entity.Reply;
import dog.service.BoardServiceImpl;
import dog.service.ReplyService;
import dog.service.ReplyServiceImpl;

@WebServlet({"/dog/board/list", "/dog/board/insert", "/dog/board/update", 
			 "/dog/board/delete", "/dog/board/detail","/dog/board/insertReply"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bSvc = new BoardServiceImpl();
	private UserService uSvc = new UserServiceImpl();
	private ReplyService rSvc = new ReplyServiceImpl();
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String title = "", content = "", field = "", query = "", page_ = "", uId = "", comment = "";
		Board board = null;
		Reply reply = null;
		int boardId = 0, page = 0, replyId = 0;
		String sessUid = (String) session.getAttribute("sessUid");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		switch(action) {
		case "list":			
			page_ = request.getParameter("p");
			field = request.getParameter("f");
			query = request.getParameter("q");
			page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			session.setAttribute("currentBoardPage", page);
			field = (field == null || field.equals("")) ? "title" : field;
			query = (query == null || query.equals("")) ? "" : query;
			session.setAttribute("field", field);
			session.setAttribute("query", query);
			List<Board> boardList = bSvc.getBoardList(page, field, query);
			request.setAttribute("boardList", boardList);
			
			// for pagination
			int totalItems = bSvc.getBoardCount(field, query);
			int totalPages = (int) Math.ceil(totalItems * 1.0 / bSvc.COUNT_PER_PAGE);
			List<String> pageList = new ArrayList<String>();
			for (int i = 1; i <= totalPages; i++)
				pageList.add(String.valueOf(i));
			request.setAttribute("pageList", pageList);
			
			rd = request.getRequestDispatcher("/WEB-INF/view/dog/board/list.jsp");
			rd.forward(request, response);
			break;
			
		case "insert":
			if (sessUid == null || sessUid.equals("")) {
				response.sendRedirect("/jw/dog/user/login");
				break;
			}
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/WEB-INF/view/dog/board/insert.jsp");
				rd.forward(request, response);		
			} else {
				title = request.getParameter("title");
				content = request.getParameter("content");
				board = new Board(title, content, sessUid);
				bSvc.insertBoard(board);
				
				comment = request.getParameter("comment");	
			    reply = new Reply(comment, board.getBoardId(), sessUid);
                rSvc.insertReply(reply);
				
				int sessBalance = (int) session.getAttribute("sessBalance");
				sessBalance += 100;
				session.setAttribute("sessBalance",sessBalance);
				User user = uSvc.getUserByUid(sessUid);
				user.setBalance(sessBalance);
				uSvc.updateUser(user);


				response.sendRedirect("/jw/dog/board/list?p=1");
			}
			break;
		
		case "detail":
			boardId = Integer.parseInt(request.getParameter("boardId"));
			board = bSvc.getBoard(boardId);
			uId = board.getuId();
			request.setAttribute("board", board);
			if ((!uId.equals(sessUid)) && sessUid!=null)
				bSvc.increaseViewCount(boardId);
			List<Reply> replyList = rSvc.getReplyList(boardId); 
			request.setAttribute("replyList", replyList);
			rd = request.getRequestDispatcher("/WEB-INF/view/dog/board/detail.jsp");
			rd.forward(request, response);
			
			break;
			
		case "delete":
			boardId = Integer.parseInt(request.getParameter("boardId"));
			bSvc.deleteBoard(boardId);
			replyId = Integer.parseInt(request.getParameter("replyId"));
			rSvc.deleteReply(replyId);
			page = (Integer) session.getAttribute("currentBoardPage");
			field = (String) session.getAttribute("field");
			query = (String) session.getAttribute("query");
			query = URLEncoder.encode(query, "utf-8");
			response.sendRedirect("/jw/dog/board/list?p=" + page + "&f=" + field + "&q=" + query);
			break;
			
		case "update":
			if (method.equals("GET")) {
				boardId = Integer.parseInt(request.getParameter("boardId"));
				board = bSvc.getBoard(boardId);
				request.setAttribute("board", board);
				
//				replyId = Integer.parseInt(request.getParameter("replyId"));
//				reply = rSvc.getReply(replyId);
				rd = request.getRequestDispatcher("/WEB-INF/view/dog/board/update.jsp");
				rd.forward(request, response);
			} else {
				boardId = Integer.parseInt(request.getParameter("boardId"));
				uId = request.getParameter("uId");
				title = request.getParameter("title");
				content = request.getParameter("content");
				board = new Board(boardId, title, content);
				
				bSvc.updateBoard(board);
				
//				replyId = Integer.parseInt(request.getParameter("replyId"));
//				comment = request.getParameter("comment");
//				reply = new Reply(replyId, comment);
//				rSvc.updateReply(reply);
				response.sendRedirect("/jw/dog/board/detail?boardId=" + boardId + "&uId=" + uId );
			}
			break;
		
		case "insertReply":
			boardId = Integer.parseInt(request.getParameter("boardId"));
			comment = request.getParameter("comment");	
		    reply = new Reply(comment, boardId, sessUid);
            rSvc.insertReply(reply);
            response.sendRedirect("/jw/dog/board/detail?boardId=" + boardId);
            break;
		}
		
	}
		
	

}