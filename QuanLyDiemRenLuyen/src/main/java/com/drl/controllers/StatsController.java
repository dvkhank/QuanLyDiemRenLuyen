/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.services.StatsService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author DELL
 */
@Controller
public class StatsController {
    @Autowired
    private StatsService StatsService;
    @GetMapping("/stats")
    public String statsView(Model model) {
        model.addAttribute("statsTheoKhoa", this.StatsService.statsDiemRenLuyenTheoKhoa());   
        
        return "stats";
//        List<Object[]> statsTheoKhoa = this.StatsService.statsDiemRenLuyenTheoKhoa();
//        for (Object[] c : statsTheoKhoa) {
//            System.out.println(Arrays.toString(c));
//        }
//        return "stats";
    }
}
