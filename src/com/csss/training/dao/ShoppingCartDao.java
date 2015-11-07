package com.csss.training.dao;

import java.io.IOException;
import java.util.List;

/**
 * Created by larry on 11/7/15.
 */
public interface ShoppingCartDao {
    public void purchasedProduct(int prodNumber, int prodQuantity) throws IOException;
    public List<String> getProductList();
    public List<String> getShopCartList();
}
