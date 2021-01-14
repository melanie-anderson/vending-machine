package materials;

import java.math.BigDecimal;

public class Candy extends Sellable {

	private String name;
	private BigDecimal price;
	private String code;
	private int quantity;
	private static String message = "Munch Munch, Yum!";

	public Candy(String name, BigDecimal price, String code, int quantity) {
		super(name, price, code, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return message;
	}

}
