package org.univalle.rdf.operators;

public class SubjectTerm implements ASTNode{

	private String term;

	public SubjectTerm(String term){
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
}
