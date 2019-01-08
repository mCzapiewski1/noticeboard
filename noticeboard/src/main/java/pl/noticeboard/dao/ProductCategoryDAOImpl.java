package pl.noticeboard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.noticeboard.entity.ProductCategory;

@Repository
public class ProductCategoryDAOImpl implements ProductCategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProductCategory> getProductCategories() {
		
		Session currentSession  = sessionFactory.getCurrentSession();
		Query<ProductCategory> query = currentSession.createQuery("from ProductCategory order by name", ProductCategory.class);
		List<ProductCategory> productCategories = query.getResultList();
		
		return productCategories;
	}

	@Override
	public ProductCategory getProductCategory(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		ProductCategory productCategory = currentSession.get(ProductCategory.class, id);
		
		return productCategory;
	}

	@Override
	public void deleteProductCategory(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from ProductCategory where id:=id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void saveProductCategory(ProductCategory productCategory) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(productCategory);
	}
	
	
}
