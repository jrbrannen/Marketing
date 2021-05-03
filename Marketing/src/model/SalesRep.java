/**
 * 
 */
package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 26, 2021
 */
public class SalesRep {
	
	private String firstname;
	private String lastname;
	private String managerFirstName;
	private String managerLastName;
	private int priority;
	private double commission;
	private long social;
	
	public SalesRep() {
		super();
	}	

	public SalesRep(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public SalesRep(String firstname, String lastname, String managerFirstName, String managerLastName, int priority,
			long social) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.priority = priority;
		this.social = social;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public long getSocial() {
		return social;
	}

	public void setSocial(long social) {
		this.social = social;
	}

	@Override
	public String toString() {
		return "SalesRep [firstname=" + firstname + ", lastname=" + lastname + ", managerFirstName=" + managerFirstName
				+ ", managerLastName=" + managerLastName + ", priority=" + priority + ", commission=" + commission
				+ ", social=" + social + "]";
	}
	
}
