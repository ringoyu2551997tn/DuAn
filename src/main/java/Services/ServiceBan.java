/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Ban;
import DomainModel.Hoadoinchitiet;
import DomainModel.Hoadon;
import ViewModels.BanView;
import ViewModels.SelectedItems;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangBan;
import repositories.ImplBangHoaDon;
import repositories.ImplBangHoaDonChiTiet;
import repositories.InterfaceBangBan;
import repositories.InterfaceBangHoaDon;
import repositories.InterfaceBangHoaDonChiTiet;

/**
 *
 * @author lucif
 */
public class ServiceBan implements IServiceBan {

    InterfaceBangBan daoBan = new ImplBangBan();
    InterfaceBangHoaDon daoHD = new ImplBangHoaDon();
    InterfaceBangHoaDonChiTiet daoHDCT = new ImplBangHoaDonChiTiet();
    
    @Override
    public List<BanView> findByStatus(int status) {
        if (status == 2) {
            List<BanView> lstBanView = new ArrayList<>();
            for (Ban x : daoBan.findAll()) {
                lstBanView.add(new BanView(x.getID_Ban(), x.getMaBan(), x.getTrangThai()));
            }
            return lstBanView;
        } else {
            List<BanView> lstBanView = new ArrayList<>();
            for (Ban x : daoBan.findByStatus(status)) {
                lstBanView.add(new BanView(x.getID_Ban(), x.getMaBan(), x.getTrangThai()));
            }
            return lstBanView;
        }
    }

    @Override
    public List<SelectedItems> showSelectedItems(int ID_ban, int trangthai) {
        if(trangthai==0){
            List<SelectedItems> lst= new ArrayList<>();
            return lst;
        }else{
            List<SelectedItems> lst= new ArrayList<>();
            lst = daoBan.findAllSelectedItem(ID_ban);
            return lst;
        }
    }

    @Override
    public void chuyenBan(int idBanDi, int idBanToi) {
        List<Hoadoinchitiet> lst = daoHDCT.findByIdBan(idBanDi);
        for (Hoadoinchitiet x : lst) {
            x.setBan(daoBan.findById(idBanToi));
            daoHDCT.update(x);
            System.out.println(x.toString());
        }
        Ban bantoi = daoBan.findById(idBanToi);
        Ban ban= daoBan.findById(idBanDi);
        bantoi.setTrangThai(1);
        ban.setTrangThai(0);
        daoBan.update(ban);
        daoBan.update(bantoi);
    }

    @Override
    public void gopBan(int idBanDi, int idBanToi) {
        List<Hoadoinchitiet> lst = daoHDCT.findByIdBan(idBanDi);
        Hoadon hoadon = daoHD.findHoaDonByBan(idBanToi);
        Hoadon hoadonBanDi = daoHD.findHoaDonByBan(idBanDi);
        for (Hoadoinchitiet x : lst) {
            x.setBan(daoBan.findById(idBanToi));
            x.setHoadon(hoadon);
            daoHDCT.update(x);
        }
        Ban ban= daoBan.findById(idBanDi);
        ban.setTrangThai(0);
        daoBan.update(ban);
        hoadonBanDi.setTrangThai(1);
        daoHD.update(hoadonBanDi);
    }

    
}
