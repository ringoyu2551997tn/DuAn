/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Ban;
import ViewModels.BanView;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangBan;

/**
 *
 * @author Ngọc Hùng
 */
public class ServiceBan {
    private final ImplBangBan _dao;

    public ServiceBan() {
        _dao = new ImplBangBan();
        getlst();
    }
    
    public List<Ban> getlst() {
        return _dao.findAll();
    }
    
    public BanView create(BanView ban) {
        _dao.create(new Ban(ban.getMaBan(), ban.getTrangThai()));
        return new BanView(ban.getMaBan(), ban.getTrangThai());
    }

    public BanView update(BanView ban) {
        _dao.update(new Ban(ban.getID_Ban(),ban.getMaBan(),ban.getTrangThai()));
        return new BanView(ban.getID_Ban(),ban.getMaBan(),ban.getTrangThai());
    }
}
