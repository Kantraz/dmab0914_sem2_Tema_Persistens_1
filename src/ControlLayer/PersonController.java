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

	public Customer findCustomer(String phoneNo){
		PersonDB pDB = new PersonDB();
		return pDB.findCustomer(phoneNo);
	}

	public Supplier findSupplier(String supNumber){
		return pDB.findSupplier(supNumber);
	}

	public ArrayList<Customer> findAllCustomers()
	{
		PersonDB pDB = new PersonDB();
		ArrayList<Customer> allCust = new ArrayList<Customer>();
		allCust = pDB.getAllEmployees(false);
		return allCust;
	}
	public int updateCustomer(String name, String address, int phoneNo, String email, String city, int zipCode, String country, int oldPhone)
	{
		PersonDB pDB = new PersonDB();
		Customer cust = new Customer(name, address, phoneNo, email, city, zipCode, country);
		return  pDB.updateCustomer(cust, oldPhone);         
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