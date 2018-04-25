package com.spring.cart.springbootcartmysql.service;

import com.spring.cart.springbootcartmysql.dao.controller.BarangDaoController;
import com.spring.cart.springbootcartmysql.dto.model.InsertModelBarang;
import com.spring.cart.springbootcartmysql.dto.model.UpdateModelBarang;
import com.spring.cart.springbootcartmysql.entity.Barang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangServiceImpl implements BarangService{

    @Autowired
    private BarangDaoController barangDaoController;

    @Override
    public List<Barang> listBarang() {
        return barangDaoController.listBarang();
    }

    @Override
    public Barang createdBarang(InsertModelBarang insert) {
        return barangDaoController.insertBarang(insert);
    }

    @Override
    public Barang updatedBarang(UpdateModelBarang updated) {
        return barangDaoController.UpdateBarang(updated);
    }

    @Override
    public Barang findIdbarang(int idbarang) {
        return barangDaoController.findIdbarang(idbarang);
    }
}
