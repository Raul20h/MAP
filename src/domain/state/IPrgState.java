package domain.state;

import domain.dictionary.IMyDictionary;
import domain.list.IMyList;
import domain.stack.IMyStack;
import domain.stmt.IStmt;

/**
 * @author flori
 *
 */
public interface IPrgState {
	/**
	 * Gets the original code of the program.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the original program, returned as a statement.
	 */
	IStmt getOriginal();
	/**
	 * Gets the SymTbl associated to the program.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IMyDictionary, the table.
	 */
	IMyDictionary<String, Integer> getSymTbl();
	/**
	 * Gets the stack associated to the program.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IMyStack, the stack.
	 */
	IMyStack<IStmt> getStack();
	/**
	 * Gets the output list associated to the program.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * MyILst, the list.
	 */
	IMyList<String> getOutput();
	/**
	 * Gets the contents of the program state in a string format.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * String, representing the contents of the program state.
	 */
	String toStr();
}
