package com.spring.cart.springbootcartmysql.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingCartIdDto {

    private List<Integer> ids;
}
