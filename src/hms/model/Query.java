package hms.model;

public class Query {
	
	int qID;
	String name;
	String email;
	String subject;
	String message;
	String time;
	
	public Query(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public Query(int qID, String name, String email, String subject, String message, String time) {
		super();
		this.qID = qID;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.time = time;
	}
	
	public int getqID() {
		return qID;
	}
	public void setqID(int qID) {
		this.qID = qID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Query [qID=" + qID + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + ", time=" + time + "]";
	}
	
}
