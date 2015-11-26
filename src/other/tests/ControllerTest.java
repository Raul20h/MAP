/**
 * 
 */
package other.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import domain.exp.ConstExp;
import domain.exp.VarExp;
import domain.stmt.AssignStmt;
import domain.stmt.CompoundStmt;
import domain.stmt.PrintStmt;
import exceptions.MyEx;
import repository.*;

/**
 * @author flori
 *
 */
public class ControllerTest {
	
	Controller[] temp;
	IRepo[] testRepo;
	CompoundStmt[] testStmt;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp = new Controller[10];
		testRepo = new IRepo[10];
		testStmt = new CompoundStmt[10];
		for(int i = 0; i < 10; ++i){
			testRepo[i] = new Repo();
			testStmt[i] = new CompoundStmt(new AssignStmt("a", new ConstExp(i)),
					new PrintStmt(new VarExp("a")));
			testRepo[i].addPrg(testStmt[i]);
			temp[i] = new Controller(testRepo[i]);
		}
	}

	/**
	 * Test method for {@link controller.Controller#oneStep(domain.state.IPrgState, boolean)}.
	 */
	@Test
	public void testOneStep() {
		for(int i = 0; i < 10; ++i){
			assertFalse(temp[i].getRepo().getCrtPrg().getStack().isEmpty());
			temp[i].oneStep(temp[i].getRepo().getCrtPrg(), false);
			assertEquals(testStmt[i].getFrst(), temp[i].getRepo().getCrtPrg().getStack().top());
			assertTrue(temp[i].getRepo().getCrtPrg().getSymTbl().isEmpty());
			temp[i].oneStep(temp[i].getRepo().getCrtPrg(), false);
			assertFalse(temp[i].getRepo().getCrtPrg().getSymTbl().isEmpty());
			assertEquals(testStmt[i].getScnd(), temp[i].getRepo().getCrtPrg().getStack().top());
			assertTrue(temp[i].getRepo().getCrtPrg().getOutput().isEmpty());
			temp[i].oneStep(temp[i].getRepo().getCrtPrg(), false);
			assertTrue(temp[i].getRepo().getCrtPrg().getStack().isEmpty());
			assertFalse(temp[i].getRepo().getCrtPrg().getOutput().isEmpty());
			try{
				temp[i] = new Controller(new Repo());
				temp[i].oneStep(temp[i].getRepo().getCrtPrg(), false);
				fail();
			}
			catch(MyEx e){
				return;
			}
		}
	}

	/**
	 * Test method for {@link controller.Controller#allStep(boolean)}.
	 */
	@Test
	public void testAllStep() {
		for(int i = 0; i < 10; ++i){
			assertFalse(temp[i].getRepo().getCrtPrg().getStack().isEmpty());
			temp[i].allStep(temp[i].getRepo().getCrtPrg(), false);
			assertTrue(temp[i].getRepo().getCrtPrg().getStack().isEmpty());
			assertFalse(temp[i].getRepo().getCrtPrg().getOutput().isEmpty());
			assertFalse(temp[i].getRepo().getCrtPrg().getSymTbl().isEmpty());
			try{
				temp[i] = new Controller(new Repo());
				temp[i].allStep(temp[i].getRepo().getCrtPrg(), false);
				fail();
			}
			catch(MyEx e){
				return;
			}
		}
	}

	/**
	 * Test method for {@link controller.Controller#getRepo()}.
	 */
	@Test
	public void testGetRepo() {
		for(int i = 0; i < 10; ++i){
			assertEquals(testRepo[i], temp[i].getRepo());
		}
	}

}
