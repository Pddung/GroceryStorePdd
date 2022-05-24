package service;

import java.util.ArrayList;
import java.util.List;


import entitys.OrderDetails;
import entitys.Products;

public class OrderService {
	List<OrderDetails> listOrderDetails = new ArrayList<OrderDetails>();
	public List<OrderDetails> addProductByOrderdetails(OrderDetails orderDetails) {
		listOrderDetails.add(orderDetails);
		return listOrderDetails;
	}
	public void showOrder(List<OrderDetails> list) {
		
		for(OrderDetails orderDetails : list) {
			System.out.println("***Product Name: " + orderDetails.getProducts().getName());
			System.out.println("Amount: " + orderDetails.getAmount());
//			System.out.println("Actual mount : " + (orderDetails.getAmount()- orderDetails.getAmountAfterPromotion()));
			System.out.println("Price : " + orderDetails.getProducts().getPrice());
			System.out.println("Money: " + orderDetails.getTotalMoneyAfterPromotion());
		}
		
	}
	public double totalBills(List<OrderDetails> list) {
		double total = 0;
		for(OrderDetails orderDetails : list) {
			total += orderDetails.getTotalMoneyAfterPromotion();
		}
		return total;
	}
	
	
}
