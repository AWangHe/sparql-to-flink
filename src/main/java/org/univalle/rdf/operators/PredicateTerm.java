package org.univalle.rdf.operators;

public class PredicateTerm implements ASTNode{

	private String term;

	public PredicateTerm(String term){
		super();
		this.term = term;
	}

	//@Override
	public String execute(){
		String t = null;
		if(!(getTerm().charAt(0)=='?'))
			t = getTerm().substring(1, getTerm().length()-1);
		return t;
	}

	public String getTerm(){
		return this.term;
	}

    public String getVarName() {
        return getTerm().substring(1, getTerm().length());
    }
}
