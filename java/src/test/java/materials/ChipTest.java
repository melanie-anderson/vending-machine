package materials;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class ChipTest {

	@Test
	public void chip_get_quantity() {
		Sellable sellable = new Chip("item", new BigDecimal(2.00), "R7", 2);
		int expectedResult = 2;
		int actualResult = sellable.getQuantity();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void chip_decrease_quantity() {
		Sellable sellable = new Chip("item", new BigDecimal(2.00), "R7", 2);
		int expectedResult = 1;
		sellable.decreaseQuantity();
		int actualResult = sellable.getQuantity();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void chip_get_name() {
		Sellable sellable = new Chip("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "item";
		String actualResult = sellable.getName();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void chip_get_price() {
		Sellable sellable = new Chip("item", new BigDecimal(2.00), "R7", 2);
		BigDecimal expectedResult = new BigDecimal(2.00);
		BigDecimal actualResult = sellable.getPrice();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void chip_get_code() {
		Sellable sellable = new Chip("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "R7";
		String actualResult = sellable.getCode();
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void chip_get_message() {
		Sellable sellable = new Chip("item", new BigDecimal(2.00), "R7", 2);
		String expectedResult = "Crunch Crunch, Yum!";
		String actualResult = sellable.getMessage();
		
		assertEquals(expectedResult, actualResult);
	}

}

