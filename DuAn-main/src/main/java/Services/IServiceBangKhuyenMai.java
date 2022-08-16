package Services;

import java.util.List;
import DomainModel.Khuyenmai;

public interface IServiceBangKhuyenMai {
	
	List<Khuyenmai> findAll(int page,int pagesize);
	
	Khuyenmai findById(String maKM);
    
	Khuyenmai create(Khuyenmai khuyenmai);
    
	Khuyenmai update(Khuyenmai khuyenmai);

    
    long totalCount();

    List<Khuyenmai> find (int page,int pagesize, String name);
}
