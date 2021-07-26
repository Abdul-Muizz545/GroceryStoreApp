package GroceryStore;
// Beginning of employee class (contains all the methods and attributes needed to define an employee)

public class Employee {	
	// Declaring the attributes
	private int ID;
	private String Name; 
	
	
	 //Constructor method
	public Employee (String name, int id) {
		Name=name;
		ID=id;
	} //end of constructor
	
	//setName method
	public void setName(String name) {
		Name= name;
	}
	
	// setID method
	public void setID(int id) {
		ID=id;
	}
	
	//getName method 
	public String getName() {
		return Name;
	}
	
	//getID method
	public int getID() {
		return ID;
	}
	

	
} //end of class
 
