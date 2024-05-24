/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.services.StatsService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class StatsController {

    @Autowired
    private StatsService StatsService;

    @GetMapping("/admin/stats")
    public String statsView(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("statsTheoKhoa", this.StatsService.statsDiemRenLuyenTheoKhoa());
        String thanhtich = params.get("thanhtich");
        int min = 0, max = 0;
        if (thanhtich != null) {
            if (thanhtich.equals("XUATSAC")) {
                min = 90;
                max = 100;
            } else if (thanhtich.equals("GIOI")) {
                min = 80;
                max = 89;
            } else if (thanhtich.equals("KHA")) {
                min = 70;
                max = 79;
            }
        } else {
            // Thiết lập giá trị mặc định nếu thanhtich không được đặt
            min = 0;
            max = 100;
        }
        
        int hocKi = 1;
        int namHoc = 2024;
        
        String hocKiString = params.get("hocKi");
        String namHocString = params.get("namHoc");

        if (hocKiString != null && namHocString != null) {
            hocKi = Integer.parseInt(hocKiString);
            namHoc = Integer.parseInt(namHocString);
        }

        model.addAttribute("statsTheoThanhTichVaTheoKhoa", this.StatsService.statsDiemRenLuyenTheoThanhTichVaTheoKhoa(min, max, hocKi, namHoc));
        
        int khoaId = 1;
        String khoaIdString = params.get("khoaId");
        if(khoaIdString != null) {
            khoaId = Integer.parseInt(khoaIdString);
        }
        model.addAttribute("statsTheoThanhTichVaTheoLop", this.StatsService.statsDiemRenLuyenTheoThanhTichVaTheoLop(min, max, hocKi, namHoc, khoaId));
        
        int lopId = 1;
        String lopIdString = params.get("lopId");
        if(lopIdString != null) {
            lopId = Integer.parseInt(lopIdString);
        }
        model.addAttribute("statsDiemRenLuyenTheoThanhTich", this.StatsService.statsDiemRenLuyenTheoThanhTich(min, max, hocKi, namHoc, lopId));
        
        
        
        
        return "stats";
//        List<Object[]> statsTheoKhoa = this.StatsService.statsDiemRenLuyenTheoKhoa();
//        for (Object[] c : statsTheoKhoa) {
//            System.out.println(Arrays.toString(c));
//        }
//        return "stats";
    }
}
