package org.univalle.rdf.operators;

import java.util.List;
import java.util.Map;

public class Project implements ASTNode{
	
	private Operator operator;
	private List<String> varsProject;

	public Project(Operator operator, List<String> varsProject){
		super();
		this.operator = operator;
		this.varsProject = varsProject;
	}

	//@Override
	public String execute(){
		String queryResult = "";
		if((getOperator().execute()).equals("project")){
			queryResult = "\t\tDataSet<Tuple"+getVarsProject().size()+
                    "<"+listStrings("String", getVarsProject().size())+">> queryResult = "+
                    "setSolutionMapping\n\t\t\t.project("+listIndices(getVarsProject(), 0)+");";
		}
		return queryResult;
	}

	public Operator getOperator(){
		return this.operator;
	}

	public List<String> getVarsProject(){
		return this.varsProject;
	}

    public String listStrings(String list, int i){
        if(i==1){
            return list;
        }else{
            return list+", "+listStrings(list, i-1);
        }
    }

    public String listIndices (List<String> list, int indice) {
        String var = (list.get(indice)).substring(1, (list.get(indice)).length());
        int pos = varsWhere.get(searchIndice(var)).get(var);
        //System.out.println("var: "+var);
        pos = (searchIndice(var)==1) ? pos : pos+2;
        //System.out.println("pos: "+pos);
        if(indice == list.size()-1){
            return String.valueOf(pos);
        }else{
            return String.valueOf(pos)+", "+listIndices(list, indice+1);
        }
    }

    public int searchIndice(String varName){
        int indice=0;
        Boolean flag=false;
        for(Map.Entry<Integer, Map<String, Integer>> sM : varsWhere.entrySet()) {
            //System.out.println("sM.getKey(): "+sM.getKey());
            for (Map.Entry<String, Integer> varPos : sM.getValue().entrySet()) {
                //System.out.println("\tvarPos.getKey(): "+varPos.getKey()+ " --- "+"varPos.getValue(): "+varPos.getValue());
                if (varPos.getKey().equals(varName) && !flag) {
                    indice = sM.getKey();
                    flag = true;
                    break;
                }
            }
        }
        return indice;
    }
}
