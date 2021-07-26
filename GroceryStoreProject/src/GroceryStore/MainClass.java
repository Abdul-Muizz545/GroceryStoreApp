/* Names: Abdul-Muizz Imtiaz, Abdul Mohsen Adel Alabdeen, Najeeb Salim
 * ID: 2181151889, 2181145248, 2181151588
 * JavaProjectPhase1
 */

package GroceryStore; 
import java.util.Scanner;
import java.util.ArrayList;


//Beginning of main class 
public class MainClass {	
	static Scanner input = new Scanner(System.in); //Creating Scanner object for user input (common for all methods)
	
	//Beginning of main method
	public static void main(String[] args) {
		int c1; //Choice variable for main menu
		int c2 = 1; //Choice variable for items menu (initialized to a value)
		int c3; //Choice variable for employees menu (initialized to a value)
		int c4; //Choice variable for the reports menu 

		ArrayList<Employee> employees = new ArrayList<Employee>(); //ArrayList to store employee objects from the Employee class
		ArrayList<Item> items = new ArrayList<Item>(); //ArrayList to store item objects from the Item class
		ArrayList<Item> receipt = new ArrayList<Item>(); //ArrayList to store the items that the customer buys
		ArrayList<Item> soldItems = new ArrayList<Item>(); //ArrayList to store the total sold items and their quantity
		
		
		//Main menu for application 
		System.out.println("Welcome to the Grocery console app!");
		System.out.println("-----------------------------------\n");
		System.out.print("Choose an option from the following: \n1. Items\n2. Employees\n3. Cashier\n4. Reports \n0. Exit\n\n");
		System.out.print("Your choice: ");
		while (true) {
			try {
				c1 = input.nextInt(); //Input the choice from the user for main menu
				break;
			}
			catch (Exception e) {
				System.out.print("Please enter an integer: ");
				input.nextLine();
			}
		} //end of try catch
		//End of main menu  
		
		
		//Beginning of while loop for main menu choice
		while (c1 != 0) { //While user does not press exit choice in main menu
			switch (c1) {	
			case 1: //User selects item option 				
				//Beginning of items menu
				System.out.println("Items");
				System.out.println("-----\n");
				System.out.println("Choose an option from the following: \n1. Add an item \n2. Update an item \n3. Remove an item \n4. Search for an item \n0. Exit\n-1. Go Back\n");
				System.out.print("Your choice: ");

				while(true) {
					try {
						c2= input.nextInt(); //Input choice for item menu
						break;
					}
					catch(Exception e) {
						System.out.println("Please enter an integer :");
						input.nextLine();	
					}
				}

				//End of items menu 

				//While loop for Items menu choice
				while (c2 != -1) { //While user does not press exit choice in items menu
					if (c2 == 0) {
						c1 = 0;
						break; //break from this while loop for c2
					}
					switch (c2) {	
					case 1: //User chooses to add an item
						printItems(items);         
						items = addItem(items);
						break;

					case 2: // User chooses to update an item

						if (items.isEmpty()) {
							System.out.println("Sorry there are currently no items in the store.");
						} 
						else {
							printItems(items);
							items = updateItem(items);
						}
						break;

					case 3: // User chooses to remove an item
						if (items.isEmpty()) {
							System.out.println("Sorry there are currently no items in the store");
						}
						else {
							printItems(items);
							items = removeItem(items);
						}
						break;

					case 4: // User chooses to search for an item
						if (items.isEmpty()) {
							System.out.println("Sorry there are currently no items in the store.");
						}
						else {
							printItems(items);
							searchItem(items);
						}
						break;		

					default: //User puts invalid input
						System.out.println("\nInvalid choice! Try again\n");
						break;

					} //end of switch for Items menu

					//Displaying Items menu again
					System.out.println("Items");
					System.out.println("-----\n");
					System.out.println("Choose an option from the following: \n1. Add an item \n2. Update an item \n3. Remove an item \n4. Search for an item \n0. Exit\n-1. Go Back\n");
					System.out.print("Your choice: ");

					while(true) {
						try {
							c2= input.nextInt(); //Input choice for item menu
							break;
						}
						catch(Exception e) {
							System.out.println("Please enter an integer :");
							input.nextLine();	
						}
					}

				} //end of while loop for Items menu choice

				break;


			case 2: //User selects employees option from main menu

				//Beginning of employees menu
				System.out.println("\nEmployees");
				System.out.println("---------\n");
				System.out.println("Choose an option from the following: \n1. Add a new employee \n2. Update a new employee \n3. Remove an employee \n4. Search for an employee \n0. Exit\n-1. Go back\n");
				System.out.print("Your choice: ");
				while (true) {
					try {
						c3 = input.nextInt(); //Input choice for employees menu
						break;
					}
					catch (Exception e) {
						System.out.print("Enter an integer: ");
						input.nextLine();
					}
					
				}
					
				//While loop for Employees menu choice
				while (c3 != -1) { //While user does not press exit in employees menu
					if (c3 == 0) {
						c1 = 0;
						break; //break from this while loop for c3
					}
					switch (c3) {
					case 1: //User chooses to add an employee
						printEmployees(employees);
						employees = addEmployee(employees);
						break;
						
					case 2: // User chooses to update an employee
						if (employees.isEmpty()) { //if there are no employees in the store
							System.out.print("There are no employees in the store currently.");
						}
						else { 
							printEmployees(employees);
							employees = updateEmployee(employees);
						}
						break;
						
					case 3: // User chooses to remove an employee
						if (employees.isEmpty()) { //if no employees in the store
							System.out.println("There are no employees in the store currently.");
						}
						else {
							printEmployees(employees);
							employees = removeEmployee(employees);
						
						}
						break;

					case 4: // User chooses to search for an employee
						if (employees.isEmpty()) { //if no employees in the store
							System.out.println("There are no employees in the store currently.");
						}
						else {
							printEmployees(employees); 
							searchEmployee(employees); //Calling a method to search for employee in employees list
						}
						break;
						
				
					default: //User puts invalid input for employees menu choice
						System.out.println("\nInvalid choice for employees menu! Please try again\n");
						break;
											
					} //end of switch for Employees choice
					
					//Displaying employees menu again
					System.out.println("\nEmployees");
					System.out.println("---------\n");
					System.out.println("Choose an option from the following: \n1. Add a new employee \n2. Update a new employee \n3. Remove an employee \n4. Search for an employee \n0. Exit\n-1. Go back\n");
					System.out.print("Your choice: ");
					while (true) {
						try {
							c3 = input.nextInt(); //Input choice for employees menu
							break;
						}
						catch (Exception e) {
							System.out.print("Enter an integer: ");
							input.nextLine();
						}	
					}

					
				} //end of while loop for Employees menu	
				
				break;
			
			case 3: //User selects cashier option
				//Allow user to choose an item (or items) from our items array created and print a receipt at the end of each purchase
				if (items.isEmpty()) {
					System.out.println("Sorry! There are currently no items in the store");
				}
				else {
					System.out.println("\nHello there customer! Choose the items you want to buy.");
					chooseItems(items, receipt, soldItems); //This is the method that will let you choose your items and print the items list each time
				}
				
				break;

			case 4: //User selects report option
				//Do report stuff
				//Printing a report menu
				System.out.println("Select an option from the following reports");
				System.out.println("-------------------------------------------");
				System.out.println("1. Report of total sold items and their quantity \n2. Report of the remaining items and their quantity \n3. Report of the total profit and the profit for each item \n4. Report of the total sales, and the profit for each item \n5. Report of the list of employees\n0. Exit\n-1. Go back\n");
 				System.out.print("Enter your choice here: ");
 				while (true) {
 					try {
 						c4 = input.nextInt(); //Input report menu choice
 		 				break;
 					}
 					catch (Exception e) {
 						System.out.print("Enter an integer: ");
 						input.nextLine();
 					}
 				}
	 				
 
 				while (c4 != -1) {
 					if (c4 == 0) {
						c1 = 0;
						break; //break from this while loop for c4
					}
 					//Switch for report menu choice
 					switch (c4) { 
 					case 1: //Report of total sold items and their quantity
 						printSoldItems(soldItems);
 						break;
 					
 					case 2: //Report of the remaining items and their quantity
 						printItems(items);
 						break;
 					
 					case 3: //Report of the total profit and profit for each item
 						printItemProfit(soldItems);
 						break;
 					
 					case 4: //Report of the total sales and profit for each item
 						printItemSale(soldItems);
 						break;
 						
 					case 5: //Report of the the list of employees
 						printEmployees(employees);
 						break;
 				
 						
 					default: //Otherwise (invalid input in report menu choice)
 						System.out.println("Invalid choice for report menu! Please try again\n");
 						break;
 					} //end of switch for reports menu
 					
 					//Print report menu again
 					System.out.println("Select an option from the following reports");
 					System.out.println("-------------------------------------------");
 					System.out.println("1. Report of total sold items and their quantity \n2. Report of the remaining items and their quantity \n3. Report of the total profit and the profit for each item \n4. Report of the total sales, and the profit for each item \n5. Report of the list of employees\n0. Exit\n-1. Go back\n");
 					System.out.print("Enter your choice here: ");
 					while (true) {
 	 					try {
 	 						c4 = input.nextInt(); //Input report menu choice
 	 		 				break;
 	 					}
 	 					catch (Exception e) {
 	 						System.out.print("Enter an integer: ");
 	 						input.nextLine();
 	 					}
 	 				}

 				} //end of while loop for reports menu
 			
				break; //break from case 4 of main menu
				
			default:// Invalid input in main menu choice
				System.out.println("Invalid input for main menu! Please try again\n\n");
				break;
				
			}//end of switch for main menu
			
			if (c1 != 0) { //if main menu choice is not to exit 
				//Main menu for application 
				System.out.println("Welcome to the Grocery console app!");
				System.out.println("-----------------------------------\n");
				System.out.print("Choose an option from the following: \n1. Items\n2. Employees\n3. Cashier\n4. Reports \n0. Exit\n\n");
				System.out.print("Your choice: ");
				while (true) {
					try {
						c1 = input.nextInt(); //Input the choice from the user for main menu
						break;
					}
					catch (Exception e) {
						System.out.print("Please enter an integer: ");
						input.nextLine();
					}
				}
				//End of main menu  
			}
			
		} //end of while loop for main menu
	
	} //end of main method

	

