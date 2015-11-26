package domain.list;

/**
 * @author flori
 *
 */
public interface IMyList<T> {
	/**
	 * Adds a message to the list
	 * 
	 * @param s
	 * String, the message to be added.
	 * 
	 * @return
	 * Nothing
	 */
	void addMsg(T s);
	/**
	 * Gets the most recent message from the list(the message is then removed).
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * String, the message.
	 * 
	 * @throws
	 * MyEx if the list is empty.
	 */
	T getMsg();
	/**
	 * Concatenates all the messages in the list into a single string of characters(the messages aren't
	 * removed).
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * String, containing all the messages in the list(msg1,msg2,...).
	 * 
	 * @throws
	 * MyEx if the list is empty.
	 */
	T getAll();
	/**
	 * Checks whether or not the list is empty.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Boolean, true if the list is empty, false otherwise.
	 */
	boolean isEmpty();
	/**
	 * Gets the number of strings in the list.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Int, the number of strings in the list.
	 */
	int getLength();
	/**
	 * {getAll}
	 * 
	 * @return
	 * String, all the messages surrounded by curly brackets.
	 */
	String toStr();
}
