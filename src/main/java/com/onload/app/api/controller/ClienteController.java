/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onload.app.api.controller;

import com.onload.app.api.models.Cliente;
import com.onload.app.api.repository.ClienteRepository;
import com.onload.app.api.util.DataUtil;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private DataUtil datautil;

    @GetMapping("/")
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Cliente save(@Valid @RequestBody Cliente cliente) {
        cliente.setData(datautil.dataHoje());
        return repo.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Cliente old = repo.findById(id).orElse(null);
        old.setNome(cliente.getNome());
        old.setTelefone(cliente.getTelefone());
        old.setEmail(cliente.getEmail());
        old.setCep(cliente.getCep());
        return repo.save(old);
    }

    @DeleteMapping("/{id}")
    public Cliente delete(@PathVariable Long id) {
        Cliente del = repo.findById(id).orElse(null);
        repo.delete(del);
        return del;
    }

}