	//ITEM METHODS	
	
	//addItem method (adds item object to an item array that contains item objects)
	public static ArrayList<Item> addItem(ArrayList<Item> items) {	
		System.out.print("Enter a positive number for the item ID.\n IT MUST BE UNIQUE\n ");
		int num;
		while(true) {
			try {
				while(true) {
				 num = input.nextInt(); //stores the ID of the item to be added
				if(num<=0)//checks for 0 or negative values and gives error
					System.out.println("The ID must be a positive integer!\nEnter ID:");
				else
					break;
				}
				 break;
			}
			catch(Exception e) {
				System.out.println("The ID must be an integer!\nEnter ID:");
				input.nextLine();	
			}
		}

		while(indexOfItemNumber(items, num) != -1) {//checks if it is a new id
			System.out.println("This ID is already assigned to another item.\nPlease select a new ID: ");
			while(true) {
				try {
					while(true) {
						 num = input.nextInt(); //stores the ID of the item to be added
						if(num<=0)//checks for 0 or negative values and gives error
							System.out.println("The ID must be a positive integer!\nEnter I:");
						else
							break;
						}
					 
					break;
				}
				catch(Exception e) {
					System.out.println("The ID must be an integer!\\nEnter ID:");
					input.nextLine();	
				}
			}
			
		}//while loop	
		
		input.nextLine(); 
		System.out.print("What is the name of the item you want to add? ");
		String name = input.nextLine();
		System.out.print("What is this items quantity? ");
		int quantity;
		while(true) {
			try {
				while(true) {
					quantity = input.nextInt(); 
					if(quantity<0)//checks for negative values and gives error
						System.out.println("The quantity cannot be less than zero!\nEnter quantity:");
					else
						break;
					}
				
				break;
			}
			catch(Exception e) {
				System.out.println("Item quantity must be an integer\nEnter quantity:");
				input.nextLine();	
			}
		}
		
		System.out.print("What is this items selling price? ");
		double price;
		while(true) {
			try {
				while(true) {
					price = input.nextDouble(); 
					if(price<0)//checks for negative values and gives error
						System.out.println("The price cannot be less than zero!\nEnter price:");
					else
						break;
					}
				
				break;
			}
			catch(Exception e) {
				System.out.println("Please enter a Double :");
				input.nextLine();	
			}
		}
		
		double cost;
		System.out.print("What is this items cost? ");
		while(true) {
			try {
				while(true) {
					cost = input.nextDouble();  
					if(cost<=0)//checks for 0 and negative values and gives error
						System.out.println("The cost cannot be less than or equal to zero!\nEnter cost:");
					else
						break;
					}
				
				break;
			}
			catch(Exception e) {
				System.out.println("Cost must be a double!\nEnter cost:");
				input.nextLine();	
			}
		}
		
		////double cost = input.nextDouble();
		items.add(new Item(name, num, quantity, price, cost));
		//}
		System.out.println("Item added:");
		printItem(items,indexOfItemNumber(items, num));
		return items;
	} //end of addItem method
	
