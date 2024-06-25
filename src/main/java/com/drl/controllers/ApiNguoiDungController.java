/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.controllers;

import com.drl.components.JwtService;
import com.drl.pojo.NguoiDung;
import com.drl.services.NguoiDungService;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiNguoiDungController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private JwtService jwtService;

    @PostMapping(path = "/nguoidung", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void createSinhVien(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) throws ParseException {
        NguoiDung n = new NguoiDung();
        n.setHo(params.get("ho"));
        n.setTen(params.get("ten"));
        n.setEmail(params.get("email"));
        n.setUsername(params.get("username"));
        String password = params.get("password");

        n.setPassword(this.passwordEncoder.encode((password)));
        n.setUserRole("ROLE_SINHVIEN");
        String namSinh = params.get("namsinh");

        if (namSinh != null && !namSinh.isEmpty()) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(namSinh);
                n.setNamSinh(date);
            } catch (ParseException e) {
                // Xử lý khi không thể parse ngày sinh
                e.printStackTrace(); // hoặc log lỗi
                // Có thể throw ngoại lệ hoặc xử lý khác tùy theo yêu cầu
            }
        } else {
            // Xử lý khi ngày sinh là null hoặc rỗng
        }

        // Xử lý giới tính
        String gioiTinh = params.get("gioitinh");
        if (gioiTinh != null && !gioiTinh.isEmpty()) {
            try {
                Short gt = Short.parseShort(gioiTinh);
                n.setGioiTinh(gt);
            } catch (NumberFormatException e) {
                // Xử lý khi không thể parse giới tính
                e.printStackTrace(); // hoặc log lỗi
                // Có thể throw ngoại lệ hoặc xử lý khác tùy theo yêu cầu
            }
        } else {
            // Xử lý khi giới tính là null hoặc rỗng
        }

        if (file.length > 0) {
            n.setFile((file[0]));
        }
        this.nguoiDungService.addNguoiDung(n);
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody NguoiDung nguoiDung) {
        if (this.nguoiDungService.authNguoiDung(nguoiDung.getUsername(), nguoiDung.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(nguoiDung.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/current-user", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<NguoiDung> getCurrentNguoiDung(Principal p) {
                    System.out.println(p);
        // Kiểm tra xem Principal p có null không
        if (p == null || p.getName() == null) {

            // Trả về HTTP 401 Unauthorized nếu không có Principal hoặc tên người dùng là null
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Gọi service để lấy thông tin người dùng dựa trên tên đăng nhập (username)
        NguoiDung u = this.nguoiDungService.getNguoiDungByUsername(p.getName());

        // Kiểm tra xem người dùng có tồn tại không
        if (u == null) {
            // Trả về HTTP 404 Not Found nếu không tìm thấy người dùng
            return ResponseEntity.notFound().build();
        }

        // Trả về thông tin người dùng và HTTP 200 OK nếu thành công
        return ResponseEntity.ok(u);
    }

}
