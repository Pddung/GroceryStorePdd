package entitys;

public class Products {
	private int id;
	private String name;
	private PromotionType promotionType;
	private double price;
	private String unit;
	
	public Products() {
		super();
	}
	public Products(int id, String name, PromotionType promotionType, double price, String unit) {
		super();
		this.id = id;
		this.name = name;
		this.promotionType = promotionType;
		this.price = price;
		this.unit = unit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PromotionType getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
