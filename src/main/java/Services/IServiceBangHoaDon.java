package Services;

import Repositories.*;
import java.util.Date;
import java.util.List;
import DomainModel.Hoadon;
import ViewModels.HoadonView;

public interface IServiceBangHoaDon {
	
	List<HoadonView> findAll(int position, int pageSize);
	 List<HoadonView> findAll() ;
	HoadonView findById(int id);
    
	HoadonView create(Hoadon hoadon);
	
	HoadonView update(Hoadon hoadon);
    
    long totalCount();
    List<HoadonView> findByTStatus (int a);
    List<HoadonView> findByDate (Date date);
   
}
