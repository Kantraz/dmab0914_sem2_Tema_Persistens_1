/**
 * 
 */
package ControlLayer;

import DBLayer.*;
import ModelLayer.*;

/**
 * @author S�ren
 *
 */
public class ProductController {
	
	private Product p;
	private ProductDB pDB;

	/**
	 * 
	 */
	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	public Product findProduct(int productID){
		return pDB.findProduct(productID);
	}

}
