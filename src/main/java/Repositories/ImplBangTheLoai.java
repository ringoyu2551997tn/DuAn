package repositories;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DomainModel.Theloai;
import Utilities.JpaUtils;


public class ImplBangTheLoai implements InterfaceBangTheLoai{
	public static final EntityManager entityManager = JpaUtils.getEntityManager();
	@Override
	public List<Theloai> findAll() {
		String sql = "SELECT b FROM Bangtheloai b";
		TypedQuery<Theloai> query = entityManager.createQuery(sql.toString(), Theloai.class);
		return query.getResultList();
	}
	@Override
	public Theloai findById(int id) {
			EntityManager em = JpaUtils.getEntityManager();

			TypedQuery<Theloai> query = em.createQuery("Select k from Theloai k where k.maTheLoai =:maTL",Theloai.class);

			query.setParameter("maTL", id);
			
			Theloai tl = query.getSingleResult();
			return tl;
		}
	}




