/**
 * 
 */
package domain.exp.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.*;
import domain.dictionary.*;

/**
 * @author flori
 *
 */
public class ArithExpTest {
	
	ArithExp[] temp;
	IMyDictionary<String, Integer> tbl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new ArithExp[5];
		for(int i = 0; i < 5; ++i)
			temp[i] = new ArithExp(new ConstExp(i), new ConstExp(i*2), i+1);
	}

	/**
	 * Test method for {@link domain.exp.ArithExp#eval(domain.dictionary.IMyDictionary)}.
	 */
	@Test
	public void testEval() {
		int[] res = {0, -1, 8, 0, 4};
		for(int i = 0; i < 5; ++i)
			assertEquals(temp[i].eval(tbl), res[i]);
		return;
	}

	/**
	 * Test method for {@link domain.exp.ArithExp#toStr()}.
	 */
	@Test
	public void testToStr() {
		String s;
		s = "(0+0)";
		assertTrue(s.equals(temp[0].toStr()));
		s = "(1-2)";
		assertTrue(s.equals(temp[1].toStr()));
		s = "(2*4)";
		assertTrue(s.equals(temp[2].toStr()));
		s = "(3/6)";
		assertTrue(s.equals(temp[3].toStr()));
		s = "(4%8)";
		assertTrue(s.equals(temp[4].toStr()));
		return;
	}

	/**
	 * Test method for {@link domain.exp.ArithExp#getE1()}.
	 */
	@Test
	public void testGetE1() {
		for(int i = 0; i < 5; ++i)
			assertEquals(temp[i].getE1().eval(tbl), i);
		return;
	}

	/**
	 * Test method for {@link domain.exp.ArithExp#getE2()}.
	 */
	@Test
	public void testGetE2() {
		for(int i = 0; i < 5; ++i)
			assertEquals(temp[i].getE2().eval(tbl), i*2);
		return;
	}

	/**
	 * Test method for {@link domain.exp.ArithExp#getOp()}.
	 */
	@Test
	public void testGetOp() {
		for(int i = 0; i < 5; ++i)
			assertEquals(temp[i].getOp(), i+1);
		return;
	}

}
