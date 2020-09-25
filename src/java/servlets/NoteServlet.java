package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import static java.lang.System.out;

/**
 *
 * @author cprg352
 */
public class NoteServlet extends HttpServlet {

    private Note note;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //read from file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        readFile(path);
        
        request.setAttribute("note", this.note);
        
        if (request.getParameter("edit") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp").forward(request, response);
    }

    private void readFile(String path) {
        this.note = new Note();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            
            note.setTitle(reader.readLine());
            note.setContent(reader.readLine());
            
            reader.close();
        } catch(Exception e) {
            
        }
    }
}
