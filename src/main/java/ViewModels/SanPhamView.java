package ViewModels;

import DomainModel.Theloai;
import java.io.Serializable;




public class SanphamView implements Serializable {
	
	private int ID_SanPham;

	private double giaTien;

	private String hinhAnh;

	private String maSanPham;

	private String tenSanPham;

	private int trangThai;

	private Theloai theloai;

	public SanphamView() {
	}

	public int getID_SanPham() {
		return this.ID_SanPham;
	}

	public void setID_SanPham(int ID_SanPham) {
		this.ID_SanPham = ID_SanPham;
	}

	public double getGiaTien() {
		return this.giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMaSanPham() {
		return this.maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return this.tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	

	public Theloai getTheloai() {
		return this.theloai;
	}

	public void setTheloai(Theloai theloai) {
		this.theloai = theloai;
	}

	@Override
	public String toString() {
		return  tenSanPham;
	}
	

}