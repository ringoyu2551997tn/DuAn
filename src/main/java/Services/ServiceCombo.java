/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Combo;
import ViewModels.ComboView;
import java.util.List;
import repositories.ImplBangCombo;

/**
 *
 * @author Ngọc Hùng
 */
public class ServiceCombo {
    private final ImplBangCombo _dao;

    public ServiceCombo() {
        _dao = new ImplBangCombo();
        getlst();
    }
    
    public List<Combo> getlst() {
        return _dao.findAll();
    }
    
    public ComboView create(ComboView cb) {
//        double giaTien, String HInhAnh, String maComBo, String tenComBo, int trangThai
        _dao.create(new Combo(cb.getGiaTien(),cb.getHInhAnh(),cb.getMaComBo(),cb.getTenComBo(),cb.getTrangThai()));
        return new ComboView(cb.getGiaTien(),cb.getHInhAnh(),cb.getMaComBo(),cb.getTenComBo(),cb.getTrangThai());
    }

    public ComboView update(ComboView cb) {
        _dao.update(new Combo(cb.getID_ComBo(),cb.getGiaTien(),cb.getHInhAnh(),cb.getMaComBo(),cb.getTenComBo(),cb.getTrangThai()));
        return new ComboView(cb.getID_ComBo(),cb.getGiaTien(),cb.getHInhAnh(),cb.getMaComBo(),cb.getTenComBo(),cb.getTrangThai());
    }
}
