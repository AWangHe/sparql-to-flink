package org.univalle.rdf.runner.functions;

import org.apache.flink.api.java.functions.KeySelector;

// SolutionMapping - Key Selector Join
public class SM_JKS implements KeySelector<SolutionMapping, String> {

    private String key;

    public SM_JKS(String k){
        this.key = k;
    }

    @Override
    public String getKey(SolutionMapping sm) {
    	if(sm.getMapping().containsKey(key)) {
			return key;
		} else {
    		return "The key: "+key+" is not a valid key";
		}
    }
}
