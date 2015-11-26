package domain.exp;

import domain.dictionary.IMyDictionary;
import exceptions.MyEx;

/**
 * An extension of the Exp class used to keep track of expression of the form (exp1 o exp2),
 * where exp1 and exp1 are other expressions and o is an operator.
 * 
 * @author flori
 *
 */
public class ArithExp extends Exp{
	Exp e1;
	Exp e2;
	int op; //1 stands for +, 2 for -, 3 for *, 4 for /, 5 for %

	/**
	 * The constructor for the ArithExp class.
	 * 
	 * @param ex1
	 * Exp, the first part of the arithmetic expression.
	 * @param ex2
	 * Exp, the second part of the arithmetic expression.
	 * @param o
	 * Int, the type of the operation.
	 * 1: +, 2: -, 3: *, 4: /, 5: %
	 * 
	 * @return
	 * Nothing
	 * 
	 * @throws
	 * MyEx if the operation type is not one of the numbers mentioned above.
	 */
	public ArithExp(Exp ex1, Exp ex2, int o){
		e1 = ex1;
		e2 = ex2;
		if(o < 1 || o > 5)
			throw new MyEx("ERROR: Invalid arithmetic operation type!");
		op = o;
	}

	/**
	 * Gets the first expression.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Exp, the first expression.
	 */
	public Exp getE1() {
		return e1;
	}

	/**
	 * Gets the second expression.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Exp, the second expression.
	 */
	public Exp getE2() {
		return e2;
	}

	/**
	 * Gets the type of the operation(as its integer code).
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Int, the type of the operation.
	 */
	public int getOp() {
		return op;
	}

	/* (non-Javadoc)
	 * @see domain.exp.Exp#toStr()
	 */
	@Override
	public String toStr(){
		String temp;
		temp = "(" + e1.toStr();
		if(op == 1)
			temp = temp + '+';
		else if (op == 2)
			temp = temp + '-';
		else if (op == 3)
			temp = temp + '*';
		else if (op == 4)
			temp = temp + '/';
		else if (op == 5)
			temp = temp + '%';
		temp = temp + e2.toStr() + ')';
		return temp;
	}

	/* (non-Javadoc)
	 * @see domain.exp.Exp#eval(domain.dictionary.IMyDictionary)
	 */
	@Override
	public int eval(IMyDictionary<String, Integer> tbl) {
		if (op==1) return (e1.eval(tbl) + e2.eval(tbl));
		
		else if (op==2) return (e1.eval(tbl) - e2.eval(tbl));
		
		else if (op==3) return (e1.eval(tbl) * e2.eval(tbl));
		
		else if (op==4){
			if(e2.eval(tbl) == 0)
				throw new MyEx("DIVISION BY ZERO!");
			return (e1.eval(tbl) / e2.eval(tbl));
			
		}
		
		else if (op==5){
			if(e2.eval(tbl) == 0)
				throw new MyEx("DIVISION BY ZERO!");
			return (e1.eval(tbl) % e2.eval(tbl));
		}
		return 0;
	}

}
