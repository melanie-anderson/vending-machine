package materials;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetInventory {

	private List<String[]> itemsList = new ArrayList<String[]>();
	private List<Sellable> itemsInMachine = new ArrayList<Sellable>();

	public List<String[]> readFile(File file) {
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] lineArray = line.split("\\|");
				itemsList.add(lineArray);
			}
		} catch (Exception e) {
			System.out.println("File Cannot Be Found");
		}
		return itemsList;

	}

	public void addItemsToMachine() {

		for (

		String[] item : itemsList) {
			String type = item[3];
			if (type.equals("Candy")) {
				Sellable newSellable = new Candy(item[1], new BigDecimal(item[2]), item[0], 5);
				itemsInMachine.add(newSellable);
			}
			if (type.equals("Chip")) {
				Sellable newSellable = new Chip(item[1], new BigDecimal(item[2]), item[0], 5);
				itemsInMachine.add(newSellable);
			}
			if (type.equals("Drink")) {
				Sellable newSellable = new Drink(item[1], new BigDecimal(item[2]), item[0], 5);
				itemsInMachine.add(newSellable);
			}
			if (type.equals("Gum")) {
				Sellable newSellable = new Gum(item[1], new BigDecimal(item[2]), item[0], 5);
				itemsInMachine.add(newSellable);
			}
		}
	}

	public List<String[]> getItemsList() {
		return itemsList;
	}

	public List<Sellable> getItemsInMachine() {
		return itemsInMachine;
	
	} 
}
