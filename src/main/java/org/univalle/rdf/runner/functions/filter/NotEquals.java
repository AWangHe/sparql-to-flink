package org.univalle.rdf.runner.functions.filter;

import org.apache.jena.graph.Node;
import org.apache.jena.sparql.expr.*;

import java.math.BigDecimal;
import java.util.HashMap;

public class NotEquals{

	Expr arg1 = null;
	Expr arg2 = null;

	public NotEquals(E_NotEquals expresion){
		this.arg1 = expresion.getArg1();
		this.arg2 = expresion.getArg2();
	}

	public boolean eval(HashMap<String, Node> solutionMapping){
		Boolean flag = false;

		Node value_left = solutionMapping.get(arg1.toString());
		Node value_right = null;
		if (arg2.isConstant()) {
			value_right = arg2.getConstant().getNode();
		} else if (arg2.isVariable()) {
			value_right = solutionMapping.get(arg2.toString());
		}

		//System.out.println("NotEquals: " + arg1.toString() + "--" + arg2.toString() + " **** " + value_left + " != " + value_right);

		if (!(value_left.getLiteralValue().toString().equals(value_right.getLiteralValue().toString()))) {
			//System.out.println("--- they are NotEquals ---");
			flag = true;
		}

		return flag;
	}
}
