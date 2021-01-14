package materials;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class DrinkTest {

	@Test
	public void drink_get_quantity() {
		Sellable sellable = new Drink("item", new BigDecimal(2.00), "R7", 2);
		int expectedResult = 2;
		int actualResult = sellable.getQuantity();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void drink_decrease_quantity() {
		Sellable sellable = new Drink("item", new BigDecimal(2.00), "R7", 2);
		int expectedResult = 1;
		sellable.decreaseQuantity();
		int actualResult = sellable.getQuantity();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void drink_get_name() {
		Sellable sellable = new Drink("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "item";
		String actualResult = sellable.getName();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void drink_get_price() {
		Sellable sellable = new Drink("item", new BigDecimal(2.00), "R7", 2);
		BigDecimal expectedResult = new BigDecimal(2.00);
		BigDecimal actualResult = sellable.getPrice();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void drink_get_code() {
		Sellable sellable = new Drink("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "R7";
		String actualResult = sellable.getCode();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void drink_get_message() {
		Sellable sellable = new Drink("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "Glug Glug, Yum!";
		String actualResult = sellable.getMessage();
		
		assertEquals(expectedResult, actualResult);
	}

}


