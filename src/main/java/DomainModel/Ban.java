package DomainModel;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ban database table.
 * 
 */
@Entity
@NamedQuery(name="Ban.findAll", query="SELECT b FROM Ban b")
public class Ban implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Ban;

	private String maBan;

	private int trangThai;

	//bi-directional many-to-one association to Hoadoinchitiet
	@OneToMany(mappedBy="ban")
	private List<Hoadoinchitiet> hoadoinchitiets;

	public Ban() {
	}

	public int getID_Ban() {
		return this.ID_Ban;
	}

	public void setID_Ban(int ID_Ban) {
		this.ID_Ban = ID_Ban;
	}

	public String getMaBan() {
		return this.maBan;
	}

	public void setMaBan(String maBan) {
		this.maBan = maBan;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public List<Hoadoinchitiet> getHoadoinchitiets() {
		return this.hoadoinchitiets;
	}

	public void setHoadoinchitiets(List<Hoadoinchitiet> hoadoinchitiets) {
		this.hoadoinchitiets = hoadoinchitiets;
	}

	public Hoadoinchitiet addHoadoinchitiet(Hoadoinchitiet hoadoinchitiet) {
		getHoadoinchitiets().add(hoadoinchitiet);
		hoadoinchitiet.setBan(this);

		return hoadoinchitiet;
	}

	public Hoadoinchitiet removeHoadoinchitiet(Hoadoinchitiet hoadoinchitiet) {
		getHoadoinchitiets().remove(hoadoinchitiet);
		hoadoinchitiet.setBan(null);

		return hoadoinchitiet;
	}

}