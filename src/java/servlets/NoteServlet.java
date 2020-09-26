package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author cprg352
 */
public class NoteServlet extends HttpServlet {
    private String path;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //read from file
        Note note = readFile();
        
        request.setAttribute("note", note);
        
        if (request.getParameter("edit") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Note note = new Note(request.getParameter("title"), request.getParameter("content"));
        writeFile(note);
        
        doGet(request, response);
    }

    private Note readFile() {
        Note note = new Note();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.path)));
            
            note.setTitle(reader.readLine());
            note.setContent(reader.readLine());
            
            reader.close();
        } catch(Exception e) {
            
        }
        return note;
    }
    
    private void writeFile(Note note) {
        try { 
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.path, false)));
            writer.println(note.getTitle());
            writer.println(note.getContent());
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
