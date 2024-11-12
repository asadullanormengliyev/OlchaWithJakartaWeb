package pdp.uz.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pdp.uz.dao.UserDao;
import pdp.uz.service.UserService;

import java.io.IOException;

public class UserControllerServlet extends HttpServlet {
    private  UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
         userService = new UserService(new UserDao());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
