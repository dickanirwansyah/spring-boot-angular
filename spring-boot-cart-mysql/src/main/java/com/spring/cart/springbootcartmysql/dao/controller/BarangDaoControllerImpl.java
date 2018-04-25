package com.spring.cart.springbootcartmysql.dao.controller;

import com.spring.cart.springbootcartmysql.dto.model.InsertModelBarang;
import com.spring.cart.springbootcartmysql.dto.model.UpdateModelBarang;
import com.spring.cart.springbootcartmysql.entity.Barang;
import com.spring.cart.springbootcartmysql.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class BarangDaoControllerImpl implements BarangDaoController{

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public Barang insertBarang(InsertModelBarang inserted) {
        int idbarang = inserted.getIdbarang();
        boolean valid = false;
        Barang barang = null;

        if(idbarang == 0){
            barang = new Barang();
            valid = true;
        }

        barang.setName(inserted.getName());
        barang.setDescription(inserted.getDescription());
        barang.setQuantity(inserted.getQuantity());
        barang.setUnitprice(inserted.getUnitprice());
        return barangRepository.save(barang);
    }

    @Override
    public Barang UpdateBarang(UpdateModelBarang updated) {
        int idbarang = updated.getIdbarang();
        boolean valid = false;
        Barang barang = null;

        if(idbarang != 0){
            barang = barangRepository.findByIdbarang(idbarang);
            valid = true;
        }

        barang.setIdbarang(updated.getIdbarang());
        barang.setName(updated.getName());
        barang.setDescription(updated.getDescription());
        barang.setUnitprice(updated.getUnitprice());
        barang.setQuantity(updated.getQuantity());
        return barangRepository.save(barang);
    }

    @Override
    public List<Barang> listBarang() {
        List<Barang> list = new ArrayList<>();
        for (Barang barang: barangRepository.findAll()) {
            list.add(barang);
        }
        return list;
    }

    @Override
    public Barang findIdbarang(int idbarang) {
        return barangRepository.findByIdbarang(idbarang);
    }
}
