/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onload.app.api.controller;

import com.onload.app.api.models.Pedido;
import com.onload.app.api.repository.PedidoRepository;
import com.onload.app.api.util.DataUtil;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alan
 */
@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repo;
    
    @Autowired
    private DataUtil datautil;
    
    @GetMapping("/")
    public List<Pedido> find(){
      return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Long id){
      return repo.findById(id).orElse(null);
    }
    
    @PostMapping("/")
    public Pedido save(@Valid @RequestBody Pedido pedido){
      pedido.setData(datautil.dataHoje());
      return repo.save(pedido);
    }
    
    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @Valid @RequestBody Pedido pedido){
      Pedido old = repo.findById(id).orElse(null);
      old.setProduto(pedido.getProduto());
      old.setTotal(pedido.getTotal());
      return repo.save(pedido);
    }
    
    @DeleteMapping("/{id}")
    public Pedido delete(@PathVariable Long id){
        Pedido del = repo.findById(id).orElse(null);
        if(del !=null){
        repo.delete(del);
        return del;
        }else{
        return new Pedido();
        }
    }
    
        
    
}
