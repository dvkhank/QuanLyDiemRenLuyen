/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.services.BaoThieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author DELL
 */
@Controller
public class BaoThieuController {
    @Autowired
    private BaoThieuService baoThieuService;
    
    
    @GetMapping("/admin/baothieus")
    public String listBaoThieu(Model model) {
        model.addAttribute("baoThieus", this.baoThieuService.getBaoThieus());
        return "baothieu";
    }
}
