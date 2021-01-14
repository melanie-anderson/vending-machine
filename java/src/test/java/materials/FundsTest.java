package materials;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class FundsTest {
	
	@Test
	public void set_balance_to_zero_test() {
		Funds funds = new Funds();
		BigDecimal expectedResult = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
		funds.setBalanceToZero();
		BigDecimal actualResult = funds.getBalance();
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void add_to_balance() {
		Funds funds = new Funds();
		BigDecimal expectedResult = new BigDecimal(3.50).setScale(2, RoundingMode.HALF_UP);
		funds.addToBalance(new BigDecimal(3.50));
		BigDecimal actualResult = funds.getBalance();
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void subtract_from_balance() {
		Funds funds = new Funds();
		BigDecimal expectedResult = new BigDecimal(-3.50).setScale(2, RoundingMode.HALF_UP);
		funds.subtractFromBalance(new BigDecimal(3.50));
		BigDecimal actualResult = funds.getBalance();
		
		assertEquals(expectedResult, actualResult);
	}

}
