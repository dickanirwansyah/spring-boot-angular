package com.spring.cart.springbootcartmysql.dto.model;

import com.spring.cart.springbootcartmysql.entity.Barang;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BarangModel {

    private int idbarang;
    private String name;
    private String description;
    private int unitprice;
    private int quantity;

    public BarangModel(){}

    public BarangModel(Barang barang){
        this.idbarang = barang.getIdbarang();
        this.name = barang.getName();
        this.description = barang.getDescription();
        this.unitprice = barang.getUnitprice();
        this.quantity = barang.getQuantity();
    }

    public BarangModel(int idbarang, String name, String description, int unitprice, int quantity){
        this.idbarang = idbarang;
        this.name = name;
        this.description = description;
        this.unitprice = unitprice;
        this.quantity = quantity;
    }
}
