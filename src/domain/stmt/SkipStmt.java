package domain.stmt;

public class SkipStmt implements IStmt {

	@Override
	public String toStr() {
		return "(skip)";
	}

}
