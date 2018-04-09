package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataExtractor ex = new DataExtractor();
        System.out.println("hi");
        String search = request.getParameter("search");
        System.out.println("eee");
        try (PrintWriter out = response.getWriter()) {
            
            ResultSet rs = ex.getPost(search);
            ResultSet res = ex.getNumPosts(search);
            System.out.println("1");
            try {
                rs.beforeFirst();
                res.beforeFirst();
                ArrayList<String> username = new ArrayList<>();
                ArrayList<String> title = new ArrayList<>();
                ArrayList<String> desc = new ArrayList<>();
                ArrayList<String> postId = new ArrayList<>();
                ArrayList<String> tagId = new ArrayList<>();
                int ctr = 0;
                System.out.println("2");
                while(rs.next()){
                    username.add(rs.getString(1)); 
                    title.add(rs.getString(2));
                    desc.add(rs.getString(3));
                    postId.add(rs.getString(4));
                    tagId.add(rs.getString(5));
                }
                System.out.println("3");
                while(res.next()){
                    ctr = Integer.parseInt(res.getString(1));
                }
                System.out.println("4");
                request.setAttribute("username", username);
                request.setAttribute("title", title);
                request.setAttribute("desc", desc);
                request.setAttribute("postId", postId);
                request.setAttribute("tagId", tagId);
                request.setAttribute("search", search);
                request.setAttribute("ctr", ctr);
                System.out.println("5");
                RequestDispatcher rd = request.getRequestDispatcher("searchResults.jsp");
                rd.forward(request, response);
                System.out.println("6");
                username.clear();
                title.clear();
                desc.clear();
                postId.clear();
                tagId.clear();
                
            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
