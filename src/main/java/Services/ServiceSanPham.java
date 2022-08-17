/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Sanpham;
import ViewModels.SanPhamModel;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangSanPham;

/**
 *
 * @author LuongQuocBao
 */
public class ServiceSanPham implements ISanPhamService {

    private final ImplBangSanPham _daosp;
    private List<SanPhamModel> _lstSanPhamMod = new ArrayList<SanPhamModel>();
    private List<Sanpham> _lstSanPhams = new ArrayList<Sanpham>();

    public ServiceSanPham() {
        _daosp = new ImplBangSanPham();
        getlst();
    }

    @Override
    public List<SanPhamModel> getSanPham() {
        _lstSanPhamMod = new ArrayList<>();
        var sanPham = _daosp.findAll(1, 9);
        for (Sanpham x : sanPham) {
            _lstSanPhamMod.add(new SanPhamModel(x.getID_SanPham(), x.getGiaTien(), x.getHinhAnh(),
                    x.getMaSanPham(), x.getTenSanPham(), x.getTrangThai(), x.getTheloai()));
        }
        return _lstSanPhamMod;
    }

    public int findIDByMa(String ma){
        for (Sanpham x : getlst()) {
            if (x.getMaSanPham().equals(ma)) {
                return x.getID_SanPham();
            }
        }
        return -1;
    }
    
    @Override
    public SanPhamModel getSanPhamById(int id) {
        var x = _daosp.findById(id);
        return new SanPhamModel(x.getID_SanPham(), x.getGiaTien(), x.getHinhAnh(),
                x.getMaSanPham(), x.getTenSanPham(), x.getTrangThai(), x.getTheloai());
    }

    @Override
    public SanPhamModel createNewSanPham(SanPhamModel sanPhamModel) {
        sanPhamModel.setID_SanPham(0);
        var x = _daosp.create(new Sanpham(sanPhamModel.getID_SanPham(), sanPhamModel.getGiaTien(), sanPhamModel.getHinhAnh(),
                sanPhamModel.getMaSanPham(), sanPhamModel.getTenSanPham(), sanPhamModel.getTrangThai(), sanPhamModel.getTheloai()));
        return new SanPhamModel(x.getID_SanPham(), x.getGiaTien(), x.getHinhAnh(),
                x.getMaSanPham(), x.getTenSanPham(), x.getTrangThai(), x.getTheloai());
    }

    @Override
    public SanPhamModel updateSanPhamById(SanPhamModel sanPhamModel) {
        var x = _daosp.update(new Sanpham(sanPhamModel.getID_SanPham(), sanPhamModel.getGiaTien(), sanPhamModel.getHinhAnh(),
                sanPhamModel.getMaSanPham(), sanPhamModel.getTenSanPham(), sanPhamModel.getTrangThai(), sanPhamModel.getTheloai()));
        return new SanPhamModel(x.getID_SanPham(), x.getGiaTien(), x.getHinhAnh(),
                x.getMaSanPham(), x.getTenSanPham(), x.getTrangThai(), x.getTheloai());
    }

    @Override
    public int deleteSanPhamById(Sanpham sp) {
        int idsp = sp.getID_SanPham();
        _daosp.remove(idsp);
        return -1;
    }
    
     public List<Sanpham> getlst() {
        return _daosp.findSP();
    }

}
