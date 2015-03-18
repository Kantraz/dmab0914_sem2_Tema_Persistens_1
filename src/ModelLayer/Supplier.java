package ModelLayer;

public class Supplier extends Person {
	
	private int supNumber;
	
	public Supplier(String name, String address, int phoneNo, String email, String city, int zipCode, String country, int supNumber){
		super(name, address, phoneNo, email, city, zipCode, country);
		this.setSupNumber(supNumber);
	}

	/**
	 * @return the supNumber
	 */
	public int getSupNumber() {
		return supNumber;
	}

	/**
	 * @param supNumber the supNumber to set
	 */
	public void setSupNumber(int supNumber) {
		this.supNumber = supNumber;
	}

}
