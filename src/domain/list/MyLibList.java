/**
 * 
 */
package domain.list;

import java.util.List;

import exceptions.MyEx;

/**
 * @author flori
 *
 */
public class MyLibList implements IMyList<String> {
	
	List<String> l;
	int current;
	
	public MyLibList(){
		current = 0;
	}
	
	/* (non-Javadoc)
	 * @see domain.list.IMyList#addMsg(java.lang.Object)
	 */
	@Override
	public void addMsg(String s) {
		l.add(s);
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#getMsg()
	 */
	@Override
	public String getMsg() {
		if(l.isEmpty())
			throw new MyEx("Tried to retrieve message from an empty list!");
		String temp = l.get(current++);
		return temp;
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#getAll()
	 */
	@Override
	public String getAll() {
		String temp = "";
		for(int i = current; i < l.size(); ++i){
			temp = temp + l.get(i);
			if(i < l.size()-1)
				temp = temp + ",";
		}
		return temp;
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return l.isEmpty();
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#getLength()
	 */
	@Override
	public int getLength() {
		return l.size();
	}

	/* (non-Javadoc)
	 * @see domain.list.IMyList#toStr()
	 */
	@Override
	public String toStr() {
		String temp = "{";
		temp = temp + this.getAll() + "}";
		return temp;
	}

}