	public static ArrayList<Item> updateItem(ArrayList<Item> items) {
		int cu = 0; //choice variable for updating an item

		System.out.println("Enter the item's ID");
		int numm;
		while(true) {
			try {
				numm = input.nextInt(); //stores the item number of the item to be added
				break;
			}
			catch(Exception e) {
				System.out.println("Please enter an integer :");
				input.nextLine();	
			}
		}



		while(indexOfItemNumber(items, numm) == -1) {//checks if it is a new id
			System.out.println("This ID is not assigned to any item.\nPlease enter a valid ID: ");
			while(true) {
				try {
					numm = input.nextInt();
					break;
				}
				catch(Exception e) {
					System.out.println("Please enter an integer :");
					input.nextLine();	
				}
			}

		}//while loop
		int index = indexOfItemNumber(items, numm);
		System.out.println("You've selected the item: ");
		printItem(items, index);
		System.out.println("What would you like to update?\n1.Name\n2.Quantity\n3.Selling price\n4.Cost\n\n-1.go back");						
		while(true) {
			try {
				cu = input.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("Please enter an integer :");
				input.nextLine();	
			}
		}

		while(cu != -1) {
			switch(cu) {

			case 1:
				System.out.println("Enter the new name: ");
				String newname = input.next();

				items.get(index).setName(newname);
				break;
			case 2:
				System.out.println("Would you like to:\n1.Increase quantity\n2.Decrease quantity\n3.Enter new quantity");
				while(true) {
					try {
						cu = input.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.println("Please enter an integer :");
						input.nextLine();	
					}
				}

				if(cu==1) {
					System.out.println("Enter increment amount: ");

					while(true) {
						try {
							items.get(index).increaseQuantity(input.nextInt());
							break;
						}
						catch(Exception e) {
							System.out.println("Increment amount must be an integer! \nEnter increment amount:");
							input.nextLine();	
						}
					}

				}
				else if(cu==2){
					System.out.println("Enter decrement amount: ");

					while(true) {
						try {
							items.get(index).decreaseQuantity(input.nextInt());
							break;
						}
						catch(Exception e) {
							System.out.println("Decrement amount must be an integer! \nEnter decrement amount:");
							input.nextLine();	
						}
					}

				}
				else if(cu==3) {
					System.out.println("Enter new Quantity: ");
					while(true) {
						try {
							items.get(index).setQuantity(input.nextInt());
							break;
						}
						catch(Exception e) {
							System.out.println("Quantity must be an integer!\nEnter new quantity:");
							input.nextLine();	
						}
					}

				}

				else {
					System.out.println("Invalid choice");
				}
				break;

			case 3:
				System.out.println("Enter the new selling price: ");
				while(true) {
					try {
						items.get(index).setPrice(input.nextDouble());
						break;
					}
					catch(Exception e) {
						System.out.println("Please enter an integer :");
						input.nextLine();	
					}
				}

				break;
			case 4:
				System.out.println("Enter the new cost: ");
				while(true) {
					try {
						items.get(index).setCost(input.nextDouble());
						break;
					}
					catch(Exception e) {
						System.out.println("Please enter an integer :");
						input.nextLine();	
					}
				}

				break;

			default:
				System.out.println("Invalid choice. please select one of the valid choices: ");
				break;
			}//end of updating item switch case

			System.out.println("The item now is:");
			printItem(items,index);
			System.out.println("\n1.Name\n2.Quantity\n3.Selling price\n4.Cost\n\n-1.go back");
			while(true) {
				try {
					cu = input.nextInt();
					break;
				}
				catch(Exception e) {
					System.out.println("Please enter an integer :");
					input.nextLine();	
				}
			}


		}

		return items;
	}


