package com.spring.cart.springbootcartmysql.controller.thecontroller;

import com.spring.cart.springbootcartmysql.dto.model.OrdersModel;
import com.spring.cart.springbootcartmysql.entity.Orders;
import com.spring.cart.springbootcartmysql.entity.OrdersBarang;
import com.spring.cart.springbootcartmysql.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @GetMapping(value = "/api/ordered/list")
    public ResponseEntity<List<Orders>> listOrders(){
        return Optional.ofNullable(ordersService.listOrders())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/api/orderebarang/list")
    public ResponseEntity<List<OrdersBarang>> listOrdersBarang(){
        return Optional.ofNullable(ordersService.listOrdersBarang())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<OrdersBarang>>(HttpStatus.BAD_REQUEST));
    }
}
