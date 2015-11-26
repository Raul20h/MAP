/**
 * 
 */
package domain.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.list.MyList;

/**
 * @author flori
 *
 */
public class MyListTest {
	
	MyList[] temp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new MyList[10];
		for(int i = 0; i < 10; ++i){
			temp[i] = new MyList();
		}
	}

	/**
	 * Test method for {@link domain.list.MyList#addMsg(java.lang.String)}.
	 */
	@Test
	public void testAddMsg() {
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].isEmpty());
			temp[i].addMsg("");
			assertFalse(temp[i].isEmpty());
			assertEquals("", temp[i].getMsg());
			assertTrue(temp[i].isEmpty());
			temp[i].addMsg("test123");
			assertFalse(temp[i].isEmpty());
			assertEquals("test123", temp[i].getMsg());
			assertTrue(temp[i].isEmpty());
			temp[i].addMsg("test1");
			assertEquals(1, temp[i].getLength());
			temp[i].addMsg("test2");
			assertEquals(2, temp[i].getLength());
			temp[i].addMsg("test3");
			assertEquals(3, temp[i].getLength());
		}
	}

	/**
	 * Test method for {@link domain.list.MyList#getMsg()}.
	 */
	@Test
	public void testGetMsg() {
		for(int i = 0; i < 10; ++i){
			temp[i].addMsg("a");
			temp[i].addMsg("b");
			assertEquals(2, temp[i].getLength());
			assertEquals("b", temp[i].getMsg());
			assertEquals(1, temp[i].getLength());
			assertEquals("a", temp[i].getMsg());
			assertEquals(0, temp[i].getLength());
		}
	}

	/**
	 * Test method for {@link domain.list.MyList#getAll()}.
	 */
	@Test
	public void testGetAll() {
		for(int i = 0; i < 10; ++i){
			temp[i].addMsg("a");
			temp[i].addMsg("b");
			assertEquals("b,a", temp[i].getAll());
			assertTrue(temp[i].isEmpty());
		}
	}

	/**
	 * Test method for {@link domain.list.MyList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].isEmpty());
			temp[i].addMsg("test");
			assertFalse(temp[i].isEmpty());
		}
	}

	/**
	 * Test method for {@link domain.list.MyList#getLength()}.
	 */
	@Test
	public void testGetLength() {
		for(int i = 0; i < 10; ++i){
			assertEquals(0, temp[i].getLength());
			temp[i].addMsg("test1");
			temp[i].addMsg("test2");
			temp[i].addMsg("test3");
			assertEquals(3, temp[i].getLength());
		}
	}

	/**
	 * Test method for {@link domain.list.MyList#toStr()}.
	 */
	@Test
	public void testToStr() {
		for(int i = 0; i < 10; ++i){
			assertEquals("{}", temp[i].toStr());
			temp[i].addMsg("test1");
			temp[i].addMsg("test2");
			temp[i].addMsg("test3");
			assertEquals("{test3,test2,test1}", temp[i].toStr());
		}
	}

}
