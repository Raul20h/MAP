package domain.state;

import domain.dictionary.*;
import domain.list.*;
import domain.stack.*;
import domain.stmt.IStmt;

/**
 * Class used to save the state of a toy language program.
 * Implements the IPrgState interface.
 * 
 * @author flori
 *
 */
public class PrgState implements IPrgState{
	IMyStack<IStmt> exeStack;
	IMyDictionary<String, Integer> symTable;
	IMyList<String> out;
	IStmt original;

	/**
	 * The constructor of the PrgState class.
	 * 
	 * @param prg
	 * IStmt, the raw program.
	 * 
	 * @return
	 * Nothing
	 */
	public PrgState(IStmt prg){
		exeStack = new MyStack();
		symTable = new MyDictionary();
		out = new MyList();
		original = prg;
		exeStack.push(prg);
	}

	/* (non-Javadoc)
	 * @see domain.state.IPrgState#getOriginal()
	 */
	@Override
	public IStmt getOriginal() {
		return original;
	}

	/* (non-Javadoc)
	 * @see domain.state.IPrgState#getSymTbl()
	 */
	@Override
	public IMyDictionary<String, Integer> getSymTbl() {
		return symTable;
	}

	/* (non-Javadoc)
	 * @see domain.state.IPrgState#getStack()
	 */
	@Override
	public IMyStack<IStmt> getStack() {
		return exeStack;
	}

	/* (non-Javadoc)
	 * @see domain.state.IPrgState#getOutput()
	 */
	@Override
	public IMyList<String> getOutput() {
		return out;
	}

	/* (non-Javadoc)
	 * @see domain.state.IPrgState#toStr()
	 */
	@Override
	public String toStr() {
		String temp = "";
		temp = temp + "Stack: " + exeStack.toStr() + '\n';
		temp = temp + "SymTable: " + symTable.toStr() + '\n';
		temp = temp + "Output: " + out.toStr() + '\n';
		return temp;
	}


}
