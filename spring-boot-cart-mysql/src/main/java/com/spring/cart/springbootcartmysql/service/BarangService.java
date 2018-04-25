package com.spring.cart.springbootcartmysql.service;

import com.spring.cart.springbootcartmysql.dto.model.InsertModelBarang;
import com.spring.cart.springbootcartmysql.dto.model.UpdateModelBarang;
import com.spring.cart.springbootcartmysql.entity.Barang;

import java.util.List;

public interface BarangService {

    List<Barang> listBarang();
    Barang createdBarang(InsertModelBarang insert);
    Barang updatedBarang(UpdateModelBarang updated);
    Barang findIdbarang(int idbarang);
}
