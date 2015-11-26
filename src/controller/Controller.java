package controller;

import domain.dictionary.IMyDictionary;
import domain.exp.*;
import domain.list.IMyList;
import domain.stack.IMyStack;
import domain.state.IPrgState;
import domain.stmt.*;
import exceptions.MyEx;
import repository.IRepo;

/**
 * Class which implements the IController interface and has an IRepo field.
 * Used as the controller in the toy language interpreter.
 * 
 * @author flori
 */
public class Controller implements IController{

	IRepo repo;

	/**
	 * Constructor for the controller class.
	 * 
	 * @param r
	 * A repository object which implements the IRepo interface.
	 * 
	 * @return
	 * Nothing
	 */
	public Controller(IRepo r){
		repo = r;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.IController#oneStep(domain.state.IPrgState, boolean)
	 */
	//@SuppressWarnings("unchecked")
	@Override
	public void oneStep(IPrgState state, boolean displayFlag) {
		try{
			if(displayFlag){
				System.out.println("\nProgram state before the step:\n"
						+ this.crtPrgState()
						+ "\n\n ==>\n\n");
			}
			IMyStack<IStmt> stk=state.getStack();
			if(stk.isEmpty())
				throw new MyEx("ERROR: One step failed! Stack is empty!");
			IStmt crtStmt = stk.pop();
			if (crtStmt instanceof CompoundStmt){
				CompoundStmt crtStmt1 = (CompoundStmt) crtStmt;
				stk.push(crtStmt1.getScnd());
				stk.push(crtStmt1.getFrst());
				return;
			}
			else if (crtStmt instanceof AssignStmt){
				AssignStmt crtStmt1 = (AssignStmt) crtStmt;
				Exp exp = crtStmt1.getExp();
				String id = crtStmt1.getId();
				IMyDictionary<String, Integer> symTbl= state.getSymTbl();
				int val = exp.eval(symTbl);
				symTbl.addVar(id,val);
				return;
			}
			else if(crtStmt instanceof PrintStmt){
				PrintStmt crtStmt1 = (PrintStmt) crtStmt;
				Exp exp = crtStmt1.getExp();
				IMyDictionary<String, Integer> symTbl= state.getSymTbl();
				IMyList<String> out = state.getOutput();
				String output = Integer.toString(exp.eval(symTbl));
				out.addMsg(output);
				return;
			}
			else if(crtStmt instanceof IfStmt){
				IfStmt crtStmt1 = (IfStmt) crtStmt;
				Exp exp = crtStmt1.getExp();
				IMyDictionary<String, Integer> symTbl= state.getSymTbl();
				int val = exp.eval(symTbl) ;
				if(val == 0)
					stk.push(crtStmt1.getElseS());
				else
					stk.push(crtStmt1.getThenS());
				return;
			}
			else if(crtStmt instanceof SwitchStmt){
				SwitchStmt crtStmt1 = (SwitchStmt) crtStmt;
				IfStmt if1, if2;
				ArithExp aExp = new ArithExp(new VarExp(crtStmt1.getVarName()), crtStmt1.getCase1(), 2);
				if2 = new IfStmt(aExp, crtStmt1.getDefStmt(), crtStmt1.getStmt1());
				aExp = new ArithExp(new VarExp(crtStmt1.getVarName()), crtStmt1.getCase2(), 2);
				if1 = new IfStmt(aExp, if2, crtStmt1.getStmt2());
				stk.push(if1);
				return;
			}
			else if(crtStmt instanceof WhileStmt){
				WhileStmt crtStmt1 = (WhileStmt) crtStmt;
				IMyDictionary<String, Integer> symTbl= state.getSymTbl();
				int val = crtStmt1.getExp().eval(symTbl);
				if(val == 0)
					return;
				stk.push(new CompoundStmt(crtStmt1.getStmt(), crtStmt1));
				return;
			}
			else if(crtStmt instanceof SkipStmt)
				return;
			else if(crtStmt instanceof IfThenStmt){
				IfThenStmt crtStmt1 = (IfThenStmt) crtStmt;
				stk.push(new IfStmt(crtStmt1.getExp(), crtStmt1.getStmt(), new SkipStmt()));
				return;
			}
		}
		catch(MyEx e){
			throw e;
		}
		finally
		{
			if(displayFlag){
				System.out.println("\nProgram state after the step:\n"
						+ this.crtPrgState()
						+ '\n');
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.IController#allStep(boolean)
	 */
	@Override
	public void allStep(IPrgState state, boolean displayFlag){
		try{
			while(state.getStack().isEmpty() == false){
				oneStep(state, displayFlag);
			}
		}
		catch(MyEx e){
			throw new MyEx("ERROR: Problem occured during execution!(" + e + ")");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.IController#crtPrgState()
	 */
	@Override
	public String crtPrgState() {
		if(repo.getCrtPrg() == null)
			return "No program found.";
		return repo.getCrtPrg().toStr();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.IController#getRepo()
	 */
	@Override
	public IRepo getRepo() {
		return repo;
	}
}
