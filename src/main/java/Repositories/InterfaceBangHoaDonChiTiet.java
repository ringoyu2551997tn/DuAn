package repositories;

import java.util.List;

import DomainModel.Combo;
import DomainModel.Hoadoinchitiet;
import DomainModel.Sanpham;

public interface InterfaceBangHoaDonChiTiet {

	List<Hoadoinchitiet> findAll(int position, int pageSize);


        List<Hoadoinchitiet> findAll();
        
        List<Hoadoinchitiet> findByIdBan(int id);
        

	Hoadoinchitiet findById(long id);

	Hoadoinchitiet create(Hoadoinchitiet hdct);

	Hoadoinchitiet update(Hoadoinchitiet hdct);

	long totalCount();

        
        void UpdateSelected (int idBan);

	List<Hoadoinchitiet> findByIdHD(int id);

	List<Sanpham> findSanPham(int id);

	List<Combo> findCombo(int id);

	double tongdoanhthu();

	Long tongsp(int a , int b );
	
	Long tonghd();
	
	Sanpham top1sp();
	
	List<Sanpham> thongkesp();
}
