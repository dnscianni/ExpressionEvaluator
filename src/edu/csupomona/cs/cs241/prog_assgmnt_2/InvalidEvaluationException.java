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
 * This exception is used when an invalid expression is called in the Calculator
 * class.
 * 
 * @author David Scianni
 * 
 */
public class InvalidEvaluationException extends Exception {

	/**
	 * This is the default serial ID of the InvalidEvaluationException
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor makes the error message 'Ill-formed expression!'.
	 */
	public InvalidEvaluationException() {
		super("Ill-formed expression!");
	}
}
