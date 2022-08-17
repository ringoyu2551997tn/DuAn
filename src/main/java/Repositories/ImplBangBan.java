package repositories;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Utilities.JpaUtils;
import DomainModel.Ban;

public class ImplBangBan implements InterfaceBangBan{

	public final EntityManager entityManager = JpaUtils.getEntityManager();

	@Override
	public List<Ban> findAll(int position, int pageSize) {
		String jsql = "SELECT b FROM Ban b";
		TypedQuery<Ban> query = entityManager.createQuery(jsql.toString(), Ban.class);
		query.setFirstResult((position-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Ban> list = query.getResultList();
		return list;
	}
        
        public List<Ban> findAll() {
		String jsql = "SELECT b FROM Ban b";
		TypedQuery<Ban> query = entityManager.createQuery(jsql.toString(), Ban.class);
		List<Ban> list = query.getResultList();
		return list;
	}

	@Override
	public Ban findById(long id) {
		Ban Ban = entityManager.find(Ban.class, id);
		return Ban;
	}

	@Override
	public Ban create(Ban ban) {
		try {
			entityManager.getTransaction().begin();
			System.out.println(ban.getID_Ban());
			System.out.println(ban.getMaBan());	
			System.out.println(ban.getTrangThai());	
			entityManager.persist(ban);
		    entityManager.getTransaction().commit();
//		    entityManager.flush();
					return ban;
		}catch(Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	@Override
	public Ban update(Ban ban) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(ban);
		    entityManager.getTransaction().commit();
					return ban;
		}catch(Exception ex) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	@Override
	public Ban remove(long id) {
		Ban ban = this.findById(id);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(ban);
		    entityManager.getTransaction().commit();
					return ban;
		}catch(Exception ex) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	@Override
	public long totalCount() {
		EntityManager em =  JpaUtils.getEntityManager();
        try {
        	String sql = "Select COUNT(k.id) From Ban k ";
    		Query query = em.createQuery(sql);
            return Long.parseLong(query.getSingleResult().toString());
        } catch (Exception e) {
        	em.getTransaction().rollback();
			throw new RuntimeException();
        }
	}
	
	
}
