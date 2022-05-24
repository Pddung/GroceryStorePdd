package entitys;

import java.util.Set;

public class Order {
	private Set<OrderDetails> listOrderDetails;
	private double totalPrice;
	public Order() {
		super();
	}
	
	

	public Order(Set<OrderDetails> listOrderDetails, double totalPrice) {
		super();
		this.listOrderDetails = listOrderDetails;
		this.totalPrice = totalPrice;
	}



	public Set<OrderDetails> getListOrderDetails() {
		return listOrderDetails;
	}

	public void setListOrderDetails(Set<OrderDetails> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
