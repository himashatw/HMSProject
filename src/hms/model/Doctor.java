package hms.model;

public class Doctor {
	int dID;
	String name;
	int contact;
	String specialization;
	String time;
	String email;
	String password;
	
	
	
	public Doctor(String name, int contact, String specialization, String time, String email, String password) {
		super();
		this.name = name;
		this.contact = contact;
		this.specialization = specialization;
		this.time = time;
		this.email = email;
		this.password = password;
	}
	public Doctor(int dID, String name, int contact, String specialization, String time, String email,
			String password) {
		super();
		this.dID = dID;
		this.name = name;
		this.contact = contact;
		this.specialization = specialization;
		this.time = time;
		this.email = email;
		this.password = password;
	}
	public int getdID() {
		return dID;
	}
	public void setdID(int dID) {
		this.dID = dID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	@Override
	public String toString() {
		return "Doctor [dID=" + dID + ", name=" + name + ", contact=" + contact + ", specialization=" + specialization
				+ ", time=" + time + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
