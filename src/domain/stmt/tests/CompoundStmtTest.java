/**
 * 
 */
package domain.stmt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;
import domain.stmt.CompoundStmt;
import domain.stmt.PrintStmt;

/**
 * @author flori
 *
 */
public class CompoundStmtTest {
	
	CompoundStmt[] temp;
	String s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new CompoundStmt[10];
		for(int i = 0; i < 10; ++i){
			temp[i] = new CompoundStmt(new PrintStmt(new ConstExp(i)), new PrintStmt(new ConstExp(i*2)));
		}
	}

	/**
	 * Test method for {@link domain.stmt.CompoundStmt#getFrst()}.
	 */
	@Test
	public void testGetFrst() {
		for(int i = 0; i < 10; ++i)
			assertTrue(temp[i].getFrst().toStr().equals("print(" + Integer.toString(i) + ')'));
	}

	/**
	 * Test method for {@link domain.stmt.CompoundStmt#getScnd()}.
	 */
	@Test
	public void testGetScnd() {
		for(int i = 0; i < 10; ++i)
			assertTrue(temp[i].getScnd().toStr().equals("print(" + Integer.toString(i*2) + ')'));
	}

	/**
	 * Test method for {@link domain.stmt.CompoundStmt#toStr()}.
	 */
	@Test
	public void testToStr() {
		for(int i = 0; i < 10; ++i){
			String s2 = temp[i].toStr();
			assertTrue(s2.equals("(" + temp[i].getFrst().toStr() + ';' +
					temp[i].getScnd().toStr() + ')'));
		}
	}

}
