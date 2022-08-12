/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Hoadon;
import DomainModel.Nhanvien;
import ViewModels.HoadonView;
import ViewModels.NhanvienView;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangNhanVien;
import repositories.InterfaceBangNhanVien;

/**
 *
 * @author ADMIN
 */
public class ServiceNhanVien implements IServiceBangNhanVien {

    InterfaceBangNhanVien daonv;
    List<NhanvienView> listNVModel;

    public ServiceNhanVien() {
        daonv = new ImplBangNhanVien();
        getlst();
    }
    
    public List<Nhanvien> getlst() {
        return daonv.findAll();
    }

    Nhanvien setdata(NhanvienView nv) {
        Nhanvien nv1 = new Nhanvien();
        nv1.setMaNhanVien(nv.getMaNhanVien());
        nv1.setTenNhanVien(nv.getTenNhanVien());
        nv1.setTaiKhoan(nv.getTaiKhoan());
        nv1.setMatKhau(nv.getMatKhau());
        nv1.setTrangThai(nv.getTrangThai());
        nv1.setGioITinh(nv.getGioITinh());
        nv1.setNgaySinh(nv.getNgaySinh());
        nv1.setSoDienThoai(nv.getSoDienThoai());
        nv1.setVaiTro(nv.getVaiTro());
        nv1.setDiaChi(nv.getDiaChi());
        nv1.setEmail(nv.getEmail());

        return nv1;
    }

    NhanvienView setdata2(Nhanvien nv) {
        NhanvienView nv1 = new NhanvienView();
        nv1.setMaNhanVien(nv.getMaNhanVien());
        nv1.setTenNhanVien(nv.getTenNhanVien());
        nv1.setTaiKhoan(nv.getTaiKhoan());
        nv1.setMatKhau(nv.getMatKhau());
        nv1.setTrangThai(nv.getTrangThai());
        nv1.setGioITinh(nv.getGioITinh());
        nv1.setNgaySinh(nv.getNgaySinh());
        nv1.setSoDienThoai(nv.getSoDienThoai());
        nv1.setVaiTro(nv.getVaiTro());
        nv1.setDiaChi(nv.getDiaChi());
        nv1.setEmail(nv.getEmail());

        return nv1;
    }

//    @Override
//    public List<NhanvienView> findAll(int position, int pageSize) {
//        return daonv.findAll(position, pageSize);
//    }
    @Override
    public List<NhanvienView> findAll() {
        List<NhanvienView> list = new ArrayList();
        for (Nhanvien x : daonv.findAll()) {
            list.add(new NhanvienView(x.getID_NhanVien(), x.getDiaChi(), x.getEmail(), x.getGioITinh(), x.getMatKhau(), x.getMatKhau(), x.getNgaySinh(), x.getSoDienThoai(), x.getTaiKhoan(), x.getTenNhanVien(), x.getTrangThai(), x.getVaiTro()));
        }
        return list;
    }

    @Override
    public Nhanvien findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Nhanvien create(NhanvienView nv) {
        return daonv.create(setdata(nv));
    }

//    @Override
//    public Nhanvien update(NhanvienView nv) {
//        return daonv.update(setdata(nv));
//    }
    public Nhanvien update(NhanvienView nvModel){
        daonv.update(new Nhanvien(nvModel.getID_NhanVien(),nvModel.getDiaChi(),nvModel.getEmail(),nvModel.getGioITinh(),nvModel.getMaNhanVien(),nvModel.getMatKhau(),nvModel.getNgaySinh(),nvModel.getSoDienThoai(),nvModel.getTaiKhoan(),nvModel.getTenNhanVien(),nvModel.getTrangThai(),nvModel.getVaiTro()));
        return new Nhanvien(nvModel.getID_NhanVien(),nvModel.getDiaChi(),nvModel.getEmail(),nvModel.getGioITinh(),nvModel.getMaNhanVien(),nvModel.getMatKhau(),nvModel.getNgaySinh(),nvModel.getSoDienThoai(),nvModel.getTaiKhoan(),nvModel.getTenNhanVien(),nvModel.getTrangThai(),nvModel.getVaiTro());
    }

    @Override
    public Nhanvien remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long totalCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhanvienView login(String userName, String password) {
        Nhanvien nv = new Nhanvien();
        nv = daonv.login(userName, password);

        return setdata2(nv);
    }

    @Override
    public NhanvienView quenmatkhau(String email, String taikhoan) {
        Nhanvien nv = new Nhanvien();
        nv = daonv.findbyEmail(email, taikhoan);
        NhanvienView nvmodel = new NhanvienView();

        return setdata2(nv);
    }

    @Override
    public List<NhanvienView> findAll(int position, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
