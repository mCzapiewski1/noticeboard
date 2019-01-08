package pl.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.noticeboard.dao.ProductDAO;
import pl.noticeboard.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	@Override
	public List<Product> getProducts() {
		
		return productDAO.getProducts();
	}
	
	@Transactional
	@Override
	public Product getProduct(int id) {
		
		return productDAO.getProduct(id);
	}
	
	@Transactional
	@Override
	public void deleteProduct(int id) {
		
		productDAO.deleteProduct(id);
	}
	
	@Transactional
	@Override
	public void saveProduct(Product product) {

		productDAO.saveProduct(product);
	}

}
