package com.demo.main;

import java.awt.SystemTray;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDB {
	
	private static Scanner scan = new Scanner(System.in); //Scanner
	
	private static Connection con;
	private static Statement st;
	private static PreparedStatement ps;//For input from user
	private static ResultSet rs;
	private static ResultSetMetaData rsmd;
	
	public TestDB() { //Constructor
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Loading of the driver class
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tryout?serverTimezone=UTC", "root", "Mercedes9987");
		    //Getting the connection. Autocommit is true for jdbc
			
			if(con != null)
		{
			System.out.println("Connected");
//			st = con.createStatement();
//			ResultSet rs = st.executeQuery("select * from employee"); //To select all the details of employee table
//			ResultSetMetaData rsmd = rs.getMetaData(); //To get the metadata of the Result Set
//			int count = rsmd.getColumnCount(); //To get the column count of our table
//			while(rs.next()) //To check if we have data in our database 
//			{
////				System.out.println("ID: "+rs.getInt(1));
////				System.out.println("Name: "+rs.getString(2));
////				System.out.println("Age: "+rs.getInt(3));
////				System.out.println("Salary: "+rs.getDouble(4));
////				System.out.println("Zipcode: "+rs.getString(5));
//				
////				for(int i=1; i<=count; i++)
////				{
////					System.out.println(rs.getString(i)); //Best way to get the output instead of inputing the entries
////				}
//				System.out.println();
//			}
			
			//Insert
//			System.out.println("Inserting into table");
//		    String sql = "INSERT INTO employee (name, age, salary, zipcode) VALUES ('BINGO', 87, 99954, '99332')";
//	        st.executeUpdate(sql); 
			
			//Insert with user input (Prepared Statement)
//			Scanner scan = new Scanner(System.in);
//			System.out.println("Enter the id to be inserted");
//			int Id = scan.nextInt();
//			scan.nextLine();
//			
//			System.out.println("Enter the name to be inserted");
//			String Name = scan.nextLine();
//			
//			System.out.println("Enter the age to be inserted");
//			int Age = scan.nextInt();
//			scan.nextLine();
//			
//			System.out.println("Enter the salary to be inserted");
//			Double Salary = scan.nextDouble();
//			scan.nextLine();
//			
//			System.out.println("Enter the zipcode to be inserted");
//			String Zip = scan.nextLine();
//			
//			String sql = "INSERT INTO employee (id, name, age, salary, zipcode) VALUES (?, ?, ?, ?, ?)";
//			ps = con.prepareStatement(sql); //PreparedStatement
//			
//			ps.setInt(1, Id);
//			ps.setString(2, Name);
//			ps.setInt(3, Age);
//			ps.setDouble(4, Salary);
//			ps.setString(5, Zip);
//			
//			ps.executeUpdate();
//			System.out.println("INSERTED");
			
			//Delete
//			System.out.println("Deleting from table");
//		    String sql = "DELETE FROM employee WHERE id = 3";
//	        st.executeUpdate(sql); 
			
//			Update
//			System.out.println("Updating the table");
//		    String sql = "UPDATE employee SET age=99 WHERE id = 4";
//	        st.executeUpdate(sql); 
			
			
		}
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new TestDB(); //Anonymous Object creation 
      
      boolean quit = false;
      int choice;
      printinstructions();
      
      while(!quit)
      {
          System.out.println("Enter your choice");
          choice = scan.nextInt();
          scan.nextLine();
          
          switch(choice)
          {
          case 0:
        	  alldata();
        	  break;
        	  
          case 1:
        	  insertdata();
        	  break;
        	  
          case 2:
        	  updatedata();
        	  break;
        	  
          case 3:
        	  deletedata();
        	  break;
        	  
          case 4:
        	  searchdata();
        	  break;
        	  
          case 5:
        	  printinstructions();
        	  break;
        	  
          case 6:
        	  quit = true;
        	  break;
        	  
//          default:
//        		  break;
          }
      }
	}
	
	//instructions
	private static void printinstructions()
    {
        System.out.println("0 - To print all (select *)");
        System.out.println("1 - To insert data into database");
        System.out.println("2 - To update a record in database");
        System.out.println("3 - To remove a record from database");
        System.out.println("4 - To search a record from database");
        System.out.println("5 - To print instructions");
        System.out.println("6 - Quit");
    }
	
	//print all the data from table
	private static void alldata()
	{
	    try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM employee");
			rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			
			while(rs.next())
			{
				for(int i=1; i<count; i++)
				{
					System.out.println(rs.getString(i));
				}
				System.out.println();
				
			}
		} 
	    catch (Exception e) 
	    {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	    
	}
	
	//insert into database
	private static void insertdata() 
	{
		try {
			//System.out.println("Enter the id to be inserted");
			//int Id = scan.nextInt();
			//scan.nextLine();
			
			System.out.println("Enter the name to be inserted");
			String Name = scan.nextLine();
			
			System.out.println("Enter the age to be inserted");
			int Age = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Enter the salary to be inserted");
			Double Salary = scan.nextDouble();
			scan.nextLine();
			
			System.out.println("Enter the zipcode to be inserted");
			String Zip = scan.nextLine();
			
			String sql = "INSERT INTO employee (name, age, salary, zipcode) VALUES (?, ?, ?, ?)";
			ps = con.prepareStatement(sql); //PreparedStatement
			
			//ps.setInt(1, Id);
			ps.setString(1, Name);
			ps.setInt(2, Age);
			ps.setDouble(3, Salary);
			ps.setString(4, Zip);
			
			ps.executeUpdate();
			System.out.println("INSERTED");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
	
	//update any data 
	private static void updatedata()
	{
		try 
		{
			int pick = 0;
			System.out.println("Pick any one of the data that you want to updated (You must know the ID)");
			System.out.println("1. Name");
			System.out.println("2. Age");
			System.out.println("3. Salary");
			System.out.println("4. Zip");
			pick = scan.nextInt();
			scan.nextLine();
			
			switch (pick) {
			case 1:
				System.out.println("Enter the new name which will be updated with the old name");
				String Name = scan.nextLine();
				
				System.out.println("Enter the id whose name will be updated");
				int Id1 = scan.nextInt();
				scan.nextLine();
				
				String sql1 = "UPDATE employee SET name= ? WHERE id= ?";
				
				ps = con.prepareStatement(sql1);
				ps.setString(1, Name);
				ps.setInt(2, Id1);
				
				ps.executeUpdate();
				System.out.println("NAME UPDATED");
				
				break;
				
			case 2:
				System.out.println("Enter the new age which will be updated with the old age");
				int Age = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter the id whose age will be updated");
				int Id2 = scan.nextInt();
				scan.nextLine();
				
				String sql2 = "UPDATE employee SET age= ? WHERE id= ?";
				
				ps = con.prepareStatement(sql2);
				ps.setInt(1, Age);
				ps.setInt(2, Id2);
				
				ps.executeUpdate();
				System.out.println("AGE UPDATED");
				
				break;
				
			case 3:
				System.out.println("Enter the new salary which will be updated with the old salary");
				double Salary = scan.nextDouble();
				scan.nextLine();
				
				System.out.println("Enter the id whose salary will be updated");
				int Id3 = scan.nextInt();
				scan.nextLine();
				
				String sql3 = "UPDATE employee SET salary= ? WHERE id= ?";
				
				ps = con.prepareStatement(sql3);
				ps.setDouble(1, Salary);
				ps.setInt(2, Id3);
				
				ps.executeUpdate();
				System.out.println("SALARY UPDATED");
				
				break;
				
			case 4:
				System.out.println("Enter the new zip which will be updated with the old zip");
				String Zip = scan.nextLine();
				//scan.nextLine();
				
				System.out.println("Enter the id whose zip will be updated");
				int Id4 = scan.nextInt();
				scan.nextLine();
				
				String sql4 = "UPDATE employee SET zipcode= ? WHERE id= ?";
				
				ps = con.prepareStatement(sql4);
				ps.setString(1, Zip);
				ps.setInt(2, Id4);
				
				ps.executeUpdate();
				System.out.println("ZIP UPDATED");
				
				break;

			default:
				break;
			}
//			System.out.println("Enter the new name which will be updated with the old name");
//			String Name = scan.nextLine();
//			
//			System.out.println("Enter the id whose name will be updated");
//			int Id = scan.nextInt();
//			
//			String sql = "UPDATE employee SET name= ? WHERE id= ?";
//			
//			ps = con.prepareStatement(sql);
//			ps.setString(1, Name);
//			ps.setInt(2, Id);
//			
//			ps.executeUpdate();
//			System.out.println("UPDATED");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//delete an entry from database
	private static void deletedata()
	{
		try 
		{
		System.out.println("Enter the id to be deleted");
		int Id = scan.nextInt();
		
		String sql = "DELETE FROM employee WHERE id= ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, Id);
		ps.executeUpdate();
		System.out.println("DELETED");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			// TODO: handle exception
		}
	}
	
	//search 
	private static void searchdata()
	{
		try
		{
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			
			System.out.println("Enter a name to be searched");
			Object search = scan.next();
			
			while(rs.next())
			{
				for(int i=1; i<=count; i++)
				{
					if(search.equals(rs.getObject(i)))
					{
						System.out.println("Found "+search);
					}
				}
				//System.out.println();
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
