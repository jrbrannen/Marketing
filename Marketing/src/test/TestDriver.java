/**
 * 
 */
package test;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Map;
import model.PayrollList;
import model.PriorityQueue;
import model.QueueIsEmptyException;
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
	 * @throws QueueIsEmptyException 
	 */
	public static void main(String[] args) throws QueueIsEmptyException {
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
				
				// test to map insert methods and print hash values to test hash method
				repMap.insertValue("JoeDirt", one);
				System.out.println(repMap.hash("JoeDirt", 10000));
				repMap.insertValue("HarryKerry", two);
				System.out.println(repMap.hash("HarryKerry", 10000));
				repMap.insertValue("JoAnne", three);
				repMap.insertValue("RiccoSuave", four);
				System.out.println(repMap.hash("RiccoSuave", 10000));
				repMap.insertValue("DennisMenace", five);
				repMap.insertValue("LaraCroft", six);
				repMap.insertValue("PeterParker", seven);
				repMap.insertValue("RexJones", eight);
				repMap.insertValue("VanillaIce", nine);
				repMap.insertValue("SyAnora", ten);
				
				// test display all
				repMap.displayAll();
		
				// test find value
				System.out.println("\n*******" + repMap.findValue("JoAnne") + "********\n");
				
				// test priority queue
				repMap.findValue("JoeDirt").setPriority(2);
				repMap.findValue("HarryKerry").setPriority(0);
				repMap.findValue("DennisMenace").setPriority(1);
				repMap.findValue("LaraCroft").setPriority(0);
				repMap.findValue("SyAnora").setPriority(2);
				
				// enqueue reps in various order and priorities
				paylist.enqueue(one);
				paylist.enqueue(two);
				paylist.enqueue(five);
				paylist.enqueue(six);
				paylist.enqueue(ten);
				
				// tried dequeing with console but get java.util.ConcurrentModificationException
				//exception that has to do with my hashmap but still works in GUI
				paylist.printQueue();
		
	}

}
