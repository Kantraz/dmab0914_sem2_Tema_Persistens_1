package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ModelLayer.*;

public class PersonDB {
	
	private  Connection con;

	public PersonDB() {
		con = DbConnection.getInstance().getDBcon();
	}

	public Customer findCustomer(int phoneNo) {
		String wClause = "  phoneNo = '" +  "?'";
		return (Customer) singleWhereCust(wClause,phoneNo);
	}

	public Supplier findSupplier(String supNumber) {
		String wClause = "  supNumber = '" +  "?'";
		return (Supplier) singleWhereSupp(wClause,supNumber);
	}
	
	private Person singleWhereSupp(String wClause, String supNumber)
	{
		ResultSet results;
		Supplier supp = new Supplier();

		String query =  buildQuerySupp(wClause);
		System.out.println(query);
		try{ // read the product from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, supNumber);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery(query);
			if( results.next() ){
				supp = buildSupp(results);
				//assocaition is to be build
				pstmt.close();     
			}
			else{ //no employee was found
				supp = null;
			}
		}//end try	
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return supp;
	}

	private Person singleWhereCust(String wClause, int phoneNo)
	{
		ResultSet results;
		Customer cust = new Customer();

		String query =  buildQueryCust(wClause);
		System.out.println(query);
		try{ // read the product from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, phoneNo);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery(query);
			if( results.next() ){
				cust = buildCust(results);
				//assocaition is to be build
				pstmt.close();     
			}
			else{ //no employee was found
				cust = null;
			}
		}//end try	
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return cust;
	}
	//method to build the query
	private String buildQueryCust(String wClause)
	{
		String query="SELECT ID, Name, Adress, PhoneNo, Email, ZipCode, Country, FROM Person";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}
	
	private String buildQuerySupp(String wClause)
	{
		String query="ID, Name, Adress, PhoneNo, Email, ZipCode, Country, Supplier_ID FROM Person";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}
	
	private Customer buildCust(ResultSet results)
	{   Customer pers = new Customer();
	try{ // the columns from the table product  are used
		pers.setName(results.getString("Name"));
		pers.setAddress(results.getString("Adress"));
		pers.setPhoneNo(results.getInt("PhoneNo"));
		pers.setEmail(results.getString("Email"));
		pers.setZipCode(results.getInt("ZipCode"));
		pers.setCountry(results.getString("Country"));
	}
	catch(Exception e)
	{
		System.out.println("error in building the employee object");
	}
	return pers;
	}
	
	private Supplier buildSupp(ResultSet results)
	{ // the columns from the table product  are used
		Supplier pers = new Supplier();
		try{ // the columns from the table product  are used
			pers.setName(results.getString("Name"));
			pers.setAddress(results.getString("Adress"));
			pers.setPhoneNo(results.getInt("PhoneNo"));
			pers.setEmail(results.getString("Email"));
			pers.setZipCode(results.getInt("ZipCode"));
			pers.setCountry(results.getString("Country"));
			pers.setSupNumber(results.getInt("Supplier_ID"));
	}
	catch(Exception e)
	{
		System.out.println("error in building the employee object");
	}
	return pers;
	}

	public ArrayList<Customer> getAllEmployees(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateCustomer(Customer cust, int oldPhone) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteCustomer(int phoneNo) {
		// TODO Auto-generated method stub
		
	}

}
