package com.csss.training.dao;

import com.csss.training.fileaccess.FileAccess;
import com.csss.training.model.Product;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larry on 11/7/15.
 */
public class ShoppingCartDummyDao implements ShoppingCartDao {

    private static final String []DB_PATH = {
            "resources/productlist.txt",
            "resources/shoppingcart.txt"
    };

    private static final int PRODUCT_LIST = 0;
    private static final int SHOPPING_CART = 1;

    private Product[] productDatabase;
    private FileAccess fileAccessProdList;
    private FileAccess fileAccessShoppCart;

    private List<String> fileDataProd = new ArrayList<>();
    private List<String> fileDataShoppCart = new ArrayList<>();

    public ShoppingCartDummyDao() throws IOException {
        super();

        fileAccessProdList = new FileAccess(DB_PATH[PRODUCT_LIST]);
        fileAccessShoppCart = new FileAccess(DB_PATH[SHOPPING_CART]);

        fileDataProd = fileAccessProdList.readFile();
        fileDataShoppCart = fileAccessShoppCart.readFile();

        productDatabase = new Product[fileDataProd.size()];
        Product products[] = new Product[fileDataProd.size()];

        int counter = 0;

        for(String s : fileDataProd){
            products[counter] = new Product();
            String[] splitData = s.split("\t\t");

            products[counter].setNumber(counter+1);
            products[counter].setName(splitData[0]);
            products[counter].setQuantity(Integer.parseInt(splitData[1]));
            products[counter].setPrice(new BigDecimal(splitData[2]));
            productDatabase[counter] = products[counter];
            counter++;
        }
    }

    @Override
    public void purchasedProduct(int prodNumber, int prodQuantity) throws IOException {
        for(Product prod : productDatabase){
            if(prodNumber == prod.getNumber() && prodQuantity <= prod.getQuantity() && prodNumber > 0 && prodQuantity > 0){
                fileDataShoppCart.add(prod.getName()+"\t\t"+prodQuantity+"\t\t"+prod.getPrice());
                prod.setQuantity(prod.getQuantity() - prodQuantity);
                fileDataProd.set((prodNumber-1), prod.getName()+"\t\t"+prod.getQuantity()+"\t\t"+prod.getPrice());
            }
        }
        fileAccessProdList.writeFile(fileDataProd);
        fileAccessShoppCart.writeFile(fileDataShoppCart);
    }

    @Override
    public List<String> getProductList() {
        return fileDataProd;
    }

    @Override
    public List<String> getShoppCartList() {
        return fileDataShoppCart;
    }
}
