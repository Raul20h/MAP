package domain.stmt;

import domain.exp.Exp;

/**
 * Class which is used to represent assignment statements. Implements the IStmt interface.
 * 
 * @author flori
 *
 */
public class AssignStmt implements IStmt{

	String id;
	Exp exp;

	/**
	 * The constructor of the AssignStmt class.
	 * 
	 * @param s
	 * String, the name of the variable.
	 * @param e
	 * Exp, the new value of the variable.
	 * 
	 * @return
	 * Nothing
	 */
	public AssignStmt(String s, Exp e){
		id = s;
		exp = e;
	}

	/**
	 * Gets the name of the variable.
	 * 
	 * @param
	 * None
	 * 
	 * @return the id
	 * String, the name of the variable.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the value assigned to the variable, as an expression.
	 * 
	 * @param
	 * None
	 * 
	 * @return the expression
	 * Exp, the expression representing the value.
	 */
	public Exp getExp() {
		return exp;
	}

	/* (non-Javadoc)
	 * @see domain.stmt.IStmt#toStr()
	 */
	@Override
	public String toStr(){
		return '(' + id + "=" + exp.toStr() + ')';
	}
}
