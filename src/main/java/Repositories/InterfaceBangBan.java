package repositories;

import java.util.List;
import DomainModel.Ban;

import ViewModels.SelectedItems;



public interface InterfaceBangBan {
	
	List<Ban> findAll(int position, int pageSize);
    

        List<Ban> findByStatus(int status);
        
        List<Ban> findAll();
        
        List<SelectedItems> findAllSelectedItem(int id_ban);
        

	Ban findById(long id);
    
	Ban create(Ban ban);
	
	Ban update(Ban ban);
    
	Ban remove(long id);
    
    long totalCount();
}