	public static ArrayList<Item> removeItem(ArrayList<Item> items) {
		System.out.println("Enter the item's ID to delete it: ");
		int nummm;
		int cu = 0;
		while(true) {
			try {
				nummm = input.nextInt(); //stores the item number of the item to be added
				break;
			}
			catch(Exception e) {
				System.out.println("Please enter an integer :");
				input.nextLine();	
			}
		}
		
		


		while(indexOfItemNumber(items, nummm) == -1) {//checks if it is a new id
			System.out.println("This ID is not assigned to any item.\nPlease enter a valid ID:\n-1.go back ");
			
			while(true) {
				try {
					nummm = input.nextInt();
					break;
				}
				catch(Exception e) {
					System.out.println("Please enter an integer :");
					input.nextLine();	
				}
			}
			if(nummm==-1)
				break;
			
		}//while loop
		if(nummm != -1) {
		int indexx = indexOfItemNumber(items, nummm);
		System.out.println("Are you sure you want to delete this item?");
		printItem(items, indexx);
		System.out.println("1. Confirm and DELETE\n2.Cancel");
		while(true) {
			try {
				cu = input.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("Please enter an integer :");
				input.nextLine();	
			}
		}
		
		if(cu == 1) {
			items.remove(indexx);
			System.out.println("Item removed!");
		}
		else if(cu == 2)
			System.out.println("Item remains.");
		else
			System.out.println("Invalid coice. Item remains");
		}
		return items;
	}

