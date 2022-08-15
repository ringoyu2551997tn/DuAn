/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Sanpham;
import ViewModels.SanPhamView;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangSanPham;
import repositories.InterfaceBangSanPham;

/**
 *
 * @author lucif
 */
public class ServiceSanPham implements IServiceSanPham{

    @Override
    public List<SanPhamView> findByType(int type) {
        List<SanPhamView> lstSPView = new ArrayList<>();
        InterfaceBangSanPham daoSP = new ImplBangSanPham();
        for (Sanpham x : daoSP.findByType(type)) {
            lstSPView.add(new SanPhamView(x.getID_SanPham(), x.getGiaTien(), x.getHinhAnh(), x.getMaSanPham(), x.getTenSanPham()));
        }
        return lstSPView;
    }
    
    
    
}
