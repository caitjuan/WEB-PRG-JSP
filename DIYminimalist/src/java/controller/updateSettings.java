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

@WebServlet(name = "updateSettings", urlPatterns = {"/updateSettings"})
public class updateSettings extends HttpServlet {

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
        DataUpdater up = new DataUpdater();
        DataExtractor ex = new DataExtractor();

        String name = request.getParameter("name"),
                email = request.getParameter("email"),
                username = request.getParameter("username"),
                gender = request.getParameter("gender"),
                password1 = request.getParameter("pw1"),
                password2 = request.getParameter("pw2"),
                description = request.getParameter("desc"),
                oldPassword = request.getParameter("oldpw"),
                userId = request.getParameter("userId");

        System.out.println(name);
        System.out.println(email);
        System.out.println(username);
        System.out.println(gender);
        System.out.println(password1);
        System.out.println(password2);
        System.out.println(description);
        System.out.println(oldPassword);
        System.out.println(userId);

        try (PrintWriter out = response.getWriter()) {
            if (password1.equals(password2)) {
                ResultSet rs1 = ex.getUsername(username);
                ResultSet rs2 = ex.getPassword(username);

                try {
                    rs1.beforeFirst();
                    rs2.beforeFirst();
                    ArrayList<String> user = new ArrayList<>();
                    ArrayList<String> pass = new ArrayList<>();

                    while (rs1.next()) {
                        user.add(rs1.getString(1));
                    }
                    while (rs2.next()) {
                        pass.add(rs2.getString(1));
                    }

                    if (user.isEmpty() || user.get(0).equals(userId)) {
                        if (oldPassword.equals(pass.get(0))) {
                            up.update(userId, email, gender, username, name, description, password2);
                            HttpSession session = request.getSession();
                            session.setAttribute("userId", username);
                            session.setAttribute("name", name);
                            response.sendRedirect("/DIYminimalist/showPostsMember");
                        } else {
                            request.setAttribute("error", "Username already exists. Please enter again.");
                            RequestDispatcher rd = request.getRequestDispatcher("settings.jsp");
                            rd.forward(request, response);
                        }

                    } else {
                        request.setAttribute("error", "Username already exists. Please enter again.");
                        RequestDispatcher rd = request.getRequestDispatcher("settings.jsp");
                        rd.forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("error", "Passwords don't match. Please enter again.");
                RequestDispatcher rd = request.getRequestDispatcher("settings.jsp");
                rd.forward(request, response);
            }
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
