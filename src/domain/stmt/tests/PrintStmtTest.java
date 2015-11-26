/**
 * 
 */
package domain.stmt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;
import domain.stmt.PrintStmt;

/**
 * @author flori
 *
 */
public class PrintStmtTest {
	
	PrintStmt[] temp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new PrintStmt[10];
		for(int i = 0; i < 10; ++i){
			temp[i] = new PrintStmt(new ConstExp(i*2));
		}
	}

	/**
	 * Test method for {@link domain.stmt.PrintStmt#getExp()}.
	 */
	@Test
	public void testGetExp() {
		for(int i = 0; i < 10; ++i){
			assertEquals(i*2, temp[i].getExp().eval(null));
		}
	}

	/**
	 * Test method for {@link domain.stmt.PrintStmt#toStr()}.
	 */
	@Test
	public void testToStr() {
		for(int i = 0; i < 10; ++i){
			assertEquals("print(" + Integer.toString(i*2) + ")", temp[i].toStr());
		}
	}

}
