package view;

import java.util.Scanner;

import controller.IController;

import java.util.InputMismatchException;
import domain.exp.*;
import domain.stmt.*;
import exceptions.MyEx;

/**
 * Class used to
 * 
 * @author flori
 *
 */
public class MainMenu implements IMainMenu{

	Scanner in;
	IController ctrl;
	boolean displayFlag;

	/**
	 * The constructor of the MainMenu class.
	 * 
	 * @param c
	 * IController, the controller that the program shall use.
	 * 
	 * @return
	 * None
	 */
	public MainMenu(IController c){
		ctrl = c;
		displayFlag = false;
	}

	/* (non-Javadoc)
	 * @see view.IMainMenu#showMain()
	 */
	public void showMain(){
		in = new Scanner(System.in);
		while(true){
			int o = 0;
			String msg = "1. New program.\n"
					+ "2. Print current program state.\n"
					+ "3. Solve one step for the current program.\n"
					+ "4. Solve all steps for the current program.\n"
					+ "5. Display flag is currently ";
			if(displayFlag == false)
				msg = msg + "OFF";
			else
				msg = msg + "ON";
			msg = msg + ".\n0. Exit.";
			System.out.println(msg);
			try{
				System.out.print("Your option: ");
				o = in.nextInt();
				System.out.print("\n");
				if(o == 1){
					ctrl.getRepo().addPrg(stmtMenu());
				}
				else if (o == 2){
					System.out.println("\nCurrent program state:\n" + ctrl.crtPrgState() + "\n");
				}
				else if (o == 3){
					ctrl.oneStep(ctrl.getRepo().getCrtPrg(), displayFlag);
				}
				else if (o == 4){
					ctrl.allStep(ctrl.getRepo().getCrtPrg(), displayFlag);
				}
				else if (o == 5){
					displayFlag = !displayFlag;
				}
				else if(o == 0)
					break;
				else
					System.out.println("Invalid input!\n");
			}
			catch(InputMismatchException e){
				System.err.println("ERROR: Option must be an integer!");
				return;
			}
			catch(MyEx e){
				System.err.println(e.getMessage());
				return;
			}
		}
		in.close();
	}

	/**
	 * Used to create any implemented type of statement.
	 * Prints a menu and waits for a response from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the statement obtained if the input is valid.
	 * 
	 * @throws
	 * InputMismatchException if the input is not an int.
	 */
	IStmt stmtMenu(){
		while(true){
			int o = 0;
			System.out.println("1. Add assignment statement.\n"
					+ "2. Add print statement.\n"
					+ "3. Add if statement.\n"
					+ "4. Add compound statement.\n"
					+ "5. Add switch statement.\n"
					+ "6. Add while statement.\n"
					+ "7. Add skip statement.\n"
					+ "8. Add if then statement.");
			try{
				System.out.print("Your option: ");
				o = in.nextInt();
				System.out.print("\n");
				if(o == 1)
					return readAsgnStmt();
				else if(o == 2)
					return readPrintStmt();
				else if(o == 3)
					return readIfStmt();
				else if(o == 4)
					return readCompStmt();
				else if(o == 5)
					return readSwitchStmt();
				else if(o == 6)
					return readWhileStmt();
				else if(o == 7)
					return new SkipStmt();
				else if(o == 8)
					return readIfThenStmt();
				else
					System.out.println("Invalid input!\n");
			}
			catch(InputMismatchException e){
				throw e;
			}
		}
	}

	private IfThenStmt readIfThenStmt() {
		System.out.println("Give the if's expression:");
		Exp e = expMenu();
		System.out.println("Give the then statement:");
		IStmt s = stmtMenu();
		return new IfThenStmt(e, s);
	}

	private IStmt readWhileStmt() {
		System.out.println("Give the while's expression:");
		Exp ex = expMenu();
		System.out.println("Give the statement:");
		IStmt st = stmtMenu();
		return new WhileStmt(ex, st);
	}

	/**
	 * Creates an Assignment statement using input from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the statement obtained if the input is valid.
	 * 
	 * @throws
	 * InputMismatchException if the "associated value" is not an int.
	 */
	private IStmt readAsgnStmt(){
		try{
			System.out.print("Give the variable's name: ");
			String s = in.next();
			System.out.println("Associated value: ");
			System.out.print("\n");
			Exp e = expMenu();
			return new AssignStmt(s, e);
		}
		catch(InputMismatchException e){
			throw e;
		}
	}

	/**
	 * Creates a Print statement using input from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the statement obtained if the input is valid.
	 */
	private IStmt readPrintStmt(){
		System.out.println("Give the expression which you want to print:");
		Exp temp = expMenu();
		return new PrintStmt(temp);
	}

	/**
	 * Creates an If statement using input from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the statement obtained if the input is valid.
	 */
	private IStmt readIfStmt(){
		System.out.println("Give the if's expression:");
		Exp e = expMenu();
		System.out.println("Give the then statement:");
		IStmt s1 = stmtMenu();
		System.out.println("Give the else statement:");
		IStmt s2 = stmtMenu();
		return new IfStmt(e, s1, s2);
	}

