package dog.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dog.entity.User;
import dog.service.UserServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dog/user/list","/dog/user/register","/dog/user/update",
            "/dog/user/delete","/dog/user/login","/dog/user/logout",
            "/dog/home", "/dog/items/payments",
            "/dog/items/foodlist", "/dog/items/foodlist2",
            "/dog/items/itemlist", "/dog/items/itemlist2",
            "/dog/items/otherlist", "/dog/items/otherlist2" })
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserServiceImpl uSvc = new UserServiceImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String[] uri = request.getRequestURI().split("/");
        String action = uri[uri.length - 1];
        String method = request.getMethod();
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;

        String uId = "", pwd = "", pwd2 = "", uname = "", email = "", hashedPwd = "";
        String msg = "", url = "";
        User user = null;
        String sessUid = (String) session.getAttribute("sessUid");

        switch (action) {
	        case "otherlist2":
                rd = request.getRequestDispatcher("/WEB-INF/view/dog/items/otherlist2.jsp");
	            rd.forward(request, response);
	            break;
	            
	        case "otherlist":
                rd = request.getRequestDispatcher("/WEB-INF/view/dog/items/otherlist.jsp");
	            rd.forward(request, response);
	            break;
        
	        case "itemlist2":
	        	rd = request.getRequestDispatcher("/WEB-INF/view/dog/items/itemlist2.jsp");
	            rd.forward(request, response);
	            break;
	            
	        case "itemlist":
	        	rd = request.getRequestDispatcher("/WEB-INF/view/dog/items/itemlist.jsp");
	            rd.forward(request, response);
	            break;
            
	        case "foodlist2":
	        	rd = request.getRequestDispatcher("/WEB-INF/view/dog/items/foodlist2.jsp");
	            rd.forward(request, response);
	            break;
        
	        case "foodlist":
	        	rd = request.getRequestDispatcher("/WEB-INF/view/dog/items/foodlist.jsp");
	            rd.forward(request, response);
	            break;
        
        	case "payments":
                if (sessUid == null || sessUid.equals("")) {
                    response.sendRedirect("/jw/dog/user/login");
                    break;
                }
                rd = request.getRequestDispatcher("/WEB-INF/view/dog/items/payments.jsp");
                rd.forward(request, response);
                break;
        
        	case "home":

                rd = request.getRequestDispatcher("/WEB-INF/view/dog/common/Home.jsp");
                rd.forward(request, response);
                break;
            case "list":
                String page_ = request.getParameter("page");
                int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
                session.setAttribute("currentUserPage", page);
                List<User> userList = uSvc.getUserList(page);
                request.setAttribute("userList", userList);

                // for pagination
                int totalUsers = uSvc.getUserCount();
                int totalPages = (int) Math.ceil(totalUsers * 1.0 / uSvc.COUNT_PER_PAGE);
                List<String> pageList = new ArrayList<String>();
                for (int i = 1; i <= totalPages; i++)
                    pageList.add(String.valueOf(i));
                request.setAttribute("pageList", pageList);


                rd = request.getRequestDispatcher("/WEB-INF/view/dog/user/list.jsp");
                rd.forward(request, response);
                break;

            case "login":
                if (method.equals("GET")) {
                    rd = request.getRequestDispatcher("/WEB-INF/view/dog/user/login.jsp");
                    rd.forward(request, response);
                } else {
                    uId = request.getParameter("uid");
                    pwd = request.getParameter("pwd");
                    int result = uSvc.login(uId, pwd);
                    if (result == uSvc.CORRECT_LOGIN) {
                        user = uSvc.getUserByUid(uId);
                        session.setAttribute("sessUid", uId);
                        session.setAttribute("sessUname", user.getUname());
                        session.setAttribute("sessBalance", user.getBalance());
                        session.setAttribute("sessEmail", user.getEmail());
                        session.setAttribute("sessRegDate", user.getRegDate());
                        msg = user.getUname() + "님 환영합니다.";
                        url = "/jw/dog/home";
                    } else if (result == uSvc.WRONG_PASSWORD) {
                        msg = "패스워드가 틀립니다.";
                        url = "/jw/dog/user/login";
                    } else {
                        System.out.println(uId);
                        System.out.println(pwd);
                        msg = "아이디 입력이 잘못되었습니다.";
                        url = "/jw/dog/user/login";
                    }
                    rd = request.getRequestDispatcher("/WEB-INF/view/dog/common/alertMsg.jsp");
                    request.setAttribute("msg", msg);
                    request.setAttribute("url", url);
                    rd.forward(request, response);
                }
                break;

            case "logout":
                session.invalidate();
                response.sendRedirect("/jw/dog/user/login");
                break;

            case "register":
                if (method.equals("GET")) {
                    session.invalidate();
                    rd = request.getRequestDispatcher("/WEB-INF/view/dog/user/register.jsp");
                    rd.forward(request, response);
                } else {
                    uId = request.getParameter("uId");
                    pwd = request.getParameter("pwd");
                    pwd2 = request.getParameter("pwd2");
                    uname = request.getParameter("uname");
                    email = request.getParameter("email");
                    if (uSvc.getUserByUid(uId) != null) {
                        rd = request.getRequestDispatcher("/WEB-INF/view/dog/common/alertMsg.jsp");
                        request.setAttribute("msg", "아이디가 중복입니다.");
                        request.setAttribute("url", "/jw/dog/user/register");
                        rd.forward(request, response);
                    } else if (pwd.equals(pwd2)) {
                        user = new User(uId, pwd, uname, email);
                        uSvc.registerUser(user);
                        response.sendRedirect("/jw/dog/user/list?page=1");
                    } else {
                        rd = request.getRequestDispatcher("/WEB-INF/view/dog/common/alertMsg.jsp");
                        request.setAttribute("msg", "패스워드 입력이 잘못되었습니다.");
                        request.setAttribute("url", "/jw/dog/user/register");
                        rd.forward(request, response);
                    }
                }
                break;

            case "update":
                if (method.equals("GET")) {
                    uId = request.getParameter("uId");
                    user = uSvc.getUserByUid(uId);
                    rd = request.getRequestDispatcher("/WEB-INF/view/dog/user/update.jsp");
                    request.setAttribute("user", user);
                    rd.forward(request, response);
                } else {
                    uId = request.getParameter("uId");
                    pwd = request.getParameter("pwd");
                    pwd2 = request.getParameter("pwd2");
                    hashedPwd = request.getParameter("hashedPwd");
                    uname = request.getParameter("uname");
                    email = request.getParameter("email");
                    if (pwd != null && pwd.equals(pwd2))
                        hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
                    user = new User(uId, hashedPwd, uname, email);
                    uSvc.updateUser(user);
                    response.sendRedirect("/jw/dog/user/list?page=1");
                }
                break;

            case "delete":
                uId = request.getParameter("uId");
                uSvc.deleteUser(uId);
                sessUid = (String) session.getAttribute("sessUId");
                if (!sessUid.equals("admin"))
                    session.invalidate();
                response.sendRedirect("/jw/dog/user/list?page=1");
                break;
        }


    }
}
