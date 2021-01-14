package materials;

import java.math.BigDecimal;

public class Chip extends Sellable {
	private String name;
	private BigDecimal price;
	private String code;
	private int quantity;
	private static String message = "Crunch Crunch, Yum!";

	public Chip(String name, BigDecimal price, String code, int quantity) {
		super(name, price, code, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return message;
	}
}
