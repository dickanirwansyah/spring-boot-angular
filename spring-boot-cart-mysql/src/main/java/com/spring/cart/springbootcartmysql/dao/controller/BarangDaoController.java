package com.spring.cart.springbootcartmysql.dao.controller;

import com.spring.cart.springbootcartmysql.dto.model.InsertModelBarang;
import com.spring.cart.springbootcartmysql.dto.model.UpdateModelBarang;
import com.spring.cart.springbootcartmysql.entity.Barang;

import java.util.List;

public interface BarangDaoController {

    Barang insertBarang(InsertModelBarang inserted);
    Barang UpdateBarang(UpdateModelBarang updated);
    List<Barang> listBarang();
    Barang findIdbarang(int idbarang);
}
