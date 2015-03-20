/**
 * 
 */
package ModelLayer;

/**
 * @author Benjamin Ørskov, Lasse Lambertsen, Ole Kirk & Søren Søgaard
 *
 */
public class PartOrder {
	private String name;
	private float price;
	private int amount;
	private int orderID;
	public PartOrder(int amount2, String name2, float price2, int orderID2){
		name = name2;
		amount = amount2;
		price = price2;
		orderID = orderID2;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
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
