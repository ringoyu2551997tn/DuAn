/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import DomainModel.Hoadon;
import DomainModel.Sanpham;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangHoaDon;
import repositories.ImplBangSanPham;
import repositories.InterfaceBangHoaDon;
import repositories.InterfaceBangSanPham;

/**
 *
 * @author ADMIN
 */
public class NewClass {
     public static void main(String[] args) {
         InterfaceBangSanPham daosp = new ImplBangSanPham();
        List<Sanpham> list = new ArrayList();
        list = daosp.findAll(3, 3);
        for (Sanpham x : list ) {
            System.out.println(x.getTenSanPham());
        }
    }
}
