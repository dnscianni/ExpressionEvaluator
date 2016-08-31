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
 * The ExpressionEvaluator will take in a string and will use two stacks, one to
 * hold the operators and another to hold the arguments. It will then go through
 * those stacks and evaluate the expression according to the precedence set. The
 * expression it receives must have only numbers parentheses or the operators
 * '+' '-' '*' or '/', and they must have spaces inbetween them all.
 * 
 * @author David Scianni
 * 
 */
public class ExpressionEvaluator {

	/**
	 * The stack args will hold all the argument values of the expression.
	 */
	private Stack<Integer> args = new ListStack<Integer>();

	/**
	 * The stack ops will hold all the operator values of the expression.
	 */
	private Stack<String> ops = new ListStack<String>();

	/**
	 * The boolean parsingNumber will determine if the item being parsed is a
	 * number or an operator. If it's a number it will be {@code true} else, it
	 * will be {@code false}.
	 */
	private boolean parsingNumber = false;

	/**
	 * The boolean nextIsNeg will determine if the next variable should be
	 * converted to a negative.
	 */
	private boolean nextIsNeg = false;

	/**
	 * The boolean lastIsDiv will determine if the last operator that was sent
	 * was a division operator, so that it can evaluate the previous expression
	 * immediately.
	 */
	private boolean lastIsDiv = false;

	/**
	 * The boolean divParen will determine if a division symbol was placed
	 * before a parentheses.
	 */
	private boolean divParen = false;

	/**
	 * The boolean lastIsMult will determine if the last operator that was sent
	 * was a multiplication operator, so that it can evaluate the previous
	 * expression immediately, or after a division, if the next expression is a
	 * division.
	 */
	private boolean lastIsMult = false;

	/**
	 * The boolean multParen will determine if a multiplication symbol was
	 * placed before a parentheses.
	 */
	private boolean multParen = false;

	/**
	 * The int totalParens will help keep track of the total amount of
	 * parentheses in the stack.
	 */
	private int totalParens = 0;

	/**
	 * The int currentParens will keep track of the current amount of
	 * parentheses when a multiplication or division is called before a
	 * parentheses.
	 */
	private int currentParens = 0;

	/**
	 * The eval method will take in a string, will parse the string and then
	 * return the evaluation, which will be a number.
	 * 
	 * @param expr
	 *            The string that holds the expression.
	 * @return the number that is evaluated from the expression.
	 * @throws InvalidEvaluationException
	 *             when an invalid expression is sent.
	 */
	public int eval(String expr) throws InvalidEvaluationException {
		parseExpression(expr);

		return eval();
	}

	/**
	 * The eval method uses recursion to evaluate the expression. It will solve
	 * all the addition, plus any multiplications that could not be solved in
	 * the parser.
	 * 
	 * @return uses recursion to return the final number that results from
	 *         evaluating the expression.
	 * @throws InvalidEvaluationException
	 *             when an invalid expression is sent.
	 */
	private int eval() throws InvalidEvaluationException {
		while (ops.peek() != null) {
			String op = ops.pop();
			int arg2 = args.pop();

			if (op.compareTo("*") == 0) {
				args.push(eval() * arg2);
			} else if (op.compareTo("+") == 0) {
				args.push(eval() + arg2);
			} else {
				throw new InvalidEvaluationException();
			}
		}

		return args.pop();
	}

	/**
	 * The evalParens method uses recursion to evaluate the expression. It will
	 * solve all the addition, plus any multiplications that could not be solved
	 * in the parser. It will only be called when a ')' is found, and will run
	 * until a '(' is found, so that it solves everything in the parentheses.
	 * 
	 * @return uses recursion to return the final number that results from
	 *         evaluating the expression in the parentheses.
	 * @throws InvalidEvaluationException
	 *             when an invalid expression is sent.
	 */
	private int evalParens() throws InvalidEvaluationException {
		while (ops.peek() != "(") {
			String op = ops.pop();
			int arg2 = args.pop();

			if (op.compareTo("*") == 0) {
				args.push(evalParens() * arg2);
			} else if (op.compareTo("+") == 0) {
				args.push(evalParens() + arg2);
			} else {
				throw new InvalidEvaluationException();
			}
		}
		return args.pop();
	}

