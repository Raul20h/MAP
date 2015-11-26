package domain.stmt;

import domain.exp.Exp;

public class IfThenStmt implements IStmt {

	Exp exp;
	IStmt stmt;

	/**
	 * The constructor of the IfThenStmt class.
	 * 
	 * @param e
	 * Exp, the expression which needs to be checked.
	 * @param t
	 * IStmt, the statement executed if e is true.
	 * 
	 * @return
	 * Nothing
	 */
	public IfThenStmt(Exp e, IStmt t){
		exp=e;
		stmt=t;
	}

	/**
	 * Gets the if statement's expression.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Exp, the expression.
	 */
	public Exp getExp() {
		return exp;
	}

	/**
	 * Gets the then statement.
	 * 
	 * @return
	 * IStmt, the statement.
	 */
	public IStmt getStmt() {
		return stmt;
	}


	/* (non-Javadoc)
	 * @see domain.stmt.IStmt#toStr()
	 */
	@Override
	public String toStr(){
		return "(IF(" + exp.toStr() + ") THEN(" + stmt.toStr() 
		+ "))";
	}

}
