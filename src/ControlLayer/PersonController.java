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
	/**
	 * 
	 */
	public PersonController() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer findCustomer(String phoneNo){
		PIFDB pDB = new PersonDB();
		return pDB.findCustomer(phoneNo);
	}
	
	public Supplier findSupplier(String supNumber){
		return pDB.findSupplier(supNumber);
	}
	
	public ArrayList<Customer> findAllCustomers()
    {
      PIFDB pDB = new PersonDB();
      ArrayList<Customer> allCust = new ArrayList<Customer>();
      allCust = pDB.getAllEmployees(false);
      return allEmp;
    }
	
	public Employee findByFname(String fname)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeFname(fname, true);
    }
	
}
