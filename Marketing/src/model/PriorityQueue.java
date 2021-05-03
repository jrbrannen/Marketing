/**
 * 
 */
package model;

import java.util.LinkedList;

/**
 * @author Jeremy Brannen - jrbrannen CIS152 Mar 8, 2021
 */
public class PriorityQueue {

	private LinkedList<SalesRep> payroll;

	/**
	 * Constructors for Linked List containing Node objects
	 */
	public PriorityQueue() {
		this.payroll = new LinkedList<SalesRep>();
	}

	public PriorityQueue(LinkedList<SalesRep> payroll) {
		this.payroll = payroll;
	}

	/**
	 * Checks to see if the list is empty
	 * 
	 * @return true if empty, else false if not empty
	 */
	public boolean isEmpty() {
		if (payroll.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

//	/**
//	 * Takes a string for the jobs priority and assigns an int value to make
//	 * comparison coding simpler
//	 * 
//	 * @param priority
//	 * @return value
//	 */
//	public int PriorityToIntVal(String priority) {
//		int value = 0;
//		if (priority == 1) {
//			value = 1;
//		}
//		if (priority.equals("B")) {
//			value = 2;
//		}
//		if (priority.equals("C")) {
//			value = 3;
//		}
//		if (priority.equals("D")) {
//			value = 4;
//		}
//		return value;
//
//	}

	/**
	 * accepts an object parameter, if list is empty it adds it to the list. if not
	 * empty it assigns an integer value according to the nodes priority. it then
	 * compares the values to see if it can add it to the front of the list or if it
	 * needs to iterate through the list comparing values until it finds where to
	 * enter it in the list.
	 * 
	 * @param node
	 */
	public void enqueue(SalesRep rep) {
		int count = 0;
		if (payroll.isEmpty()) {
			payroll.add(rep);
//			System.out.println("is empty" + node.toString());
		} else if (!payroll.isEmpty()) {

			SalesRep findNode = payroll.element();

			int elementPriority = findNode.getPriority();
			int objectPriority = rep.getPriority();

			if (elementPriority > objectPriority) {
				payroll.addFirst(rep);
			} else {
				for (SalesRep item : payroll) {
					elementPriority = item.getPriority();
					if (elementPriority <= objectPriority) {
						count++;
					}
				}
				payroll.add(count, rep);
			}
		}
	}

	/**
	 * removes the first element(node) from the list
	 * @return 
	 * 
	 * @throws QueueIsEmptyException
	 */
	public SalesRep dequeue() throws QueueIsEmptyException {
			if (!payroll.isEmpty()) {
				while(!payroll.isEmpty()) {
					return payroll.removeFirst();
				}	
			}else {
				throw new QueueIsEmptyException();
			}
			return null; 			
	}

}
