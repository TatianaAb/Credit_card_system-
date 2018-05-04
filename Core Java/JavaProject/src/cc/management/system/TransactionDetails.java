package cc.management.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.CreateConnection;
import dao.TransactionDao;
import resourses.myQueries;

public class TransactionDetails extends CreateConnection {	
	
	public void getTransactionsByZipcode() throws SQLException {
		
		Scanner scan = new Scanner(System.in);		
		System.out.println("enter zipcode");		
		int zipcode = scan.nextInt();
		
		System.out.println("enter month in 'mm' format");		
		int month = scan.nextInt();
		
		System.out.println("enter year in 'yyyy' format");		
		int year = scan.nextInt();
		
		// stretch goal - Separate connection transaction to separate pacage/classes 
		// TransactionDao tdao = new TransactionDao();
		// ArrayList<String> a = tdao.getTransactionsByZipcodeDao(zipcode, month, year);
		
		createConnection();
	    st = con.prepareStatement(myQueries.getByZipcode);			
		st.setInt(1, zipcode);
		st.setInt(2, month);
		st.setInt(3, year);        
		
		ResultSet rs = st.executeQuery();
		    
		while(rs.next()) {
		   // retrieve by column value
		   int TRANSACTION_ID = rs.getInt(2);
	       int BRANCH_CODE = rs.getInt(7);
		   String mon = rs.getString(4);	   
		   String yr = rs.getString(5);
		   String date = mon + "/" + yr;		       
		   double TRANSACTION_VALUE = rs.getDouble(9);
		   
	       // display Value
        System.out.println("BRANCH CODE " + BRANCH_CODE);
        System.out.println("Transaction date: "  + date);
        System.out.println("TRANSACTION ID: "  + TRANSACTION_ID);
        System.out.println("Transaction amount: " + TRANSACTION_VALUE);
		}
		
        scan.close();
        closeallconnection();
	}

	public void getTransactionTotalByType()   {
		
		createConnection();
		try {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		  
		  System.out.println("Enter Transaction type:");		
		  String type = scan.next();
		  
		  
		  st = con.prepareStatement(myQueries.getTotalByType);			
	      st.setString(1, type);	      
	      ResultSet rs = st.executeQuery();
		  
	      while(rs.next()) {
	            // retrieve by column value
	           int number_of_transactions = rs.getInt(1);
		       double total = rs.getDouble(2);
 							    
		       // display Value
	           System.out.println("Number of transactions: " + number_of_transactions);
	           System.out.println("Total amount of transactions: "  + total);
	      }   
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.println("data not found");
		}
		 finally {
			 closeallconnection(); 
		}
		 		 
	      
	}
	
	public void getTotalByBranchState() throws ClassNotFoundException, SQLException {
		
		  createConnection();
		  Scanner scan = new Scanner(System.in);
		  
		  System.out.println("Enter Branch state:");		
		  String state = scan.next();
		  
		  st = con.prepareStatement(myQueries.getTotalByBranchState);			
	      st.setString(1, state);	      
	      ResultSet rs = st.executeQuery();
		  
	      while(rs.next()) {
	            // retrieve by column value
	           int number_of_transactions = rs.getInt(2);
		       double total = rs.getDouble(3);
							    
		       // display Value
	           System.out.println("Number of transactions in "+ state + " branch is " + number_of_transactions);
	           System.out.println("for total amount of "  + total);
	      } 
	      scan.close();
	      closeallconnection(); 
	}
	
	
}
