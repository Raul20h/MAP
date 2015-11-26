/**
 * 
 */
package other.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.exp.ConstExp;
import domain.stmt.PrintStmt;
import exceptions.MyEx;
import repository.Repo;

/**
 * @author flori
 *
 */
public class RepoTest {
	
	Repo[] temp;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new Repo[10];
		for(int i = 0; i < 10; ++i){
			temp[i] = new Repo();
		}
	}

	/**
	 * Test method for {@link repository.Repo#addPrg(domain.stmt.IStmt)}.
	 */
	@Test
	public void testAddPrg() {
		PrintStmt prg;
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].getPrgCount() == 0);
			prg = new PrintStmt(new ConstExp(i*2));
			temp[i].addPrg(prg);
			assertTrue(temp[i].getPrgCount() == 1);
			assertEquals("print(" + Integer.toString(i*2) + ")", 
					temp[i].getCrtPrg().getStack().top().toStr());
			assertEquals(temp[i].getCrtPrg().getOriginal(), 
					temp[i].getCrtPrg().getStack().top());
		}
	}

	/**
	 * Test method for {@link repository.Repo#getCrtPrg()}.
	 * This also tests the method moveToNextProg {@link repository.Repo#moveToNextProg()}
	 */
	@Test
	public void testGetCrtPrg() {
		PrintStmt prg1, prg2;
		for(int i = 0; i < 10; ++i){
			assertTrue(temp[i].getPrgCount() == 0);
			prg1 = new PrintStmt(new ConstExp(i*2));
			temp[i].addPrg(prg1);
			prg2 = new PrintStmt(new ConstExp(i*3));
			temp[i].addPrg(prg2);
			assertEquals(prg1, temp[i].getCrtPrg().getStack().top());
			temp[i].moveToNextProg();
			assertEquals(prg2, temp[i].getCrtPrg().getStack().top());
			temp[i] = new Repo();
			try{
				temp[i].getCrtPrg();
				fail();
			}
			catch(MyEx e){
				return;
			}
		}
	}
	
	public void testGetPrgCount(){
		for(int i = 0; i < 10; ++i){
			assertEquals(1, temp[i].getPrgCount());
		}
	}

}
