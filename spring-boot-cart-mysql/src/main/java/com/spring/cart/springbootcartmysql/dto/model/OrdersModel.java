package com.spring.cart.springbootcartmysql.dto.model;

import com.spring.cart.springbootcartmysql.entity.Barang;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class OrdersModel {

    private String idorders;
    private String ordersName;
    private Barang barang;
    private String ordersEmail;
    private String ordersPhone;
    private String ordersAddress;
    private int total;
    private List<OrdersBarangModel> models;
}