	public static void searchItem(ArrayList<Item> items) {
		int cu=0;
		while(cu==0) {
			System.out.println("Would like to:\n1.Show Item's list\n2.Search using an items name\n3.Search using an items ID\n\n-1.go back");
			while(true) {
				try {
					cu = input.nextInt();
					break;
				}
				catch(Exception e) {
					System.out.println("Please enter an integer :");
					input.nextLine();	
				}
			}
			
			switch(cu) {
			case -1:
				cu=-321;
				break;
			case 1:
				printItems(items);
				break;
			case 2:
				System.out.println("Enter the items name:");
				input.nextLine();
				String iname = input.nextLine();
				while(indexOfItemName(items, iname) == -1) {//checks if it is a new id
					System.out.println("This name is not assigned to any item.\nPlease enter a valid name or enter -1 to go back: ");
					iname = input.nextLine();
					if(iname.equals("-1"))/////////////////////////////////////////////////////////////////////////////////////
						break;
				}//for loop
				if(iname.equals("-1") == false)
					printItem(items,indexOfItemName(items, iname));
				break;
			case 3:
				System.out.println("Enter the items ID:");
				int iid;
				while(true) {
					try {
						iid = input.nextInt();
						break;
					}
					catch(Exception e) {
						System.out.println("Please enter an integer :");
						input.nextLine();	
					}
				}
				
				while(indexOfItemNumber(items, iid) == -1) {//checks if it is a new id
					System.out.println("This ID is not assigned to any item.\nPlease enter a valid ID or enter -1 to go back: ");
					while(true) {
						try {
							iid = input.nextInt();
							break;
						}
						catch(Exception e) {
							System.out.println("Please enter an integer :");
							input.nextLine();	
						}
					}
					
					if(iid==-1)
						break;
				}//while loop
				if(iid != -1)
					printItem(items,indexOfItemNumber(items, iid));

				break;
			default:
				System.out.println("Please enter a valid option");
				break;
			}//switch
			if(cu != -321)
				cu=0;
		}//while
	}


	//Additional methods called for items 


	//indexOfItemNumber method (method that returns the index of the item number in the items array)
	public static int indexOfItemNumber(ArrayList<Item> items, int num) {
		for (int i = 0; i< items.size(); i++) {
			if (items.get(i).getItemNumber() == num) { 
				return i; //return index if the item number is found in the items array
			}
		} //end of the for loop
		
		return -1; //Return -1 if Item number is not found in the items arraylist
	} //end of indexOfItemNumber method
	
	
	public static int indexOfItemName(ArrayList<Item> items, String nam) {
		for (int i = 0; i< items.size(); i++) {
			if (items.get(i).getName().equals(nam)) { 
				return i; //return index if the item name is found in the items array
			}
		} //end of the for loop

		return -1; //Return -1 if Item  is not found in the items arraylist
	} //end of indexOfItemName method

	
	
	//printItem method (prints a given item using it's index)
	public static void printItem(ArrayList<Item> items, int i) {
		System.out.printf("%-15s %-12s %-10s %-10s %-10s \n\n", "NAME", "ITEM ID", "QUANTITY", "PRICE","COST");
		System.out.printf("%-15s %-12d %-10d %-10.2f %-10.2f \n\n",items.get(i).getName(), items.get(i).getItemNumber(), items.get(i).getQuantity(), items.get(i).getPrice(), items.get(i).getCost() );
	}
	
	//printItems method (method that prints the current list of items in the store)
	public static void printItems(ArrayList<Item> items) {
		System.out.println("\nHere is the list of items.");
		System.out.printf("%-15s %-12s %-10s %-10s %-10s \n\n", "NAME", "ITEM NUMBER", "QUANTITY", "PRICE","COST");

		for (int i = 0; i < items.size(); i++) {
			System.out.printf("%-15s %-12d %-10d %-10.2f %-10.2f \n",items.get(i).getName(), items.get(i).getItemNumber(), items.get(i).getQuantity(), items.get(i).getPrice(), items.get(i).getCost() );
		}
		System.out.println();
	}
	


	//--------------
	
	//EMPLOYEE METHODS 

