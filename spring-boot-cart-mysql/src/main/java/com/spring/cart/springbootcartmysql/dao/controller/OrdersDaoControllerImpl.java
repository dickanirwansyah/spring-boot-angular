package com.spring.cart.springbootcartmysql.dao.controller;

import com.spring.cart.springbootcartmysql.dto.model.OrdersBarangModel;
import com.spring.cart.springbootcartmysql.dto.model.OrdersModel;
import com.spring.cart.springbootcartmysql.entity.Barang;
import com.spring.cart.springbootcartmysql.entity.Orders;
import com.spring.cart.springbootcartmysql.entity.OrdersBarang;
import com.spring.cart.springbootcartmysql.repository.BarangRepository;
import com.spring.cart.springbootcartmysql.repository.OrdersBarangRepository;
import com.spring.cart.springbootcartmysql.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class OrdersDaoControllerImpl implements OrdersDaoController{

    private final OrdersRepository ordersRepository;
    private final OrdersBarangRepository ordersBarangRepository;
    private final BarangRepository barangRepository;

    @Autowired
    public OrdersDaoControllerImpl(OrdersRepository ordersRepository,
                                   OrdersBarangRepository ordersBarangRepository,
                                   BarangRepository barangRepository){

        this.ordersRepository = ordersRepository;
        this.ordersBarangRepository = ordersBarangRepository;
        this.barangRepository = barangRepository;
    }

    @Override
    public Orders createdOrders(OrdersModel ordersModel) {

        String idorders = ordersModel.getIdorders();
        Orders orders = null;
        boolean valid = false;

        if(idorders == null){
            orders = new Orders();
            valid = true;
        }

        orders.setOrdersName(ordersModel.getOrdersName());
        orders.setOrdersAddress(ordersModel.getOrdersAddress());
        orders.setOrdersEmail(ordersModel.getOrdersEmail());
        orders.setOrdersPhone(ordersModel.getOrdersPhone());
        orders.setTotal(ordersModel.getTotal());
        ordersRepository.save(orders);

        List<OrdersBarangModel> ordersBarangModels = ordersModel.getModels();
        for(OrdersBarangModel ord : ordersBarangModels){
            OrdersBarang ordersBarang = new OrdersBarang();
            ordersBarang.setOrders(orders);

            int idbarang = ord.getBarangModel().getIdbarang();
            Barang barang = barangRepository.findByIdbarang(idbarang);
            ordersBarang.setBarang(barang);
            ordersBarang.setPrice(barang.getUnitprice() * ord.getQuantity());
            ordersBarang.setQuantity(ord.getQuantity());
            ordersBarangRepository.save(ordersBarang);
        }

        return orders;
    }

    @Override
    public List<Orders> listOrders() {
        List<Orders> list = new ArrayList<>();
        for(Orders orders : ordersRepository.findAll()){
            list.add(orders);
        }
        return list;
    }

    @Override
    public List<OrdersBarang> listOrdersBarang() {
        List<OrdersBarang> ordersBarangList = new ArrayList<>();
        for(OrdersBarang ordersBarang : ordersBarangRepository.findAll()){
            ordersBarangList.add(ordersBarang);
        }
        return ordersBarangList;
    }
}
