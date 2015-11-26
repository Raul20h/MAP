/**
 * 
 */
package domain.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;
import domain.stack.MyLibStack;
import domain.stmt.PrintStmt;

/**
 * @author flori
 *
 */
public class MyStackTest {
	
	MyLibStack[] temp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new MyLibStack[10];
		for(int i = 0; i < 10; ++i){
			temp[i] = new MyLibStack();
		}
	}

	/**
	 * Test method for {@link domain.stack.MyStack#push(domain.stmt.IStmt)}.
	 */
	@Test
	public void testPush() {
		PrintStmt tempStmt;
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].isEmpty());
			tempStmt = new PrintStmt(new ConstExp(i));
			temp[i].push(tempStmt);
			assertFalse(temp[i].isEmpty());
			assertEquals(tempStmt, (PrintStmt)temp[i].top());
		}
	}

	/**
	 * Test method for {@link domain.stack.MyStack#pop()}.
	 */
	@Test
	public void testPop() {
		PrintStmt tempStmt[] = new PrintStmt[3];
		for(int i = 0; i < 10; ++i){
			for(int j=0; j < 3; ++j){
				tempStmt[j] = new PrintStmt(new ConstExp(i*(j+1)));
			}
			temp[i].push(tempStmt[0]);
			temp[i].push(tempStmt[1]);
			temp[i].push(tempStmt[2]);
			assertFalse(temp[i].isEmpty());
			for(int j=2; j >= 0; --j){
				assertEquals(tempStmt[j], temp[i].pop());
			}
			assertTrue(temp[i].isEmpty());
		}
	}

	/**
	 * Test method for {@link domain.stack.MyStack#top()}.
	 */
	@Test
	public void testTop() {
		PrintStmt tempStmt[] = new PrintStmt[3];
		for(int i = 0; i < 10; ++i){
			for(int j=0; j < 3; ++j){
				tempStmt[j] = new PrintStmt(new ConstExp(i*(j+1)));
			}
			temp[i].push(tempStmt[0]);
			temp[i].push(tempStmt[1]);
			temp[i].push(tempStmt[2]);
			assertFalse(temp[i].isEmpty());
			for(int j=2; j >= 0; --j){
				assertEquals(tempStmt[2], temp[i].top());
			}
			assertFalse(temp[i].isEmpty());
		}
	}

	/**
	 * Test method for {@link domain.stack.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].isEmpty());
			temp[i].push(new PrintStmt(new ConstExp(i)));
			assertFalse(temp[i].isEmpty());
		}
	}

	/**
	 * Test method for {@link domain.stack.MyStack#toStr()}.
	 */
	@Test
	public void testToStr() {
		PrintStmt tempStmt[] = new PrintStmt[3];
		for(int i = 0; i < 10; ++i){
			for(int j=0; j < 3; ++j){
				tempStmt[j] = new PrintStmt(new ConstExp(i*(j+1)));
			}
				assertEquals("{}", temp[i].toStr());
				temp[i].push(tempStmt[0]);
				assertEquals("{print(" + Integer.toString(i) + ")}", temp[i].toStr());
				temp[i].push(tempStmt[1]);
				assertEquals("{print(" + Integer.toString(i*2) +
						")|" + "print(" + Integer.toString(i) + ")}", temp[i].toStr());
				temp[i].push(tempStmt[2]);
				assertEquals("{print(" + Integer.toString(i*3) +
						")|" + "print(" + Integer.toString(i*2) +
						")|" + "print(" + Integer.toString(i) + ")}", temp[i].toStr());
			
		}
	}

}
