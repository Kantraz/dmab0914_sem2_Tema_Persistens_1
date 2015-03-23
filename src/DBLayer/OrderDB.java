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
import java.util.Date;

import ModelLayer.Order;
import ModelLayer.PartOrder;
import ModelLayer.Product;

/**
 * @author S�ren
 *
 */



public class OrderDB {
	private  Connection con;

	/** Creates a new instance of ProductDB */
	public OrderDB() {
		con = DbConnection.getInstance().getDBcon();
	}

	public void addOrder(Order newOrder) throws Exception
	{  	  
		String query="INSERT INTO Order(ID, Date,DeliveryStatus, DeliveryDate, Price, Person_ID)  "
				+ "VALUES(?,?,?,?,?,?)";

		try{ // insert new order
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, newOrder.getOrderID());
			pstmt.setDate(2, new java.sql.Date(newOrder.getCreationDate().getDate()));
			pstmt.setString(3, newOrder.getDeliveryStatus());
			pstmt.setDate(4, new java.sql.Date(newOrder.getDeliveryDate().getDate()));
			pstmt.setFloat(5, newOrder.getOrderPrice());
			pstmt.setInt(6, newOrder.getCustomerID());
			pstmt.setQueryTimeout(5);
			pstmt.executeUpdate();
			pstmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println("Ordre ikke oprettet");
			throw new Exception ("Order is not inserted correct");
		}
	}
	
	public void addPartOrder(PartOrder newPartOrder) throws Exception
	{  	  
		String query="INSERT INTO PartOrder(Order_ID, Product_ID,Amount, ProductPrice)  "
				+ "VALUES(?,?,?,?)";

		try{ // insert new order
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, newPartOrder.getOrderID());
			pstmt.setInt(2, newPartOrder.getProductID());
			pstmt.setInt(3, newPartOrder.getAmount());
			pstmt.setFloat(4, newPartOrder.getPrice());
			pstmt.setQueryTimeout(5);
			pstmt.executeUpdate();
			pstmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println("Ordrelinie ikke oprettet");
			throw new Exception ("PartOrder is not inserted correct");
		}
	}

	public Order findOrder(int orderID) {
		String wClause = "  ID = '" +  "?'";
		return singleWhere(wClause,orderID);
	}

	public int updateProduct(Product prod, int oldID) {
		Product newProd  = prod;
		int rc=-1;
		String query = "UPDATE Product SET ID = ?, Name = ?,PurchasePrice = ?, SalesPrice = ?, RentPrice = ?,CountryOfOrigin = ?, MinStock = ?, Type = ?, Supplier_ID = ?, IsActive = ?"
				+ " WHERE ID = ?'";
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
			pstmt.setBoolean(10, newProd.isActive());
			pstmt.setInt(11, oldID);

			pstmt.setQueryTimeout(5);
			rc = pstmt.executeUpdate();

			pstmt.close();
		}
		catch(Exception ex){
			System.out.println("Update exception in product db: "+ex);
		}
		return(rc);
	}

	//Singelwhere is used when we only select one product 	
	private Order singleWhere(String wClause, int orderID)
	{
		ResultSet results;
		Order o = new Order();

		String query =  buildQuery(wClause);
		System.out.println(query);
		try{ // read the order from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderID);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery(query);
			if( results.next() ){
				o = buildOrder(results);
				//association is to be build
				pstmt.close();     
			}
			else{ //no order was found
				o = null;
			}
		}//end try	
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return o;
	}
	public ArrayList<Order> getAllOrders(){
		ResultSet results;
		String query="SELECT * FROM OrderTable";
		ArrayList<Order> allOrders = new ArrayList<Order>();
		Order o = new Order();
		try{ // read the product from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery(query);
			while( results.next() ){
				o = buildOrder(results);
				allOrders.add(o);
				//association is to be build	   
			}
			pstmt.close();
		}
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}

		return allOrders;
	}
	
	
	public ArrayList<PartOrder> getAllPartOrders(int orderID){
		ResultSet results;
		ResultSet resultsProduct;
		String query="SELECT * FROM PartOrder WHERE Order_ID = orderID;";
		ArrayList<PartOrder> allPartOrders = new ArrayList<PartOrder>();
		
		try{ // read the partorder from the database
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setQueryTimeout(5);
			results = pstmt.executeQuery(query);
			while( results.next() ){
				
				String productQuery="SELECT Name FROM Product WHERE ID = "+ results.getInt("Product_ID")+";";
				PreparedStatement pstmt2 = con.prepareStatement(productQuery);
				pstmt2.setQueryTimeout(5);
				resultsProduct = pstmt2.executeQuery(productQuery);
				if (resultsProduct.next()){
					PartOrder po = new PartOrder(results.getInt("Amount"),resultsProduct.getString("Name"),results.getFloat("ProductPrice"),results.getInt("Order_ID"),results.getInt("Product_ID"));
					allPartOrders.add(po);
				}
				pstmt2.close();
				//association is to be build	   
			}
			pstmt.close();
			
		}
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}

		return allPartOrders;
	}
	

	//method to build the query
	private String buildQuery(String wClause)
	{
		String query="SELECT ID, Name,PurchasePrice, SalesPrice, RentPrice,CountryOfOrigin, MinStock, Type, Supplier_ID, IsActive FROM Product";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}

	//method to build an order object
	private Order buildOrder(ResultSet results)
	{   Order o = new Order();
	try{ // the columns from the table order  are used
		o.setOrderID(results.getInt("ID"));
		Date createDate  = results.getTimestamp("Date");
		o.setCreationDate(createDate);
		o.setDeliveryStatus("DeliveryStatus");
		Date deliveryDate  = results.getTimestamp("DeliveryDate");
		o.setDeliveryDate(deliveryDate);
		o.setOrderPrice(results.getFloat("Price"));
		o.setCustomerID(results.getInt("Person_ID"));
	}
	catch(Exception e)
	{
		System.out.println("error in building the order object");
	}
	return o;
	}

	public void setStatus(Order o) {
		Order tempO = o;
		String query = "UPDATE OrderTable SET DeliveryStatus = ?";
	try{ // update product
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, tempO.getDeliveryStatus());

		pstmt.setQueryTimeout(5);
		pstmt.executeUpdate();

		pstmt.close();
	}
	catch(Exception ex){
		System.out.println("Update exception in order db: "+ex);
	}
	}


}
