package ModelLayer;

public class Person {
	private String name;
	private String address;
	private int phoneNo;
	private String email;
	private String city;
	private String zipCode;
	private String country;
	private int isActive;
	
	public Person(){
		
	}
	
	public Person(String name, String address, int phoneNo, String email, String city, String zipCode, String country, int isActive){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
		this.setCity(city);
		this.setZipCode(zipCode);
		this.setCountry(country);
		this.setIsActive(isActive);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode2 the zipCode to set
	 */
	public void setZipCode(String zipCode2) {
		this.zipCode = zipCode2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the isActive
	 */
	public int getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}