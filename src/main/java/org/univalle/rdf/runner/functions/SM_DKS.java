package org.univalle.rdf.runner.functions;

import org.apache.flink.api.java.functions.KeySelector;

// SolutionMapping - Distinct Key Selector
public class SM_DKS implements KeySelector<SolutionMapping, String> {

    @Override
    public String getKey(SolutionMapping sm) {
    	//System.out.println("getMapping: "+sm.getMapping().toString());
        return sm.getMapping().toString();
    }
}
