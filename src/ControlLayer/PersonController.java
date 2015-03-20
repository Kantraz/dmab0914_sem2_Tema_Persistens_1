package ControlLayer;

import java.util.ArrayList;

import ModelLayer.*;
import DBLayer.*;

/**
 * @author Sørenpikkemand
 *
 */
public class PersonController {
	private Person p;
	private PersonDB pDB;
	private PersonIFDB pIFDB;
	/**
	 * 
	 */
	public PersonController() {
		// TODO Auto-generated constructor stub
	}

	public Person findPerson(String phoneNo){
		PersonDB pDB = new PersonDB();
		return pDB.findPerson(phoneNo);
	}

	public ArrayList<Person> findAllPersons()
	{
		PersonDB pDB = new PersonDB();
		ArrayList<Person> allPers = new ArrayList<Person>();
		allPers = pDB.getAllPersons(false);
		return allPers;
	}
	public int updatePerson(String name, String address, int phoneNo, String email, String city, String zipCode, String country, int isActive, int oldPhone)
	{
		PersonDB pDB = new PersonDB();
		Person pers = new Person(name, address, phoneNo, email, city, zipCode, country, isActive);
		return  pDB.updatePerson(pers, oldPhone);         
	}
	public void insertNew(String name, String address, int phoneNo, String email, String city, int zipCode, String country) throws Exception
	{    
		Customer custObj = new Customer(name, address, phoneNo, email, city, zipCode, country);
		try{
			DbConnection.startTransaction();
			PersonDB pDB = new PersonDB();
			pDB.insertCustomer(custObj);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
			throw new Exception("Customer not inserted");
		}
	}
	public void deleteCustomer(int phoneNo) throws Exception
	{
		try{
			DbConnection.startTransaction();
			PersonDB pDB = new PersonDB();
			pDB.deleteCustomer(phoneNo);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
			throw new Exception("Customer not deleted");
		}
	}
}