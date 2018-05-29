package org.univalle.rdf.runner.functions;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.jena.graph.Node;

import java.util.Map;

// SolutionMapping - Key Selector Order by
public class SM_OKS implements KeySelector<SolutionMapping, String> {

    private String key;

    public SM_OKS(String k){
        this.key = k;
    }

    @Override
    public String getKey(SolutionMapping sm) {
    	//System.out.println("sm: "+ sm.getMapping());
		/*if(sm.getMapping().containsKey(key)) {
			return key;
		} else {
			return "The key: << "+key+" >> is not a valid key";
		}*/

		String value = null;
		for (Map.Entry<String, Node> hm : sm.getMapping().entrySet()) {
			if(hm.getKey().equals(key)) {
				//value = hm.getValue().getLiteralValue().toString();
				value = hm.getKey();
				break;
			}
		}

		System.out.println("value: "+value);

		//System.out.println("sm.getMapping().get(key): "+sm.getMapping().keySet());

        //return sm.getMapping().get(key).toString();

		return value;

    }
}
