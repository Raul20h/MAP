/**
 * 
 */
package domain.stmt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;
import domain.exp.Exp;
import domain.stmt.AssignStmt;

/**
 * @author flori
 *
 */
public class AssignStmtTest {
	
	AssignStmt[] temp;
	String s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new AssignStmt[10];
		s = "abcdefghij";
		Exp tempExp;
		for(int i = 0; i < 10; ++i){
			tempExp = new ConstExp(i);
			temp[i] = new AssignStmt("" + s.charAt(i), tempExp);
		}
	}

	/**
	 * Test method for {@link domain.stmt.AssignStmt#getId()}.
	 */
	@Test
	public void testGetId() {
		for(int i = 0; i < 10; ++i){
			assertEquals(1, temp[i].getId().length());
			assertTrue(temp[i].getId().equals("" + s.charAt(i)));
		}
	}

	/**
	 * Test method for {@link domain.stmt.AssignStmt#getExp()}.
	 */
	@Test
	public void testGetExp() {
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].getExp() instanceof ConstExp);
			assertEquals(i, temp[i].getExp().eval(null));
		}
	}

	/**
	 * Test method for {@link domain.stmt.AssignStmt#toStr()}.
	 */
	@Test
	public void testToStr() {
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].toStr().equals("(" + s.charAt(i) + 
					'=' + Integer.toString(i) + ')'));
		}
	}

}
