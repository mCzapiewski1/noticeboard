package pl.noticeboard.service;

import java.util.List;
import pl.noticeboard.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	public Product getProduct(int id);
	public void deleteProduct(int id);
	public void saveProduct(Product product);
}
