package service;

import java.util.List;
import java.util.Scanner;

import entitys.Order;
import entitys.OrderDetails;
import entitys.Products;

public class OrderDetaisService {
	public OrderDetails addProductByOrderDetails(Products product, int amount) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setProducts(product);
		orderDetails.setAmount(amount);
		// if promotionAmout != null and order amount > promotion amount . recalculate the number of products
		int amountAfterPromotion = 0;
		if(product.getPromotionType().getPromotionAmount()!= null) {
			String [] parts = product.getPromotionType().getPromotionAmount().split(" ");
			int promotionAmount = Integer.parseInt(parts[0]);
			int freeQuantityBypromotionAmount = Integer.parseInt(parts[2]);
			//int remainder = amount % promotionAmount;
			if(amount > promotionAmount) {
				int freeQuantity = amount / promotionAmount * freeQuantityBypromotionAmount;
				amountAfterPromotion = amount - freeQuantity;
				orderDetails.setAmountAfterPromotion(amountAfterPromotion);
				orderDetails.setTotalMoneyAfterPromotion(amountAfterPromotion * product.getPrice());
			}
			
		}
		
//		orderDetails.setAmount(amount);
		
		
		//if promotionPercent >0 update price
		if(product.getPromotionType().getPromotionPercent() > 0) {
			if(orderDetails.getAmountAfterPromotion() == 0) {
				double priceAfterPromotion =product.getPrice()- product.getPrice() 
						* product.getPromotionType().getPromotionPercent()/100;
				
				orderDetails.setTotalMoneyAfterPromotion(amount * priceAfterPromotion);
			}
			else{
				double priceAfterPromotion =product.getPrice()- product.getPrice() 
						* product.getPromotionType().getPromotionPercent()/100;
				
				orderDetails.setTotalMoneyAfterPromotion(amountAfterPromotion * priceAfterPromotion);
			}
		}
		if(product.getPromotionType().getPromotionPercent() == 0 &&
				product.getPromotionType().getPromotionAmount()== null) {
			orderDetails.setTotalMoneyAfterPromotion(amount * product.getPrice());
		}
		return orderDetails;
	}
	
	public void updateTotalOrderDetails(OrderDetails orderDetails) {
		int amount = orderDetails.getAmount();
		int amoutAfterPromotion = orderDetails.getAmountAfterPromotion();
		double priceAfterPromotion = orderDetails.getProducts().getPrice() - orderDetails.getProducts().getPrice()
				* orderDetails.getProducts().getPromotionType().getPromotionPercent()/100;
		if(orderDetails.getAmountAfterPromotion() == 0) {
			orderDetails.setTotalMoneyAfterPromotion(amount * priceAfterPromotion);
		}else {
			String [] parts = orderDetails.getProducts().getPromotionType().getPromotionAmount().split(" ");
			int promotionAmount = Integer.parseInt(parts[0]);
			int freeQuantityBypromotionAmount = Integer.parseInt(parts[2]);
			int freeQuantity = amount / promotionAmount * freeQuantityBypromotionAmount;
			amoutAfterPromotion = amount - freeQuantity;
			orderDetails.setTotalMoneyAfterPromotion(amoutAfterPromotion * priceAfterPromotion);
		}
	}
	public void clearn() {

	}
	
}
