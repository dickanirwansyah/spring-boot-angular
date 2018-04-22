package com.spring.cart.springbootcartmysql.repository;

import com.spring.cart.springbootcartmysql.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    List<ShoppingCart> findByStatus(String status);
    ShoppingCart findByIdshopping(int idshopping);
}
