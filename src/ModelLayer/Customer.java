package ModelLayer;

public class Customer extends Person{
	
	public Customer(){
		
	}
	
	public Customer(String name, String address, int phoneNo, String email, String city, int zipCode, String country){
		super(name, address, phoneNo, email, city, zipCode, country);
	}

}
