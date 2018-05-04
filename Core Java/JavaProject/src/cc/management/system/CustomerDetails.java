package cc.management.system;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import dao.CreateConnection;
import resourses.myQueries;

public class CustomerDetails extends CreateConnection {
	
	public void getCustomerDetails() throws SQLException {

		createConnection();
		Scanner scan = new Scanner(System.in);		
		System.out.println("enter SSN of customer");		
		int ssn = scan.nextInt();		
		st = con.prepareStatement(myQueries.getCustomerDetails);		
        st.setInt(1, ssn);          
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            // retrieve by column value
           String firstName = rs.getString(1);
	       String lastName = rs.getString(3);
	       String ccNumber = rs.getString(5);
	       String city = rs.getString(8);
	       String email = rs.getString(13);
	       
	       
	       // display Value
           System.out.println("Customer full name " + firstName + " " + lastName);
           System.out.println("Account number: "  + ccNumber);
           System.out.println("City "  + city);
           System.out.println("Email: " + email);
        }  
        scan.close();
        closeallconnection(); 
	}
    
	public void modifyAccountDetails() throws SQLException {
		
		  createConnection();
		  Scanner scan = new Scanner(System.in);
		  
		  System.out.println("Pleast enter customer Credit Card Number:");		
		  String ccNumber = scan.next();
		  
		  System.out.println("What information would you like to update?");	
		  System.out.println("Please enter 1 for First name");
		  System.out.println("Please enter 2 for Last name");
		  System.out.println("Please enter 3 for Email");
		  
		  String columnName = "";
		  int input = scan.nextInt();
		  String query = "";
		  if (input == 1) {
			  query = myQueries.modifyFirstName;
			  columnName = "First name";
			}else if (input == 2) {
				query = myQueries.modifylastName;
				columnName = "Last name";
		    }else if (input == 3) {
		    	query = myQueries.modifyEmail;
		    	columnName = "Email";
		    }else { System.out.println("Wrong input");	}
		  
		  
		  System.out.println("Pleast enter updated " + columnName );		
		  String newValue = scan.next();
		  
		  // Statement cst = con.createStatement();
		  st = con.prepareStatement(query);
		  st.setString(1, newValue);
		  st.setString(2, ccNumber); 

	      
		  
	      st.executeUpdate();
	      System.out.println("Information has been seccesfully updated!");
	      
	      st = con.prepareStatement("select * from cdw_sapp_customer where CREDIT_CARD_NO = " + ccNumber);
	      ResultSet rs = st.executeQuery();
	      
	      rs.next();
	      String firstName = rs.getString(1);
	      String lastName = rs.getString(3);
	      String email = rs.getString(13);
	       
	      System.out.println("Customer full name " + firstName + " " + lastName);
          System.out.println("Account number: "  + ccNumber);
          System.out.println("Email: " + email);
	      
	      scan.close();
	      closeallconnection(); 
	}
	
	public void generateMonthlyBill() throws SQLException {
		createConnection();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Pleast enter customer Credit Card Number:");		
		String ccNumber = scan.next();
		
		System.out.println("enter month in 'mm' format");		
		int month = scan.nextInt();
		
		System.out.println("enter year in 'yyyy' format");		
		int year = scan.nextInt();
		
		st = con.prepareStatement(myQueries.generateMonthlyBill);
		
        st.setString(1, ccNumber);
        st.setInt(3, month);
        st.setInt(2, year);
        
        System.out.println("Your monthly bll for " + month + "/" + year + " is: ");
        
        ResultSet rs = st.executeQuery();
        rs.next();               
        double  monthlyBill= rs.getDouble(3);  
           
	       // display Value
         System.out.println(monthlyBill);
       
        scan.close();
        closeallconnection(); 
	}

	public void getTransactionByDates() throws SQLException, ParseException  {
		
		createConnection();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter SSN of a customer");		
		int ssn = scan.nextInt();
		
		System.out.println("Enter Beginning date in 'yyyy-[m]m-[d]d' format");		
		String b_date = scan.next();
		
		System.out.println("Enter End date in 'yyyy-[m]m-[d]d' format");		
		String e_date = scan.next();
		
		st = con.prepareStatement(myQueries.getTransactionByDates);	
		st.setDate(1, java.sql.Date.valueOf(b_date));
		st.setDate(2, java.sql.Date.valueOf(e_date));
        st.setInt(3, ssn);        
  
        ResultSet rs = st.executeQuery();
        System.out.println("Please see all transactions below");
        
        while(rs.next()) {
            // retrieve by column value
           String transaction_date = rs.getString(3);
           Double transaction_value = rs.getDouble(2);
           String firstName = rs.getString(4);
	       String lastName = rs.getString(5);
	       
	  	       
	       // display Value
           System.out.println("Customer full name " + firstName + " " + lastName);
           System.out.println("Transaction date: "  + transaction_date);
           System.out.println("Transaction amount "  + transaction_value);
        }  
        scan.close();
        closeallconnection(); 
	}

}

