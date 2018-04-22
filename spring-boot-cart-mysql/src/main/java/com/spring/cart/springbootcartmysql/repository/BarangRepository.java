package com.spring.cart.springbootcartmysql.repository;

import com.spring.cart.springbootcartmysql.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<Barang, Integer> {

    Barang findByIdbarang(int idbarang);
}
