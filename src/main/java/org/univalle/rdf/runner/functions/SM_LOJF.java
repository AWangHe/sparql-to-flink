package org.univalle.rdf.runner.functions;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.util.Collector;

//SolutionMapping - Flat - LeftOuterJoin Function
public class SM_LOJF implements FlatJoinFunction<SolutionMapping, SolutionMapping, SolutionMapping> {

	private String key;

	public SM_LOJF(String k){
		this.key = k;
	}

    @Override
    public void join(SolutionMapping left, SolutionMapping right, Collector<SolutionMapping> out) throws Exception {
		//System.out.println("left: "+left.toString()+" --- right: "+right.toString());
		if(left.getMapping().get(key).toString().equals(right.getMapping().get(key).toString())) {
			out.collect(left.union(right));
		} else {
			out.collect(left.union(null));
		}
    }
}
