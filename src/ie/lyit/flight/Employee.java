package ie.lyit.flight;

import java.io.Serializable;

import javax.swing.JOptionPane;

//INHERITANCE - Employee IS-A Person, and CAN-DO Payable methods
public class Employee extends Person implements Payable, Serializable {
    private Date startDate;	// Employee has name&dateOfBirth from Person		
    private double salary;	// AND startdate,salary, & number
    private int number;
    private String title, firstName, surname;
    private String name = title+" "+firstName+" "+surname;

	private static int nextNumber=1000;	// static for unique number - starts off at 1000    

	private final double MAX_SALARY = 150000.00;
	
    // Default Constructor
	// Called when object is created like this ==> 
	// Employee eObj = new Employee();	
    public Employee(){
    	super();
    	startDate=new Date();
 		salary=0.0;
		// Set number to static nextNumber before incrementing nextNumber
 		number=nextNumber++;
    }

    // Initialization Constructor
    public Employee(String title, String fname, String sname, 
    		        int d, int m, int y,
    		        Date startDate, double salary){
       // Call super class constructor - Passing parameters required by Person ONLY!
	   super(title, fname, sname, d, m, y);
	   // And then initialise Employees own instance variables
	   this.startDate=startDate;	// Set instance variable to parameter
	   this.salary=salary;
	   
		// Set number to static nextNumber before incrementing nextNumber
	   number = nextNumber++;						
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
    public String toString(){
		return number + " " + super.toString() + " €" + salary;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(e1.equals(e2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Employee eObject;
		if (obj instanceof Employee)
		   eObject = (Employee)obj;
		else
		   return false;
		   
	    return(this.number==eObject.number);
	}

	public void setStartDate(Date startDate){
		this.startDate=startDate;
	}
	public Date getStartDate(){
		return startDate;
	}	
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getSurname()
	{
		return surname;
	}
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}	
	//need to set number if so we dont have dublicate numbers
	public static void setNumber(int number) 
	{
		nextNumber = number +1;
	}
	
	
	public double calculateWage(double taxPercentage) {
		// calculate and return the wage as salary/12 less taxPercentage
		double wage=salary/12;
		wage -= (wage * (taxPercentage/100));
		return wage;
	}

	public double incrementSalary(double incrementAmount) {
		// add incrementAmount to, and return the new salary
		// salary should not go over a maximum salary of €150,000
		salary += incrementAmount;
		
		if(salary > MAX_SALARY)
			salary = MAX_SALARY;
		
		return salary;
	}

	    public void setTitle(String setTitleTo){
		   title=setTitleTo;
		}
		public void setFirstName(String setFirstNameTo){
		   firstName=setFirstNameTo;
		}
		public void setSurname(String setSurnameTo){
		   surname=setSurnameTo;
		}
}
