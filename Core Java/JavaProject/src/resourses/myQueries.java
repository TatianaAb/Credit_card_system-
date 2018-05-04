package resourses;

public class myQueries {
	
	public static final String getByZipcode = "SELECT * FROM cdw_sapp_creditcard "
			+ "JOIN cdw_sapp_customer USING (CREDIT_CARD_NO)"
			+ " WHERE CUST_ZIP = ? AND MONTH = ? AND YEAR = ? "
			+ "ORDER BY day DESC";
	
	public static final String getTotalByType = "SELECT COUNT(*) AS number_of_transactions, "
			+ "SUM(TRANSACTION_VALUE) AS total"
			+ " FROM cdw_sapp_creditcard WHERE TRANSACTION_TYPE = ?";
	
	public static final String getTotalByBranchState = "SELECT BRANCH_STATE, count(*) as number_of_transactions, "
			+ "SUM(TRANSACTION_VALUE) as total"
			+ " FROM cdw_sapp_creditcard JOIN cdw_sapp_branch using (BRANCH_CODE)"
			+ " WHERE BRANCH_STATE = ?";
	
	public static final String getCustomerDetails = "select * from cdw_sapp_customer "
			+ "JOIN cdw_sapp_creditcard on cdw_sapp_customer.SSN = cdw_sapp_creditcard.CUST_SSN"
			+ " where SSN = ?"
			+ " group by cdw_sapp_customer.CREDIT_CARD_NO";

	public static final String modifyFirstName = "UPDATE cdw_sapp_customer "
			+ "SET FIRST_NAME = ? WHERE CREDIT_CARD_NO = ?";
	
	public static final String modifylastName = "UPDATE cdw_sapp_customer "
			+ "SET LAST_NAME = ? WHERE CREDIT_CARD_NO = ?";
	
	public static final String modifyEmail = "UPDATE cdw_sapp_customer "
			+ "SET CUST_EMAIL = ? WHERE CREDIT_CARD_NO = ?";
	
	

	public static final String generateMonthlyBill = "select MONTH, YEAR, SUM(TRANSACTION_VALUE) as monthly_bill "
			+ "from cdw_sapp_creditcard "
			+ "where CREDIT_CARD_NO = ?" 
			+ " and YEAR = ? and MONTH = ?";
	
	public static final String getTransactionByDates = "SELECT * from "
			+ " ( SELECT TRANSACTION_ID, TRANSACTION_VALUE, concat(YEAR, \"-\", LPAD(MONTH,2,'0'), \"-\", LPAD(DAY,2,'0')) as TRANSACTION_DATE, "
			+ "FIRST_NAME, LAST_NAME, SSN from cdw_sapp_creditcard cc join cdw_sapp_customer cust "
			+ "on cust.SSN = cc.CUST_SSN) as customer_transactions "
			+ "where (TRANSACTION_DATE BETWEEN ? AND ?) AND SSN = ? "
			+ "ORDER BY TRANSACTION_DATE DESC";
	 
}
