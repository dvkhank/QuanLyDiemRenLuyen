/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.services;

import com.drl.pojo.HoatDong;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface HoatDongService {

    List<HoatDong> getHoatDongs(Map<String, String> params);

    void addOrUpdate(HoatDong h);
    HoatDong getHoatDongByIDd(int id);
    void deleteHoatDong(int id);

}

