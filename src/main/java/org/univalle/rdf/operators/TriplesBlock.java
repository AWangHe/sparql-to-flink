package org.univalle.rdf.operators;

public class TriplesBlock implements ASTNode{

	private Operator operator;
	private TriplePattern triplePattern;

	public TriplesBlock(Operator operator, TriplePattern triplePattern){
		super();
		this.operator = operator;
		this.triplePattern = triplePattern;
	}
	
	//@Override
	public String execute(){
		String tripleBlock = "";
		if((getOperator().execute()).equals("triple")){
			tripleBlock = "staticRdfDataset\n\t\t\t.filter(" + triplePattern.execute() + ");\n";
		}
		return tripleBlock;
	}

	public Operator getOperator(){
		return this.operator;
	}

	public TriplePattern getTriplePattern(){
		return this.triplePattern;
	}
}
