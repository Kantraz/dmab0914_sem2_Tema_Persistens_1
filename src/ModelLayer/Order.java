/**
 * 
 */
package ModelLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Benjamin �rskov, Lasse Lambertsen, Ole Kirk & S�ren S�gaard
 *
 */
public class Order {
	private Product product;
	private Customer customer;
	private Date date;
	private int orderID;
public Order(){
	date = new Date();

}
/**
 * @return the product
 */
public Product getProduct() {
	return product;
}
/**
 * @param product the product to set
 */
public void setProduct(Product product) {
	this.product = product;
}
/**
 * @return the customer
 */
public Customer getCustomer() {
	return customer;
}
/**
 * @param customer the customer to set
 */
public void setCustomer(Customer customer) {
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
}
