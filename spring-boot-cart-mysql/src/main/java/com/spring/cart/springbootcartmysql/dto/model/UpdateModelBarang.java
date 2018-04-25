package com.spring.cart.springbootcartmysql.dto.model;

public class UpdateModelBarang {

    private int idbarang;
    private String name;
    private String description;
    private int quantity;
    private int unitprice;

    public UpdateModelBarang(){}

    public UpdateModelBarang(int idbarang, String name, String description, int quantity, int unitprice){
        this.idbarang = idbarang;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }

    public int getIdbarang(){
        return idbarang;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getUnitprice(){
        return unitprice;
    }
}
