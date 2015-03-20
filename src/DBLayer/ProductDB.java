/**
 * 
 */
package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Department;
import ModelLayer.Employee;
import ModelLayer.Product;

/**
 * @author Søren
 *
 */



public class ProductDB {
	private  Connection con;

	/** Creates a new instance of ProductDB */
	public ProductDB() {
		con = DbConnection.getInstance().getDBcon();
	}

	public Product findProduct(int productID) {
		String wClause = "  ID = '" +  "?'";
		return singleWhere(wClause,productID);
	}

	public ArrayList<Product> getAllProducts(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateProduct(Product prod) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void insertProduct(Product prod) {
		// TODO Auto-generated method stub

	}

	public void deleteProduct(Product prod) {
		// TODO Auto-generated method stub

	}

	//Singelwhere is used when we only select one product 	
	private Product singleWhere(String wClause, int productID)
	{
		ResultSet results;
		Product prod = new Product();

		String query =  buildQuery(wClause);
		System.out.println(query);
		try{ // read the product from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, productID);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery(query);
			if( results.next() ){
				prod = buildProduct(results);
				//assocaition is to be build
				pstmt.close();     
			}
			else{ //no employee was found
				prod = null;
			}
		}//end try	
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return prod;
	}

	//method to build the query
	private String buildQuery(String wClause)
	{
		String query="SELECT ID, Name,PurchasePrice, SalesPrice, RentPrice,CountryOfOrigin, MinStock, Type,Supplier_ID, IsActive  FROM Product";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}

	//method to build an employee object
	private Product buildProduct(ResultSet results)
	{   Product prod = new Product();
	try{ // the columns from the table product  are used
		prod.setId(results.getInt("ID"));
		prod.setName(results.getString("Name"));
		prod.setPurchasePrice(results.getFloat("PurchasePrice"));
		prod.setSalesPrice(results.getFloat("SalesPrice"));
		prod.setRentPrice(results.getFloat("RentPrice"));
		prod.setCountryOfOrigin(results.getString("CountryOfOrigin"));
		prod.set
	}
	catch(Exception e)
	{
		System.out.println("error in building the employee object");
	}
	return empObj;
	}


}
