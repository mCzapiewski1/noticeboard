package pl.noticeboard.dao;

import java.util.List;

import pl.noticeboard.entity.ProductCategory;

public interface ProductCategoryDAO {
	
	public List<ProductCategory> getProductCategories();
	public ProductCategory getProductCategory(int id);
	public void deleteProductCategory(int id);
	public void saveProductCategory(ProductCategory productCategory);
}
