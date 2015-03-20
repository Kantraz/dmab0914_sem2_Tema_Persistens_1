package DBLayer;

import ModelLayer.Person;

class DbPersonHelper extends Person{

	public DbPersonHelper(String name, String address, int phoneNo, String email, String city, int zipCode, String country) {
		super(name, address, phoneNo, email, city, zipCode, country);
	}
	
	public DbPersonHelper(){
		super();
	}

}
