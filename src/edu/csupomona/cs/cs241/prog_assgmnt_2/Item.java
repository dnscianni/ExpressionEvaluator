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
 * The Item class is used to store a value of generic type V and a key of
 * generic type K, that will be used in the subclasses of List to store
 * information. Item also has an Item called next in it for the LinkedList, so
 * that it can hold the next Item in the List.
 * 
 * @author David Scianni
 * 
 */
public class Item<K extends Comparable<K>, V> {

	/**
	 * The key of generic type K that will be used to find a specific Item in
	 * the List.
	 */
	protected K key;
	/**
	 * The value of generic type V, which is what the user wants to store in the
	 * list.
	 */
	protected V value;
	/**
	 * The Item that is used in LinkedList that holds the Item that is next in
	 * the list.
	 */
	protected Item<K, V> next;

	/**
	 * The contructor that will set this.key to the key sent in the arguments,
	 * this.value to the value sent in the arguments, and will set next to null.
	 * 
	 * @param key
	 *            The key the user wants the Item to hold
	 * @param value
	 *            The value the user wants the Item to hold
	 */
	public Item(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

}
