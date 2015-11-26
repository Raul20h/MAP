package exceptions;

public class MyEx extends RuntimeException{
	
	public MyEx() {}
	
	public MyEx(String s){
		super(s);
	}
	
	private static final long serialVersionUID = 1L;
	
}
