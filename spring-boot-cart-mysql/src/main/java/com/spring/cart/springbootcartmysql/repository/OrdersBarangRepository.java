package com.spring.cart.springbootcartmysql.repository;

import com.spring.cart.springbootcartmysql.entity.OrdersBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersBarangRepository extends JpaRepository<OrdersBarang, String>{

    @Query
    OrdersBarang findByIdordersbarang(String idordersbarang);
}
