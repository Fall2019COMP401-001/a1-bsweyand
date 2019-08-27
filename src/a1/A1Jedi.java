package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//get number of items in store and create an array to store names
		int numItems = scan.nextInt();
		String items[] = new String[numItems] ;
		
		//iterate through items to get name and price
		for(int i = 0; i < numItems; i++)
		{
			//add name and price of item to items
			String itemName = scan.next();
			String itemPrice = scan.next();
			
			items[i] = itemName;
		}
		
		
		/*get number of customers and create a matrix to store item amounts for each customer/item pair.
		 * In this matrix, the row number represents the item name and the column number represents the customer
		 */
		int numCustomers = scan.nextInt();
		String[] customers = new String[numCustomers];
		int[][] itemsSold = new int[numItems][numCustomers];
		
		//iterate through customers to get # of items bought to populate array
		for(int i = 0; i < numCustomers ; i++ )
		{
			customers[i] = scan.next() + " " + scan.next();
			int itemsBought = scan.nextInt();
			
			//iterate through items bought and add amounts to itemsSold
			for(int j = 0; j < itemsBought; j++)
			{
				int amount = scan.nextInt();
				String itemName = scan.next();
				int rowIndex = Arrays.binarySearch(items, itemName);
				itemsSold[rowIndex][i] = amount;
			}	
		}
		 
		//iterate through itemsSold to get counts for the # of customers who bought each item and total # of item sold
		for(int i = 0; i < numItems; i++)
		{
			int customerCount = 0;
			int itemCount = 0;
			for(int j = 0; j < numCustomers; j++)
			{
				if(itemsSold[i][j] > 0)
				{
					customerCount++;
					itemCount += itemsSold[i][j];
				}
			}
			
			//print customer and item totals for current item. If no customers bought current item, print a specialized string
			if(customerCount > 0)
				System.out.println(customerCount + " customers bought " + itemCount + " " + items[i]);
			else
				System.out.println("No customers bought " + items[i]);
		}
		
	}
}
