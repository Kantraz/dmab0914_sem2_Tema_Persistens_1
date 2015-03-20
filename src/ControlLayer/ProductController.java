/**
 * 
 */
package ControlLayer;

import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

/**
 * @author Søren
 *
 */
public class ProductController {

	private Product p;
	private ProductDB pDB;
	private ProductIFDB pIFDB;

	/**
	 * 
	 */
	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	public Product findProduct(int productID){
		pDB = new ProductDB();
		return pDB.findProduct(productID);
	}
	public ArrayList<Product> findAllProducts()
	{
		pDB = new ProductDB();
		ArrayList<Product> allProd = new ArrayList<Product>();
		allProd = pDB.getAllProducts(false);
		return allProd;
	}

	public int updateProduct(int productID, String name, int minStock, int purchasePrice, float rentPrice, float salesPrice, String countryOfOrigin)
	{
		pDB = new ProductDB();
		Product prod = new Product();
		prod.setName(name);
		prod.setMinStock(minStock);
		prod.setPurchasePrice(purchasePrice);
		prod.setRentPrice(rentPrice);
		prod.setSalesPrice(salesPrice);
		prod.setCountryOfOrigin(countryOfOrigin);
		return  pDB.updateProduct(prod);         
	}
	public void insertNew(int productID, String name, int minStock, int purchasePrice, float rentPrice, float salesPrice, String countryOfOrigin) throws Exception
	{    
		Product prod = new Product();
		prod.setName(name);
		prod.setMinStock(minStock);
		prod.setPurchasePrice(purchasePrice);
		prod.setRentPrice(rentPrice);
		prod.setSalesPrice(salesPrice);
		prod.setCountryOfOrigin(countryOfOrigin);

		try{
			DbConnection.startTransaction();
			pDB = new ProductDB();
			pDB.insertProduct(prod);
			DbConnection.commitTransaction();
		}
		catch(Exception e)
		{
			DbConnection.rollbackTransaction();
			throw new Exception("Product not inserted");
		}
	}
	public void deleteProduct(int productID) throws Exception{
		pDB = new ProductDB();
		Product prod = findProduct(productID);
		
		try{
			pDB.deleteProduct(prod);
		}
		catch(Exception e)
		{
			throw new Exception("Product not deleted");
		}
	}

}
