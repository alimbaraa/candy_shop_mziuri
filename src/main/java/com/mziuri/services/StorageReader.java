package com.mziuri.services;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import com.mziuri.models.Product;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class StorageReader {   //reads json file and fill up product table
    public void registerProducts() throws FileNotFoundException {
        JsonParser parser = new JsonParser();

        Object obj = parser.parseDoc(String.valueOf(new FileReader("C:\\Users\\PC\\IdeaProjects\\candy_shop_mziuri\\src\\main\\resources\\storage.json")));
        JsonArray jsonArray = (JsonArray) obj;

        for(Object jsonElement : jsonArray){
            Product product = (Product) jsonElement;
            DatabaseManager dbManager = new DatabaseManager();

            dbManager.addProductInDatabase(product);
        }
    }
}
