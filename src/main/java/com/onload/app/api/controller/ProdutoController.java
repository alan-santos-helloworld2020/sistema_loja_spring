/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onload.app.api.controller;

import com.onload.app.api.models.Produto;
import com.onload.app.api.repository.ProdutoRepository;
import com.onload.app.api.util.DataUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alan
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repo;
    @Autowired
    private DataUtil datautil;

    @GetMapping("/")
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Produto save(@Valid Produto produto, @RequestParam("imagem") MultipartFile imagem) {
        produto.setData(datautil.dataHoje());
        try {
            byte[] bytes = imagem.getBytes();
            Path caminho = Paths.get("./uploads/" + imagem.getOriginalFilename());
            Files.write(caminho, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        produto.setFoto(imagem.getOriginalFilename());
        return repo.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) {
        Produto old = repo.findById(id).orElse(null);
        if (old != null) {
            old.setFoto(produto.getFoto());
            old.setNome(produto.getFoto());
            old.setDescricao(produto.getDescricao());
            old.setPreco_unitario(produto.getPreco_unitario());
            old.setPreco_venda(produto.getPreco_venda());
            repo.save(old);
            return produto;
        } else {
            return new Produto();
        }
    }

    @DeleteMapping("/{id}")
    public Produto delete(@PathVariable Long id) {
        Produto produto = repo.findById(id).orElse(null);
        if (produto != null) {
            repo.delete(produto);
            return produto;
        } else {
            return new Produto();
        }

    }

}
