package com.spring.cart.springbootcartmysql.dao;

import com.spring.cart.springbootcartmysql.dto.ShoppingCartDto;
import com.spring.cart.springbootcartmysql.dto.ShoppingDto;
import com.spring.cart.springbootcartmysql.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {

    //created shopping cart
    ShoppingCart createdShoppingCart(ShoppingDto shopping);
    //list shopping cart
    List<ShoppingCart> listShoppingCart();
    //update cart
    ShoppingCart updateShoppingCart(ShoppingCartDto shopping, int idshopping);

    List<ShoppingCart> listByPurchased();
    //delete product
    void deleteProduct(int idshopping);
    //clear cart
    void clearShoppingCart(Object object);
    //payment
    void prosesPurchased(int idshopping);
}
