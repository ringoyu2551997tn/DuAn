/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author lucif
 */
public class SanPhamView {
    private int ID_SanPham;
    private double giaTien;
    private String hinhAnh;
    private String maSanPham;
    private String tenSanPham;

    public SanPhamView() {
    }

    public SanPhamView(int ID_SanPham, double giaTien, String hinhAnh, String maSanPham, String tenSanPham) {
        this.ID_SanPham = ID_SanPham;
        this.giaTien = giaTien;
        this.hinhAnh = hinhAnh;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
    }

    public int getID_SanPham() {
        return ID_SanPham;
    }

    public void setID_SanPham(int ID_SanPham) {
        this.ID_SanPham = ID_SanPham;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
    
    
}
