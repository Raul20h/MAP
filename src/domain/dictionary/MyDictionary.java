package domain.dictionary;

import exceptions.MyEx;

/**
 * Class which implements the IMyDictionary interface.
 * Used to keep track of variables for the toy language interpreter.
 * 
 * @author flori
 */
public class MyDictionary implements IMyDictionary<String, Integer> {

	String[] id;
	int[] val;
	int len;


	/**
	 * Constructor for the MyDictionary class.
	 * 
	 * @param 
	 * None
	 * 
	 * @return 
	 * Nothing
	 */
	public MyDictionary(){
		id = new String[64];
		val = new int[64];
		len = 0;
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#lookup(java.lang.String)
	 */
	@Override
	public Integer lookup(String var){
		int search = this.isVar(var);
		if(search >= 0)
			return val[search];
		throw new MyEx("ERROR: Lookup failed! No such variable!");
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#addVar(java.lang.String, int)
	 */
	@Override
	public void addVar(String name, Integer value){
		if(this.isVar(name) >= 0){
			throw new MyEx("ERROR: Problem occured during SymTable operation:"
					+ " addVar -> Variable already exists!");
		}
		id[len] = name;
		val[len] = value;
		++len;
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#isVar(java.lang.String)
	 */
	@Override
	public Integer isVar(String name) {
		for(int i = 0; i < len; ++i)
			if(id[i].equals(name))
				return i;
		return -1;
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if(len == 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#toStr()
	 */
	@Override
	public String toStr() {
		if(this.isEmpty())
			return "{}";
		String temp = "{";
		for(int i = 0; i < len; ++i){
			temp = temp + id[i] + '=' + Integer.toString(val[i]);
			if(i != len-1)
				temp = temp + ",";
		}
		temp = temp + "}";
		return temp;
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#updateVar(java.lang.String, int)
	 */
	@Override
	public void updateVar(String name, Integer value) {
		int pos = this.isVar(name);
		if(pos == -1){
			throw new MyEx("ERROR: Problem occured during SymTable operation:"
					+ " updateVar -> Variable doesn't exist!");
		}
		val[pos] = value;
	}

}
