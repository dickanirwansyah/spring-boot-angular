package com.spring.cart.springbootcartmysql.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Orders implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idorders;

    @NotBlank(message = "nama masih kosong")
    @Column(name = "orders_name", nullable = false)
    private String ordersName;

    @NotBlank(message = "email masih kosong")
    @Email(message = "email tidak valid")
    @Column(name = "orders_email", nullable = false)
    private String ordersEmail;

    @NotBlank(message = "phone masih kosong")
    @Column(name = "orders_phone", nullable = false)
    private String ordersPhone;

    @NotBlank(message = "address masih kosong")
    @Column(name = "orders_address", nullable = false)
    private String ordersAddress;

    @NotNull(message = "total masih kosong")
    @Column(name = "total", nullable = false)
    private int total;

    public String getIdorders(){
        return idorders;
    }

    public void setIdorders(String idorders){
        this.idorders = idorders;
    }

    public String getOrdersName(){
        return ordersName;
    }

    public void setOrdersName(String ordersName){
        this.ordersName = ordersName;
    }

    public String getOrdersPhone(){
        return ordersPhone;
    }

    public void setOrdersPhone(String ordersPhone){
        this.ordersPhone = ordersPhone;
    }

    public String getOrdersAddress(){
        return ordersAddress;
    }

    public void setOrdersAddress(String ordersAddress){
        this.ordersAddress = ordersAddress;
    }

    public String getOrdersEmail(){
        return ordersEmail;
    }

    public void setOrdersEmail(String ordersEmail){
        this.ordersEmail = ordersEmail;
    }

    public int getTotal(){
        return total;
    }

    public void setTotal(int total){
        this.total = total;
    }
}
