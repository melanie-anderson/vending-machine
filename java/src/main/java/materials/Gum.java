package materials;

import java.math.BigDecimal;

public class Gum extends Sellable {
	private String name;
	private BigDecimal price;
	private String code;
	private int quantity;
	private static String message = "Chew Chew, Yum!";

	public Gum(String name, BigDecimal price, String code, int quantity) {
		super(name, price, code, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return message;
	}
}
