package pl.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.noticeboard.dao.ProductCategoryDAO;
import pl.noticeboard.entity.ProductCategory;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	@Transactional
	@Override
	public List<ProductCategory> getProductCategories() {
		
		return productCategoryDAO.getProductCategories();
	}
	
	@Transactional
	@Override
	public ProductCategory getProductCategory(int id) {
		
		return productCategoryDAO.getProductCategory(id);
	}
	
	@Transactional
	@Override
	public void deleteProductCategory(int id) {
		
		productCategoryDAO.deleteProductCategory(id);
	}
	
	@Transactional
	@Override
	public void saveProductCategory(ProductCategory productCategory) {
		
		productCategoryDAO.saveProductCategory(productCategory);
	}

}
