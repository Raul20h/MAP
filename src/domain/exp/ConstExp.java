package domain.exp;

import domain.dictionary.IMyDictionary;

/**
 * An extension of the Exp class used to keep track of expression of the form n,
 * where n is an integer.
 * 
 * @author flori
 *
 */
public class ConstExp extends Exp{

	int nr;

	/**
	 * The constructor for the ConstExp class.
	 * 
	 * @param n
	 * Int, the integer value of the expression.
	 * 
	 * @return
	 * Nothing
	 */
	public ConstExp(int n){
		nr = n;
	}

	/* (non-Javadoc)
	 * @see domain.exp.Exp#toStr()
	 */
	@Override
	public String toStr(){
		return Integer.toString(nr);
	}

	/* (non-Javadoc)
	 * @see domain.exp.Exp#eval(domain.dictionary.IMyDictionary)
	 */
	@Override
	public int eval(IMyDictionary<String, Integer> tbl){
		return nr;
	}
}

