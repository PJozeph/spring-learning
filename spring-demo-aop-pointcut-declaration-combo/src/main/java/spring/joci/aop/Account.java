package spring.joci.aop;

public class Account {
	
	private String fristname;
	private String lastname;
	
	public Account(String fristname, String lastname) {
		this.fristname = fristname;
		this.lastname = lastname;
	}
	
	public String getFristname() {
		return fristname;
	}
	public void setFristname(String fristname) {
		this.fristname = fristname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
