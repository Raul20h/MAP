/**
 * 
 */
package domain.exp;

import domain.dictionary.IMyDictionary;
import exceptions.MyEx;

/**
 * @author flori
 *
 */
public class RelationalExp extends Exp {
	
	Exp e1;
	Exp e2;
	int op; //1 stands for <, 2 for <=, 3 for ==, 4 for !=, 5 for >=, 6 for >
	
	public RelationalExp(Exp ex1, Exp ex2, int o){
		e1 = ex1;
		e2 = ex2;
		if(o < 1 || o > 6)
			throw new MyEx("ERROR: Invalid relational operation type!");
		op = o;
	}
		
	
	/* (non-Javadoc)
	 * @see domain.exp.Exp#eval(domain.dictionary.IMyDictionary)
	 */
	@Override
	public int eval(IMyDictionary<String, Integer> tbl){
		if (op==1){
			if(e1.eval(tbl) < e2.eval(tbl))
				return 1;
			return 0;
		}
		
		else if (op==2){
			if(e1.eval(tbl) <= e2.eval(tbl))
				return 1;
			return 0;
		}
		
		else if (op==3){
			if(e1.eval(tbl) == e2.eval(tbl))
				return 1;
			return 0;
		}
		
		else if (op==4){
			if(e1.eval(tbl) != e2.eval(tbl))
				return 1;
			return 0;
		}
		
		else if (op==5){
			if(e1.eval(tbl) >= e2.eval(tbl))
				return 1;
			return 0;
		}
		
		else if(op == 6){
			if(e1.eval(tbl) > e2.eval(tbl))
				return 1;
			return 0;
		}
		else
			throw new MyEx("Undefined behaviour in the Relational Expression!");
	}
	
	/* (non-Javadoc)
	 * @see domain.exp.Exp#toStr()
	 */
	@Override
	public String toStr(){
		String temp;
		temp = "(" + e1.toStr();
		if(op == 1)
			temp = temp + "<";
		else if (op == 2)
			temp = temp + "<=";
		else if (op == 3)
			temp = temp + "==";
		else if (op == 4)
			temp = temp + "!=";
		else if (op == 5)
			temp = temp + ">=";
		else if (op == 6)
			temp = temp + ">";
		temp = temp + e2.toStr() + ')';
		return temp;
	}
}
