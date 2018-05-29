package org.univalle.rdf.runner.functions;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.util.Collector;

//SolutionMapping - Flat Join Function
public class SM_JF implements FlatJoinFunction<SolutionMapping, SolutionMapping, SolutionMapping> {

	private String key;

	public SM_JF(String k){
		this.key = k;
	}

    @Override
    public void join(SolutionMapping left, SolutionMapping right, Collector<SolutionMapping> out) throws Exception {
		if(left.getMapping().get(key).toString().equals(right.getMapping().get(key).toString())) {
			out.collect(left.union(right));
		}
    }
}
