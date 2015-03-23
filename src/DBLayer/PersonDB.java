package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ModelLayer.*;

public class PersonDB {

	private  Connection con;

	public PersonDB() {
		con = DbConnection.getInstance().getDBcon();
	}

	public void insertPerson(Person newPers) throws Exception
	{  	  
		int nextID = GetMax.getMaxId("Select max(ID) from Person");
<<<<<<< HEAD

		String query="INSERT INTO Person (ID, Name, Address, PhoneNo, Email, ZipCode, Country, IsActive) VALUES"
				+ "(?,?,?,?,?,?,?,?)";
=======
		String query="INSERT INTO Person(ID, Name, Address, PhoneNo, Email, ZipCode, Country, IsActive)  "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
>>>>>>> origin/master

		try{ // insert new person
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nextID);
			pstmt.setString(2, newPers.getName());
			pstmt.setString(3, newPers.getAddress());
			pstmt.setInt(4, newPers.getPhoneNo());
			pstmt.setString(5, newPers.getEmail());
			pstmt.setString(6, newPers.getZipCode());
			pstmt.setString(7, newPers.getCountry());
			pstmt.setInt(8, newPers.getIsActive());
<<<<<<< HEAD
			pstmt.setQueryTimeout(5);
			pstmt.executeUpdate();
=======
			pstmt.setQueryTimeout(5);	
>>>>>>> origin/master

			pstmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}

	public Person findPerson(int phoneNo) {
		String wClause = "  phoneNo = '" +  "?'";
		return singleWhere(wClause,phoneNo);
	}

	private Person singleWhere(String wClause, int phoneNo)
	{
		ResultSet results;
		Person pers = new Person();

		String query =  buildQuery(wClause);
		System.out.println(query);
		try{ // read the product from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, phoneNo);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery();
			if( results.next() ){
				pers = build(results);
				//assocaition is to be build
				pstmt.close();     
			}
			else{ //no employee was found
				pers = null;
			}
		}//end try	
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return pers;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
		String query="SELECT ID, Name, Adress, PhoneNo, Email, ZipCode, Country, IsActive FROM Person";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}

	private Person build(ResultSet results)
	{   Person pers = new Person();
	try{ // the columns from the table product  are used
		pers.setName(results.getString("Name"));
		pers.setAddress(results.getString("Adress"));
		pers.setPhoneNo(results.getInt("PhoneNo"));
		pers.setEmail(results.getString("Email"));
		pers.setZipCode(results.getString("ZipCode"));
		pers.setCountry(results.getString("Country"));
		pers.setIsActive(results.getInt("IsActive"));
	}
	catch(Exception e)
	{
		System.out.println("error in building the person object");
	}
	return pers;
	}

	public ArrayList<Person> getAllPersons(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePerson(Person pers, int oldPhone) {
		Person newPers  = pers;
		String query = "UPDATE Person SET Name = ?,Adress = ?, PhoneNo = ?, Email = ?,ZipCode = ?, Country = ?, IsActive = ?"
				+ " WHERE PhoneNo = ?";
		System.out.println("Update query:" + query);
		try{ // update product
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPers.getName());
			pstmt.setString(2, newPers.getAddress());
			pstmt.setInt(3, newPers.getPhoneNo());
			pstmt.setString(4, newPers.getEmail());
			pstmt.setString(5, newPers.getZipCode());
			pstmt.setString(6, newPers.getCountry());
			pstmt.setInt(7, newPers.getIsActive());
			pstmt.setInt(8, oldPhone);

			pstmt.setQueryTimeout(5);
			pstmt.executeUpdate();

			pstmt.close();
		}
		catch(Exception ex){
			System.out.println("Update exception in product db: "+ex);
		}
	}

	public void deletePerson(int phoneNo) {
		Person tempP = findPerson(phoneNo);
		tempP.setIsActive(0);
		updatePerson(tempP, phoneNo);
	}
}