package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//get number of customers to be entered
		int numCustomers = scan.nextInt();
		
		
		//iterate through customers
		for(int i = 0 ; i < numCustomers ; i++)
		{
			//get first/last name and # of items bought
			String firstName = scan.next();
			String lastName = scan.next();
			int numItems = scan.nextInt();
			
			double totalPrice = 0;
			
			//iterate through items
			for(int j = 0 ; j < numItems ; j++)
			{
				//get quantity, name, and price of item
				int quantity = scan.nextInt();
				String name = scan.next();
				double price = scan.nextDouble();
				
				//add cost of items to total
				totalPrice += quantity * price;
			}
			
			//compose message with customer name and price of goods bought
			System.out.println(firstName.charAt(0) + ". " + lastName + ": " + String.format("%.2f", totalPrice));
		}
		
		
		
	}
}
