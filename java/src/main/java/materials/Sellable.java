package materials;

import java.math.BigDecimal;

public abstract class Sellable {
	
	private String name;
	private BigDecimal price;
	private String code;
	private int quantity;
	private String message;
	
	public Sellable(String name, BigDecimal price, String code, int quantity) {
		this.name = name;
		this.price = price;
		this.code = code;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void decreaseQuantity() {
		quantity--;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
}
