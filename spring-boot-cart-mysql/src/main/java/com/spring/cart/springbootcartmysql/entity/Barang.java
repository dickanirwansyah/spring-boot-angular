package com.spring.cart.springbootcartmysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name = "barang")
public class Barang implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbarang;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unitprice", nullable = false)
    private int unitprice;

    public Barang(){}

    public Barang(String name, String description, int quantity, int unitprice){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }
}
