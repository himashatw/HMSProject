package hms.model;

public class Patient {
	protected int pID;
	protected String name;
	protected int age;
	protected int contact;
	protected String email;
	protected String password;
	protected String prescription;
	public Patient(int pID, String name, int age, int contact, String email) {
		super();
		this.pID = pID;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.email = email;
		
	}
	
	
	public Patient(int pID, String name, int age, int contact, String email, String password) {
		super();
		this.pID = pID;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}


	public Patient(int pID, String name, int age, int contact, String email, String password, String prescription) {
		super();
		this.pID = pID;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.prescription = prescription;
	}


	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "Patient [pID=" + pID + ", name=" + name + ", age=" + age + ", contact=" + contact + ", email=" + email
				+ ", password=" + password + ", prescription=" + prescription + "]";
	}
	
}
