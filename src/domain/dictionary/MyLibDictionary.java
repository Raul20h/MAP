/**
 * 
 */
package domain.dictionary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exceptions.MyEx;

/**
 * @author flori
 *
 */
public class MyLibDictionary implements IMyDictionary<String, Integer> {
	
	Map<String, Integer> m;
	
	public MyLibDictionary() {
		m = new HashMap<>();
	}
	
	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#lookup(java.lang.Object)
	 */
	@Override
	public Integer lookup(String var) {
		if(m.containsKey(var) == false)
			throw new MyEx("Lookup called for a variable which doesn't exist!");
		return m.get(var);
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#addVar(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void addVar(String name, Integer value) {
		m.put(name, value);
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#isVar(java.lang.String)
	 */
	@Override
	public int isVar(String name) {
		boolean x = m.containsKey(name);
		if(x == true)
			return 1;
		return -1;
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return m.isEmpty();
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#toStr()
	 */
	@Override
	public String toStr() {
		if(m.isEmpty())
			return "{}";
		String temp = "{";
		Iterator<String> i = m.keySet().iterator();
		String s;
		while(i.hasNext()){
			s = i.next();
			temp = temp + s + '=' + Integer.toString(m.get(s));
			if(i.hasNext())
				temp = temp + ",";
		}
		temp = temp + "}";
		return temp;
	}

	/* (non-Javadoc)
	 * @see domain.dictionary.IMyDictionary#updateVar(java.lang.String, int)
	 */
	@Override
	public void updateVar(String id, Integer val) {
		this.addVar(id, val);
	}

}
