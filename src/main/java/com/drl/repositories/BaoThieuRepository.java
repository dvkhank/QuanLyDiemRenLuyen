/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.drl.repositories;

import com.drl.pojo.BaoThieu;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BaoThieuRepository {
    public List<BaoThieu> getBaoThieus( );
    public void updateBaoThieu(int id);
    public void deleteBaoThieu(int id);
}
