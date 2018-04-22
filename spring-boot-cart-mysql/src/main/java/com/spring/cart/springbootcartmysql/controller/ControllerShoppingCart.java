package com.spring.cart.springbootcartmysql.controller;

import com.spring.cart.springbootcartmysql.dao.ShoppingCartDao;
import com.spring.cart.springbootcartmysql.dto.ShoppingCartDto;
import com.spring.cart.springbootcartmysql.dto.ShoppingDto;
import com.spring.cart.springbootcartmysql.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/api/shopping")
public class ControllerShoppingCart {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @PostMapping(value = "/created")
    public ResponseEntity<ShoppingCart> created(@RequestBody ShoppingDto shopping){
        return Optional.ofNullable(shoppingCartDao.createdShoppingCart(shopping))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<ShoppingCart>(HttpStatus.BAD_REQUEST));
    }

    /**
    @PostMapping(value = "/updated")
    public ResponseEntity<ShoppingCart> updated(@RequestBody ShoppingDto shopping){
        return Optional.ofNullable(shoppingCartDao.updateShoppingCart(shopping))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<ShoppingCart>(HttpStatus.BAD_REQUEST));
    }
     **/

    @PostMapping(value = "/updated/{idshopping}")
    public ResponseEntity<ShoppingCart> updated(@RequestBody ShoppingCartDto shopping,
                                                @PathVariable String idshopping){
        return Optional.ofNullable(shoppingCartDao.updateShoppingCart(shopping, Integer.parseInt(idshopping)))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<ShoppingCart>(HttpStatus.BAD_REQUEST));
    }


    @GetMapping(value = "/purchased")
    public ResponseEntity<List<ShoppingCart>> listByPurchased(){
        return Optional.ofNullable(shoppingCartDao.listByPurchased())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<ShoppingCart>>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/not_purchased")
    public ResponseEntity<List<ShoppingCart>> listByNotPurchased(){
        return Optional.ofNullable(shoppingCartDao.listShoppingCart())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<ShoppingCart>>(HttpStatus.BAD_REQUEST));
    }
}
