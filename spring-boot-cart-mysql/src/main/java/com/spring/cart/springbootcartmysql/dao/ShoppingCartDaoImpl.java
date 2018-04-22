package com.spring.cart.springbootcartmysql.dao;

import com.spring.cart.springbootcartmysql.dto.ShoppingCartDto;
import com.spring.cart.springbootcartmysql.dto.ShoppingDto;
import com.spring.cart.springbootcartmysql.entity.Barang;
import com.spring.cart.springbootcartmysql.entity.ShoppingCart;
import com.spring.cart.springbootcartmysql.repository.BarangRepository;
import com.spring.cart.springbootcartmysql.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
@Service
public class ShoppingCartDaoImpl implements ShoppingCartDao{

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public ShoppingCart createdShoppingCart(ShoppingDto shopping) {
        int idshopping = shopping.getIdshopping();
        ShoppingCart entityShopping = new ShoppingCart();
        Barang barang = null;
        boolean valid = false;

        if(idshopping == 0){
            entityShopping = new ShoppingCart();
            barang = barangRepository.findByIdbarang(shopping.getBarang().getIdbarang());
            valid = true;
        }
        entityShopping.setStatus(shopping.getStatus());
        entityShopping.setBarang(barang);
        entityShopping.setStock(shopping.getStock());
        entityShopping.setDate(new Date());
        entityShopping.setAmout(barang.getUnitprice() * shopping.getStock());
        return shoppingCartRepository.save(entityShopping);
    }

    /*find by cart not -> purchased*/
    @Override
    public List<ShoppingCart> listShoppingCart() {
        List<ShoppingCart> listAdd = new ArrayList<>();
        for (ShoppingCart cartlist : shoppingCartRepository.findByStatus("NOT_PURCHASED")){
            listAdd.add(cartlist);
        }
        return listAdd;
    }

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCartDto shopping, int idshopping) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByIdshopping(idshopping);
        shoppingCart.setStock(shopping.getStock());
        shoppingCart.setAmout(shoppingCart.getBarang().getUnitprice() * shopping.getStock());
        return shoppingCartRepository.save(shoppingCart);
    }

    /*find by cart purchased*/
    @Override
    public List<ShoppingCart> listByPurchased() {
        List<ShoppingCart> listadd = new ArrayList<>();
        for(ShoppingCart listcart : shoppingCartRepository.findByStatus("PURCHASED")){
            listadd.add(listcart);
        }
        return listadd;
    }

    @Override
    public void deleteProduct(int idshopping) {

    }

    @Override
    public void clearShoppingCart(Object object) {

    }

    @Override
    public void prosesPurchased(int idshopping) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByIdshopping(idshopping);
        shoppingCart.setStatus("PURCHASED");
        shoppingCartRepository.save(shoppingCart);
    }
}
