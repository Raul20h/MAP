package domain.stmt;

import domain.exp.Exp;

/**
 * Class used to represent print statements. Implements the IStmt interface.
 * 
 * @author flori
 *
 */
public class PrintStmt implements IStmt{

	Exp exp;

	/**
	 * The constructor of the PrintStmt class.
	 * 
	 * @param e
	 * Exp, the expression which should be printed.
	 * 
	 * @return
	 * Nothing
	 */
	public PrintStmt(Exp e){
		exp = e;
	}

	/**
	 * Gets the expression.
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

	/* (non-Javadoc)
	 * @see domain.stmt.IStmt#toStr()
	 */
	@Override
	public String toStr(){
		return "print(" +exp.toStr()+")";
	}

}
