package org.univalle.rdf.runner.functions;

import org.univalle.rdf.runner.functions.filter.FilterConvert;
import org.apache.jena.graph.Node;
import org.apache.jena.sparql.expr.Expr;
import org.apache.jena.sparql.sse.SSE;

import java.util.HashMap;
import java.util.Map;

public class SolutionMapping {

	private HashMap<String, Node> mapping = new HashMap<>();

	public SolutionMapping() {}

	public void SolutionMapping(HashMap<String, Node> sm){
		this.mapping = sm;
	}

	public HashMap<String, Node> getMapping(){
		return mapping;
	}

	public void putMapping(String var, Node val) {
		mapping.put(var, val);
	}

	public Node getValue(String var){ //Revisar ... se puede simplificar
		/*String v = null;
		for (Map.Entry<String, Node> m : mapping.entrySet()) {
			if (m.getKey().equals(var)) {
				v = m.getValue().toString();
			}
		}
		return v;*/
		return mapping.get(var);
	}

	public boolean existMapping(String var, Node val){
		Boolean flag = false;
		//for (Map.Entry<String, Node> hm : mapping.entrySet()) {
			//if(hm.getKey().equals(var) && hm.getValue().equals(val)) {
			if(mapping.containsKey(var)) {
				if(mapping.get(var).equals(val)) {
					flag = true;
					//break;
				}
			}
		//}
		return flag;
	}

	public SolutionMapping union(SolutionMapping sm){
		if(sm != null) {
			for (Map.Entry<String, Node> hm : sm.getMapping().entrySet()) {
				if (!existMapping(hm.getKey(), hm.getValue())) {
					this.putMapping(hm.getKey(), hm.getValue());
				}
			}
		}
		return this;
	}

	public SolutionMapping project(String[] vars){
		SolutionMapping sm = new SolutionMapping();
		for (String var : vars) {
			for (Map.Entry<String, Node> hm : this.getMapping().entrySet()) {
				if(hm.getKey().equals(var)) {
					sm.putMapping(hm.getKey(), hm.getValue());
					break;
				}
			}
		}
		return sm;
	}

	public boolean filter(String expression){
		Expr expr = SSE.parseExpr(expression);
		return FilterConvert.convert(expr, this.getMapping());
	}

	@Override
	public String toString() {
		String sm="";
		for (Map.Entry<String, Node> hm : mapping.entrySet()) {
			sm += hm.getKey() + "-->" + hm.getValue().toString() + "\t";
		}
		return sm;
	}
}
