package org.univalle.rdf.operators;

public class Operator implements ASTNode{

	private String operator;

	public Operator(String operator){
		super();
		this.operator = operator;
	}

	//@Override
	public String execute(){
		return this.operator;
	}
}
