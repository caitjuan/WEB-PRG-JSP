import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)

public class upload extends HttpServlet {
    private static final String SAVE_DIR="images";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String savePath = "C:" + File.separator + SAVE_DIR;
                File fileSaveDir=new File(savePath);
                if(!fileSaveDir.exists()){
                    fileSaveDir.mkdir();
                }
            String postTitle=request.getParameter("posttitle");
            String postDesc=request.getParameter("postdesc");
            
            Part pic1=request.getPart("pic1");  
            Part pic2=request.getPart("pic2");
            Part pic3=request.getPart("pic3");
            
            String fileName1=extractFileName(pic1);
            String fileName2=extractFileName(pic2);
            String fileName3=extractFileName(pic3);
            
            pic1.write(savePath + File.separator + fileName1);
            pic2.write(savePath + File.separator + fileName2);
            pic3.write(savePath + File.separator + fileName3);
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
}