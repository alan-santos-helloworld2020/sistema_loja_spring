/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.onload.app.api.repository;

import com.onload.app.api.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alan
 */
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
}
