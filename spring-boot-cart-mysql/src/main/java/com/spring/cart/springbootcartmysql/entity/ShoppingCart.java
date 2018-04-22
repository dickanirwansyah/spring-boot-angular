package com.spring.cart.springbootcartmysql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idshopping;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idbarang", nullable = false)
    private Barang barang;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "amout", nullable = false)
    private int amout;

    @Column(name = "status")
    private String status;

    @Column(name = "date", nullable = false)
    private Date date;
}
