package DomainModel;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hoadoinchitiet database table.
 * 
 */
@Entity
public class Hoadoinchitiet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_HDCT")
	private int idHdct;

	private double donGia;

	private byte kieu;

	private int ma;

	private String maHoaDonChiTiet;

	private int soLuong;

	//bi-directional many-to-one association to Ban
	@ManyToOne
	@JoinColumn(name="IDBan")
	private Ban ban;

	//bi-directional many-to-one association to Hoadon
	@ManyToOne
	@JoinColumn(name="IDHoaDon")
	private Hoadon hoadon;

	public Hoadoinchitiet() {
	}

	public int getIdHdct() {
		return this.idHdct;
	}

	public void setIdHdct(int idHdct) {
		this.idHdct = idHdct;
	}

	public double getDonGia() {
		return this.donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public byte getKieu() {
		return this.kieu;
	}

	public void setKieu(byte kieu) {
		this.kieu = kieu;
	}

	public int getMa() {
		return this.ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getMaHoaDonChiTiet() {
		return this.maHoaDonChiTiet;
	}

	public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
		this.maHoaDonChiTiet = maHoaDonChiTiet;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Ban getBan() {
		return this.ban;
	}

	public void setBan(Ban ban) {
		this.ban = ban;
	}

	public Hoadon getHoadon() {
		return this.hoadon;
	}

	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}

}