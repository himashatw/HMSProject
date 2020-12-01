package hms.model;

public class Appointment {
		
	int appID;
	String details;
	String appTime;
	int pID;
	int dID;
	
	public Appointment(int appID, String details, String appTime, int pID, int dID) {
		super();
		this.appID = appID;
		this.details = details;
		this.appTime = appTime;
		this.pID = pID;
		this.dID = dID;
	}

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public int getdID() {
		return dID;
	}

	public void setdID(int dID) {
		this.dID = dID;
	}

	@Override
	public String toString() {
		return "Appointment [appID=" + appID + ", details=" + details + ", appTime=" + appTime + ", pID=" + pID
				+ ", dID=" + dID + "]";
	}
	
	
}
