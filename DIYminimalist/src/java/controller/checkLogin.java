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
import javax.servlet.http.HttpSession;

@WebServlet(name = "checkLogin", urlPatterns = {"/checkLogin"})
public class checkLogin extends HttpServlet {

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

        String username = request.getParameter("username"),
                password = request.getParameter("password");
        
        try (PrintWriter out = response.getWriter()) {
            ResultSet rs = ex.getUsername(username);

            try {
                rs.beforeFirst();
                ArrayList<String> str = new ArrayList<>();
                while (rs.next()) {
                    str.add(rs.getString(1));
                }                
                if (str.isEmpty()) {
                    request.setAttribute("error", "Incorrect username and/or password");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                } else {
                    rs = ex.getPassword(username);
                    try {
                        rs.beforeFirst();
                        str.clear();
                        while (rs.next()) {
                            str.add(rs.getString(1));
                        }
                        if (str.get(0).equals(password)) {
                            HttpSession session = request.getSession();
                            session.setAttribute("userId", username);
                            response.sendRedirect("/DIYminimalist/showPostsMember");
                        } else {
                            request.setAttribute("error", "Incorrect username and/or password");
                            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                            rd.forward(request, response);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ex.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
