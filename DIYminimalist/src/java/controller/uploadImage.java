package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "uploadImage", urlPatterns = {"/uploadImage"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)
public class uploadImage extends HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        DataInserter in = new DataInserter();
        DataExtractor ex = new DataExtractor();
                
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String contextRoot = request.getServletContext().getRealPath("/");
        factory.setRepository(new File(contextRoot + "WEB-INF/tmp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        String path = "D:/. College Docs/3RD YEAR/8TH TERM/WEB-PRG/Examples/MProject V1/WEB-PRG-JSP/DIYminimalist/web/POSTS";
        
        int postId = ex.getNextPostID() - 1,
            imagectr = 1;
                
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    String fileName = item.getName();
                    
                    System.out.println("Field name: " + item.getFieldName());
                    System.out.println("File name: " + fileName);
                    System.out.println("File size: " + item.getSize());
                    System.out.println("File type: " + item.getContentType());
                    
                    try {
                        File fileSaveDir = new File(path);
                        if(!fileSaveDir.exists()){
                            fileSaveDir.mkdir();
                        }
                        String newFilename = "POST" + postId + "_image" + (imagectr++) + ".jpg";
                        File saveFile = new File(path, newFilename);
                        in.insertNewImage(postId, newFilename);
                        
                        saveFile.createNewFile();
                        item.write(saveFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member_home.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }       
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
            Logger.getLogger(uploadImage.class.getName()).log(Level.SEVERE, null, ex);
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