package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.techelevator.view.Menu;

public class VendingMachineCLITest {

	@Test
	public void make_change_equals_quarter() {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI machine = new VendingMachineCLI(menu);
		BigDecimal money = new BigDecimal(.25).setScale(2, RoundingMode.HALF_UP);
		String actualResult = machine.makeChange(money);
		String expectedResult = "The total change dispensed is: $0.25\n1 quarters \n0 dimes \n0 nickels \n";
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void make_change_greater_than_a_quarter() {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI machine = new VendingMachineCLI(menu);
		BigDecimal money = new BigDecimal(1.80).setScale(2, RoundingMode.HALF_UP);
		String actualResult = machine.makeChange(money);
		String expectedResult = "The total change dispensed is: $1.80\n7 quarters \n0 dimes \n1 nickels \n";
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void make_change_equals_dime() {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI machine = new VendingMachineCLI(menu);
		BigDecimal money = new BigDecimal(.10).setScale(2, RoundingMode.HALF_UP);
		String actualResult = machine.makeChange(money);
		String expectedResult = "The total change dispensed is: $0.10\n0 quarters \n1 dimes \n0 nickels \n";
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void make_change_equals_nickel() {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI machine = new VendingMachineCLI(menu);
		BigDecimal money = new BigDecimal(.05).setScale(2, RoundingMode.HALF_UP);
		String actualResult = machine.makeChange(money);
		String expectedResult = "The total change dispensed is: $0.05\n0 quarters \n0 dimes \n1 nickels \n";
		
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void make_change_balance_is_0() {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI machine = new VendingMachineCLI(menu);
		BigDecimal money = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
		String actualResult = machine.makeChange(money);
		String expectedResult = "No change necessary";
		
		assertEquals(expectedResult, actualResult);
	}
}
