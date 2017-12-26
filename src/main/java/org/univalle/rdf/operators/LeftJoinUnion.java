package org.univalle.rdf.operators;

import java.util.List;
import java.util.ArrayList;

public class LeftJoinUnion implements ASTNode{
	
	private Operator operator;
	private List<Bgp> bgp;

	public LeftJoinUnion(Operator operator, List<Bgp> bgp){
		super();
		this.operator = operator;
		this.bgp = bgp;
	}

	//@Override
	public String execute(){
		String groupGraphPattern = "";
        if((getOperator().execute()).equals("leftjoin") || (getOperator().execute()).equals("union")){
			int i=1;
			for(Bgp bGP : getBgp()){
			    if(bGP.getTriplesBlock().size() == 1){
                    String solutionMapping = bGP.execute();
                    groupGraphPattern += solutionMapping.replace("setSolutionMapping", "solutionMapping"+i);
                } /*else if(bGP.getTriplesBlock().size() == 2) {
                    String solutionMapping = bGP.execute();
                    groupGraphPattern += solutionMapping.replace("setSolutionMapping", "solutionMapping"+i);
			        //System.out.println("tamanio lista bgp: "+getBgp().size()+ " -- tamanio lista tripleblock: "+bGP.getTriplesBlock().size());
                }*/
				i++;
			}
            if((getOperator().execute()).equals("leftjoin")){
				groupGraphPattern += "\t\tDataSet<Tuple5<String, String, String, String, String>> setSolutionMapping = solutionMapping1\n" +
                    "\t\t\t.leftOuterJoin(solutionMapping2)\n" +
					"\t\t\t.where(0)\n" +
					"\t\t\t.equalTo(0)\n" +
					"\t\t\t.with(new FlinkLeftOuterJoinFunction());\n\n";
			}else if((getOperator().execute()).equals("union")){
                groupGraphPattern += "\t\tDataSet<Tuple3<String, String, String>> setSolutionMapping = solutionMapping1\n" +
                        "\t\t\t.union(solutionMapping2);\n\n";
            }
        }
        return groupGraphPattern;
	}

	public Operator getOperator(){
		return this.operator;
	}

	public List<Bgp> getBgp(){
		return this.bgp;
	}
}
