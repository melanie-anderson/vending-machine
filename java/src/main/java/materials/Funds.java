package materials;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funds {
	
	private BigDecimal balance = new BigDecimal(0);

	public void setBalanceToZero() {
		BigDecimal zero = new BigDecimal(0);
		this.balance = zero;
	}

	public BigDecimal getBalance() {
		return balance.setScale(2, RoundingMode.HALF_UP);
	}

	public void addToBalance(BigDecimal amountAdded) {
		this.balance = this.balance.add(amountAdded);
	}
	
	public void subtractFromBalance(BigDecimal amountSubtracted) {
		this.balance = this.balance.subtract(amountSubtracted);

	}

}
