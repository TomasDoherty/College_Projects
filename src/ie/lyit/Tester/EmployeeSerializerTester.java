package ie.lyit.Tester;
import ie.lyit.flight.*;
import ie.lyit.flight.Date;
import ie.lyit.serialize.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class EmployeeSerializerTester extends JFrame{
       
	   //variables
	   private JPanel p1;
	   private JButton create, view, list, edit, delete, save;
	   private JLabel title;
	   int largestNum=0;
	   //create employee serializer object
	   EmployeeSerializer employee = new EmployeeSerializer();
	   
		private ArrayList<Employee> employees;
	
	 
	   public EmployeeSerializerTester()
	   {
	      
	      //creating panels
	      JPanel p1 = new JPanel();
	      
	    
	      employee.deserializeEmployees();//deserialises employees as soon as program runs
	  
	     
	      
	      //initializing components
	      create = new JButton("Create (ADD)");
          view = new JButton("View");
	      list = new JButton("List");
	      edit = new JButton("Edit");
	      delete = new JButton("Delete");
	      save = new JButton("Save");
	      
	      title = new JLabel("FAB FLIGHTS");
	      title.setFont(new Font("Serif", Font.BOLD, 30));
	      
	     
	    
	      
	        
	     p1.setLayout(null);//sets layout null as i assign it myself
	      
	      //create button and
	     create.setBounds(70, 80, 140, 35);
	     create.setBackground(Color.WHITE);
	     
	     //view button
	     view.setBounds(70, 160, 140, 35);
	     view.setBackground(Color.WHITE);
	     
	     //list button
	     list.setBounds(70, 240, 140, 35);
	     list.setBackground(Color.WHITE);
	     
	     //edit button
	     edit.setBounds(70, 320, 140, 35);
	     edit.setBackground(Color.WHITE);
	     
	     //delete button
	     delete.setBounds(70, 400, 140, 35);
	     delete.setBackground(Color.WHITE);
	     
	     save.setBounds(70, 480, 140, 35);
	     save.setBackground(Color.WHITE);
	     
	    
	     //title
	     title.setBounds(40, 5, 220, 80);
	     //adds components to p1
	     p1.add(create);
	     p1.add(view);
	     p1.add(list);
	     p1.add(edit);
	     p1.add(delete);
	     p1.add(save);
	     p1.add(title);
	    
	     
	     //set layout to null
	     add(p1, null);
	     
	     //set line border
	     p1.setBorder(new LineBorder(Color.BLACK, 2));
	     
	     //action listener for when create button is clicked
	     create.addActionListener(e -> {
	   
	    	 createEmployee();
	    	
	    	});
	     
	     //action listener for when view button is clicked
	     view.addActionListener(e -> {
		  	            employee.view();	
	    	});
	     
	     //action listener for when list button is clicked
	     list.addActionListener(e -> {
			       employee.list();
	    	});
	     
	     //action listener for when edit button is clicked
	     edit.addActionListener(e -> {
	            employee.edit();
	    
	    	});
	     
	     //action listener for when delete button is clicked
	     delete.addActionListener(e -> {
	    	    employee.delete();
	    	});
	     
	     //action listener for when save button is clicked
	     save.addActionListener(e -> {
	    	 
	    	 employee.serializeEmployees();
	    	 JOptionPane.showMessageDialog(null, "Saved Successfully");
  
	    	});
	     
	   }
	  
	   // Main method
	   public static void main(String[] args){
	      EmployeeSerializerTester frame = new EmployeeSerializerTester();
	      frame.setTitle("FAB Flights");		
	      frame.setSize(310, 580);
	      frame.setLocationRelativeTo(null); // Center the frame
	      frame.setResizable(false);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	   }
	   
	   //method that creates employee
	   public Employee createEmployee()
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
		   JButton add = new JButton("Add");
		   JButton cancel = new JButton("Cancel");
		   
		   title = new JLabel("Create Employee");
		   title.setFont(new Font("Serif", Font.BOLD, 30));
		   
		   //set position of title
		   title.setBounds(60, 5, 220, 80);
		    
		   //add title
		   p1.add(title);
		   
		   //jlabels
		   titl=new JLabel("Title");
		   fname=new JLabel("First Name");
		   sname=new JLabel("Surname");
		   date=new JLabel("DOB");
		   sal=new JLabel("Salary");
		   
		   //jtextfields
		   titleIn=new JTextField();
		   fnameIn=new JTextField();
		   snameIn=new JTextField();
		   dd=new JTextField();
		   mm=new JTextField();
		   yyyy=new JTextField();
		   sIn=new JTextField();
		   
		   //adds components to p1
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
		   p1.add(add);
		   p1.add(cancel);
		   
		   p1.setLayout(null);//sets layout to null as i assign components manually
		   
		   titleIn.setFont(new Font("Serif", Font.BOLD, 15));
		   fnameIn.setFont(new Font("Serif", Font.BOLD, 15));
		   snameIn.setFont(new Font("Serif", Font.BOLD, 15));
		   dd.setFont(new Font("Serif", Font.BOLD, 15));
		   mm.setFont(new Font("Serif", Font.BOLD, 15));
		   yyyy.setFont(new Font("Serif", Font.BOLD, 15));
		   sIn.setFont(new Font("Serif", Font.BOLD, 15));
		   
		   
		 //sets positions of components
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
			
			add.setBounds(40, 330, 120, 25);
			cancel.setBounds(170, 330, 120, 25);
		   
			//creating employee object
			Employee emp= new Employee();
		
			 //action listener for when add button is clicked
		     add.addActionListener(e -> {
		    	 
		    	 //creating name object from jtextfields
		    	 Name n = new Name(titleIn.getText().toString(), fnameIn.getText().toString(), snameIn.getText().toString());
		    	 //converting salary to double from jtextfields
		    	 double salary = Double.parseDouble(sIn.getText());
		    	 //creating int variables from day, month, year reading them from jtextfield
		    	 int day = Integer.parseInt(dd.getText());
     			 int month = Integer.parseInt(mm.getText());
				 int year = Integer.parseInt(yyyy.getText());
					
				 //assign date object the 3 variables i just created
			     Date d = new Date(day, month, year);
		    	 
			    
			     // sets employees details
		    	   emp.setName(n);
				   emp.setDateOfBirth(d);
				   emp.setSalary(salary);
				   //adds employee to arraylist
		    	   employee.add(emp);
				 //pops up message dialog box if employee successfully added
			    	 JOptionPane.showMessageDialog(null, "Employee Successfully Added");
		    	});
		     
		   //action listener for when cancel button is clicked
		   //if user clicks cancel all details are set to null or blank
		     cancel.addActionListener(e -> {
		    	   titleIn.setText("");
		    	   fnameIn.setText("");
		    	   snameIn.setText("");
				   emp.setDateOfBirth(null);
				   dd.setText("");
				   mm.setText("");
				   yyyy.setText("");
				   emp.setSalary(0);
				   sIn.setText("");
		    	});
		   
	
			frame.add(p1, null);
		   
			return emp; //returns employee object thats we created as method needs a return type
		   
	   }
}
