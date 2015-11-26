package domain.stack;

/**
 * @author flori
 *
 */
public interface IMyStack<T> {
	/**
	 * Adds a statement to the stack.
	 * 
	 * @param prg
	 * IStmt, the statement which should be added.
	 * 
	 * @return
	 * Nothing
	 */
	void push(T prg);
	/**
	 * Retrieves and removes the statement from the top of the stack.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the top statement.
	 */
	T pop();
	/**
	 * Retrieves the statement from the top of the stack without removing it from the stack.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the top statement.
	 */
	T top();
	/**
	 * Checks whether the stack is empty or not.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Boolean, true if the stack is empty, false otherwise.
	 */
	boolean isEmpty();
	/**
	 * Gets the contents of the Stack in a string format.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * String, representing the contents of the stack formated in the following way:
	 * {Stmt1|Stmt2|...}
	 */
	String toStr();
}
