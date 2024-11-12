package pdp.uz.olchawithjakartaweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pdp.uz.olchawithjakartaweb.dao.ProductDao;
import pdp.uz.olchawithjakartaweb.model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class MainController extends HttpServlet {
    private ProductDao productDao;

    @Override
    public void init() throws ServletException {
        this.productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");

        if ("product".equals(type)) {
            List<Product> productList = productDao.productList();
            req.setAttribute("productList", productList);
            req.getRequestDispatcher("product-list.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid type parameter");
        }
    }
}