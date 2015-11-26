/**
 * 
 */
package domain.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.dictionary.MyLibDictionary;
import exceptions.MyEx;

/**
 * @author flori
 *
 */
public class MyDictionaryTest {
	
	MyLibDictionary[] temp;
	String s;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new MyLibDictionary[10];
		s = "abcdefghij";
		for(int i = 0; i < 10; ++i){
			temp[i] = new MyLibDictionary();
			temp[i].addVar("" + s.charAt(i), i*2);
		}
	}

	/**
	 * Test method for {@link domain.dictionary.MyDictionary#lookup(java.lang.String)}.
	 */
	@Test
	public void testLookup() {
		for(int i = 0; i < 10; ++i){
			assertEquals(Integer.valueOf(i*2), temp[i].lookup("" + s.charAt(i)));
			try{
				temp[i].lookup("n");
				fail();
			}
			catch(MyEx e){
				return;
			}
		}
	}

	/**
	 * Test method for {@link domain.dictionary.MyDictionary#addVar(java.lang.String, int)}.
	 */
	@Test
	public void testAddVar() {
		for(int i = 0; i < 10; ++i){
			temp[i].addVar("x", i*32);
			assertEquals(Integer.valueOf(i*32), temp[i].lookup("x"));
			try{
				temp[i].addVar("x", i*i*32);
				fail();
			}
			catch(MyEx e){
				return;
			}
		}
	}

	/**
	 * Test method for {@link domain.dictionary.MyDictionary#isVar(java.lang.String)}.
	 */
	@Test
	public void testIsVar() {
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].isVar("" + s.charAt(i)) >= 0);
			assertTrue(temp[i].isVar("z") == -1);
		}
	}

	/**
	 * Test method for {@link domain.dictionary.MyDictionary#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		for(int i = 0; i < 10; ++i){
			assertFalse(temp[i].isEmpty());
			temp[i] = new MyLibDictionary();
			assertTrue(temp[i].isEmpty());
			temp[i].addVar("x", 32);
			assertFalse(temp[i].isEmpty());
		}
	}

	/**
	 * Test method for {@link domain.dictionary.MyDictionary#toStr()}.
	 */
	@Test
	public void testToStr() {
		String tempS;
		for(int i = 0; i < 10; ++i){
			tempS = new String("{");
			tempS = tempS + s.charAt(i) + '=' + i*2;
			tempS = tempS + "}";
			assertEquals(tempS, temp[i].toStr());
			temp[i] = new MyLibDictionary();
			assertEquals("{}", temp[i].toStr());
			temp[i].addVar("x", i*32);
			assertNotEquals("{}", temp[i].toStr());
		}
	}

	/**
	 * Test method for {@link domain.dictionary.MyDictionary#updateVar(java.lang.String, int)}.
	 */
	@Test
	public void testUpdateVar() {
		for(int i = 0; i < 10; ++i){
			temp[i].updateVar("" + s.charAt(i), i*32);
			assertEquals(Integer.valueOf(i*32), temp[i].lookup("" + s.charAt(i)));
			try{
				temp[i].updateVar("y", 32);
				fail();
			}
			catch(MyEx e){
				return;
			}
		}
	}

}
