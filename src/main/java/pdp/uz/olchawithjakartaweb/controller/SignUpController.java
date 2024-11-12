package pdp.uz.olchawithjakartaweb.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pdp.uz.olchawithjakartaweb.dao.UserDao;
import pdp.uz.olchawithjakartaweb.model.User;
import pdp.uz.olchawithjakartaweb.service.UserService;

import java.io.IOException;
@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.userService = new UserService(new UserDao());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-up.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.getWriter().println("<h1>keldiku</h1>");
        userService.createUser(name, username, password);
        resp.sendRedirect("/sign-in");
    }
}
