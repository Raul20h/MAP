/**
 * 
 */
package domain.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;
import domain.state.PrgState;
import domain.stmt.PrintStmt;

/**
 * @author flori
 *
 */
public class PrgStateTest {
	
	PrgState temp[];
	PrintStmt[] prg;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new PrgState[10];
		prg = new PrintStmt[10];
		for(int i = 0; i < 10; ++i){
			prg[i] = new PrintStmt(new ConstExp(i*2));
			temp[i] = new PrgState(prg[i]);
			temp[i].getOutput().addMsg(Integer.toString(i*3));
			temp[i].getSymTbl().addVar("x", i*4);
		}
	}

	/**
	 * Test method for {@link domain.state.PrgState#getOriginal()}.
	 */
	@Test
	public void testGetOriginal() {
		for(int i = 0; i < 10; ++i){
			assertEquals(prg[i], temp[i].getOriginal());
		}
	}

	/**
	 * Test method for {@link domain.state.PrgState#getSymTbl()}.
	 */
	@Test
	public void testGetSymTbl() {
		for(int i = 0; i < 10; ++i){
			assertEquals(Integer.valueOf(i*4), temp[i].getSymTbl().lookup("x"));
		}
	}

	/**
	 * Test method for {@link domain.state.PrgState#getStack()}.
	 */
	@Test
	public void testGetStack() {
		for(int i = 0; i < 10; ++i){
			assertEquals(prg[i], temp[i].getStack().top());
		}
	}

	/**
	 * Test method for {@link domain.state.PrgState#getOutput()}.
	 */
	@Test
	public void testGetOutput() {
		for(int i = 0; i < 10; ++i){
			assertEquals(Integer.toString(i*3), temp[i].getOutput().getMsg());
		}
	}
}
