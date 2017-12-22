package com.Dao;

import java.util.List;
import com.model.Product;

public interface ProductDao 
{
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> retrieveProduct();
	public Product getProduct(int productId);
	public List<Product> getCategoryProducts(int categoryId);
	public List<Product> retrieveLatestProducts();
}
