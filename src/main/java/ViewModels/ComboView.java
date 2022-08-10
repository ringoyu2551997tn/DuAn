/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModel.ComboSanpham;
import java.util.List;

/**
 *
 * @author lucif
 */
public class ComboView {
    
    private int ID_ComBo;
    private String maComBo;
    private String HInhAnh;
    private String tenComBo;
    private double giaTien;
    private List<ComboSanpham> comboSanPhams;

    public ComboView() {
    }

    public ComboView(int ID_ComBo, String maComBo,String HInhAnh, String tenComBo, double giaTien, List<ComboSanpham> comboSanPhams) {
        this.ID_ComBo = ID_ComBo;
        this.maComBo = maComBo;
        this.HInhAnh = HInhAnh;
        this.tenComBo = tenComBo;
        this.giaTien = giaTien;
        this.comboSanPhams = comboSanPhams;
    }

    public String getHInhAnh() {
        return HInhAnh;
    }

    public void setHInhAnh(String HInhAnh) {
        this.HInhAnh = HInhAnh;
    }

    public int getID_ComBo() {
        return ID_ComBo;
    }

    public void setID_ComBo(int ID_ComBo) {
        this.ID_ComBo = ID_ComBo;
    }

    public String getMaComBo() {
        return maComBo;
    }

    public void setMaComBo(String maComBo) {
        this.maComBo = maComBo;
    }

    public String getTenComBo() {
        return tenComBo;
    }

    public void setTenComBo(String tenComBo) {
        this.tenComBo = tenComBo;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public List<ComboSanpham> getComboSanPhams() {
        return comboSanPhams;
    }

    public void setComboSanPhams(List<ComboSanpham> comboSanPhams) {
        this.comboSanPhams = comboSanPhams;
    }
    
    
}
