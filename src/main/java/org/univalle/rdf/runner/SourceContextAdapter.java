package org.univalle.rdf.runner;

import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.functions.source.SourceFunction.SourceContext;
import org.apache.jena.graph.Triple;
import org.apache.jena.riot.system.StreamRDFBase;

public class SourceContextAdapter extends StreamRDFBase {

	private SourceContext<Tuple3<String, String, String>> ctx;

	public SourceContextAdapter(SourceContext<Tuple3<String, String, String>> ctx){
		this.ctx = ctx;
	}

	@Override
	public void triple(Triple t){
		ctx.collect(new Tuple3<>(t.getSubject().toString(), t.getPredicate().toString(), t.getObject().toString()));
	}

	@Override
	public void finish(){}
}
