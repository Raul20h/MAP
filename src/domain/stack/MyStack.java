package domain.stack;

import domain.stmt.*;

/**
 * Class used as the stack by the toy language interpreter. Implements the IMyStack interface.
 * 
 * @author flori
 *
 */
public class MyStack implements IMyStack<IStmt>{

	IStmt[] stk;
	int prgCount;


	/**
	 * The constructor of the MyStack class.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Nothing
	 */
	public MyStack(){
		stk = new IStmt[64];
		prgCount = 0;
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#push(domain.stmt.IStmt)
	 */
	@Override
	public void push(IStmt prg){
		stk[++prgCount] = prg;
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#pop()
	 */
	@Override
	public IStmt pop(){
		return stk[prgCount--];
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#top()
	 */
	@Override
	public IStmt top(){
		return stk[prgCount];
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if(prgCount == 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#toStr()
	 */
	@Override
	public String toStr() {
		if(this.isEmpty())
			return "{}";
		String temp = "{";
		for(int i = prgCount; i > 0; --i){
			temp = temp + stk[i].toStr();
			if(i > 1)
				temp = temp + "|";
		}
		temp = temp + "}";
		return temp;
	}
}
