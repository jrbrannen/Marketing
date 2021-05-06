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
		super();
		this.payroll = payroll;
	}

	public LinkedList<SalesRep> getPayroll() {
		return payroll;
	}

	public void setPayroll(LinkedList<SalesRep> payroll) {
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

	/**
	 * accepts an object parameter, if list is empty it adds it to the list. if not
	 * empty it checks the objects priority. it then looks at the elements priority and
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
			System.out.println("is empty" + rep.toString());
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
	 * removes the first element(S) from the list
	 * @return a sales rep object
	 * @throws QueueIsEmptyException
	 */
	public SalesRep dequeue() throws QueueIsEmptyException {
			if (!payroll.isEmpty()) {
				System.out.println("dequing");
				return payroll.removeFirst();
			}else {
				throw new QueueIsEmptyException();
			}			
	}

}
