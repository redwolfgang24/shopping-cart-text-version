package com.csss.training.service;

import java.io.IOException;
import java.util.List;

/**
 * Created by larry on 11/7/15.
 */
public interface ShoppingCartService {
    public List<String> getProductList();
    public List<String> getShoppCartList();
    public void purchasedProduct(int number, int quantity) throws IOException;
}
