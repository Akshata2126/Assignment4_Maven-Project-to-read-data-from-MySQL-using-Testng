package com.mycompany.app;

import org.testng.annotations.Test;

import java.sql.Connection;

import org.testng.annotations.BeforeMethod;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterMethod;

public class App {


	private Connection conn = null;
	private   Statement st;
	
	 @BeforeMethod
	  public void beforeMethod() 
	  {
	  try
	 {
	// create our mysql database connection
    String myUrl = "jdbc:mysql://localhost/test";
    //provide userid and password for the database
    conn = DriverManager.getConnection(myUrl, "root", "Alwayshappy@21");
	 }
	 catch (Exception e) {
		// TODO: handle exception
	}
	 }
	 
  @Test(priority=2)
  public void insert_Data() {
	  try
	  {
		//create statement object 
	   st = conn.createStatement();
	   //SQL insert query for Employee_Details Table
	   String insert_query= "insert into test.Employee_Details(Emp_ID, Emp_name , Emp_City,Project_ID)"+ " values (1010,'karan','Mumbai', 'PROJ02');";
       //execute insert query and update in database
	   st.executeUpdate(insert_query);
       System.out.println("Row inserted in Employee_Details Table ");
       String query = "SELECT * FROM test.Employee_Details;";
      //contains result of database query
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java ResultSet
      while (rs.next())
      {
    	int Emp_ID=rs.getInt("Emp_ID");
    	String Emp_name=rs.getString("Emp_name");
    	String Emp_City=rs.getString("Emp_City");
    	String Project_ID=rs.getString("Project_ID");
    	//Display the data stored in ResultSet on console
        System.out.format("%s, %s, %s, %s\n", Emp_ID, Emp_name, Emp_City, Project_ID);
      } 
	  
  }
	  catch (Exception e) {
		// TODO: handle exception
	}
  }
  
	  @Test(priority=1)
	  public void print() {    	
		  try
		  {
		 //create statement object 
		  st = conn.createStatement();
		  //SQL insert query for Project_Details Table
		  String insert_query= "insert into test.Project_Details(Project_ID, Project_Name , Domain)"+ " values ('Proj05','BT','Support');";
	      st.executeUpdate(insert_query);
	      System.out.println("Row inserted in Project_Details Table ");
	      //SQL SELECT query. 
	      String pro_query = "SELECT * FROM test.Project_Details;";
	      //contains result of database query
	      ResultSet rs = st.executeQuery(pro_query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	    	String Project_ID=rs.getString("Project_ID");
	    	String Project_Name=rs.getString("Project_Name");
	    	String Domain=rs.getString("Domain");
	    	//Display the data stored in ResultSet on console 
	    	System.out.format("%s, %s, %s\n", Project_ID, Project_Name, Domain);
	      } 
		  
	  }
		  catch (Exception e) {
				// TODO: handle exception
			}
	  }

  @AfterMethod
  public void afterMethod() throws SQLException {
	  st.close();
  }

}