	/**
	 * The parseExpression method will take in the expression and will take in
	 * every element of the expression and send it to get processed. It will
	 * process the first token first, in case it is a '-'. Then it will
	 * coninuously go through the rest. It will also check if there is a '*'
	 * because this is a special case. It deals with this because it has a lower
	 * precedence than the division, so it must check to make sure the next one
	 * isnt a '/', and if so, it will deal with the division first. Then it
	 * makes sure that it is a valid expression.
	 * 
	 * @param expr
	 *            The string that holds the expression.
	 * @throws InvalidEvaluationException
	 *             when an invalid expression is sent.
	 */
	private void parseExpression(String expr) throws InvalidEvaluationException {
		Scanner sc = new Scanner(expr);

		String firstToken = sc.next();

		parsingNumber = true;
		nextIsNeg = false;

		processFirstToken(firstToken);

		while (sc.hasNext()) {
			if (lastIsMult) {
				String token1 = sc.next();
				if (token1.compareTo("(") == 0) {
					processTailToken(token1);
				} else if (token1.compareTo("-") == 0 && sc.hasNext()) {
					processTailToken(token1);
					token1 = sc.next();
					String token2 = sc.next();
					if (token2.compareTo("/") == 0) {
						lastIsMult = false;
						processTailToken(token1);
						processTailToken(token2);
						token1 = sc.next();
						processTailToken(token1);
						lastIsMult = true;
					} else {
						processTailToken(token1);
						processTailToken(token2);
					}
				} else {
					if (sc.hasNext()) {
						String token2 = sc.next();
						if (token2.compareTo("/") == 0) {
							lastIsMult = false;
							processTailToken(token1);
							processTailToken(token2);
							token1 = sc.next();
							processTailToken(token1);
							lastIsMult = true;
						} else {
							processTailToken(token1);
							processTailToken(token2);
						}
					} else {
						processTailToken(token1);
					}
				}
			} else {
				String token = sc.next();
				processTailToken(token);
			}

		}

		if (parsingNumber && ops.peek() != null) {
			throw new InvalidEvaluationException();
		}

	}

	/**
	 * Used to process all the tokens that aren't the first ones.
	 * 
	 * @param token
	 *            the argument or operation that needs to be processed.
	 * @throws InvalidEvaluationException
	 *             when an invalid expression is sent.
	 */
	private void processTailToken(String token)
			throws InvalidEvaluationException {
		processToken(token, false);
	}

	/**
	 * Used to process the first token.
	 * 
	 * @param firstToken
	 *            the first argument or operation that needs to be processed.
	 * @throws InvalidEvaluationException
	 *             when an invalid expression is sent.
	 */
	private void processFirstToken(String firstToken)
			throws InvalidEvaluationException {
		processToken(firstToken, true);
	}

	/**
	 * This processes each token buy checking if it is an argument or an
	 * operation, and it will push the token in the correct stack. It will also
	 * deal with division, some multiplication, and parentheses by evaluating
	 * them.
	 * 
	 * @param token
	 *            the argument or operation that needs to be processed.
	 * @param isFirst
	 *            true if this is the first token, false if it is not.
	 * @throws InvalidEvaluationException
	 *             when an invalid expression is sent.
	 */
	private void processToken(String token, boolean isFirst)
			throws InvalidEvaluationException {
		if (parsingNumber) {
			try {
				int arg = Integer.parseInt(token);

				if (nextIsNeg) {
					arg *= -1;
					nextIsNeg = false;
				}

				args.push(arg);
				parsingNumber = false;

				if (lastIsDiv) {
					int arg1 = args.pop();
					int arg2 = args.pop();
					ops.pop();
					args.push(arg2 / arg1);
					lastIsDiv = false;
				} else if (lastIsMult) {
					int arg1 = args.pop();
					int arg2 = args.pop();
					ops.pop();
					args.push(arg2 * arg1);
					lastIsMult = false;
				}

			} catch (NumberFormatException nfe) {
				if (token.compareTo("-") == 0) {
					nextIsNeg = true;
				} else if (token.compareTo("(") == 0) {
					if (lastIsDiv) {
						divParen = true;
						lastIsDiv = false;
						currentParens = totalParens;
					} else if (lastIsMult) {
						multParen = true;
						lastIsMult = false;
						currentParens = totalParens;
					}
					ops.push("(");
					totalParens++;
				} else {
					throw new InvalidEvaluationException();
				}
			}
		} else {
			if (token.compareTo("+") != 0 && token.compareTo("-") != 0
					&& token.compareTo(")") != 0 && token.compareTo("/") != 0
					&& token.compareTo("*") != 0) {
				throw new InvalidEvaluationException();
			} else {
				if (token.compareTo("-") == 0) {
					nextIsNeg = true;
					ops.push("+");
					parsingNumber = true;
				} else if (token.compareTo("/") == 0) {
					lastIsDiv = true;
					ops.push("/");
					parsingNumber = true;
				} else if (token.compareTo("*") == 0) {
					lastIsMult = true;
					ops.push("*");
					parsingNumber = true;
				} else if (token.compareTo(")") == 0) {
					totalParens--;
					args.push(evalParens());
					ops.pop();
					if (divParen && currentParens == totalParens) {
						int arg1 = args.pop();
						int arg2 = args.pop();
						ops.pop();
						args.push(arg2 / arg1);
						divParen = false;
					} else if (multParen && currentParens == totalParens) {
						int arg1 = args.pop();
						int arg2 = args.pop();
						ops.pop();
						args.push(arg2 * arg1);
						multParen = false;
					}
				} else {
					ops.push("+");
					parsingNumber = true;
				}
			}

		}

	}

}
