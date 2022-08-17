package repositories;

import java.util.List;
import DomainModel.Combo;
import DomainModel.Sanpham;

public interface InterfaceBangComBo {
	
	List<Combo> findAll(int position, int pageSize);
<<<<<<< Updated upstream

        List<Combo> findAll();
        

	Combo findById(int id);
=======
    
	Combo findById(int id);
        
        Combo findByMa(String id);
>>>>>>> Stashed changes
    
	Combo create(Combo combo);
	
	Combo update(Combo combo);
	
	List<Sanpham> findSanPhamByIDCB(int id);
    
    long totalCount();
    
    int findIdByMaCB(String maCB);
    
    Combo findLatestCB ();
}