	//addEmployee method (adds employee object to an employee array that contains employee objects)
	public static ArrayList<Employee> addEmployee(ArrayList<Employee> employees) {	
		input.nextLine();
		System.out.print("\nWhat is the name of the new employee? ");
		String name = input.nextLine(); //employee name
	
		System.out.print("What is the new employees ID? ");
		int ID;
		while (true) {
			try {
				ID = input.nextInt(); //employee ID
				break;
			}
			catch (Exception e) {
				System.out.print("Enter an integer: ");
				input.nextLine();
			}
		}
		//Error checking (to make sure that every employee has a unique ID)
		while (indexOfEmployeeID(employees, ID) != -1) { //calling indexOfEmployeeID method
				System.out.print("That ID belongs to another employee! Please enter again: ");
				while (true) {
					try {
						ID = input.nextInt(); //employee ID
						break;
					}
					catch (Exception e) {
						System.out.print("Enter an integer: ");
						input.nextLine();
					}
				}
		}
		
		employees.add(new Employee(name, ID)); //Add the new employee object to our employees arraylist
		return employees; //return the employees arraylist
	} //end of addEmployee method
	

	//updateEmployee method (updates an employee object in the employees array)
	public static ArrayList<Employee> updateEmployee(ArrayList<Employee> employees) {
		System.out.print("What is the ID of the employee you want to update? ");
		int ID;
		while (true) {
			try {
				ID = input.nextInt(); //employee ID
				break;
			}
			catch (Exception e) {
				System.out.print("Enter an integer: ");
				input.nextLine();
			}
		}
		int index = indexOfEmployeeID(employees, ID); //index of the employee to be updated (based on ID)
		
		//Error checking (making sure that employee to be updated actually exists)
		while (index == -1) { //while the ID does not belong to any employee
			System.out.print("That ID does not belong to any employee in the store. Please enter another ID: ");
			while (true) {
				try {
					ID = input.nextInt(); //employee ID
					break;
				}
				catch (Exception e) {
					System.out.print("Enter an integer: ");
					input.nextLine();
				}
			}
			index = indexOfEmployeeID(employees, ID);
		}
		
		
		//Input information about the updated employee
		input.nextLine();
		System.out.print("What is the updated name for the employee? ");
		String updatedName= input.nextLine(); //new name for employee
		
		System.out.print("What is the updated ID? ");
		int updatedID; //new ID for employee 
		while (true) {
			try {
				updatedID = input.nextInt(); //employee ID
				break;
			}
			catch (Exception e) {
				System.out.print("Enter an integer: ");
				input.nextLine();
			}
		}
		
		//error checking (to make sure that the updated employee has a unique ID)
		while (indexOfEmployeeID(employees, updatedID) != -1) {
				System.out.print("That ID belongs to another person! Please enter a new ID for the updated employee: ");
				while (true) {
					try {
						updatedID = input.nextInt(); //employee ID
						break;
					}
					catch (Exception e) {
						System.out.print("Enter an integer: ");
						input.nextLine();
					}
				}
		}
		
		Employee employee = employees.get(index); //This will store the new employee at the same index of the old employee
		employee.setName(updatedName); //set the employees name to updatedName
		employee.setID(updatedID); //set the employees ID to updatedID

		employees.set(index, employee); //Updating the employee object at the same index
		return employees; //return the employees list
	} //end of updateEmployee method


	//removeEmployee method (deletes an employee object in the employees arraylist)
	public static ArrayList<Employee> removeEmployee(ArrayList<Employee> employees) {
		System.out.print("What is the ID of the employee you want to delete? ");
		int ID;
		while (true) {
			try {
				ID = input.nextInt(); //employee ID
				break;
			}
			catch (Exception e) {
				System.out.print("Enter an integer: ");
				input.nextLine();
			}
		}
		
		//Error checking (to make sure that the employee ID entered actually belongs to one of the employees)
		while (indexOfEmployeeID(employees, ID) == -1) { 
			System.out.print("That ID does not belong to any employee! Please enter again: ");
			while (true) {
				try {
					ID = input.nextInt(); //employee ID
					break;
				}
				catch (Exception e) {
					System.out.print("Enter an integer: ");
					input.nextLine();
				}
			}
		}

		int index = indexOfEmployeeID(employees, ID); //index of the employee to be removed in the employees array
		
		employees.remove(index); //removes the employee at the index given
		return employees;
	} //end of removeEmployee method
	

