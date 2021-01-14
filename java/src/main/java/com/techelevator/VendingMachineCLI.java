package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

import admin.LogWriter;
import materials.Candy;
import materials.Chip;
import materials.DateAndTime;
import materials.Drink;
import materials.Funds;
import materials.Sellable;
import materials.GetInventory;
import materials.Gum;

public class VendingMachineCLI {

	private GetInventory getInventory = new GetInventory();
	private File inventoryFile = new File("vendingmachine.csv");

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU = { "Feed Money", "Select Product", "Finish Transaction", "Back" };
	private static final String[] FEED_MONEY_MENU = { "$1", "$2", "$5", "$10", "Back" };

	private Menu menu;
	private DateAndTime dat = new DateAndTime();
	private LogWriter writer = new LogWriter(new File("log.txt"));
	private Funds funds = new Funds();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {

		getInventory.readFile(inventoryFile);

		getInventory.addItemsToMachine();
		File logFile = new File("log.txt");

		if (!logFile.exists()) {
			logFile.createNewFile();
		}
		writer.writeMessage("\nMACHINE STARTING >");
		while (true) {

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			System.out.println("You picked: " + choice);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(displayItems(getInventory.getItemsInMachine()));

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				String selection = "";

				while (!selection.equals("Back")) {

					System.out.println("> > Current Money Provided: $" + funds.getBalance());
					selection = (String) menu.getChoiceFromOptions(PURCHASE_MENU);

					if (selection.contentEquals("Feed Money")) {
						BigDecimal startingBalance = funds.getBalance();
						processMoney();
						BigDecimal amountEntered = funds.getBalance().subtract(startingBalance);
						writer.writeMessage(dat.getCurrentDateTime() + " FEED MONEY $" + amountEntered + " $"
								+ funds.getBalance() + " >");
					}

					if (selection.contentEquals("Select Product")) {
						BigDecimal startingBalance = funds.getBalance();
						System.out.println(displayItems(getInventory.getItemsInMachine()));
						System.out.println("Please enter item code");
						Scanner userInput = new Scanner(System.in);
						String itemCode = userInput.nextLine();
						boolean codeExists = false;
						boolean soldOut = false;
						String selectedName = "";
						BigDecimal selectedPrice = new BigDecimal(0);
						int selectedQuantity = 0;
						String selectedMessage = "";
						for (Sellable item : getInventory.getItemsInMachine()) {
							if (item.getCode().equals(itemCode)) {
								codeExists = true;
								selectedName = item.getName();
								selectedPrice = item.getPrice();
								selectedQuantity = item.getQuantity();
								if (selectedQuantity == 0) {
									soldOut = true;
								}
								selectedMessage = item.getMessage();
							}
						}
						if (codeExists == false) {
							System.out.println("Sorry there is no such item.");
						}
						else if (soldOut) {
							System.out.println("Sorry the item is sold out");
						} 
						else if (funds.getBalance().compareTo(selectedPrice) != -1) {
							funds.subtractFromBalance(selectedPrice);
							for (Sellable item1 : getInventory.getItemsInMachine()) {
								if (item1.getCode().equals(itemCode)) {
									item1.decreaseQuantity();
								}
							}
							System.out.println("Dispensing: " + selectedName + " " + selectedPrice + " "
									+ funds.getBalance() + " " + selectedMessage);
							writer.writeMessage(dat.getCurrentDateTime() + " " + selectedName + " " + itemCode + " $"
									+ startingBalance + " $" + funds.getBalance() + " >");
						} else {
							System.out.println("Sorry insufficient funds");
						}

					}
					if (selection.contentEquals("Finish Transaction")) {
						BigDecimal remainingBalance = funds.getBalance();
						System.out.println(makeChange(remainingBalance));
						funds.setBalanceToZero();
						writer.writeMessage(dat.getCurrentDateTime() + " " + "GIVE CHANGE $" + remainingBalance + " $"
								+ funds.getBalance() + " >");
						selection = "Back";
					}

					System.out.println("You selected from the second level: " + selection);
				}

			} else if (choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {

				System.out.println("Thank you!");
				writer.writeMessage("MACHINE CLOSEDg");
				writer.closeWriter();
				System.exit(0);

			}

		}
	}

	public String displayItems(List<Sellable> listOfItems) {

		String display = "";

		for (Sellable item : listOfItems) {
			if (item.getQuantity() > 0) {
				display = display + item.getCode() + " " + item.getName() + " Price: " + item.getPrice() + " Quantity: "
						+ item.getQuantity() + "\n";
			} else {
				display = display + item.getCode() + " " + item.getName() + " Price: " + item.getPrice() + " SOLD OUT"
						+ "\n";
			}
		}
		return display;
	}

	public String processMoney() {

		String selection = "";
		while (!selection.contentEquals("Back")) {
			System.out.println("> > Current Money Provided: $" + funds.getBalance());
			selection = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU);

			if (selection.equals("$1")) {

				funds.addToBalance(new BigDecimal(1));

			} else if (selection.equals("$2")) {

				funds.addToBalance(new BigDecimal(2));
			} else if (selection.equals("$5")) {

				funds.addToBalance(new BigDecimal(5));

			} else if (selection.equals("$10")) {

				funds.addToBalance(new BigDecimal(10));
			}
		}
		return selection;
	}

	public String makeChange(BigDecimal remainder) {

		int newRemainder = (int) (remainder.doubleValue() * 100);
		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		int numOfQuarters = 0;
		int numOfDimes = 0;
		int numOfNickels = 0;

		String change = "";

		if (newRemainder > 0) {
			if (newRemainder >= 25) {
				numOfQuarters = newRemainder / quarter;
				int valueOfQuarters = numOfQuarters * quarter;
				newRemainder -= valueOfQuarters;
			}
			if (newRemainder >= 10) {
				numOfDimes = newRemainder / dime;
				int valueOfDimes = numOfDimes * dime;
				newRemainder -= valueOfDimes;
			}
			if (newRemainder >= 5) {
				numOfNickels = newRemainder / nickel;
				int valueOfNickels = numOfNickels * nickel;
				newRemainder -= valueOfNickels;
			}
			change = change + "The total change dispensed is: $" + remainder + "\n" + numOfQuarters + " quarters \n"
					+ numOfDimes + " dimes \n" + numOfNickels + " nickels \n";
		} else {
			change = "No change necessary";
		}
		return change;

	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
