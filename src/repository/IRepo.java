package repository;

import domain.state.IPrgState;
import domain.stmt.IStmt;

/**
 * @author flori
 *
 */
public interface IRepo {
	/**
	 * Adds a new program to the repository.
	 * 
	 * @param prg
	 * IStmt, the program represented as a statement.
	 * 
	 * @return
	 * Nothing
	 */
	void addPrg(IStmt prg);
	/**
	 * Gets the program which is currently active.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IPrgState, the program.
	 */
	IPrgState getCrtPrg();
	/**
	 * Makes the next program active and the current one inactive.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Nothing
	 */
	void moveToNextProg();
	/**
	 * Gets the total number of programs in the repository.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Int, the number of programs.
	 */
	int getPrgCount();
}