	//searchEmployee method (searches for an employee object in the employees array)
	public static void searchEmployee(ArrayList<Employee> employees) {
		System.out.print("What is the ID of the person you want to search for? ");
		int ID; 
		while (true) {
			try {
				ID = input.nextInt(); //employee ID
				break;
			}
			catch (Exception e) {
				System.out.print("Enter an integer: ");
				input.nextLine();
			}
		}
		int index = indexOfEmployeeID(employees, ID); //index of the ID for an employee in the employee list
		
		if (index == -1) { //employee not found in list
			System.out.println("Sorry! The employee was not found");
		}
		else { //employee found in list
			System.out.println("The employee was found at index "+ index);
		}

	} // end of searchEmployee method	

	//Additional methods called for Employees 

	//indexOfEmployeeID method (method that returns the index of the ID of an employee in the employees array)
	public static int indexOfEmployeeID(ArrayList<Employee> employees , int ID) {
		for (int i=0; i< employees.size(); i++) {
			if (((employees.get(i)).getID()) == ID) {
				return i; //Return index if ID is found in employees array
			}			
		} //end of the for loop
		
		return -1; //Return -1 if ID is not found in the employees array
	} //end of indexOfEmployeeID method

	//printEmployees method (method that prints the current list of employees in the store)
	public static void printEmployees(ArrayList<Employee> employees) {
		System.out.println("\nHere is the list of employees.");
		System.out.printf("%-20s %-8s \n", "NAME", "ID");
		for (int i = 0; i < employees.size(); i++) {
			System.out.printf("%-20s %-8d \n", employees.get(i).getName(), employees.get(i).getID());
		}
		System.out.println();
	} //end of printEmployees method
	
	
	//CASHIER METHODS 
	

	//chooseItem method (finds the quantity of the item that you want to buy and adds it to the receipt)
	public static void chooseItem(ArrayList<Item> items, ArrayList<Item> receipt, int itemnum) {
		System.out.print("How much of this item do you want to buy? "); 
		int q; //number of items of this type to buy
		while (true) {
			try {
				q = input.nextInt(); //number of items
				break;
			}
			catch (Exception e) {
				System.out.print("Enter an integer: ");
				input.nextLine();
			}
		}
		while (q <= 0) {
			System.out.print("Please enter a positive value for the number of items you want to buy: ");
			while (true) {
				try {
					q = input.nextInt(); 
					break;
				}
				catch (Exception e) {
					System.out.print("Enter an integer: ");
					input.nextLine();
				}
			}
		} //end of while
		
		int index = indexOfItemNumber(items,itemnum); //This is the index of the item you want to buy in the items list
		items.get(index).decreaseQuantity(q);
		receipt.add(new Item(items.get(index).getName(), itemnum, q, items.get(index).getPrice(), items.get(index).getCost())); //This will add q of the item to the receipt list

		if (items.get(index).getQuantity() == 0) //if the items quantity in the store is 0
			items.remove(items.get(index)); //remove the item from the items list
		
		
	} 
	
	
	// chooseItems method (chooses all the items that the customer wants to buy)
	public static void chooseItems(ArrayList<Item> items, ArrayList<Item> receipt, ArrayList<Item> soldItems) {
		boolean purchaseOver = false; //This stores whether or not the user wants to continue buying items
		while (!purchaseOver) { //as long as user wants to buy more items
			printItems(items); //print the list of items in the store currently
			
			System.out.print("\nWhat is the item number of the item you want to buy (enter -1 to stop buying items)? ");
			int itemnum; //This is the item number of the item to be bought
			while (true) {
				try {
					itemnum = input.nextInt(); //employee ID
					break;
				}
				catch (Exception e) {
					System.out.print("Enter an integer: ");
					input.nextLine();
				}
			} //end of try catch
			
			if (itemnum == -1) { //user doesn't want to buy more items
				purchaseOver = true; //user has stopped buying items
				continue; //leave the while loop
			}
			
			//Error checking to make sure they buy an item that exists in the store
			while (indexOfItemNumber(items,itemnum) == -1) {
				System.out.print("That item doesn't exist in the store, please enter another item number: ");
				while (true) {
					try {
						itemnum = input.nextInt(); //employee ID
						break;
					}
					catch (Exception e) {
						System.out.print("Enter an integer: ");
						input.nextLine();
					}
				} //end of try catch
			} 
			chooseItem(items, receipt, itemnum); //buy another item		
		}
		
		for (int i = 0; i < receipt.size(); i++) { //for each item in the receipt list
			int index = indexOfItemNumber(soldItems, receipt.get(i).getItemNumber()); //this is the index of where the current item in the receipt list is in the soldItems list
			if (index != -1) { //if the item in the receipt arraylist already exists in the soldItems arraylist
				soldItems.get(index).increaseQuantity(receipt.get(i).getQuantity()); //increase the quantity of this item in the soldItems list
			}
			else {
				soldItems.add(receipt.get(i)); //add the new Item object to the end of soldItems arraylist
			}
		}
		
		printReceipt(receipt); //prints the receipt at the end of the purchase
		receipt.clear(); //empty the receipt at the end of the customers purchase
	
	} //end of chooseItems method
	 
