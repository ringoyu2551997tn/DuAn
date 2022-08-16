package ViewModels;

import DomainModel.Combo;
import DomainModel.Sanpham;




public class ComboSanphamView  {

	private int ID_Combo_SanPham;

	private int soLuong;

	private Combo combo;


	private Sanpham sanpham;

	public ComboSanphamView() {
	}

	public int getID_Combo_SanPham() {
		return this.ID_Combo_SanPham;
	}

	public void setID_Combo_SanPham(int ID_Combo_SanPham) {
		this.ID_Combo_SanPham = ID_Combo_SanPham;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Combo getCombo() {
		return this.combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Sanpham getSanpham() {
		return this.sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

}