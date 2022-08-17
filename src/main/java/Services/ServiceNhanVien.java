/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Nhanvien;
import ViewModels.NhanvienView;
import java.util.List;
import repositories.ImplBangNhanVien;

/**
 *
 * @author Ngọc Hùng
 */
public class ServiceNhanVien {
    private final ImplBangNhanVien _dao;

    public ServiceNhanVien() {
        _dao = new ImplBangNhanVien();
        getlst();
    }
    
    public List<Nhanvien> getlst() {
        return _dao.findAll();
    }
    
    public NhanvienView create(NhanvienView nv) {
        _dao.create(new Nhanvien(nv.getDiaChi(), nv.getEmail(), nv.getGioITinh(), nv.getMaNhanVien(), nv.getMatKhau(), nv.getNgaySinh(), nv.getSoDienThoai(), nv.getTaiKhoan(), nv.getTenNhanVien(), nv.getTrangThai(), nv.getVaiTro()));
        return new NhanvienView(nv.getDiaChi(), nv.getEmail(), nv.getGioITinh(), nv.getMaNhanVien(), nv.getMatKhau(), nv.getNgaySinh(), nv.getSoDienThoai(), nv.getTaiKhoan(), nv.getTenNhanVien(), nv.getTrangThai(), nv.getVaiTro());
    }

    public NhanvienView update(NhanvienView nv) {
        _dao.update(new Nhanvien(nv.getID_NhanVien(),nv.getDiaChi(), nv.getEmail(), nv.getGioITinh(), nv.getMaNhanVien(), nv.getMatKhau(), nv.getNgaySinh(), nv.getSoDienThoai(), nv.getTaiKhoan(), nv.getTenNhanVien(), nv.getTrangThai(), nv.getVaiTro()));
        return new NhanvienView(nv.getID_NhanVien(),nv.getDiaChi(), nv.getEmail(), nv.getGioITinh(), nv.getMaNhanVien(), nv.getMatKhau(), nv.getNgaySinh(), nv.getSoDienThoai(), nv.getTaiKhoan(), nv.getTenNhanVien(), nv.getTrangThai(), nv.getVaiTro());
    }
}
