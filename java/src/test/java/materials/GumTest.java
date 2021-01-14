package materials;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class GumTest {

	@Test
	public void gum_get_quantity() {
		Sellable sellable = new Gum("item", new BigDecimal(2.00), "R7", 2);
		int expectedResult = 2;
		int actualResult = sellable.getQuantity();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void gum_decrease_quantity() {
		Sellable sellable = new Gum("item", new BigDecimal(2.00), "R7", 2);
		int expectedResult = 1;
		sellable.decreaseQuantity();
		int actualResult = sellable.getQuantity();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void gum_get_name() {
		Sellable sellable = new Gum("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "item";
		String actualResult = sellable.getName();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void gum_get_price() {
		Sellable sellable = new Gum("item", new BigDecimal(2.00), "R7", 2);
		BigDecimal expectedResult = new BigDecimal(2.00);
		BigDecimal actualResult = sellable.getPrice();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void gum_get_code() {
		Sellable sellable = new Gum("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "R7";
		String actualResult = sellable.getCode();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void gum_get_message() {
		Sellable sellable = new Gum("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "Chew Chew, Yum!";
		String actualResult = sellable.getMessage();
		
		assertEquals(expectedResult, actualResult);
	}

}


