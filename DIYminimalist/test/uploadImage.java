import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns={"/uploadImage"})
public class uploadImage extends HttpServlet {
    
    private static final String SAVE_DIR = "images";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String savePath = "C:" + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        
        String postTitle = request.getParameter("posttitle");
        String postDesc = request.getParameter("postdesc");

        Part pic1 = request.getPart("pic1");  
        Part pic2 = request.getPart("pic2");
        Part pic3 = request.getPart("pic3");

        String fileName1 = extractFileName(pic1);
        String fileName2 = extractFileName(pic2);
        String fileName3 = extractFileName(pic3);

        pic1.write(savePath + File.separator + fileName1);
        pic2.write(savePath + File.separator + fileName2);
        pic3.write(savePath + File.separator + fileName3);

        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Homepage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + "PUTA" + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
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