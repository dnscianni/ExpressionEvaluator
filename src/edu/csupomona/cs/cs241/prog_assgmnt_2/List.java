/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #2
 *
 * I am to build an expression evaluator that will evaluate 
 * any mathematical equation the user enters.  It should allow 
 * for adding, subtracting, division, and multiplication, as 
 * well as parentheses.  It should also follow the rules of 
 * precedence.
 *
 * David Scianni
 */
package edu.csupomona.cs.cs241.prog_assgmnt_2;

/**
 * The interface List is used to structure the classes BoundedList,
 * UnboundedList, and LinkedList. It uses generics to create a key of type K and
 * a value of type V, in which it will create an Item with a key and value. It
 * will then save Items in the list.
 * 
 * @author David Scianni
 * 
 */
public interface List<K, V> {

	/**
	 * The boolean method will take in a key of generic type K and a value of
	 * generic type V, and it will create an Item with said key and value, and
	 * place it into the list being implemented. The Item will be added to the
	 * end of the list, or after whatever Item was last added, if there is
	 * enough space.
	 * 
	 * @param key
	 *            The key that will be used in Item to keep track of the value
	 * @param value
	 *            The value that the Item holds, which is what the user wants to
	 *            store in the list.
	 * @return true if the Item was added successfully, or false if the Item was
	 *         not able to be added for some reason.
	 */
	public boolean add(K key, V value);

	/**
	 * The get method will get a value from the List, based on the key that is
	 * sent to it. The method will search the List trying to match the key sent
	 * to the key in each item, and when a match is found, it will return the
	 * value of that Item.
	 * 
	 * @param key
	 *            The key used to find the value the user wants to get.
	 * @return The value in the Item with the equivalent key as the key that was
	 *         sent, or null if there were no matching keys.
	 */
	public V get(K key);

	/**
	 * The remove method will get a value from the List, based on the key that
	 * is sent to it, and will then remove the Item that holds that key and
	 * value from the List. The method will search the List trying to match the
	 * key sent to the key in each item, and when a match is found, it will save
	 * the value, and then remove the item, and it will return the value that
	 * was saved.
	 * 
	 * @param key
	 *            The key used to find the value the user wants to remove.
	 * @return The value in the Item with the equivalent key as the key that was
	 *         sent, or null if there were no matching keys.
	 */
	public V remove(K key);

	/**
	 * This remove method will remove the Item that it at the head of the list.
	 * It will also return the value that is in that Item, by first saving the
	 * value, then removing the Item and finally returning the value that was
	 * saved.
	 * 
	 * @return The value in the Item at the head of the List.
	 */
	public V remove();

	/**
	 * This get method will get the value from the Item at the head of the list.
	 * 
	 * @return The value of the Item at the head of the list.
	 */
	public V get();

	/**
	 * The getLast method will get the value from the Item at the end of the
	 * list.
	 * 
	 * @return The value of the Item at the end of the list.
	 */
	public V getLast();

	/**
	 * The removeLast method will remove the Item that it at the end of the
	 * list. It will also return the value that is in that Item, by first saving
	 * the value, then removing the Item and finally returning the value that
	 * was saved.
	 * 
	 * @return The value in the Item at the end of the List.
	 */
	public V removeLast();

	/**
	 * The toArray method will create an array of type V[], and it will
	 * calculate the amount of Items in the list and set the array to that size.
	 * It will then fill the array with all the values of the Items in the list,
	 * starting with the first value, and ending with the last. It will then
	 * return the array.
	 * 
	 * @return The V[] array that holds all the values that are in the List.
	 */
	public V[] toArray();

	/**
	 * The toString method will return a string that is in the format (Key,
	 * Value) -- (Key, Value) -- ... and will contain the info of all the Items
	 * in the List.
	 * 
	 * @return A string containing the keys and values of all the Items in the
	 *         List.
	 */
	public String toString();

	/**
	 * The getKeys method will create an array of type K[], and it will
	 * calculate the amount of Items in the list and set the array to that size.
	 * It will then fill the array with all the keys of the Items in the list,
	 * starting with the first key, and ending with the last. It will then
	 * return the array.
	 * 
	 * @return The K[] array that holds all the keys that are in the List.
	 */
	public K[] getKeys();
}
