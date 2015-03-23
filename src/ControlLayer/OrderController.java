/**
 * 
 */
package ControlLayer;

import java.util.ArrayList;
import java.util.Date;

import DBLayer.GetMax;
import DBLayer.OrderDB;
import ModelLayer.Order;
import ModelLayer.PartOrder;
import ModelLayer.Person;
import ModelLayer.Product;

/**
 * @author S�ren
 *
 */
public class OrderController {
	private ProductController proCon;
	private PersonController persCon;
	private OrderDB oDB;
	private Order tempOrder;

	/**
	 * 
	 */
	public OrderController() {
		proCon = new ProductController();
		oDB = new OrderDB();
		createNewOrder();
	}
	
	private Order createNewOrder() {
		tempOrder = new Order();
		int nextID = GetMax.getMaxId("Select max(ID) from OrderTable");
		tempOrder.setOrderID(nextID);
		return tempOrder;
	}

	public Order findOrder(int orderID){
		oDB = new OrderDB();
		Order o = oDB.findOrder(orderID);
		
		return o;
	}
	public void setStatus(String status,int orderID){
		oDB = new OrderDB();
		Order o = oDB.findOrder(orderID);
		o.setDeliveryStatus(status);
		oDB.setStatus(o);
	}
	public ArrayList<PartOrder> findPartOrder(int orderID){
		oDB = new OrderDB();
		Order o = findOrder(orderID);
		ArrayList<PartOrder> allPartOrders = new ArrayList<PartOrder>();
		allPartOrders = oDB.getAllPartOrders(o.getOrderID());
		o.addAllPartorders(allPartOrders);
		return allPartOrders;
	}
	public ArrayList<Order> findAllOrders()
	{
		oDB = new OrderDB();
		ArrayList<Order> allOrders = new ArrayList<Order>();
		allOrders = oDB.getAllOrders();
		for(Order o : allOrders){
			findPartOrder(o.getOrderID());
		}
		
		return allOrders;
	}
	
	public void insertNewPartOrder(int productID,int amount) throws Exception
	{    
		Product product = proCon.findProduct(productID);
		tempOrder.addPartorder(amount,product.getName(),product.getSalesPrice(),tempOrder.getOrderID(),productID);
		PartOrder po = tempOrder.getPartOrders().get(tempOrder.getPartOrders().size()-1);
		
	}
	public void removePartOrder(int index) throws Exception
	{    
		tempOrder.removePartorder(index);
	}
	public void endOrder(int phoneNo){
		tempOrder.setActive(true);
		persCon = new PersonController();
		Person p = persCon.findPerson(phoneNo);
		tempOrder.setCustomerID(p.getId());
		tempOrder.setCreationDate(new Date());
		try{
		oDB.addOrder(tempOrder);
		for(PartOrder po : tempOrder.getPartOrders()){
			oDB.addPartOrder(po);
		}
		createNewOrder();
		}
		catch(Exception e){
			
		}
		
	}
}
