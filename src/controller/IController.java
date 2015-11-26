package controller;

import domain.state.IPrgState;
import repository.IRepo;

/**
 * @author flori
 *
 */
public interface IController {
	/**
	 * Completes the next step of the execution of the current program.
	 * 
	 * @param state
	 * Object which represents the active program implements the IPrgState interface.
	 * @param displayFlag
	 * Boolean value. If the displayFlag is set to true, it outputs the changes to the console.
	 * 
	 * @return
	 * Nothing
	 * 
	 * @throws
	 * MyEx if an unforeseen problem occurs during execution or if the stack is empty.
	 */
	void oneStep(IPrgState state, boolean displayFlag);
	/**
	 * Executes the current program in its entirety.
	 * If the displayFlag is set to true, it outputs the changes to the console.
	 * 
	 * @param state
	 * Object which represents the active program implements the IPrgState interface.
	 * @param displayFlag
	 * Boolean value. If the displayFlag is set to true, it outputs the changes to the console.
	 * 
	 * @return
	 * Nothing
	 * 
	 * @throws
	 * MyEx if an unforeseen problem occurs during execution or if the stack is empty.
	 */
	void allStep(IPrgState state, boolean displayFlag);
	/**
	 * Gets a string which details the state of the active program.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * A string containing information about the current state of the program.
	 */
	String crtPrgState();
	/**
	 * Gets the repository.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * An IRepo type reference to the repository.
	 */
	IRepo getRepo();
}
