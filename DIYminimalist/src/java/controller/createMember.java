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
import javax.servlet.http.HttpSession;

@WebServlet(name = "createMember", urlPatterns = {"/createMember"})
public class createMember extends HttpServlet {

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
        DataInserter in = new DataInserter();
        DataExtractor ex = new DataExtractor();

        String name = request.getParameter("name"),
                email = request.getParameter("email"),
                username = request.getParameter("username"),
                gender = request.getParameter("gender"),
                password1 = request.getParameter("password1"),
                password2 = request.getParameter("password2");
               
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
                        HttpSession session = request.getSession();
                        in.insertNewMember(username, name, gender, email, password2);
                        session.setAttribute("userId", username);
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
