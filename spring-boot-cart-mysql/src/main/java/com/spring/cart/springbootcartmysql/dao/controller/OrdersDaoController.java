package com.spring.cart.springbootcartmysql.dao.controller;

import com.spring.cart.springbootcartmysql.dto.model.OrdersModel;
import com.spring.cart.springbootcartmysql.entity.Orders;
import com.spring.cart.springbootcartmysql.entity.OrdersBarang;

import java.util.List;

public interface OrdersDaoController {

    Orders createdOrders(OrdersModel ordersModel);
    List<Orders> listOrders();
    List<OrdersBarang> listOrdersBarang();
}
