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

import java.util.Scanner;

/**
 * The Calculator class contains the main for this project, and will be the
 * interface the user uses to evaluate their expressions.
 * 
 * @author David Scianni
 * 
 */
public class Calculator {

	/**
	 * The main method will create a string to hold the argument, and an
	 * evaluator to evaluate the argument. It will then go through a loop asking
	 * the user for an argument until the user types in 'quit' to quit the
	 * program. If an exception is thrown, it will catch it and send the error
	 * message, but will continue to run the program until the user quits.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String str;
		Scanner scn = new Scanner(System.in);
		ExpressionEvaluator exp = new ExpressionEvaluator();

		while (true) {
			System.out.println("Enter an argument or \'quit\': ");
			str = scn.nextLine();

			if (str.compareTo("quit") == 0) {
				System.out.println("Have a nice day.");
				System.exit(0);
			}
			try {
				System.out.println(exp.eval(str));
			} catch (InvalidEvaluationException e) {
				System.out.println(e.getMessage());
				System.out.println("Try again.\n");
			}
			System.out.println("\n");
		}

	}

}
