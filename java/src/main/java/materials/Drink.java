package materials;

import java.math.BigDecimal;

public class Drink extends Sellable {
	private String name;
	private BigDecimal price;
	private String code;
	private int quantity;
	private static String message = "Glug Glug, Yum!";

	public Drink(String name, BigDecimal price, String code, int quantity) {
		super(name, price, code, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return message;
	}
}
