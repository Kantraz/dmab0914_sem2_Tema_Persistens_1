/**
 * 
 */
package ModelLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Benjamin Ørskov, Lasse Lambertsen, Ole Kirk & Søren Søgaard
 *
 */
public class Order {
	private ArrayList<PartOrder> partOrders = new ArrayList<PartOrder>();
	private Person customer;
	private Date date;
	private int orderID;
	private boolean isActive;
public Order(){
	date = new Date();

}
/**
 * @return the customer
 */
public Person getCustomer() {
	return customer;
}
/**
 * @param customer the customer to set
 */
public void setCustomer(Person customer) {
	this.customer = customer;
}
/**
 * @return the date
 */
public Date getDate() {
	return date;
}
/**
 * @param date the date to set
 */
public void setDate(Date date) {
	this.date = date;
}
/**
 * @return the orderID
 */
public int getOrderID() {
	return orderID;
}
/**
 * @param orderID the orderID to set
 */
public void setOrderID(int orderID) {
	this.orderID = orderID;
}
/**
 * @return the partOrders
 */
public ArrayList<PartOrder> getPartOrders() {
	return partOrders;
}
public void addPartorder(int amount, String name, float price, int orderID){
	partOrders.add(new PartOrder(amount,name,price,orderID));
}
public void removePartorder(int i){
	partOrders.remove(i);
}
/**
 * @return the isActive
 */
public boolean isActive() {
	return isActive;
}
/**
 * @param isActive the isActive to set
 */
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
}
