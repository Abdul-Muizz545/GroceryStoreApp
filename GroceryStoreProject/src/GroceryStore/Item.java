/* Name: Abdul-Muizz Imtiaz, Abdul Mohsen Adel Alabdeen, Najeeb Salim
 * ID: 2181151889, 2181145248, 2181151588
 * JavaProjectPhase1
 */

package GroceryStore;

import java.util.Scanner;

//Beginning of Item class (contains all the methods and attributes needed to define an item)
public class Item {
	Scanner input = new Scanner(System.in);
	//Declaring the attributes 
	private String Name;
	private int Item_number; 
	private int Quantity;
	private double Price; //Selling price of item to customer
	private double Cost; //Buying price of item (how much it cost for the grocery store to buy it)
	
	//Constructor method
	public Item (String name, int item_num, int quantity, double price, double cost) {
		Name = name;
		Item_number = item_num;
		Quantity = quantity;
		Price = price;
		Cost = cost;
	} //end of constructor method
	
	
	public void setName(String name) {
		Name = name;
	}

	
	public void setItemNumber(int item_num) {
		Item_number = item_num;
	}
	
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public void setPrice(Double price) {
		Price = price;
	}
	
	public void setCost(Double cost) {
		Cost = cost;
	}

	public String getName() {
		return Name;	
	}
	
	public int getItemNumber() {
		return Item_number;
	} 
	
	public int getQuantity() {
		return Quantity;	
	}
	
	public double getPrice( ) {
		return Price;
	}
	
	public double getCost() {
		return Cost;
	}
		
	
	public void increaseQuantity(int num) {
		while (num <= 0) {
			System.out.println("The increase amount should be greater than 0.");
			System.out.println("Please enter another amount to increase by: ");
			num = input.nextInt();
		}
		Quantity += num;
	}
	
	//method to decrease the quantity of the item by the value num (we do error checking in the main method
	public void decreaseQuantity(int num) { 
		while (num <= 0 || num > Quantity) {
			if (num <= 0) {
				System.out.println("The decrease amount should be greater than 0.");
				System.out.print("Please enter another amount to decrease by: ");
				num = input.nextInt();
			}
			if (num > Quantity) {
				System.out.printf("We dont have enough of that item. Please enter a value less than or equal to %d: ", Quantity);
				num = input.nextInt();
			}
		}
		Quantity -= num;
	
	}
	
	
	
	
} //end of class 




