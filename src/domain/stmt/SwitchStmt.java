/**
 * 
 */
package domain.stmt;

import domain.exp.Exp;

/**
 * @author flori
 *
 */
public class SwitchStmt implements IStmt {

	Exp c1, c2;
	IStmt stmt1, stmt2, stmtD;
	String var;
	
	public SwitchStmt(Exp C1, Exp C2, IStmt s1, IStmt s2, IStmt s3, String v){
		c1 = C1;
		c2 = C2;
		stmt1 = s1;
		stmt2 = s2;
		stmtD = s3;
		var = v;
	}
	
	public Exp getCase1(){
		return c1;
	}
	
	public Exp getCase2(){
		return c2;
	}
	
	public IStmt getStmt1(){
		return stmt1;
	}
	
	public IStmt getStmt2(){
		return stmt2;
	}
	
	public IStmt getDefStmt(){
		return stmtD;
	}
	
	public String getVarName(){
		return var;
	}
	
	/* (non-Javadoc)
	 * @see domain.stmt.IStmt#toStr()
	 */
	@Override
	public String toStr() {
		String temp = "";
		temp += "(switch(" + var + ") case(" + c1.toStr();
		temp += "): " + stmt1.toStr() + " case(" + c2.toStr();
		temp += "): " + stmt2.toStr() + " default: " + stmtD.toStr();
		return temp;
	}

}
