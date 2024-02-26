package com.mziuri.servlets;

import com.mziuri.request.service.PurchaseRequest;
import com.mziuri.response.service.GetProductInfoResponse;
import com.mziuri.services.DatabaseManager;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProductServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //productebis shesaxeb informaciis migeba
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        Integer amount = Integer.valueOf(req.getParameter("amount"));


        DatabaseManager dbManager = new DatabaseManager();
        GetProductInfoResponse productInfoResponse = new GetProductInfoResponse(name, price, amount);
        dbManager.findProductWithName(req, resp, productInfoResponse, dbManager);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer amount = Integer.valueOf(req.getParameter("amount"));

        DatabaseManager dbManager = new DatabaseManager();
        PurchaseRequest purchaseRequest = new PurchaseRequest(name, amount);
        dbManager.purchaseProduct(req, resp, purchaseRequest, dbManager);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //produqtebis raodenobis ganaxleba (schirdeba paroli)
        super.doPut(req, resp);
    }
}
