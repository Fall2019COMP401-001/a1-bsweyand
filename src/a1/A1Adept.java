package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//get number of items in store and create a large string to save items
		int numItems = scan.nextInt();
		String items = "";
		
		//iterate through items to get name and price
		for(int i = 0; i < numItems; i++)
		{
			//add name and price of item to items
			String itemName = scan.next();
			String itemPrice = scan.next();
			
			items += itemName + " " + itemPrice + " ";
		}
		
		//create a scanner to search through the list of items to find prices
		Scanner itemSearch = new Scanner(items);
		
		//get number of customers and create an array to save them
		int numCustomers = scan.nextInt();
		String[] customers = new String[numCustomers];
		double[] balances = new double[numCustomers];
		
		
		//iterate through customers to get name and calculate balance
		for(int i = 0; i < numCustomers ; i++ )
		{
			customers[i] = scan.next() + " " + scan.next();
			double balance = 0;
			int itemsBought = scan.nextInt();
			
			//iterate through items bought and lookup price using itemSearch to calculate balance
			for(int j = 0; j < itemsBought; j++)
			{
				int amount = scan.nextInt();
				String itemName = scan.next();
				itemSearch.findInLine(itemName);
				double price = Double.parseDouble(itemSearch.next());
				balance += price * amount;
				itemSearch = new Scanner(items);
			}
			
			balances[i] = balance;
		}
		
		//iterate through customers to find max, min, and average spending
		int maxIndex = 0;
		int minIndex = 0;
		double sum = balances[0];
		for(int i = 1; i < numCustomers ; i++)
		{
			if(balances[i] > balances[maxIndex])
				maxIndex = i;
			if(balances[i] < balances[minIndex])
				minIndex = i;
			sum += balances[i];
		}
		double average = sum / numCustomers;
		
		System.out.println("Biggest: " + customers[maxIndex] + " (" + String.format("%.2f", balances[maxIndex]) + ")");
		System.out.println("Smallest: " + customers[minIndex] + " (" + String.format("%.2f", balances[minIndex]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
}
