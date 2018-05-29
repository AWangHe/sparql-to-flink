package org.univalle.rdf.runner.functions.order;

import org.apache.flink.api.java.functions.KeySelector;
import org.univalle.rdf.runner.functions.SolutionMapping;

// SolutionMapping - Key Selector Order by
public class SM_OKS_String implements KeySelector<SolutionMapping, String> {

	private String key;

	public SM_OKS_String(String k) {
		this.key = k;
	}

	@Override
	public String getKey(SolutionMapping sm) {
		return sm.getMapping().get(key).getLiteralValue().toString();
	}

}
