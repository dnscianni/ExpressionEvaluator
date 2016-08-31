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
 * The ListStack class implements Stack, and uses a LinkedList to hold the items
 * of the stack.
 * 
 * @author David Scianni
 * 
 */
public class ListStack<E> implements Stack<E> {

	/**
	 * The int depth holds the amount of elements that are inside the stack.
	 */
	private int depth;

	/**
	 * The LinkedList theStack is the list that holds all the items, and is used
	 * as a stack.
	 */
	private LinkedList<Integer, E> theStack;

	/**
	 * The constructor sets depth to 0 and will instantiate theStack.
	 */
	public ListStack() {
		depth = 0;
		theStack = new LinkedList<Integer, E>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.csupomona.cs.cs241.prog_assgmnt_2.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(E value) {

		theStack.add(depth++, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.csupomona.cs.cs241.prog_assgmnt_2.Stack#pop()
	 */
	@Override
	public E pop() {

		if (depth == 0) {
			return null;
		}
		--depth;
		return theStack.removeLast();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.csupomona.cs.cs241.prog_assgmnt_2.Stack#peek()
	 */
	@Override
	public E peek() {

		return theStack.getLast();
	}

}
