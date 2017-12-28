package org.univalle.rdf;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.tuple.*;
import org.univalle.rdf.operators.*;
import org.univalle.rdf.runner.LoadTransformTriples;

public class Query1b{
	public static void main(String[] args) throws Exception{
		final ExecutionEnvironment bEnv = ExecutionEnvironment.getExecutionEnvironment();
		DataSet<Tuple3<String, String, String>> staticRdfDataset = LoadTransformTriples.loadTriplesFromDataset(bEnv, "/Users/oscar/myapps/data/data.ttl");

		DataSet<Tuple3<String, String, String>> solutionMapping1 = staticRdfDataset
			.filter(new FlinkFilterFunction(null, "http://xmlns.com/foaf/0.1/mbox", "mailto:alice@example.org"));

		DataSet<Tuple3<String, String, String>> solutionMapping2 = staticRdfDataset
			.filter(new FlinkFilterFunction(null, "http://xmlns.com/foaf/0.1/name", null));

		DataSet<Tuple5<String, String, String, String, String>> setSolutionMapping = solutionMapping1
			.join(solutionMapping2)
			.where(0)
			.equalTo(0)
			.with(new FlinkJoinFunction());

		DataSet<Tuple2<String, String>> queryResult = setSolutionMapping
			.project(0, 4);

		queryResult.print();
	}
}

