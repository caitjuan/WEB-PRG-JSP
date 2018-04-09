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
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "uploadImage", urlPatterns = {"/uploadImage"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)
public class uploadImage extends HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String contextRoot = request.getServletContext().getRealPath("/");
        factory.setRepository(new File(contextRoot + "WEB-INF/tmp"));
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    System.out.println("Field name: " + item.getFieldName());
                    System.out.println("File name: " + item.getName());
                    System.out.println("File size: " + item.getSize());
                    System.out.println("File type: " + item.getContentType());

                    String fileName = item.getName();
                    try {
                        File fileSaveDir=new File("C:/Users/caitl/Documents/DLSU/DLSU AY 1718 2nd term/WEB-PRG/GitHub/WEB-PRG-JSP/DIYminimalist/web/POSTS");
                        if(!fileSaveDir.exists()){
                            fileSaveDir.mkdir();
                        }
                        File saveFile = new File("C:/Users/caitl/Documents/DLSU/DLSU AY 1718 2nd term/WEB-PRG/GitHub/WEB-PRG-JSP/DIYminimalist/web/POSTS",fileName);
                        saveFile.createNewFile();
                        item.write(saveFile);
                        
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/member_home.jsp");
                        dispatcher.forward(request,response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            try {
                throw new ServletException("Cannot parse multipart request.", e);
            } catch (ServletException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
}