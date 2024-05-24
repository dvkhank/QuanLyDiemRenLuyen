/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.pojo.NguoiDung;
import com.drl.services.NguoiDungService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungservice;
    @GetMapping("/admin/troly")
    public String createView(Model model){
        model.addAttribute("nguoidung", new NguoiDung());
        return "troly";
    }
    @PostMapping("/admin/troly")
    public String createTroLy(@ModelAttribute (value="nguoidung") @Valid NguoiDung nguoidung, BindingResult rs, @RequestParam("khoaId") int khoaId) {
        if(!rs.hasErrors()) {
            try {
                System.out.println(nguoidung.getHo());
               System.out.println(nguoidung.getNamSinh());

                this.nguoiDungservice.addTroLy(nguoidung, khoaId);
                return "redirect:/";
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.err.println(rs);
        return "troly";
    }
    @GetMapping("/login")
    public String loginAdmin() {
        return "login";
    }

    
}
