package domain.exp;

import java.util.InputMismatchException;
import java.util.Scanner;

import domain.dictionary.IMyDictionary;

public class ReadExp extends Exp {
	
	public int eval(IMyDictionary<String, Integer> tbl){
		try{
			System.out.print("Introduce an integer for the ToyLanguage: ");
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			int x = in.nextInt();
			System.out.print("\n");
			return x;
		}
		catch(InputMismatchException e){
			throw e;
		}
	}

	public String toStr(){
		return "read()";
	}
}
