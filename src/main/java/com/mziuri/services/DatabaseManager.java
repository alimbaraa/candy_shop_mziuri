package com.mziuri.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.models.Product;
import com.mziuri.request.service.PurchaseRequest;
import com.mziuri.response.service.GetProductInfoResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("candy-shop");
    private final EntityManager entityManager = factory.createEntityManager();;
    private final CriteriaBuilder cb = entityManager.getCriteriaBuilder();;
    private final CriteriaQuery<Product> cqProd = cb.createQuery(Product.class);

    public void addProductInDatabase(Product product){
        entityManager.persist(product);

        entityManager.close();
        factory.close();
    }

    public List<Product> getProductsList(List<Product> list){ //productebis siis migeba
        Root<Product> products = cqProd.from(Product.class);
        cqProd.select(products);

        CriteriaQuery<Product> select = cqProd.select(products);
        TypedQuery<Product> query = entityManager.createQuery(select);
        list = query.getResultList();

        return list;
    }

    public void findProductWithName(HttpServletRequest req, HttpServletResponse resp, GetProductInfoResponse productInfoResponse, DatabaseManager dbManager) throws IOException {
        String name = req.getParameter("name");

        Root<Product> products = cqProd.from(Product.class);
        cqProd.where(cb.equal(products.get("name"), name));
        cqProd.select(products);

        var select = cqProd.select(products);
        TypedQuery<Product> query = entityManager.createQuery(select);

        productInfoResponse.setName(query.getSingleResult().getName());
        productInfoResponse.setPrice(query.getSingleResult().getPrice());
        productInfoResponse.setAmount(query.getSingleResult().getAmount());

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(productInfoResponse);

        if(productInfoResponse.getName() == null){
            resp.getWriter().write(405);
        } else {
            resp.getWriter().write(result);
        }
    }

    public void purchaseProduct(HttpServletRequest req, HttpServletResponse resp, PurchaseRequest purchaseRequest, DatabaseManager dbManager) throws IOException {
        List<Product> list = new ArrayList<>();

        String name = req.getParameter("name");
        int amount = Integer.parseInt(req.getParameter("amount"));
        dbManager.getProductsList(list);

        for(Product p : list){
            if(p.getName().equals(name)){
                if(p.getAmount() >= amount){
                    purchaseRequest.setName(name);
                    purchaseRequest.setAmount(amount);

                    ObjectMapper mapper = new ObjectMapper();
                    String result = mapper.writeValueAsString(purchaseRequest);

                    resp.getWriter().write(result);
                    resp.getWriter().write("bought");
                } else {
                    resp.getWriter().write(405);
                }
            } else {
                resp.getWriter().write(405);
            }
        }
    }
}
