package org.univalle.rdf.functions;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple5;

/**
 * Created by oscar on 7/27/17.
 */

public class FlinkLeftOuterJoinFunction implements JoinFunction<Tuple3<String, String, String>, Tuple3<String, String, String>, Tuple5<String, String, String, String, String>> {
	@Override
	public Tuple5<String, String, String, String, String> join(Tuple3<String, String, String> left, Tuple3<String, String, String> right) throws Exception {
		return new Tuple5<>(left.f0, left.f1, left.f2, right == null ? null : right.f1, right == null ? null : right.f2);
	}
}
