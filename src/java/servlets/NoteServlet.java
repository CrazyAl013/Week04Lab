package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cprg352
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getParameter("edit");
        if (request.getParameter("edit") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request, response);
        }
            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp").forward(request, response);
    }
}
