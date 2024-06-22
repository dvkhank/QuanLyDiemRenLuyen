/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.services.BaoThieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
public class ApiBaoThieuController {
    @Autowired
    private BaoThieuService baoThieuService;
    @PutMapping("/admin/baothieus/{baothieuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void baoThieu(@PathVariable(value = "baothieuid") int id) {
        this.baoThieuService.updateBaoThieu(id);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/baothieus/{baothieuid}")
    public void deleteBaoThieu(@PathVariable(value = "baothieuid") int id) {
        this.baoThieuService.deleteBaoThieu(id);
    }
}
