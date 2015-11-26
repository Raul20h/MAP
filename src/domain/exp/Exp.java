package domain.exp;

import domain.dictionary.IMyDictionary;

/**
 * Base class from which more specific types of expressions are derived.
 * 
 * @author flori
 *
 */
public class Exp {

	/**
	 * Evaluates the expression, returning its numeric value.
	 * 
	 * @param tbl
	 * The Table of Symbols used by the interpreter to store variables. It is needed
	 * for Variable Expressions.
	 * 
	 * @return
	 * Int, the final value of the expression after evaluation.
	 */
	public int eval(IMyDictionary<String, Integer> tbl){
		return 0;
	}

	/**
	 * Gets the expression without evaluating it.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * String, the raw version of the expression.
	 */
	public String toStr(){
		return "";
	}
}