	/**
	 * Creates a Compound statement using input from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * IStmt, the statement obtained if the input is valid.
	 */
	private IStmt readCompStmt(){
		IStmt temp1, temp2;
		System.out.println("Give the first statement:");
		temp1 = stmtMenu();
		System.out.println("Give the second statement:");
		temp2 = stmtMenu();
		return new CompoundStmt(temp1, temp2);
	}
	
	private IStmt readSwitchStmt(){
		IStmt s1, s2, s3;
		Exp e1, e2;
		String varName;
		System.out.println("Give the name of the variable:");
		varName = in.next();
		System.out.println("Give the first expression:");
		e1 = expMenu();
		System.out.println("Give the second expression:");
		e2 = expMenu();
		System.out.println("Give the first statement:");
		s1 = stmtMenu();
		System.out.println("Give the second statement:");
		s2 = stmtMenu();
		System.out.println("Give the third(default) statement:");
		s3 = stmtMenu();
		return new SwitchStmt(e1, e2, s1, s2, s3, varName);
	}

	/**
	 * Used to create any implemented type of expression.
	 * Prints a menu and waits for a response from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Exp, the statement obtained if the input is valid.
	 * 
	 * @throws
	 * InputMismatchException if the input is not an int.
	 */
	private Exp expMenu(){
		System.out.println("Type of expression?\n"
				+ "1. Constant expression.\n"
				+ "2. Variable expression.\n"
				+ "3. Arithmetic expression.\n"
				+ "4. Relational expression.\n"
				+ "5. Boolean expression.\n"
				+ "6. Read expression.");
		int o;
		try{
			while(true){
				System.out.print("Your option: ");
				o = in.nextInt();
				System.out.print("\n");
				if(o == 1)
					return readConstExp();
				else if(o == 2)
					return readVarExp();
				else if(o == 3)
					return readArithExp();
				else if(o == 4)
					return readRelationalExp();
				else if(o == 5)
					return readBooleanExp();
				else if(o == 6)
					return readReadExp();
				else
					System.out.println("Invalid option!\n");
			}
		}
		catch(InputMismatchException e){
			throw e;
		}
	}

	private ReadExp readReadExp() {
		return new ReadExp();
	}

	private BoolExp readBooleanExp() {
		System.out.print("Give the type of the operation:\n"
				+ "1. &&\n"
				+ "2. ||\n"
				+ "3. !()\n"
				+ "Your option: ");
		try{
			int x = in.nextInt();
			System.out.print("\n");
			Exp temp1, temp2 = null;
			System.out.println("Expression 1: \n");
			temp1 = expMenu();
			if(x != 3){
				System.out.println("Expression 2: \n");
				temp2 = expMenu();
			}
			return new BoolExp(temp1, temp2, x);
		}
		catch(InputMismatchException e){
			throw e;
		}
	}

	/**
	 * Creates a Constant expression using input from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Exp, the expression obtained if the input is valid.
	 * 
	 * @throws
	 * InputMismatchException if the value is not an integer.
	 */
	private ConstExp readConstExp(){
		System.out.print("Give the value: ");
		try{
			int x = in.nextInt();
			return new ConstExp(x);
		}
		catch(InputMismatchException e){
			throw e;
		}
	}

	/**
	 * Creates a Variable expression using input from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Exp, the expression obtained if the input is valid.
	 */
	private VarExp readVarExp(){
		System.out.print("Give the name of the variable: ");
		String temp = in.next();
		return new VarExp(temp);
	}

	/**
	 * Creates an Arithmetic expression using input from the console.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Exp, the expression obtained if the input is valid.
	 * 
	 * @throws
	 * InputMismatchException if the value is not an integer.
	 */
	private ArithExp readArithExp(){
		System.out.print("Give the type of the operation:\n"
				+ "1. +\n"
				+ "2. -\n"
				+ "3. *\n"
				+ "4. /\n"
				+ "5. %\n"
				+ "Your option: ");
		try{
			int x = in.nextInt();
			System.out.print("\n");
			Exp temp1, temp2;
			System.out.println("Expression 1: \n");
			temp1 = expMenu();
			System.out.println("Expression 2: \n");
			temp2 = expMenu();
			return new ArithExp(temp1, temp2, x);
		}
		catch(InputMismatchException e){
			throw e;
		}
	}
	
	private RelationalExp readRelationalExp(){
		System.out.print("Give the type of the operation:\n"
				+ "1. <\n"
				+ "2. <=\n"
				+ "3. ==\n"
				+ "4. !=\n"
				+ "5. >=\n"
				+ "6. >\n"
				+ "Your option: ");
		try{
			int x = in.nextInt();
			System.out.print("\n");
			Exp temp1, temp2;
			System.out.println("Expression 1: \n");
			temp1 = expMenu();
			System.out.println("Expression 2: \n");
			temp2 = expMenu();
			return new RelationalExp(temp1, temp2, x);
		}
		catch(InputMismatchException e){
			throw e;
		}
	}
}
