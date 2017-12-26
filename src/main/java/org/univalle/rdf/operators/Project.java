package org.univalle.rdf.operators;

import java.util.List;

public class Project implements ASTNode{
	
	private Operator operator;
	private List<String> variables;

	public Project(Operator operator, List<String> variables){
		super();
		this.operator = operator;
		this.variables = variables;
	}

	//@Override
	public String execute(){
		String queryResult = "";
                if((getOperator().execute()).equals("project")){
			int i=0;
			String strings="", indices="";
			for(String var : getVariables()){
				strings += "String, ";
				indices += i + ", ";
				i++;
			}
			queryResult = "\t\tDataSet<Tuple"+i+"<"+strings.substring(0, strings.length()-2)+">> queryResult = setSolutionMapping\n"+
                    "\t\t\t.project("+indices.substring(0, indices.length()-2)+");";
                }
                return queryResult;
	}

	public Operator getOperator(){
		return this.operator;
	}

	public List<String> getVariables(){
		return this.variables;
	}
}
