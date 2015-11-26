/**
 * 
 */
package domain.stmt;

import domain.exp.Exp;

/**
 * @author flori
 *
 */
public class WhileStmt implements IStmt {

	Exp ex;
	IStmt st;
	
	public WhileStmt(Exp e, IStmt s){
		ex = e;
		st = s;
	}
	
	public Exp getExp(){
		return ex;
	}
	
	public IStmt getStmt(){
		return st;
	}
	
	/* (non-Javadoc)
	 * @see domain.stmt.IStmt#toStr()
	 */
	@Override
	public String toStr() {
		String temp = "";
		temp += "(while(" + ex.toStr() + "): " + st.toStr() + ")";
		return temp;
	}

}
