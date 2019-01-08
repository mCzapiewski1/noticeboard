package pl.noticeboard.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.noticeboard.entity.Auction;
import pl.noticeboard.entity.Product;
import pl.noticeboard.entity.ProductCategory;
import pl.noticeboard.entity.Users;
import pl.noticeboard.service.AuctionService;
import pl.noticeboard.service.ProductCategoryService;
import pl.noticeboard.service.ProductService;
import pl.noticeboard.service.UsersService;

@Controller
public class NoticeboardController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@Autowired
	AuctionService auctionService;
	
	@Autowired
	UsersService usersService;
	
	Product tempProduct = new Product();
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		
		List<ProductCategory> productCategories = productCategoryService.getProductCategories();
		theModel.addAttribute("productCategories", productCategories);
		
		return "home";
	}
	
	@GetMapping("/showProductPage")
	public String showProductPage(@RequestParam("categoryId") int id, Model theModel) {
		
		ProductCategory productCategory = productCategoryService.getProductCategory(id);
		Collection<Product> products = productCategory.getProducts();
		theModel.addAttribute("category", productCategory);
		theModel.addAttribute("products", products);
		
		return "product-page";
	}
	
	@GetMapping("/addProductPage")
	public String addProductPage(@RequestParam("auctionId") int id,Model theModel) {
		
		Collection <ProductCategory> pCategories = productCategoryService.getProductCategories();
		Auction auction = auctionService.getAuction(id);
		Product product = new Product();
		//ProductCategory pCategory = new ProductCategory();
		theModel.addAttribute("auction", auction);
		theModel.addAttribute("newProduct", product);
		theModel.addAttribute("productCategories", pCategories);
		
		return "add-product";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int id) {
		
		productService.deleteProduct(id);
		
		return "redirect:/showMyAuctions";
	}
	
	@GetMapping("/showEditPage")
	public String showEditPage(@RequestParam("productId") int id, Model theModel) {
		
		Collection<ProductCategory> productCategories = productCategoryService.getProductCategories();
		Product product = productService.getProduct(id);
		this.tempProduct = product;
		theModel.addAttribute("product", product);
		theModel.addAttribute("productCategories", productCategories);
		
		return "edit-page";
	}
	
	@PostMapping("/editProduct{someId}")
	public String editProduct(@PathVariable(value="someId") String someId,@ModelAttribute("product") Product product) {
		
		tempProduct.setName(product.getName());
		tempProduct.setPrice(product.getPrice());
		tempProduct.setProductCategory(product.getProductCategory());
		productService.saveProduct(tempProduct);
		
		return "redirect:/showMyAuctions";
	}
	
	
	@GetMapping("/showMyAuctions")
	public String showMyAuctions(Model theModel, Principal principal) {
		
		Users user = usersService.findUserByName(principal.getName());
		Collection<Auction> auctions = user.getAuctions();
		Auction auction = new Auction();
		theModel.addAttribute("newAuction",auction);
		theModel.addAttribute("auctions", auctions);
		
		return "my-auctions";
	}
	
	@GetMapping("/showAuctionPage")
	public String showAuctionPage(@RequestParam("productId") int id, Model theModel) {
		
		Auction auction = productService.getProduct(id).getAuction();
		Collection<Product> products = auction.getProducts();
		theModel.addAttribute("auction", auction);
		theModel.addAttribute("products", products);
		
		return "auction-page";
	}
	
	@GetMapping("/showMyAuctionPage")
	public String showMyAuctionPage(@RequestParam("auctionId") int id, Model theModel) {
		
		Auction auction = auctionService.getAuction(id);
		Collection<Product> products = auction.getProducts();
		theModel.addAttribute("auction", auction);
		theModel.addAttribute("products", products);
		
		return "myauction-page";
	}
	
	@PostMapping("/saveAuction")
	public String saveAuction(@ModelAttribute("newAuction") Auction auction, Principal principal) {
		
		Users user = usersService.findUserByName(principal.getName()); 
		auction.setUser(user);
		auctionService.saveAuction(auction);
		
		return "redirect:/showMyAuctions";
	}
	
	@PostMapping("/saveProduct{someId}")
	public String saveProduct(@ModelAttribute("newProduct") Product product, @PathVariable(value="someId") String someId) {
		
		Auction auction = auctionService.getAuction(Integer.parseInt(someId));
		Collection<Product> products = auction.getProducts();
		products.add(product);
		auction.setProducts(products);
		product.setAuction(auction);
		auctionService.saveAuction(auction);
		productService.saveProduct(product);
		
		
		return "redirect:/showMyAuctions";
	}
}
