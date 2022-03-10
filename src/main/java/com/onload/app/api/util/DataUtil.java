/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onload.app.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author alan
 */
@Service
public class DataUtil {

    public String dataHoje() {
        DateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
        return dateformate.format(new Date());
    }

}
