/**
 * 
 */
package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Product;

/**
 * @author S�ren
 *
 */



public class ProductDB {
	private  Connection con;

	/** Creates a new instance of ProductDB */
	public ProductDB() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	 public void insertProduct(Product newProd) throws Exception
	    {  	  
		   String query="INSERT INTO product(ID, Name,PurchasePrice, SalesPrice, RentPrice,CountryOfOrigin, MinStock, Type, Supplier_ID, IsActive)  "
		   		+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
	                     
	      try{ // insert new product
	          PreparedStatement pstmt = con.prepareStatement(query);
	          pstmt.setInt(1, newProd.getId());
				pstmt.setString(2, newProd.getName());
				pstmt.setFloat(3, newProd.getPurchasePrice());
				pstmt.setFloat(4, newProd.getSalesPrice());
				pstmt.setFloat(5, newProd.getRentPrice());
				pstmt.setString(6, newProd.getCountryOfOrigin());
				pstmt.setInt(7, newProd.getMinStock());
				pstmt.setInt(8, newProd.getType());
				pstmt.setInt(9, newProd.getSupplierID());
				pstmt.setInt(10, newProd.isActive());
	          pstmt.setQueryTimeout(5);
	     	  pstmt.executeUpdate();
	     	 pstmt.close();
	      }//end try
	       catch(SQLException ex){
	          System.out.println("Produkt ikke oprettet");
	          throw new Exception ("Product is not inserted correct");
	       }
	    }
	
	public Product findProduct(int productID) {
		String wClause = "  ID = ? ";
		return singleWhere(wClause,productID);
	}

	public void updateProduct(Product prod, int oldID) {
		Product newProd  = prod;
		String query = "UPDATE Product SET ID = ?, Name = ?,PurchasePrice = ?, SalesPrice = ?, RentPrice = ?,CountryOfOrigin = ?, MinStock = ?, Type = ?, Supplier_ID = ?, IsActive = ?"
				+ " WHERE ID = ?";
                System.out.println("Update query:" + query);
  		try{ // update product
  			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, newProd.getId());
			pstmt.setString(2, newProd.getName());
			pstmt.setFloat(3, newProd.getPurchasePrice());
			pstmt.setFloat(4, newProd.getSalesPrice());
			pstmt.setFloat(5, newProd.getRentPrice());
			pstmt.setString(6, newProd.getCountryOfOrigin());
			pstmt.setInt(7, newProd.getMinStock());
			pstmt.setInt(8, newProd.getType());
			pstmt.setInt(9, newProd.getSupplierID());
			pstmt.setInt(10, newProd.isActive());
			pstmt.setInt(11, oldID);
			pstmt.setQueryTimeout(5);
			pstmt.executeUpdate();
			pstmt.close();
		}
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in product db: "+ex);
	  	}
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
			results = pstmt.executeQuery();
			if( results.next() ){
				prod = buildProduct(results);
				//association is to be build
				pstmt.close();     
			}
			else{ //no product was found
				prod = null;
			}
		}//end try	
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return prod;
	}
	public ArrayList<Product> getAllProducts(){
		ResultSet results;
		String query="SELECT * FROM Product";
		ArrayList<Product> allProducts = new ArrayList<Product>();
		Product prod = new Product();
		try{ // read the product from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery();
			while( results.next() ){
				prod = buildProduct(results);
				allProducts.add(prod);
				//association is to be build	   
			}
			pstmt.close();
		}
			catch(Exception e){
				System.out.println("Query exception: "+e);
			}
			
			return allProducts;
		}
	
		//method to build the query
		private String buildQuery(String wClause)
		{
			String query="SELECT ID, Name,PurchasePrice, SalesPrice, RentPrice,CountryOfOrigin, MinStock, Type, Supplier_ID, IsActive FROM Product";

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
			prod.setMinStock(results.getInt("MinStock"));
			prod.setType(results.getInt("Type"));
			prod.setSupplierID(results.getInt("Supplier_ID"));
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
			prod.setActive(results.getBoolean("IsActive"));
>>>>>>> origin/master
>>>>>>> origin/master
			prod.setActive(results.getInt("IsActive"));
		}
		catch(Exception e)
		{
			System.out.println("error in building the product object");
		}
		return prod;
		}


	}
