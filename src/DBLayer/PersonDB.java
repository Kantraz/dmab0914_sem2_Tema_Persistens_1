package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.*;

public class PersonDB {

	private  Connection con;

	public PersonDB() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	public int insertPerson(Person newPers) throws Exception
	{  	  
		int nextID = GetMax.getMaxId("Select mac(ID) from Person");
		
		int rc = -1;
		String query="INSERT INTO Person(ID, Name, Address, PhoneNo, Email, ZipCode, Country, IsActive)  "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		try{ // insert new product
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nextID);
			pstmt.setString(2, newPers.getName());
			pstmt.setString(3, newPers.getAddress());
			pstmt.setInt(4, newPers.getPhoneNo());
			pstmt.setString(5, newPers.getEmail());
			pstmt.setString(6, newPers.getZipCode());
			pstmt.setInt(7, newPers.getCountry());
			pstmt.setInt(8, newPers.get);
			pstmt.setInt(9, newProd.getSupplierID());
			pstmt.setBoolean(10, newProd.isActive());
			pstmt.setQueryTimeout(5);
			rc = pstmt.executeUpdate(query);
			pstmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println("Produkt ikke oprettet");
			throw new Exception ("Product is not inserted correct");
		}
		return(rc);
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
		DbPersonHelper cust = new DbPersonHelper();

		String query =  buildQueryCust(wClause);
		System.out.println(query);
		try{ // read the product from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, phoneNo);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery(query);
			if( results.next() ){
				cust = build(results);
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
		String query="SELECT ID, Name, Adress, PhoneNo, Email, ZipCode, Country, null FROM Person";

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

	private DbPersonHelper build(ResultSet results)
	{   DbPersonHelper pers = new DbPersonHelper();
	try{ // the columns from the table product  are used
		pers.setName(results.getString("Name"));
		pers.setAddress(results.getString("Adress"));
		pers.setPhoneNo(results.getInt("PhoneNo"));
		pers.setEmail(results.getString("Email"));
		pers.setZipCode(results.getInt("ZipCode"));
		pers.setCountry(results.getString("Country"));
		//pers.setSupNumber(results.getInt(null));
	}
	catch(Exception e)
	{
		System.out.println("error in building the person object");
	}
	return pers;
	}

	private Supplier buildSupp(ResultSet results)
	{ // the columns from the table product  are used
		Supplier pers = new Supplier();
		try{ // the columns from the table product  are used
			build(results);
			pers.setSupNumber(results.getInt("Supplier_ID"));
		}
		catch(Exception e)
		{
			System.out.println("error in building the supplier object");
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

	public void deleteCustomer(String wClause, int phoneNo) {
		String query= buildQuery();
		System.out.println(query);
		try{ 
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}//slut try	
		catch(Exception ex){
			System.out.println("Delete exception in employee db: "+ex);
		}
	}
}
