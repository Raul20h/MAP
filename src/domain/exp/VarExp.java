package domain.exp;

import domain.dictionary.IMyDictionary;

/**
 * An extension of the Exp class used to keep track of expression of the form S,
 * where S can be any string representing the name of the variable.
 * 
 * @author flori
 *
 */
public class VarExp extends Exp{

	String id;

	/**
	 * The constructor of the VarExp class.
	 * 
	 * @param s
	 * String, represents the name of the variable.
	 * 
	 * @return
	 * Nothing
	 */
	public VarExp(String s){
		id = s;
	}

	/**
	 * Gets the name of the variable as a string of characters.
	 * 
	 * @param
	 * None
	 * 
	 * @return 
	 * String, the name of the variable
	 */
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see domain.exp.Exp#toStr()
	 */
	@Override
	public String toStr(){
		return id;
	}

	/* (non-Javadoc)
	 * @see domain.exp.Exp#eval(domain.dictionary.IMyDictionary)
	 */
	@Override
	public int eval(IMyDictionary<String, Integer> tbl){
		return tbl.lookup(id);
	}
}

