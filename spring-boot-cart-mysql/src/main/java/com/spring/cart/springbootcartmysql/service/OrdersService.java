package com.spring.cart.springbootcartmysql.service;

import com.spring.cart.springbootcartmysql.dto.model.OrdersModel;
import com.spring.cart.springbootcartmysql.entity.Orders;
import com.spring.cart.springbootcartmysql.entity.OrdersBarang;

import java.util.List;

public interface OrdersService {

    Orders createdOrders(OrdersModel ordersModel);
    List<Orders> listOrders();
    List<OrdersBarang> listOrdersBarang();
}
