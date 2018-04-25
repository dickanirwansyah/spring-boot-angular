package com.spring.cart.springbootcartmysql.controller.thecontroller;

import com.spring.cart.springbootcartmysql.dto.model.InsertModelBarang;
import com.spring.cart.springbootcartmysql.dto.model.UpdateModelBarang;
import com.spring.cart.springbootcartmysql.entity.Barang;
import com.spring.cart.springbootcartmysql.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BarangController {

    @Autowired
    private BarangService barangService;

    @GetMapping(value = "/api/list/barang")
    public ResponseEntity<List<Barang>> list(){
        return Optional.ofNullable(barangService.listBarang())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Barang>>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/created/barang")
    public ResponseEntity<Barang> created(@Valid @RequestBody InsertModelBarang insert){
        return Optional.ofNullable(barangService.createdBarang(insert))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON,HttpStatus.CREATED))
                .orElse(new ResponseEntity<Barang>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/api/list/barang/{idbarang}")
    public ResponseEntity<Barang> find(@PathVariable String idbarang){
        return Optional.ofNullable(barangService.findIdbarang(Integer.parseInt(idbarang)))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<Barang>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(value = "/api/updated/barang")
    public ResponseEntity<Barang> updated(@Valid @RequestBody UpdateModelBarang updated){
        return Optional.ofNullable(barangService.updatedBarang(updated))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<Barang>(HttpStatus.BAD_REQUEST));
    }
}
