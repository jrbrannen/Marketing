/**
 * 
 */
package model;

/**
 * Creates a new map class to store strings
 * 
 * @author Jeremy Brannen - jrbrannen CIS152 Apr 11, 2021
 */
public class Map {

	private int size;
	private SalesRep mapArray[];

	public Map(int size) {
		super();
		this.size = size;
		mapArray = new SalesRep[size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// method to hash string values to store in an array
	public int hash(String key, int max) {
		int h = 0;
		for (int i = 0; i < key.length(); i++) {
			h += Character.getNumericValue(key.charAt(i));
			h *= (max - 1);
		}
		h = Math.abs(h);
		return h % max;
	}

	/**
	 * Hashes key string to get index value then determines a values indexing
	 * location based on a hash value. It inserts the string value at that index
	 * location in the array
	 * 
	 * @param rep
	 */
	public void insertValue(String key, SalesRep rep) {
		int index = hash(key, size);
		mapArray[index] = rep;

	}

	/**
	 * Hashes key string to get index value uses a key to see if its associated
	 * value is null.
	 * 
	 * @param key
	 * @return true if location is not null. return false if null
	 */
	public boolean hasKey(String key) {

		int index = hash(key, size);
		if (mapArray[index] != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Hashes key string to get index value uses a key to see if its associated
	 * value is null. If it is not null it will return the string value
	 * 
	 * @param key
	 * @return the string value
	 */
	public SalesRep findValue(String key) {

		int index = hash(key, size);
		return mapArray[index];
	}

	/**
	 * Hashes key string to get index value Replaces an index value with null
	 * removing that value from the array
	 * 
	 * @param key
	 */
	public void remove(String key) {
		int index = hash(key, size);
		mapArray[index] = null;
	}

}
