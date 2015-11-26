package domain.stmt;

/**
 * @author flori
 *
 */
public interface IStmt {
	/**
	 * Gets the statement as a string.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * String, representing the contents of the statement. Exact format depends on the type of
	 * the statement.
	 */
	String toStr();
}
