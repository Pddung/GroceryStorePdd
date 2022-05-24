package entitys;

public class OrderDetails {
	private Products products;
	private int amount;
	private int amountAfterPromotion;
	private double totalMoneyAfterPromotion;
	public OrderDetails() {
		super();
	}
	
	
	public OrderDetails(Products products, int amount, double totalMoneyAfterPromotion) {
		super();
		this.products = products;
		this.amount = amount;
		this.totalMoneyAfterPromotion = totalMoneyAfterPromotion;
	}


	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}


	public double getTotalMoneyAfterPromotion() {
		return totalMoneyAfterPromotion;
	}


	public void setTotalMoneyAfterPromotion(double totalMoneyAfterPromotion) {
		this.totalMoneyAfterPromotion = totalMoneyAfterPromotion;
	}


	public int getAmountAfterPromotion() {
		return amountAfterPromotion;
	}


	public void setAmountAfterPromotion(int amountAfterPromotion) {
		this.amountAfterPromotion = amountAfterPromotion;
	}

	
	
	
}
