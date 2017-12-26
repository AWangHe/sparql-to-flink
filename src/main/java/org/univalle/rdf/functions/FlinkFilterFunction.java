package org.univalle.rdf.functions;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.tuple.Tuple3;

public class FlinkFilterFunction implements FilterFunction<Tuple3<String, String, String>> {

	String subject, predicate, object = null;

	public FlinkFilterFunction(String subject, String predicate, String object){
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}

	@Override
	public boolean filter(Tuple3<String, String, String> tuple) {
		if(this.subject==null && this.predicate!=null && this.object!=null) {
			return tuple.f1.equals(this.predicate) && tuple.f2.equals(this.object);
		} else if(this.subject!=null && this.predicate==null && this.object!=null) {
			return tuple.f0.equals(this.subject) && tuple.f2.equals(this.object);
		} else if(this.subject!=null && this.predicate!=null && this.object==null) {
			return tuple.f0.equals(this.subject) && tuple.f1.equals(this.predicate);
		} else if(this.subject!=null && this.predicate==null && this.object==null) {
			return tuple.f0.equals(this.subject);
		} else if(this.subject==null && this.predicate!=null && this.object==null) {
			return tuple.f1.equals(this.predicate);
		} else if(this.subject==null && this.predicate==null && this.object!=null) {
			return tuple.f2.equals(this.object);
		} else {
			return true;
		}
	}
}
