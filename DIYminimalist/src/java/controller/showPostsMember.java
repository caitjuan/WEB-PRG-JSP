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

@WebServlet(name = "showPostsMember", urlPatterns = {"/showPostsMember"})
public class showPostsMember extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DataExtractor ex = new DataExtractor();

        try (PrintWriter out = response.getWriter()) {

            ResultSet rs = ex.getAllPosts();

            if (rs != null) {
                try {
                    rs.beforeFirst();

                    ArrayList<String> username = new ArrayList<>();
                    ArrayList<String> title = new ArrayList<>();
                    ArrayList<String> desc = new ArrayList<>();
                    ArrayList<String> fileName = new ArrayList<>();
                    
                    while (rs.next()) {
                        username.add(rs.getString(1));
                        title.add(rs.getString(2));
                        desc.add(rs.getString(3));
                        fileName.add(rs.getString(4));
                    }

                    request.setAttribute("username", username);
                    request.setAttribute("title", title);
                    request.setAttribute("desc", desc);
                    request.setAttribute("fileName", fileName);
                    
                    rs = ex.getDistinctPostIdAll();

                    try {
                        rs.beforeFirst();
                        ArrayList<ResultSet> resarray = new ArrayList<>();
                        ArrayList<String> tags = new ArrayList<>();
                        ArrayList<String> postId = new ArrayList<>();
                        
                        int i = 0;

                        while (rs.next()) {
                            postId.add(rs.getString(1));
                        }

                        while (i < postId.size()) {
                            resarray.add(ex.getTags(postId.get(i)));
                            i++;
                        }

                        i = 0;
                                                
                        while (i < resarray.size()) {
                            while (resarray.get(i).next()) {
                                tags.add((i+1) + resarray.get(i).getString(1));
                            }
                            i++;
                        }
                                                
                        request.setAttribute("postId", postId);
                        request.setAttribute("tags", tags);

                        RequestDispatcher rd = request.getRequestDispatcher("member_home.jsp");
                        rd.forward(request, response);

                        username.clear();
                        title.clear();
                        desc.clear();
                        fileName.clear();
                        tags.clear();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DataExtractor ex = new DataExtractor();

        try (PrintWriter out = response.getWriter()) {

            ResultSet rs = ex.getAllPosts();

            if (rs != null) {
                try {
                    rs.beforeFirst();

                    ArrayList<String> username = new ArrayList<>();
                    ArrayList<String> title = new ArrayList<>();
                    ArrayList<String> desc = new ArrayList<>();
                    ArrayList<String> fileName = new ArrayList<>();
                    
                    while (rs.next()) {
                        username.add(rs.getString(1));
                        title.add(rs.getString(2));
                        desc.add(rs.getString(3));
                        fileName.add(rs.getString(4));
                    }

                    request.setAttribute("username", username);
                    request.setAttribute("title", title);
                    request.setAttribute("desc", desc);
                    request.setAttribute("fileName", fileName);
                    
                    rs = ex.getDistinctPostIdAll();

                    try {
                        rs.beforeFirst();
                        ArrayList<ResultSet> resarray = new ArrayList<>();
                        ArrayList<String> tags = new ArrayList<>();
                        ArrayList<String> postId = new ArrayList<>();
                        
                        int i = 0;

                        while (rs.next()) {
                            postId.add(rs.getString(1));
                        }

                        while (i < postId.size()) {
                            resarray.add(ex.getTags(postId.get(i)));
                            i++;
                        }

                        i = 0;
                                                
                        while (i < resarray.size()) {
                            while (resarray.get(i).next()) {
                                tags.add((i+1) + resarray.get(i).getString(1));
                            }
                            i++;
                        }
                        //delete later
                        i = 0;
                        while (i < tags.size()) {
                            System.out.println(tags.get(i));
                            i++;
                        }
                        //delete until here
                        i = 0;
                        while (i < postId.size()) {
                            System.out.println(postId.get(i));
                            i++;
                        }
                        
                        request.setAttribute("postId", postId);
                        request.setAttribute("tags", tags);
                        RequestDispatcher rd = request.getRequestDispatcher("member_home.jsp");
                        rd.forward(request, response);
                        System.out.println("hii");
                        username.clear();
                        title.clear();
                        desc.clear();
                        fileName.clear();
                        tags.clear();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
