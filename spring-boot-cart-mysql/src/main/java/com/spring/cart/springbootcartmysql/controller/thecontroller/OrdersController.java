package com.spring.cart.springbootcartmysql.controller.thecontroller;

import com.spring.cart.springbootcartmysql.dto.model.OrdersModel;
import com.spring.cart.springbootcartmysql.entity.Orders;
import com.spring.cart.springbootcartmysql.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping(value = "/api/created/ordered")
    public ResponseEntity<Orders> createdOrders(@RequestBody OrdersModel ordersModel){
        return Optional.ofNullable(ordersService.createdOrders(ordersModel))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Orders>(HttpStatus.BAD_REQUEST));
    }
}
