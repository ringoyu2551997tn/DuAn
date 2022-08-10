/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModel.Combo;
import ViewModels.ComboView;
import java.util.ArrayList;
import java.util.List;
import repositories.ImplBangCombo;
import repositories.InterfaceBangComBo;

/**
 *
 * @author lucif
 */
public class ServiceCombo implements IServiceCombo {

    @Override
    public List<ComboView> findAll() {
        List<ComboView> listCombo = new ArrayList<>();
        InterfaceBangComBo daoCombo = new ImplBangCombo();
        for (Combo x : daoCombo.findAll()) {
            if (x.getTrangThai() != 0) {
                listCombo.add(new ComboView(x.getID_ComBo(), x.getMaComBo(),x.getHInhAnh(), x.getTenComBo(), x.getGiaTien(), x.getComboSanphams()));
            }
        }
        return listCombo;
    }

}
