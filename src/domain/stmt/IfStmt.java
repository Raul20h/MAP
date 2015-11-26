package domain.stmt;

import domain.exp.Exp;

/**
 * Class used to represent if statements. Implements the IStmt interface.
 * @author flori
 *
 */
public class IfStmt implements IStmt{

	Exp exp;
	IStmt thenS, elseS;

	/**
	 * The constructor of the IfStmt class.
	 * 
	 * @param e
	 * Exp, the expression which needs to be checked.
	 * @param t
	 * IStmt, the statement executed if e is true.
	 * @param el
	 * IStmt, the statement executed if e is false.
	 * 
	 * @return
	 * Nothing
	 */
	public IfStmt(Exp e, IStmt t, IStmt el){
		exp=e;
		thenS=t;
		elseS=el;
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
	public IStmt getThenS() {
		return thenS;
	}

	/**
	 * Gets the else statement.
	 * 
	 * @return
	 * IStmt, the statement.
	 */
	public IStmt getElseS() {
		return elseS;
	}

	/* (non-Javadoc)
	 * @see domain.stmt.IStmt#toStr()
	 */
	@Override
	public String toStr(){
		return "(IF(" + exp.toStr() + ") THEN(" + thenS.toStr() 
		+ ") ELSE(" + elseS.toStr() + "))";
	}
}
