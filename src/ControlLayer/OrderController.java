/**
 * 
 */
package ControlLayer;

import java.util.ArrayList;
import java.util.Date;

import DBLayer.DbConnection;
import DBLayer.GetMax;
import DBLayer.OrderDB;
import DBLayer.ProductDB;
import ModelLayer.Order;
import ModelLayer.PartOrder;
import ModelLayer.Person;
import ModelLayer.Product;

/**
 * @author Søren
 *
 */
public class OrderController {
	
	private PersonController perCon;
	private ProductController proCon;
	private Order o;
	private OrderDB oDB;
	private PartOrder pO;
	private Order tempOrder;

	/**
	 * 
	 */
	public OrderController() {
		createNewOrder();
	}
	
	private Order createNewOrder() {
		tempOrder = new Order();
		int nextID = GetMax.getMaxId("Select max(ID) from Order");
		tempOrder.setOrderID(nextID);
		return tempOrder;
	}

	public Order findOrder(int orderID){
		oDB = new OrderDB();
		
		return oDB.findOrder(orderID);
	}
	public ArrayList<Order> findAllOrders()
	{
		oDB = new OrderDB();
		ArrayList<Order> allOrders = new ArrayList<Order>();
		allOrders = oDB.getAllOrders();
		return allOrders;
	}
	
	public void insertNewPartOrder(int productID,int amount) throws Exception
	{    
		Product product = proCon.findProduct(productID);
		tempOrder.addPartorder(amount,product.getName(),product.getSalesPrice(),tempOrder.getOrderID());
	}
	public void removePartOrder(int index) throws Exception
	{    
		tempOrder.removePartorder(index);
	}
	public void endOrder(int personID){
		tempOrder.setActive(true);
		tempOrder.setCustomerID(personID);
		tempOrder.setCreationDate(new Date());
		try{
		oDB.addOrder(tempOrder);
		createNewOrder();
		}
		catch(Exception e){
			
		}
		
	}
	public void removeOrder(int orderID){
		oDB.removeOrder(orderID);
	}

}