	//printReceipt method (prints the receipt for a customer)
	public static void printReceipt(ArrayList<Item> receipt) {
		//Printing the receipt header
		System.out.println("\nRECEIPT"); 
		System.out.printf("%-15s %-15s %-10s %-10s \n", "ItemName", "ItemPrice", "Quantity", "Itemtotal");
		
		double sum = 0;
		for (int i = 0; i < receipt.size(); i++) {
			System.out.printf("%-15s %-15.2f %-10d %-10.2f \n", receipt.get(i).getName(), receipt.get(i).getPrice(), receipt.get(i).getQuantity(), receipt.get(i).getPrice() * receipt.get(i).getQuantity());
			sum += receipt.get(i).getPrice() * receipt.get(i).getQuantity();
		}
		System.out.println();
		System.out.printf("%-43s%.2f \n\n", "TOTAL", sum); //This is printed at end of receipt
	} //end of printReceipt method

	
	//REPORT METHODS
	
	
	//printsoldItems method (prints the total soldItems for the store used in reports)
	public static void printSoldItems(ArrayList<Item> soldItems) {
		//Printing the soldItems header
		System.out.println("\nTOTAL SOLD ITEMS"); 
		System.out.printf("%-15s %-15s %-10s %-10s \n", "ItemName", "ItemPrice", "Quantity", "Itemtotal");
		
		double sum = 0;
		for (int i = 0; i < soldItems.size(); i++) {
			System.out.printf("%-15s %-15.2f %-10d %-10.2f \n", soldItems.get(i).getName(), soldItems.get(i).getPrice(), soldItems.get(i).getQuantity(), soldItems.get(i).getPrice() * soldItems.get(i).getQuantity());
			sum += soldItems.get(i).getPrice() * soldItems.get(i).getQuantity();
		}
		System.out.println();
		System.out.printf("%-43s%.2f \n\n", "TOTAL", sum); //This is printed at end of soldItems report
	} //end of printSoldItems method
	
	
	//Calculating the profit and print total profit 
	public static void printItemProfit(ArrayList<Item> soldItems) {
		double Profit = 0;

		System.out.println("\nThe Profit"); 
		System.out.printf("%-15s %-15s %-10s %-10s %-10s \n", "ItemName", "ItemPrice", "ItemCost", "Quantity", "ItemProfit");

		for(int i = 0; i < soldItems.size();i++) {
			System.out.printf("%-15s %-15.2f %-10.2f %-10d %-10.2f \n", soldItems.get(i).getName(), soldItems.get(i).getPrice(),soldItems.get(i).getCost(), soldItems.get(i).getQuantity(),(soldItems.get(i).getPrice() - soldItems.get(i).getCost())*soldItems.get(i).getQuantity());
			Profit += (soldItems.get(i).getPrice() - soldItems.get(i).getCost())*soldItems.get(i).getQuantity();

		}
		System.out.println();
		System.out.printf("%-53s%.2f \n\n", "TOTAL PROFIT", Profit);
	}
	
	//Print the Total Sales and profit per item
	public static void printItemSale(ArrayList<Item> soldItems) {
		double sale = 0;

		System.out.println("\nThe Sales"); 
		System.out.printf("%-15s %-15s %-10s %-10s %-10s %-10s\n", "ItemName", "ItemPrice", "ItemCost", "Quantity", "ItemProfit", "Sales per item");

		for(int i = 0; i < soldItems.size();i++) {
			System.out.printf("%-15s %-15.2f %-10.2f %-10d %-10.2f %-10.2f\n", soldItems.get(i).getName(), soldItems.get(i).getPrice(),soldItems.get(i).getCost(), soldItems.get(i).getQuantity(),(soldItems.get(i).getPrice() - soldItems.get(i).getCost()) * soldItems.get(i).getQuantity(), soldItems.get(i).getPrice() * soldItems.get(i).getQuantity());
			sale += soldItems.get(i).getPrice()*soldItems.get(i).getQuantity();
		}
		
		System.out.println();
		System.out.printf("%-65s%.2f \n\n", "TOTAL SALES", sale);
	}

} //end of main class
