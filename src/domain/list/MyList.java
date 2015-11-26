package domain.list;

import exceptions.MyEx;

/**
 * Class used to store output in the toy language interpreter.
 * Implements the IMyList interface.
 * 
 * @author flori
 */
public class MyList implements IMyList<String> {

	String[] output;
	int len;


	/**
	 * The constructor for the MyList class.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Nothing
	 */
	public MyList(){
		output = new String[128];
		len = 0;
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#addMsg(java.lang.String)
	 */
	@Override
	public void addMsg(String s) {
		output[len++] = s;
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#getMsg()
	 */
	@Override
	public String getMsg() {
		if(len == 0)
			throw new MyEx("ERROR: Can't retrieve message. List is empty!");
		return output[--len];
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#getAll()
	 */
	@Override
	public String getAll() {
		String temp = new String();
		int n = len;
		for(int i = 0; i < n; ++i){
			temp = temp + output[i];
			if(i < n-1)
				temp = temp + ",";
		}
		return temp;
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if(len == 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#getLength()
	 */
	@Override
	public int getLength() {
		return len;
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#toStr()
	 */
	@Override
	public String toStr() {
		if(this.isEmpty())
			return "{}";
		String temp = "{";
		temp = temp + this.getAll() + "}";
		return temp;
	}

}
