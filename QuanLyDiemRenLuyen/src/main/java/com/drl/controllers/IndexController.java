/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.drl.services.DieuService;
import com.drl.services.HoatDongService;
import com.drl.services.HocKiNamHocService;
import com.drl.services.KhoaService;
import com.drl.services.TroLySinhVienService;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@ControllerAdvice
public class IndexController {
    @Autowired
   private DieuService dieuService;
    @Autowired
    private HoatDongService hoatDongService;
    
    @Autowired
    private HocKiNamHocService hocKiNamHocService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private TroLySinhVienService troLySinhVienService;
    @RequestMapping("/")
    public String index (Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("hoatDongs", this.hoatDongService.getHoatDongs(params));
        return "index";//Tìm trong tiles
    }
    @ModelAttribute//Tất cả các response trong Controller này sẽ có thông tin này, gắn ControllerAdvice sẽ dùng ModelAt tribute chung cho các controller khác
    public void commonAttribute(Model model) {
      model.addAttribute("dieus", this.dieuService.getDieus());
      model.addAttribute("hocKiNamHocs", this.hocKiNamHocService.getHocKiNamHocs());
      model.addAttribute("khoas", this.khoaService.getKhoas());
      model.addAttribute("troLys", this.troLySinhVienService.getTroLys());
    
}
}
