package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "showTagsViewer", urlPatterns = {"/showTagsViewer"})
public class showTagsViewer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataExtractor ex = new DataExtractor();
        
        try {
            ResultSet rs = ex.getAllTags();
            
            if(rs != null){
                try {
                    rs.beforeFirst();
                    
                    ArrayList<String> tags = new ArrayList<>();
                    
                    while(rs.next()){
                        tags.add(rs.getString(1));
                    }
                    
                    for(int i =0; i < tags.size(); i++)
                        System.out.println(tags.get(i));
                    
                    request.setAttribute("tags", tags);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("viewer_tags.jsp");
                    rd.forward(request, response);
                    
                    tags.clear();
                    
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        ex.close();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        DataExtractor ex = new DataExtractor();
        
        try {
            ResultSet rs = ex.getAllTags();
            
            if(rs != null){
                try {
                    rs.beforeFirst();
                    
                    ArrayList<String> tags = new ArrayList<>();
                    
                    while(rs.next()){
                        tags.add(rs.getString(1));
                    }
                    
                    request.setAttribute("tags", tags);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("member_tags.jsp");
                    rd.forward(request, response);
                    
                    tags.clear();
                    
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
