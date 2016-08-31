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
 * The Stack interface will take in a generic type E, and will hold that item in
 * a list that follows the LIFO rule.
 * 
 * @author David Scianni
 * 
 */
public interface Stack<E> {

	/**
	 * The push method will take in a value of generic type E and it will add it
	 * to the end of the list.
	 * 
	 * @param value
	 *            the value that is to be added to the end of the list.
	 */
	public void push(E value);

	/**
	 * The pop method will remove the last value inserted into the list and will
	 * return that value.
	 * 
	 * @return the last value in the list.
	 */
	public E pop();

	/**
	 * The peek method will look at the last item put in the list, but will not
	 * remove it from the list.
	 * 
	 * @return the last value in the list.
	 */
	public E peek();
}
