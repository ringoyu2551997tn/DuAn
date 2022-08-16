package repositories;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Utilities.JpaUtils;
import DomainModel.ComboSanpham;
import DomainModel.Sanpham;

public class ImplBangComboSanPham implements InterfaceBangComboSanPham{

	@Override
	public ComboSanpham create(ComboSanpham cbsp) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			System.out.println(cbsp.getSoLuong());
			System.out.println(cbsp.getCombo().getID_ComBo());
			System.out.println(cbsp.getSanpham().getID_SanPham());
			em.persist(cbsp);
			trans.commit();

			return cbsp;
		}catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

}
