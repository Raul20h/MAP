/**
 * 
 */
package domain.exp.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;

/**
 * @author flori
 *
 */
public class ConstExpTest {
	
	ConstExp[] temp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new ConstExp[10];
		for(int i = 0; i < 10; ++i)
			temp[i] = new ConstExp(i);
	}

	/**
	 * Test method for {@link domain.exp.ConstExp#eval(domain.dictionary.IMyDictionary)}.
	 */
	@Test
	public void testEval() {
		for(int i = 0; i < 10; ++i)
			assertEquals(i, temp[i].eval(null));
	}

	/**
	 * Test method for {@link domain.exp.ConstExp#toStr()}.
	 */
	@Test
	public void testToStr() {
		for(int i = 0; i < 10; ++i)
			assertTrue(temp[i].toStr().equals(Integer.toString(i)));
	}

}
