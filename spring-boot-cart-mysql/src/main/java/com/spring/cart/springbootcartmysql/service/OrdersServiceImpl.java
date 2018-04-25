package com.spring.cart.springbootcartmysql.service;

import com.spring.cart.springbootcartmysql.dao.controller.OrdersDaoController;
import com.spring.cart.springbootcartmysql.dto.model.OrdersModel;
import com.spring.cart.springbootcartmysql.entity.Orders;
import com.spring.cart.springbootcartmysql.entity.OrdersBarang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersDaoController ordersDaoController;

    @Override
    public Orders createdOrders(OrdersModel ordersModel) {
        return ordersDaoController.createdOrders(ordersModel);
    }

    @Override
    public List<Orders> listOrders() {
        return null;
    }

    @Override
    public List<OrdersBarang> listOrdersBarang() {
        return null;
    }
}
