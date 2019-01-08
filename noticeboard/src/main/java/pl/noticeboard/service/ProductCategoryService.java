package pl.noticeboard.service;

import java.util.List;
import pl.noticeboard.entity.ProductCategory;

public interface ProductCategoryService {
	
	public List<ProductCategory> getProductCategories();
	public ProductCategory getProductCategory(int id);
	public void deleteProductCategory(int id);
	public void saveProductCategory(ProductCategory productCategory);
}
