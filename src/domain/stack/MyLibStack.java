/**
 * 
 */
package domain.stack;

import java.util.Stack;

import domain.stmt.IStmt;
import exceptions.MyEx;

/**
 * @author flori
 *
 */
public class MyLibStack implements IMyStack<IStmt> {
	
	Stack<IStmt> stk;

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#push(java.lang.Object)
	 */
	@Override
	public void push(IStmt prg) {
		stk.push(prg);
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#pop()
	 */
	@Override
	public IStmt pop() {
		if(stk.isEmpty())
			throw new MyEx("Tried to pop an element from an empty stack!");
		return stk.pop();
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#top()
	 */
	@Override
	public IStmt top() {
		if(stk.isEmpty())
			throw new MyEx("Tried to look at the top element from an empty stack!");
		return stk.peek();
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return stk.isEmpty();
	}

	/* (non-Javadoc)
	 * @see domain.stack.IMyStack#toStr()
	 */
	@Override
	public String toStr() {
		@SuppressWarnings("unchecked")
		Stack<IStmt> tempStk = (Stack<IStmt>) stk.clone();
		String temp = "{";
		while(tempStk.isEmpty() == false){
			temp = temp + tempStk.pop().toStr();
			if(tempStk.isEmpty() == false)
				temp = temp + "|";
		}
		temp = temp + '}';
		return temp;
	}

}
