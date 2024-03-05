package dog.controller;

import dog.entity.Gallery;
import dog.entity.User;
import dog.service.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@WebServlet({"/dog/gallery/list", "/dog/gallery/insert", "/dog/gallery/update",
        "/dog/gallery/delete", "/dog/gallery/like", "/dog/gallery/view"})
@MultipartConfig(
        fileSizeThreshold = 1 * 1024 * 1024,			// 1 MB
        maxFileSize = 10 * 1024 * 1024,					// 10 MB
        maxRequestSize = 10 * 1024 * 1024
)
public class GalleryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String UPLOAD_PATH = "/Users/gudohyeon/Desktop/pictureFolder";

    private GalleryService gSvc = new GalleryServiceImpl();
    private UserService uSvc = new UserServiceImpl();
    private LikedService lSvc = new LikedServiceImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String action = uri[uri.length - 1];
        String method = request.getMethod();
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        String title = "", field = "", page_ = "", uId = "";
        Gallery gallery = null;
        int page = 0, galleryId =0;
        String sessUid = (String) session.getAttribute("sessUid");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");


        switch(action) {

            case "list":
                page_ = request.getParameter("p");
                field = request.getParameter("f");
                page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
                session.setAttribute("currentGalleryPage", page);
                field = (field == null || field.equals("")) ? "title" : field;
                session.setAttribute("field", field);
                List<Gallery> galleryList = gSvc.getGalleryList(page, field);

                for(int i=0;i< galleryList.size();i++){
                    gSvc.updateLikeCount(galleryList.get(i).getGalleryId());
                }
                galleryList = gSvc.getGalleryList(page, field);

                request.setAttribute("galleryList", galleryList);



//                List<String> uNameList = new ArrayList<>();
//                for (int i=0;i < galleryList.size();i++) {
//                    User user = uSvc.getUserByUid(galleryList.get(i).getuId());
//                    String uName = user.getUname();
//                    uNameList.add(uName);
//                }
//                request.setAttribute("uNameList",uNameList);



                int totalItems = gSvc.getGalleryCount(field);
                int totalPages = (int) Math.ceil(totalItems * 1.0 / gSvc.COUNT_PER_PAGE);
                List<String> pageList = new ArrayList<String>();
                for (int i = 1; i <= totalPages; i++)
                    pageList.add(String.valueOf(i));
                request.setAttribute("pageList", pageList);

                rd = request.getRequestDispatcher("/WEB-INF/view/dog/gallery/list.jsp");
                rd.forward(request, response);
                break;

            case "insert":
                if (sessUid == null || sessUid.equals("")) {
                    response.sendRedirect("/jw/dog/user/login");
                    break;
                }
                if (method.equals("GET")) {
                    rd = request.getRequestDispatcher("/WEB-INF/view/dog/gallery/insert.jsp");
                    rd.forward(request, response);
                } else {
                    title = request.getParameter("title");
                    Part filePart = request.getPart("fName");
                    String filename = filePart.getSubmittedFileName();
                    String[] ext = filename.split("\\.");
                    String extension = ext[ext.length - 1];
                    String fname = System.currentTimeMillis() + "." + extension;
                    String path = UPLOAD_PATH + "/" + fname;
                    filePart.write(path);
                    gallery = new Gallery(fname,sessUid,title);

                    gSvc.insertGallery(gallery);

                    int sessBalance = (int) session.getAttribute("sessBalance");
                    sessBalance += 100;
                    session.setAttribute("sessBalance",sessBalance);
                    User user = uSvc.getUserByUid(sessUid);
                    user.setBalance(sessBalance);
                    uSvc.updateUser(user);

                    request.setAttribute("gallery", gallery);
                    response.sendRedirect("/jw/dog/gallery/list?p=1");
                }
                break;

//            case "liked":
//                galleryId = Integer.parseInt(request.getParameter("galleryId"));
//
//                gSvc.changeLiked(galleryId, sessUid);
//
//                response.sendRedirect("/jw/dog/gallery/list?p=1");
//                break;

            case "delete":
                galleryId = Integer.parseInt(request.getParameter("galleryId"));
                gSvc.deleteGallery(galleryId);
                response.sendRedirect("/jw/dog/gallery/list?p=1");

                break;


            case "update":
                if (method.equals("GET")) {
                    galleryId = Integer.parseInt(request.getParameter("galleryId"));
                    gallery = gSvc.getGallery(galleryId);
                    request.setAttribute("gallery", gallery);
                    rd = request.getRequestDispatcher("/WEB-INF/view/dog/gallery/update.jsp");
                    rd.forward(request, response);
                } else {
                    galleryId = Integer.parseInt(request.getParameter("galleryId"));
                    title = request.getParameter("title");

                    request.setAttribute("galleryId",galleryId);

                    Part filePart = request.getPart("fName");
                    String fileName = filePart.getSubmittedFileName();
                    String[] ext = fileName.split("\\.");
                    String extension = ext[ext.length - 1];
                    String fName = System.currentTimeMillis() + "." + extension;
                    String path = UPLOAD_PATH + "/" + fName;
                    filePart.write(path);
                    gallery = new Gallery(galleryId, fName, title);
                    request.setAttribute("fName",fName);

                    gSvc.updateGallery(gallery);
                    response.sendRedirect("/jw/dog/gallery/list?p=1");
                }
                break;
            case "view":
                byte[] buffer = new byte[8*1024];		// 8 KB buffer
                String fname = request.getParameter("filename");
                String path = UPLOAD_PATH + "/" + fname;
                OutputStream os = response.getOutputStream();
                response.setContentType("text/html; charset=utf-8");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Content-disposition", "attachment; fileName=" +
                        URLEncoder.encode(fname, "utf-8"));

                FileInputStream fis = new FileInputStream(path);
                while (true) {
                    int count = fis.read(buffer);
                    if (count == -1)
                        break;
                    os.write(buffer, 0, count);
                }
                fis.close(); os.close();
                break;

            case "like":
                galleryId = Integer.parseInt(request.getParameter("galleryId"));
                int isLiked = lSvc.updateLiked(galleryId, sessUid);
                System.out.println("isLiked 값 =========== " + isLiked);
                System.out.println("galleryId =========== " + galleryId);
                System.out.println("userId =========== " + sessUid);
                request.setAttribute("isLiked",isLiked);
                session.setAttribute("sessLiked",isLiked);
     //           session.setAttribute("sessgalleryId", galleryId );

                gSvc.updateLikeCount(galleryId);
                response.sendRedirect("/jw/dog/gallery/list?p=1");

        }
    }
}
