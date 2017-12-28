package org.univalle.rdf.operators;

import java.util.HashMap;
import java.util.Map;

public interface ASTNode{
    public static Map<Integer, Map<String, Integer>> varsWhere = new HashMap<Integer, Map<String,Integer>>();
	public Object execute();
}
