package org.univalle.rdf.operators;

public class TriplePattern implements ASTNode{

	private SubjectTerm subject;
	private PredicateTerm predicate;
	private ObjectTerm object;

	public TriplePattern(SubjectTerm subject, PredicateTerm predicate, ObjectTerm object){
		super();
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}
	
	//@Override
	public String execute(){
		String subject=getSubject().execute();
		String predicate=getPredicate().execute();
		String object=getObject().execute();
		String triplePattern = "";
		
		if(subject != null) subject="\""+subject+"\"";
		if(predicate != null) predicate="\""+predicate+"\"";
		if(object != null) object="\""+object+"\"";
                
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
}
