package com.spring.cart.springbootcartmysql.dto;

import com.spring.cart.springbootcartmysql.entity.Barang;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class ShoppingDto {

    private int idshopping;
    private Barang barang;
    private int stock;
    private int amout;
    private String status;
    private Date date;
}
