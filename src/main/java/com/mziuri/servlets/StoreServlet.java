package com.mziuri.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.models.Product;
import com.mziuri.services.DatabaseManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //produqtebis siis gagzavna response body-shi
        DatabaseManager dbManager = new DatabaseManager();
        List<Product> products = new ArrayList<>();

        dbManager.getProductsList(products);

        ObjectMapper mapper = new ObjectMapper();

        for(Product p : products){
            String result = mapper.writeValueAsString(p);
            resp.getWriter().write(result);
        }
    }
}
