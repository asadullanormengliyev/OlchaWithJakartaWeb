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
import java.util.Optional;

@WebServlet("/sign-in")
public class SignInController extends HttpServlet {
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.userService = new UserService(new UserDao());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> user = userService.checkUser(username, password);
        if (user.isPresent()){
            resp.sendRedirect("/main-panel");
        }else {
            resp.sendRedirect("/sign-in");
        }
    }
}
