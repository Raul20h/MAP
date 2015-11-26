/**
 * 
 */
package domain.exp.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.dictionary.MyLibDictionary;
import domain.exp.VarExp;

/**
 * @author flori
 *
 */
public class VarExpTest {
	
	MyLibDictionary tbl;
	VarExp[] temp;
	String s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new VarExp[10];
		tbl = new MyLibDictionary();
		s = "abcdefghij";
		for(int i = 0; i < 10; ++i){
			temp[i] = new VarExp("" + s.charAt(i));
			tbl.addVar("" + s.charAt(i), i*2);
		}
	}

	/**
	 * Test method for {@link domain.exp.VarExp#eval(domain.dictionary.IMyDictionary)}.
	 */
	@Test
	public void testEval() {
		for(int i = 0; i < 10; ++i){
			assertEquals(i*2, temp[i].eval(tbl));
		}
	}

	/**
	 * Test method for {@link domain.exp.VarExp#toStr()}.
	 */
	@Test
	public void testToStr() {
		for(int i = 0; i < 10; ++i){
			assertEquals("" + s.charAt(i), temp[i].toStr());
		}
	}

	/**
	 * Test method for {@link domain.exp.VarExp#getId()}.
	 */
	@Test
	public void testGetId() {
		for(int i = 0; i < 10; ++i){
			assertEquals("" + s.charAt(i), temp[i].toStr());
		}
	}

}
