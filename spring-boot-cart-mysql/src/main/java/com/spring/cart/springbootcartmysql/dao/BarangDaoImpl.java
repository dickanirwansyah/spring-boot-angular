package com.spring.cart.springbootcartmysql.dao;

import com.spring.cart.springbootcartmysql.entity.Barang;
import com.spring.cart.springbootcartmysql.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
@Service
public class BarangDaoImpl implements BarangDao{

    @Autowired
    private BarangRepository barangRepository;


    @Override
    public List<Barang> listBarang() {
        List<Barang> barangs = new ArrayList<>();
        for(Barang barang : barangRepository.findAll()){
            barangs.add(barang);
        }
        return barangs;
    }
}
