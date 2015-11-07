package com.csss.training.service;

import com.csss.training.dao.ShoppingCartDummyDao;
import java.io.IOException;
import java.util.List;

/**
 * Created by larry on 11/7/15.
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartDummyDao dummyDao;

    public ShoppingCartServiceImpl() throws IOException{
        super();
        dummyDao = new ShoppingCartDummyDao();
    }

    @Override
    public void purchasedProduct(int prodNumber, int prodQuantity) throws IOException {
        dummyDao.purchasedProduct(prodNumber, prodQuantity);
    }

    @Override
    public List<String> getProductList() {
        return dummyDao.getProductList();
    }

    @Override
    public List<String> getShoppCartList() {
        return dummyDao.getShoppCartList();
    }
}
