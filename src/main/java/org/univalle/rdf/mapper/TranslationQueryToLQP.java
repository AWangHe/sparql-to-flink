package org.univalle.rdf.mapper;

import org.apache.jena.query.*;
import org.apache.jena.sparql.algebra.AlgebraGenerator;
import org.apache.jena.sparql.algebra.Op;

public class TranslationQueryToLQP {

    private String query;

    public TranslationQueryToLQP(String query){
        this.query = query;
    }

    public String translationQueryToLQP() {
        AlgebraGenerator ag = new AlgebraGenerator();
        Op op = ag.compile(QueryFactory.create(this.query));
        return op.toString();
    }
}
