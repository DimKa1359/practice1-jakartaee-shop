package com.example.web;

import com.example.ejb.ProductService;
import com.example.entities.Product;
import com.example.entities.Category;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        Long categoryId = Long.parseLong(req.getParameter("category_id"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        Category category = new Category();
        category.setId(categoryId);
        product.setCategory(category);

        productService.addProduct(product);
        resp.sendRedirect("products");
    }
}