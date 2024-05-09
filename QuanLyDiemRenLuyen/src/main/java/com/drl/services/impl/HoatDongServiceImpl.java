/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.services.impl;

import com.drl.pojo.HoatDong;
import com.drl.repositories.HoatDongRepository;
import com.drl.services.HoatDongService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class HoatDongServiceImpl implements HoatDongService{
    @Autowired
    private HoatDongRepository hoatDongRepo;

    @Override
    public List<HoatDong> getHoatDongs(Map<String, String> params) {
        return this.hoatDongRepo.getHoatDongs(params);
    }

    @Override
    public void addOrUpdate(HoatDong h) {
        this.hoatDongRepo.addOrUpdate(h);
    }

    @Override
    public HoatDong getHoatDongByIDd(int id) {
        return this.hoatDongRepo.getHoatDongByIDd(id);
    }

    @Override
    public void deleteHoatDong(int id) {
        this.hoatDongRepo.deleteHoatDong(id);
    }
    
}
