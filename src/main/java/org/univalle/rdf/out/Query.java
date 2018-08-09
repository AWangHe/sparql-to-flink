package org.univalle.rdf.out;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.core.fs.FileSystem;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.univalle.rdf.runner.functions.*;
import org.univalle.rdf.runner.LoadTransformTriples;
import org.univalle.rdf.runner.functions.order.*;
import java.math.*;

public class Query {
	public static void main(String[] args) throws Exception {

		//************ Environment (DataSet) and Source (static RDF dataset) ************
		final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
		DataSet<Triple> dataset = LoadTransformTriples.loadTriplesFromDataset(env, "/home/acastillo/Documents/git/sparql2flink/sample/dataset.ttl");

		//************ Applying Transformations ************
		DataSet<SolutionMapping> sm1 = dataset
			.filter(new T2T_FF(null, "http://xmlns.com/foaf/0.1/name", null))
			.map(new T2SM_MF("?person", null, "?name"));

		DataSet<SolutionMapping> sm2 = dataset
			.filter(new T2T_FF(null, "http://xmlns.com/foaf/0.1/mbox", null))
			.map(new T2SM_MF("?person", null, "?mbox"));

		DataSet<SolutionMapping> sm3 = sm1.leftOuterJoin(sm2)
			.where(new SM_JKS(new String[]{"?person"}))
			.equalTo(new SM_JKS(new String[]{"?person"}))
			.with(new SM_LOJF());

		DataSet<SolutionMapping> sm4 = sm3
			.map(new SM2SM_PF(new String[]{"?person", "?name", "?mbox"}));

		//************ Sink  ************
		sm4.writeAsText("./Query-Flink-Result", FileSystem.WriteMode.OVERWRITE)
			.setParallelism(1);

		sm4.print();
	}
}