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
	private String uplinkFirstName;
	private String uplinkLastName;
	private int level;
	private double commission;
	private long social;
	private SalesRep[] allReps = new SalesRep[10000];
	private Map repMap = new Map(10000);
	
	public SalesRep() {
		super();
	}	

	public SalesRep(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public SalesRep(String firstname, String lastname, int level) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.level = level;
	}
	
	public SalesRep(String firstname, String lastname, String uplinkFirstName, String uplinkLastName, int level,
			long social) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.uplinkFirstName = uplinkFirstName;
		this.uplinkLastName = uplinkLastName;
		this.level = level;
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

	public String getUplinkFirstName() {
		return uplinkFirstName;
	}

	public void setUplinkFirstName(String uplinkFirstName) {
		this.uplinkFirstName = uplinkFirstName;
	}

	public String getUplinkLastName() {
		return uplinkLastName;
	}

	public void setUplinkLastName(String uplinkLastName) {
		this.uplinkLastName = uplinkLastName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public Map getRepMap() {
		return repMap;
	}

	public void setRepMap(Map repMap) {
		this.repMap = repMap;
	}

	public void addRep(SalesRep rep) {
		
		
		String nameString = getFirstname() + getLastname();
		int index = repMap.hash(nameString, 10000);
		allReps[index] = rep;
	}
	
	public void displayAll() {
		
		for(SalesRep rep : allReps) {
			if(rep != null) {
			System.out.println(rep);
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "SalesRep [firstname=" + firstname + ", lastname=" + lastname + ", uplinkFirstName=" + uplinkFirstName
				+ ", uplinkLastName=" + uplinkLastName + ", level=" + level + ", commission=" + commission + ", social="
				+ social + "]";
	}
	
}
