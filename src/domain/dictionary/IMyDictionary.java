package domain.dictionary;

public interface IMyDictionary<T1, T2> {
	/**
	 * Gets the value associated to a variable.
	 * 
	 * @param var
	 * String, which must be exactly the name of the variable.
	 * 
	 * @return
	 * Int, representing the value associated to the variable.
	 * 
	 * @throws
	 * MyEx If the variable doesn't exist.
	 */
	T2 lookup(T1 var);
	/**
	 * Creates a new variable and adds it to the dictionary.
	 * 
	 * @param name
	 * String, which represents the name of the new variable.
	 * @param value
	 * Int, which represents the value of the new variable.
	 * 
	 * @return
	 * Nothing.
	 * 
	 * @throws
	 * MyEx if the variable already exists.
	 */
	void addVar(T1 name, T2 value);
	/**
	 * Checks whether a string of characters has a value associated to it(i.e. is a variable).
	 * 
	 * @param name
	 * String, which represents the name which needs to be checked.
	 * 
	 * @return
	 * Int, -1 if the variable doesn't exist or a number >= 0 if it does.
	 */
	T2 isVar(String name);
	/**
	 * Checks whether the Dictionary is empty or not.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Boolean, true if it's empty or false if it has some variables in it.
	 */
	boolean isEmpty();
	/**
	 * Gets the contents of the Dictionary in a string format.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * String, representing the contents of the dictionary formated in the following way:
	 * {variableName1=variableValue1,variableName2=variableValue2,...}
	 */
	String toStr();
	/**
	 * Updates the value of an existing the variable.
	 * 
	 * @param id
	 * String, represents the exact name of the variable.
	 * @param val
	 * Int, represents the new value of the variable.
	 * 
	 * @return
	 * Nothing
	 * 
	 * @throws
	 * MyEx if the variable doesn't exist.
	 */
	void updateVar(T1 id, T2 val);
}
