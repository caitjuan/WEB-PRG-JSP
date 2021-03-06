package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "createPost", urlPatterns = {"/createPost"})
public class createPost extends HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        DataInserter in = new DataInserter();
        DataExtractor ex = new DataExtractor();
                
        String  username = request.getParameter("userId"),
                title = request.getParameter("postitle"),
                desc = request.getParameter("postdesc"),
                tag = request.getParameter("tag").toLowerCase();
        int postid = ex.getNextPostID();
        tag = tag.replaceAll("\\s", "");
        String[] tags = tag.split(",");
        
        for (String tag1 : tags) {
            if (ex.ifTagExist(tag1)) {
                in.insertNewPost(postid, username, title, desc, ex.getTagID(tag1));
            } else {
                in.insertNewTag(ex.getNextTagID(), tag1);
                in.insertNewPost(postid, username, title, desc, ex.getTagID(tag1));
            }
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createphoto.jsp");
        dispatcher.forward(request,response);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(uploadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(createPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String String(Object attribute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}