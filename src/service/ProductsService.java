package service;

import java.util.ArrayList;
import java.util.List;

import entitys.Products;
import entitys.PromotionType;

public class ProductsService {
	List<Products> listProducts = new ArrayList<Products>();
	
	public List<Products> listProducts() {
		
		Products product1 = new Products(1, "chips", new PromotionType(0, "2 get 1"), 35, "bag");
		Products product2 = new Products(2, "rice", new PromotionType(20, null), 45, "kg");
		Products product3 = new Products(3, "cake Chocopie", new PromotionType(0, "3 get 2"), 50, "bag");
		Products product4 = new Products(4, "water", new PromotionType(0, null), 10, "bottle");
		Products product5 = new Products(5, "bird's nest water", new PromotionType(0, "5 get 1"), 45, "bottle");
		
		listProducts.add(product1);
		listProducts.add(product2);
		listProducts.add(product3);
		listProducts.add(product4);
		listProducts.add(product5);
		return listProducts;
	}
	
	public void showProduct(List<Products> list) {
		for(Products products : list) {
			System.out.println("*******************");
			System.out.println("Product id: " + products.getId());
			System.out.println("Name: " + products.getName());
			System.out.println("Price: " + products.getPrice());
			System.out.println("Unit: " + products.getUnit());
			System.out.println("Promotion: precent " + products.getPromotionType().getPromotionPercent()
					+ ",by amount: " + products.getPromotionType().getPromotionAmount());
			
		}
	}
	public Products getProductById(int id, List<Products> list) {
		for(Products products : list) {
			if(products.getId() == id) {
				return products;
			}
		}
		return null;
	}
}
