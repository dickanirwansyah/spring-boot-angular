package com.spring.cart.springbootcartmysql.dto.model;

import com.spring.cart.springbootcartmysql.dto.model.BarangModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrdersBarangModel {

    private BarangModel barangModel;
    private int quantity;
    private int price;

}
