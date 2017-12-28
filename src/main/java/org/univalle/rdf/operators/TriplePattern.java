package org.univalle.rdf.operators;

import java.util.HashMap;
import java.util.Map;

public class TriplePattern implements ASTNode{

	private SubjectTerm subject;
	private PredicateTerm predicate;
	private ObjectTerm object;

    private Map<String, Integer> varPosTriple;

	public TriplePattern(SubjectTerm subject, PredicateTerm predicate, ObjectTerm object){
		super();
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
        varPosTriple = new HashMap<String, Integer>();
	}
	
	//@Override
	public String execute(){
		String subject=getSubject().execute();
		String predicate=getPredicate().execute();
		String object=getObject().execute();
		String triplePattern = "";

        if(subject != null){
            subject="\""+subject+"\"";
        }else{
            setVarPos(this.subject.getVarName(), 0);
        }
        if(predicate != null){
            predicate="\""+predicate+"\"";
        }else{
            setVarPos(this.predicate.getVarName(), 1);
        }
        if(object != null){
            object="\""+object+"\"";
        }else{
            setVarPos(this.object.getVarName(), 2);
        }
                
		triplePattern = "new FlinkFilterFunction("+subject+", "+predicate+", "+object+")";
		
		return triplePattern;
	}

	public SubjectTerm getSubject(){
	    return this.subject;
	}

	public PredicateTerm getPredicate(){
        return this.predicate;
    }

	public ObjectTerm getObject(){
        return this.object;
    }

    public void setVarPos(String var, Integer pos){
        varPosTriple.put(var, pos);
    }

    public Map<String, Integer> getVarPosTriple() {
        return varPosTriple;
    }
}
