package runnable;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import cc.management.system.CustomerDetails;
import cc.management.system.TransactionDetails;
import dao.CreateConnection;

public class CC_Management_System extends CreateConnection {

	private static Scanner scan;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		System.out.println("Welcome to Credit Card Management System");
		System.out.println("Please choose an option ");
		System.out.println("What information would you like to update?");	
		System.out.println("Enter [1] for customer details");
		System.out.println("Enter [2] to get information by transaction");
		
		scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println("Please enter 3 for Email");		  
		  
		  if (input == 1) {
			 CustomerDetails cd = new CustomerDetails();
			 System.out.println("Enter [1] for customer details by ssn");
		     System.out.println("Enter [2] to update customer information");
		     System.out.println("Enter [3] for monthly bill");
			 System.out.println("Enter [4] to get transactions by date");
			 int option = scan.nextInt();
			 if (option == 1) {
				 cd.getCustomerDetails();
				}else if (option == 2) {
				 cd.modifyAccountDetails();	
			    }else if (option == 3) {
			     cd.generateMonthlyBill();
			    }else if (option == 4) {
			     cd.getTransactionByDates();
			    } else { System.out.println("Wrong input");}				 
				   
		   }else if (input == 2) {
				TransactionDetails td = new TransactionDetails();
				System.out.println("Enter [1] to get transactions by zipcode");
			    System.out.println("Enter [2] to get transactions by type");
			    System.out.println("Enter [3] for total transactions value by state");
			    
				int option = scan.nextInt();
				 if (option == 1) {
					  td.getTransactionsByZipcode();
					}else if (option == 2) {
					  td.getTransactionTotalByType();	
				    }else if (option == 3) {
				      td.getTotalByBranchState();
				    }else { System.out.println("Wrong input");}								
		    }else { System.out.println("Wrong input");}
		  
		  scan.close();							

	}

}
