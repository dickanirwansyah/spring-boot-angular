package com.spring.cart.springbootcartmysql.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShoppingCartDto {
    private int idbarang;
    private int stock;
    private String status;
}
