package Services;

import java.util.List;
import DomainModel.Sanpham;

public interface IServiceBangSanPham {
	
	 	List<Sanpham> findAll(int position, int pageSize);
	    
	 	Sanpham findById(int id);
	    
	 	Sanpham create(Sanpham SanPham);
		
	 	Sanpham update(Sanpham SanPham);
	    
	 	Sanpham remove(int id);
	    
	    long totalCount();
}
