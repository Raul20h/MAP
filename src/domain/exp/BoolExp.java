package domain.exp;

import domain.dictionary.IMyDictionary;
import exceptions.MyEx;

public class BoolExp extends Exp {
	
	Exp e1, e2;
	int op;
	
	public BoolExp(Exp ex1, Exp ex2, int o) {
		e1 = ex1;
		e2 = ex2;
		op = o;
		if(op < 1 || op > 3)
			throw new MyEx("Invalid type for the boolean expression!");
	}
	
	public int eval(IMyDictionary<String, Integer> tbl){
		if(op == 1){
			if(e1.eval(tbl) == 0 || e2.eval(tbl)== 0)
				return 0;
			return 1;
		}
		
		else if(op == 2){
			if(e1.eval(tbl) != 0 || e2.eval(tbl) != 0)
				return 1;
			return 0;
		}
		
		else if(op == 3){
			if(e1.eval(tbl) == 0)
				return 1;
			return 0;
		}
		else
			throw new MyEx("Unexpected behaviour during the evaluation of the boolean expression!");
	}

	public String toStr(){
		String temp;
		if(op == 3)
			temp = "!(" + e1.toStr() + ")";
		else{
			temp = "(" + e1.toStr();
			if(op == 1)
				temp = temp + "&&";
			else if (op == 2)
				temp = temp + "||";
			temp = temp + e2.toStr() + ')';
		}
		return temp;
	}
}
