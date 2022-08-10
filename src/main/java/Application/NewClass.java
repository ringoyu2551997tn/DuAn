/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import DomainModel.Hoadon;

import DomainModel.Nhanvien;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangHoaDon;
import repositories.ImplBangNhanVien;
import repositories.InterfaceBangHoaDon;
import repositories.InterfaceBangNhanVien;

import Views.FrmViewMainPage;

import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangHoaDon;
import repositories.InterfaceBangHoaDon;


/**
 *
 * @author ADMIN
 */
public class NewClass {
     public static void main(String[] args) {

         InterfaceBangNhanVien daonv = new ImplBangNhanVien();
        Nhanvien nv =  daonv.findbyEmail("lethithanhtam24102002hn@gmail.com", "tamltt");
     
            System.out.println(nv.getTenNhanVien());
 
    }

         new FrmViewMainPage().setVisible(true); 
        }

}
