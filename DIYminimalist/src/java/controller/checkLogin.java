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

        DataInserter in = new DataInserter();
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
                            response.sendRedirect("/DIYminimalist/member_home.jsp");
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
        } catch (Exception e) {
            e.printStackTrace();
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

}
