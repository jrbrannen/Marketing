
package model;

/**
 * @author Jeremy Brannen - jrbrannen CIS152 Mar 6, 2021 Creates a node class to
 *         use as an object for the priority queue
 */
public class Node {

	private String priority;
	private int jobNumber;
	private Node next;

	public Node() {

	}

	public Node(int jobNumber, String priority) {
		this.priority = priority;
		this.jobNumber = jobNumber;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}

	@Override
	public String toString() {
		return "Node [priority=" + priority + ", jobNumber=" + jobNumber + "]";
	}

}
