package ModelLayer;

public abstract class Person {
	private String name;
	private String address;
	private int phoneNo;
	private String email;
	
	public Person(String name, String address, int phoneNo, String email){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
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

}