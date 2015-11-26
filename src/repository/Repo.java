package repository;

import domain.state.*;
import domain.stmt.IStmt;
import exceptions.MyEx;

/**
 * Class used as a repository for the toy language interpreter. Implements the IRepo interface.
 * 
 * @author flori
 *
 */
public class Repo implements IRepo{

	IPrgState[] progs;
	int prgCount;
	int crtPrgNr;


	/**
	 * The constructor of the Repo class.
	 * 
	 * @param
	 * None
	 * 
	 * @return
	 * Nothing
	 */
	public Repo(){
		progs = new PrgState[32];
		prgCount = crtPrgNr = 0;
	}

	/* (non-Javadoc)
	 * @see repository.IRepo#addPrg(domain.stmt.IStmt)
	 */
	@Override
	public void addPrg(IStmt prg){
		IPrgState newPrg = new PrgState(prg);
		progs[prgCount] = newPrg;
		++prgCount;
	}

	/* (non-Javadoc)
	 * @see repository.IRepo#getCrtPrg()
	 */
	@Override
	public IPrgState getCrtPrg(){
		if(prgCount == 0)
			throw new MyEx("ERROR: No program found!");
		return progs[crtPrgNr];
	}

	/* (non-Javadoc)
	 * @see repository.IRepo#moveToNextProg()
	 */
	@Override
	public void moveToNextProg() {
		++crtPrgNr;
	}

	/* (non-Javadoc)
	 * @see repository.IRepo#getPrgCount()
	 */
	@Override
	public int getPrgCount() {
		return prgCount;
	}
	
}
