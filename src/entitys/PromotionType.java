package entitys;

public class PromotionType {
	private int promotionPercent;
	private String promotionAmount;
	
	public PromotionType() {
		super();
	}

	public PromotionType(int promotionPercent, String promotionAmount) {
		super();
		this.promotionPercent = promotionPercent;
		this.promotionAmount = promotionAmount;
	}

	public int getPromotionPercent() {
		return promotionPercent;
	}

	public void setPromotionPercent(int promotionPercent) {
		this.promotionPercent = promotionPercent;
	}

	public String getPromotionAmount() {
		return promotionAmount;
	}

	public void setPromotionAmount(String promotionAmount) {
		this.promotionAmount = promotionAmount;
	}
	
	
}
