package org.univalle.rdf.operators;

import java.util.HashMap;
import java.util.Map;

public class TriplesBlock implements ASTNode{

	private Operator operator;
	private TriplePattern triplePattern;

    private Map<String, Integer> varPosTriple;

	public TriplesBlock(Operator operator, TriplePattern triplePattern){
		super();
		this.operator = operator;
		this.triplePattern = triplePattern;
        varPosTriple = new HashMap<String, Integer>();
	}
	
	//@Override
	public String execute(){
		String tripleBlock = "";
		if((getOperator().execute()).equals("triple")){
			tripleBlock = "staticRdfDataset\n\t\t\t.filter(" + triplePattern.execute() + ");\n";
		}
        setVarPosTriple(this.triplePattern.getVarPosTriple());
		return tripleBlock;
	}

	public Operator getOperator(){
		return this.operator;
	}

	public TriplePattern getTriplePattern(){
		return this.triplePattern;
	}

    public void setVarPosTriple(Map<String, Integer> varPosTriple){
        this.varPosTriple = varPosTriple;
    }

    public Map<String, Integer> getVarPosTriple() {
        return this.varPosTriple;
    }
}
