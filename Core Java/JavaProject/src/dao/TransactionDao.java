package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import resourses.myQueries;

 //Stretch goal to separate all transactions connections to separate package

public class TransactionDao extends CreateConnection {

	public ArrayList<String> getTransactionsByZipcodeDao(int zipcode, int month, int year)
			{
	  ArrayList<String> typeslist = new ArrayList<>();
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
		       typeslist.add(TRANSACTION_ID);
		       typeslist.add(BRANCH_CODE);
		       typeslist.add(date);
		       return typeslist;		       
			}
		    
		}
}
