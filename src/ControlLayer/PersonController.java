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

	public Person findPerson(int phoneNo){
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
	public void updatePerson(String name, String address, int phoneNo, String email, String city, String zipCode, String country, int isActive, int oldPhone)
	{
		PersonDB pDB = new PersonDB();
		Person pers = new Person(name, address, phoneNo, email, city, zipCode, country, isActive);
		pDB.updatePerson(pers, oldPhone);         
	}
	public void insertNew(String name, String address, int phoneNo, String email, String city, String zipCode, String country) throws Exception
	{    
		Person custObj = new Person(name, address, phoneNo, email, city, zipCode, country,1);
		try{
			DbConnection.startTransaction();
			PersonDB pDB = new PersonDB();
			pDB.insertPerson(custObj);
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
			pDB.deletePerson(phoneNo);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
			throw new Exception("Customer not deleted");
		}
	}
}