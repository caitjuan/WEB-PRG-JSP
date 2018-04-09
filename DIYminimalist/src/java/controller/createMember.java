package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "createMember", urlPatterns = {"/createMember"})
public class createMember extends HttpServlet {

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

        String name = request.getParameter("name"),
                email = request.getParameter("email"),
                username = request.getParameter("username"),
                gender = request.getParameter("gender"),
                password1 = request.getParameter("password1"),
                password2 = request.getParameter("password2");
        
        System.out.println(name);
        System.out.println(email);
        System.out.println(username);
        System.out.println(gender);
        System.out.println(password1);
        System.out.println(password2);
        
        try (PrintWriter out = response.getWriter()) {
            if (password1.equals(password2)) {
                ResultSet rs = ex.getUsername(username);
                try {
                    rs.beforeFirst();
                    ArrayList<String> str = new ArrayList<>();
                    while (rs.next()) {
                        str.add(rs.getString(1));
                    }
                    if (str.isEmpty()) {
                        in.insertNewMember(username, name, gender, email, password2);
                        response.sendRedirect("/DIYminimalist/member_home.jsp");
                    } else {
                        request.setAttribute("error", "Username already exists. Please enter again.");
                        RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");  
                        rd.forward(request, response);  
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("error", "Passwords don't match. Please enter again.");
                RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                rd.forward(request, response);  
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
