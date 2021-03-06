package org.univalle.rdf.runner.functions.order;

import org.apache.flink.api.java.functions.KeySelector;
import org.univalle.rdf.runner.functions.SolutionMapping;

// SolutionMapping - Key Selector Order by
public class SM_OKS_Double implements KeySelector<SolutionMapping, Double> {

	private String key;

	public SM_OKS_Double(String k) {
		this.key = k;
	}

	@Override
	public Double getKey(SolutionMapping sm) {
		return Double.parseDouble(sm.getMapping().get(key).getLiteralValue().toString());
	}

}
