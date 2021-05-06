/**
 * 
 */
package test;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Map;
import model.PriorityQueue;
import model.SalesRep;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Apr 30, 2021
 */
public class TestDriver {

	private static SalesRep[] allReps; 
	private static Map repMap;
	static PriorityQueue paylist;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create class objects in app
				allReps = new SalesRep[10000];
				repMap = new Map(10000); 
				paylist = new PriorityQueue();
				
				// create sales reps 
				SalesRep one = new SalesRep("Joe", "Dirt");
				SalesRep two = new SalesRep("Harry", "Kerry");
				SalesRep three = new SalesRep("Jo", "Anne");
				SalesRep four = new SalesRep("Ricco", "Suave");
				SalesRep five = new SalesRep("Dennis", "Menace");
				SalesRep six = new SalesRep("Lara", "Croft");
				SalesRep seven = new SalesRep("Peter", "Parker");
				SalesRep eight = new SalesRep("Rex", "Jones");
				SalesRep nine = new SalesRep("Vanilla", "Ice");
				SalesRep ten = new SalesRep("Sy", "Anora");
				
				
				// add all the sales reps
				addRep(one);
				addRep(two);
				addRep(three);
				addRep(four);
				addRep(five);
				addRep(six);
				addRep(seven);
				addRep(eight);
				addRep(nine);
				addRep(ten);
		
		
	}

}
