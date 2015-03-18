/**
 * 
 */
package ControlLayer;

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
		return pDB.findCustomer(phoneNo);
	}
	
	public Supplier findSupplier(String supNumber){
		return pDB.findSupplier(supNumber);
	}

}
