package repositories;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DomainModel.Theloai;
import Utilities.JpaUtils;


public class ImplBangTheLoai implements InterfaceBangTheLoai{
		public final EntityManager em;


	public ImplBangTheLoai() {
		this.em = JpaUtils.getEntityManager();
	}
	@Override
	public List<Theloai> findAll() {
		
		TypedQuery<Theloai> query = em.createQuery("SELECT t FROM Theloai t", Theloai.class);
		return query.getResultList();
	}
	@Override
	public Theloai findById(int id) {
			EntityManager em = JpaUtils.getEntityManager();

			TypedQuery<Theloai> query = em.createQuery("Select t from Theloai t where t.maTheLoai =:maTL",Theloai.class);

			query.setParameter("maTL", id);
			
			Theloai tl = query.getSingleResult();
			return tl;
		}
	}




