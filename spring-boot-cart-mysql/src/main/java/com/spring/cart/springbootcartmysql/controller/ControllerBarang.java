package com.spring.cart.springbootcartmysql.controller;

import com.spring.cart.springbootcartmysql.dao.BarangDao;
import com.spring.cart.springbootcartmysql.entity.Barang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/api/barang")
public class ControllerBarang {

    @Autowired
    private BarangDao barangDao;

    @GetMapping
    public List<Barang> listBarang(){
        return barangDao.listBarang();
    }
}
