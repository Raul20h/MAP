package domain.stmt;

/**
 * Class used to represent compound statements. Implements the IStmt interface.
 * 
 * @author flori
 *
 */
public class CompoundStmt implements IStmt{

	IStmt frst, scnd;

	/**
	 * The constructor of the CompoundStmt class.
	 * 
	 * @param a
	 * IStmt, the first part of the compound statement.
	 * @param b
	 * IStmt, the second part of the compound statement.
	 * 
	 * @return
	 * Nothing
	 */
	public CompoundStmt(IStmt a, IStmt b){
		frst = a;
		scnd = b;
	}

	/**
	 * Gets the first part of the compound statement.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the first statement.
	 */
	public IStmt getFrst() {
		return frst;
	}

	/**
	 * Gets the second part of the compound statement.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the second statement.
	 */
	public IStmt getScnd() {
		return scnd;
	}

	/* (non-Javadoc)
	 * @see domain.stmt.IStmt#toStr()
	 */
	@Override
	public String toStr(){
		return '(' + frst.toStr() + ';' + scnd.toStr() + ')';
	}
}
