package org.univalle.rdf.operators;

import java.util.List;

public class Bgp implements ASTNode{
	
	private Operator operator;
	private List<TriplesBlock> triplesBlock;

	public Bgp(Operator operator, List<TriplesBlock> triplesBlock){
		super();
		this.operator = operator;
		this.triplesBlock = triplesBlock;
	}

	//@Override
	public String execute(){
		String groupGraphPattern = "";
        if((getOperator().execute()).equals("bgp")){
			if(getTriplesBlock().size() == 1){
                groupGraphPattern = "\t\tDataSet<Tuple3<String, String, String>> setSolutionMapping = "+getTriplesBlock().get(0).execute()+"\n";
                varsWhere.put(1, getTriplesBlock().get(0).getVarPosTriple());
			}else if(getTriplesBlock().size() >= 2){
				int i=1;
                for(TriplesBlock tripleBlock : getTriplesBlock()){
                    groupGraphPattern += "\t\tDataSet<Tuple3<String, String, String>> solutionMapping"+i+" = "+tripleBlock.execute()+"\n";
                    varsWhere.put(i, tripleBlock.getVarPosTriple());
                    i++;
				}
				groupGraphPattern += "\t\tDataSet<Tuple5<String, String, String, String, String>> setSolutionMapping = solutionMapping1\n"+
                    "\t\t\t.join(solutionMapping2)\n" +
					"\t\t\t.where(0)\n" +
					"\t\t\t.equalTo(0)\n" +
					"\t\t\t.with(new FlinkJoinFunction());\n\n";
			}
        }
        return groupGraphPattern;
	}

	public Operator getOperator(){
		return this.operator;
	}

	public List<TriplesBlock> getTriplesBlock(){
		return this.triplesBlock;
	}	
}
