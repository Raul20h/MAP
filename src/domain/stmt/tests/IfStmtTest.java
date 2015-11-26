/**
 * 
 */
package domain.stmt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;
import domain.stmt.IfStmt;
import domain.stmt.PrintStmt;

/**
 * @author flori
 *
 */
public class IfStmtTest {
	
	IfStmt[] temp;
	ConstExp[] tempExp;
	PrintStmt[] tempStmt1, tempStmt2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new IfStmt[10];
		tempExp = new ConstExp[10];
		tempStmt1 = new PrintStmt[10];
		tempStmt2 = new PrintStmt[10];
		for(int i = 0; i < 10; ++i){
			tempExp[i] = new ConstExp(i%3);
			tempStmt1[i] = new PrintStmt(new ConstExp(i));
			tempStmt2[i] = new PrintStmt(new ConstExp(i*2));
			temp[i] = new IfStmt(tempExp[i], tempStmt1[i], tempStmt2[i]);
		}
	}

	/**
	 * Test method for {@link domain.stmt.IfStmt#getExp()}.
	 */
	@Test
	public void testGetExp() {
		for(int i = 0; i < 10; ++i){
			assertEquals(tempExp[i], temp[i].getExp());
			assertEquals(i%3, temp[i].getExp().eval(null));
		}
	}

	/**
	 * Test method for {@link domain.stmt.IfStmt#getThenS()}.
	 */
	@Test
	public void testGetThenS() {
		for(int i = 0; i < 10; ++i){
			assertEquals(tempStmt1[i], temp[i].getThenS());
			assertEquals("print(" + Integer.toString(i) + ')', temp[i].getThenS().toStr());
		}
	}

	/**
	 * Test method for {@link domain.stmt.IfStmt#getElseS()}.
	 */
	@Test
	public void testGetElseS() {
		for(int i = 0; i < 10; ++i){
			assertEquals(tempStmt2[i], temp[i].getElseS());
			assertEquals("print(" + Integer.toString(i*2) + ')', temp[i].getElseS().toStr());
		}
	}

	/**
	 * Test method for {@link domain.stmt.IfStmt#toStr()}.
	 */
	@Test
	public void testToStr() {
//		"(IF(" + exp.toStr() + ") THEN(" + thenS.toStr() 
//		+ ") ELSE(" + elseS.toStr() + "))"
		for(int i = 0; i < 10; ++i){
			assertEquals("(IF(" + tempExp[i].toStr() + ") THEN(" + tempStmt1[i].toStr() + 
					") ELSE(" + tempStmt2[i].toStr() + "))", temp[i].toStr());
		}
	}

}
