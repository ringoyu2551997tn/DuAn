package repositories;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Utilities.JpaUtils;
import DomainModel.Ban;

import DomainModel.Combo;
import DomainModel.Hoadoinchitiet;
import DomainModel.Sanpham;
import ViewModels.SelectedItems;
import java.util.ArrayList;

public class ImplBangBan implements InterfaceBangBan{

	public EntityManager entityManager = JpaUtils.getEntityManager();

        SelectedItems getInfo(SelectedItems slt,int kieu, int ma){
            if(kieu ==1){
                String sql = "select sp from Sanpham sp "
                        + "Where sp.ID_SanPham= "+ma;
                TypedQuery<Sanpham> query = entityManager.createQuery(sql,Sanpham.class);
                Sanpham sp = query.getSingleResult();
                slt.setHinhAnh(sp.getHinhAnh());
                slt.setMaSanPham(sp.getMaSanPham());
                slt.setTenSanPham(sp.getTenSanPham());
                return slt;
            } else {
                String sql = "select cb from Combo cb "
                        + "Where cb.ID_ComBo= "+ma;
                TypedQuery<Combo> query = entityManager.createQuery(sql,Combo.class);
                Combo cb = query.getSingleResult();
                slt.setHinhAnh(cb.getHInhAnh());
                slt.setMaSanPham(cb.getMaComBo());
                slt.setTenSanPham(cb.getTenComBo());
                return slt;
            }
        }
        
	@Override
	public List<Ban> findAll(int position, int pageSize) {
            
		String jsql = "SELECT b FROM Ban b";
		TypedQuery<Ban> query = entityManager.createQuery(jsql.toString(), Ban.class);
		query.setFirstResult((position-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Ban> list = query.getResultList();
		return list;
	}

	@Override
	public Ban findById(long id) {

		 String jsql = "SELECT b FROM Ban b where b.ID_Ban = "+id;
		TypedQuery<Ban> query = entityManager.createQuery(jsql, Ban.class);
		Ban ban = query.getSingleResult();
		return ban;

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


    @Override
    public List<Ban> findByStatus(int status) {
         EntityManager entityManager = JpaUtils.getEntityManager();
        String jsql = "SELECT b FROM Ban b where b.trangThai = "+status+"and b.ID_Ban<>0";
		TypedQuery<Ban> query = entityManager.createQuery(jsql, Ban.class);
		List<Ban> list = query.getResultList();
		return list;
    }

    @Override
    public List<Ban> findAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        String jsql = "SELECT b FROM Ban b Where b.ID_Ban<>0";
		TypedQuery<Ban> query = entityManager.createQuery(jsql, Ban.class);
		List<Ban> list = query.getResultList();
		return list;
    }

    @Override
    public List<SelectedItems> findAllSelectedItem(int id_ban) {
        List<SelectedItems> lst = new ArrayList<>();
        String jsql = "SELECT hdct from Hoadoinchitiet hdct "
                + " Inner JOIN Ban b ON hdct.ban.ID_Ban = b.ID_Ban"
                + " Inner JOIN Hoadon hd ON hd.ID_HoaDon = hdct.hoadon.ID_HoaDon "
                + " Where b.ID_Ban="+id_ban+""
                +  " AND hd.trangThai = 0";
	TypedQuery<Hoadoinchitiet> query = entityManager.createQuery(jsql,Hoadoinchitiet.class);
        for (Hoadoinchitiet x : query.getResultList()) {
            SelectedItems slt = new SelectedItems();
            slt.setSoLuong(x.getSoLuong());
            slt.setGiaTien(x.getDonGia());
            getInfo(slt, x.getKieu(), x.getMa());
            lst.add(slt);
        }
		return lst;
    }

	
	
}
