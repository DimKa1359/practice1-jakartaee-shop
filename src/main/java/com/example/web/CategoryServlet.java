package com.example.web;

import com.example.ejb.CategoryService;
import com.example.entities.Category;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {

    @EJB
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.getAllCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/categories.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Category category = new Category();
        category.setName(name);
        categoryService.addCategory(category);
        resp.sendRedirect("categories");
    }
}