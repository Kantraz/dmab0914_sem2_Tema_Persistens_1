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
		PIFDB pDB = new PersonDB();
		return pDB.findCustomer(phoneNo);
	}
	
	public Supplier findSupplier(String supNumber){
		return pDB.findSupplier(supNumber);
	}
	
	public ArrayList<Customer> findAllCustomers()
    {
      pIFDB pDB = new PersonDB();
      ArrayList<Customer> allCust = new ArrayList<Customer>();
      allCust = pDB.getAllEmployees(false);
      return allEmp;
    }
	 public int updateCustomer(String name, String address, int phoneNo, String email, String city, int zipCode, String country)
     {
         pIFDB pDB = new DBEmployee();
         Employee emp = new Employee();
         emp.setSsn(ssn);
         emp.setFname(fname);
         emp.setLname(lname);
         emp.setSupervisor(new Employee(superssn));
         emp.setSalary(salary);
         return  dbEmp.updateEmployee(emp);
         
         
     }
	
	
}
