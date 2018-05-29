package org.univalle.rdf.mapper;

import org.apache.jena.query.*;
import org.apache.jena.sparql.algebra.AlgebraGenerator;
import org.apache.jena.sparql.algebra.Op;

public class TranslationSQ2LQP {

    private String query;

    public TranslationSQ2LQP(String query){
        this.query = query;
    }

    public Op translationSQ2LQP() {
        AlgebraGenerator ag = new AlgebraGenerator();
        Op op = ag.compile(QueryFactory.create(this.query));
        return op;
    }
}
