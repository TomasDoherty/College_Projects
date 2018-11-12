 package ie.lyit.serialize;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ie.lyit.Tester.EmployeeSerializerTester;
import ie.lyit.flight.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class EmployeeSerializer {
 
//creating arraylist for employees
	private ArrayList<Employee> employees;
	
	//creating file for storing employees
	private final String FILENAME = "employees.ser";
	//File f = new File("C:/Users/Tomas/Desktop/Assignment/TomasDoherty_Assignment/employees.ser");
	
	//default constructor
	public EmployeeSerializer()
	{
		employees = new ArrayList<Employee>();
	}
	
	//adding employee
	public void add(Employee e)
	{
		employees.add(e);
	}
	//viewing employee
	public void view()
	{
		boolean found=false;
		if(employees.isEmpty())//if employee arraylist is empty show an error message
		{
			JOptionPane.showMessageDialog(null, "There are no Employees!","System Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			 String numberAsString = JOptionPane.showInputDialog(null, "Enter Employee Number");//input as a string
	         //convert the String to an Integer
	         int empNum = Integer.parseInt(numberAsString);//converting input to int
		for(Employee e : employees)//iterate through employee arraylist
		{
			if(e.getNumber()==empNum)//seeing if employee number is valid, if so display details
			{
				//if found display details and exit for loop
				DisplayEmployeeDetails(empNum);
				found=true;//breaks out of for loop
				break;
			}		
		}
		//if employee does not exist
		if(found!=true)
			JOptionPane.showMessageDialog(null, "Employee Does Not Exist!","System Error", JOptionPane.ERROR_MESSAGE);
	  }
	}
	//lists employees
	public void list()
	{
	  listEmployees();
	}
	
	//edit employees
	public void edit()
	{
		if(employees.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "There are no Employees!","System Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
		 String numberAsString = JOptionPane.showInputDialog(null, "Enter Employee Number");
         //convert the String to an Integer
         int empNum = Integer.parseInt(numberAsString);
         editEmployee(empNum);
		}
	}
	//delete employee
	public void delete()
	{
		boolean found=false;
		//if there are no employees we cant delete them
		if(employees.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "There are no Employees!","System Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
		String numberAsString = JOptionPane.showInputDialog(null, "Enter Employee Number");
        //convert the String to an Integer
        int empNum = Integer.parseInt(numberAsString);
		for(Employee e : employees)
		{
			if(e.getNumber()==empNum)
			{
				employees.remove(e);
				JOptionPane.showMessageDialog(null,"Employee Removed!");
				found=true;
			    break;
			}
		}
		//if employee does not exist
				if(found!=true)
					JOptionPane.showMessageDialog(null, "Employee Does Not Exist!","System Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	//serialize employees
	public void serializeEmployees(){
		try {
			// Serialize the ArrayList..
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
				
			os.writeObject(employees);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store Employees.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
	}
	
	// This method will deserialize the employees ArrayList when called, 
	// i.e. it will restore the ArrayList from the file employees.ser
	public void deserializeEmployees(){
		try {
			
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		 
			ObjectInputStream is = new ObjectInputStream(fileStream);
			
			
			employees = (ArrayList<Employee>)is.readObject();	
			int index=employees.size()-1;
			int num = employees.get(index).getNumber();
			Employee.setNumber(num);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store Employees.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//created method to display employee details
	public void DisplayEmployeeDetails(int empNum)
	{
		//frame created to display details
		  JFrame frame = new JFrame();
		   frame.setTitle("FAB Flights");		
		   frame.setSize(320, 320);
		   frame.setLocationRelativeTo(null); // Center the frame
		   frame.setResizable(false);
		   frame.setVisible(true);
		   
		   //initilise variables and set to null
		   Name dname = null;
		   Date ddateofb = null; 
		   double dsalary=0;
	    
		   //for loop to get employee details
		   for(Employee e : employees)
		    {
			  if(e.getNumber()==empNum) 
			  {
				   dname=e.getName();//sets name to name matching employee num
			       ddateofb = e.getDateOfBirth();//sets date to date matching employee num
			       dsalary=e.getSalary();//sets salary to salary matching employee num
			  }
		    }
		   
	      //p1
		JPanel p1 = new JPanel();
		
		//jcomponents
		JLabel name, dateofb, salary, frametitle;
		JTextField nameIn, dateofbIn, salaryIn;
		
		//convertions
		String dateconverted = String.valueOf(ddateofb);//date object to string
		String salToString = String.valueOf(dsalary);//salary to string
		String nameToString = String.valueOf(dname);//name object to string
		
	//jlabels
		name=new JLabel("Name");
		dateofb=new JLabel("DOB");
		salary=new JLabel("Salary");
		
	//jtextfields
		nameIn=new JTextField(nameToString);//sets textfield text to name object that we converted to string
		nameIn.setEditable(false);//cannot edit this textfield
		dateofbIn=new JTextField(dateconverted);//sets textfield to date object converted to string
		dateofbIn.setEditable(false);//cannot edit this textfield
		salaryIn=new JTextField(salToString);//sets this textfield to salary as a string as jtexfield cannot take a double
		salaryIn.setEditable(false);//cannot edit this textfield
		
		frametitle = new JLabel("Employee -"+empNum);//creating title as a jlabel
	    frametitle.setFont(new Font("Serif", Font.BOLD, 30));
		
		//set layout to null
		//p1.setLayout(new GridLayout(5, 1))
		p1.setLayout(null);
		
		//setting positions using bounds to my own personal liking
		name.setBounds(70, 80, 140, 35);
		dateofb.setBounds(70, 130, 140, 35);
		salary.setBounds(70, 180, 140, 35);
		
		nameIn.setBounds(140, 85, 140, 25);
		dateofbIn.setBounds(140, 135, 140, 25);
		salaryIn.setBounds(140, 185, 140, 25);
		
		nameIn.setFont(new Font("Serif", Font.BOLD, 15));
		dateofbIn.setFont(new Font("Serif", Font.BOLD, 15));
		salaryIn.setFont(new Font("Serif", Font.BOLD, 15));
		
     	frametitle.setBounds(40, 5, 220, 80);
	
		//add components to panel
		p1.add(name);
		p1.add(dateofb);
		p1.add(salary);
		p1.add(frametitle);
		p1.add(nameIn);
		p1.add(dateofbIn);
		p1.add(salaryIn);
	  
		//add line border to p1
		p1.setBorder(new LineBorder(Color.BLACK, 2));
	
		frame.add(p1, null);//sets p1 to null as i am arranging them using the setbounds method
	}
	public void listEmployees()
	{
		//frame created to display details
		  JFrame frame = new JFrame();
		   frame.setTitle("FAB Flights");		
		   frame.setSize(500, 120);
		   frame.setLocationRelativeTo(null); // Center the frame
		   frame.setResizable(false);
		   frame.setVisible(true);
		   
		   //creating panels
		   JPanel p1 = new JPanel();
		   JPanel p2 = new JPanel();
		  
		   //jcomponents
		  JLabel title;
		  JComboBox j = new JComboBox();
		  
		  //checks if employee arraylist is empty
		  if(employees.isEmpty())
			 j.addItem("No Employees");//displays no employees in dropdown box
		  else
		  {
		  for(Employee ep : employees)
		  {
			  j.addItem(ep.getNumber()+" - "+ep.getName().toString());//displays employee num and name
		  }
		  }
		  title = new JLabel("List of Employees");//creates title as a label
		  title.setFont(new Font("Serif", Font.BOLD, 30));
			
		  
		  //add title
		  p1.add(title);
		  p1.add(p2);
		  p2.add(j);
		  
		  
		
		   frame.add(p1, BorderLayout.NORTH);//sets title at top of page
		   frame.add(p2, BorderLayout.PAGE_END);//sets combobox directly under it
	}
	
	public void editEmployee(int empNum)
	{
		//creating window to enter employee details
		   JFrame frame = new JFrame();
		   frame.setTitle("FAB Flights");		
		   frame.setSize(350, 425);
		   frame.setLocationRelativeTo(null); // Center the frame
		   frame.setResizable(false);
		   frame.setVisible(true);
		   
		   
		   //jpanel
		   JPanel p1 = new JPanel();
		   
		   //add line border to p1
		   p1.setBorder(new LineBorder(Color.BLACK, 2));
		   
		   //JLabel
		   JLabel titl, fname, sname, date, sal, title;
		   
		   //JTextField
		   JTextField titleIn, fnameIn, snameIn, dd, mm, yyyy, sIn;
		   
		   //JButton
		   JButton sc = new JButton("Save Changes");
		   JButton cancel = new JButton("Cancel");
		   
		   title = new JLabel("Edit Employee");
		   title.setFont(new Font("Serif", Font.BOLD, 30));
		   
		   //creating jlabels
		   titl=new JLabel("Title");
		   fname=new JLabel("First Name");
		   sname=new JLabel("Surname");
		   date=new JLabel("DOB");
		   sal=new JLabel("Salary");
		   
		   //creating jtextfields
		   titleIn=new JTextField();
		   fnameIn=new JTextField();
		   snameIn=new JTextField();
		   dd=new JTextField();
		   mm=new JTextField();
		   yyyy=new JTextField();
		   sIn=new JTextField();
		   
		   //iterates through employees setting the textfields of the employee that match the employee number
		   //the user wants so that the user can edit these details
		   for(Employee emp : employees)
		   {
			   if(emp.getNumber()==empNum)
			   {
			   
			   titleIn.setText(emp.getName().getTitle());
			   fnameIn.setText(emp.getName().getFirstName());
			   snameIn.setText(emp.getName().getSurname());
			   dd.setText(String.valueOf(emp.getDateOfBirth().getDay()));
			   mm.setText(String.valueOf(emp.getDateOfBirth().getMonth()));
			   yyyy.setText(String.valueOf(emp.getDateOfBirth().getYear()));
			   sIn.setText(String.valueOf(emp.getSalary()));
			   }
		   }
		     //set position of title
		     title.setBounds(60, 5, 220, 80);
		    
		    
		   //add components
		   p1.add(title);
		   
		   
		   p1.add(titl);
		   p1.add(fname);
		   p1.add(sname);
		   p1.add(date);
		   p1.add(sal);
		   p1.add(titleIn);
		   p1.add(fnameIn);
		   p1.add(snameIn);
		   p1.add(dd);
		   p1.add(mm);
		   p1.add(yyyy);
		   p1.add(sIn);
		   p1.add(sc);
		   p1.add(cancel);
		   
		   p1.setLayout(null);
		   
		   titleIn.setFont(new Font("Serif", Font.BOLD, 15));
		   fnameIn.setFont(new Font("Serif", Font.BOLD, 15));
		   snameIn.setFont(new Font("Serif", Font.BOLD, 15));
		   dd.setFont(new Font("Serif", Font.BOLD, 15));
		   mm.setFont(new Font("Serif", Font.BOLD, 15));
		   yyyy.setFont(new Font("Serif", Font.BOLD, 15));
		   sIn.setFont(new Font("Serif", Font.BOLD, 15));
		   
		   
		 //sets positions manually
			titl.setBounds(60, 80, 140, 20);
			fname.setBounds(60, 130, 140, 20);
			sname.setBounds(60, 180, 140, 20);
			
			date.setBounds(60, 230, 140, 35);
			sal.setBounds(60, 280, 140, 35);
			
			titleIn.setBounds(128, 80, 140, 25);
			fnameIn.setBounds(128, 130, 140, 25);
			snameIn.setBounds(128, 180, 140, 25);
			dd.setBounds(128, 230, 45, 25);
		    mm.setBounds(178, 230, 45, 25);
			yyyy.setBounds(228, 230, 48, 25);
			sIn.setBounds(130, 280, 140, 25);
			
			sc.setBounds(40, 330, 120, 25);
			cancel.setBounds(170, 330, 120, 25);
		   
		//add line border to p1
		p1.setBorder(new LineBorder(Color.BLACK, 2));
		
		 //action listener for when save changes button is clicked
	     sc.addActionListener(e -> {
	    	 //when the user clicks save changes this sets the employees details permanently
	    	 for(Employee ep : employees)
	    	 {
	    		 if(ep.getNumber()==empNum)
	    		 {
	    		 String newtitle = titleIn.getText();
	    		 String newfname = fnameIn.getText();
	    		 String newsname = snameIn.getText();
	    		 int newday = Integer.parseInt(dd.getText());
	    		 int newmonth = Integer.parseInt(mm.getText());
	    		 int newyear = Integer.parseInt(yyyy.getText());
	    		 ep.setName(new Name(newtitle, newfname, newsname));
	    		 ep.setDateOfBirth(new Date(newday, newmonth, newyear));
	    	    
	    		 }
	    	 }
	    	 //info window if employee save was successful
	    	 JOptionPane.showMessageDialog(null, "Employee Successfully Edited");
	    	 
	    	});
	
		frame.add(p1, null);
	}
	

}
