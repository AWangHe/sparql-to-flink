package org.univalle.rdf.mapper;

import org.apache.jena.query.*;
import org.apache.jena.sparql.algebra.AlgebraGenerator;
import org.apache.jena.sparql.algebra.Op;
import org.apache.jena.sparql.algebra.op.OpDistinct;
import org.apache.jena.sparql.algebra.op.OpOrder;
import org.apache.jena.sparql.algebra.op.OpProject;
import org.apache.jena.sparql.algebra.op.OpSlice;
import org.apache.jena.sparql.algebra.optimize.TransformOrderByDistinctApplication;
import org.apache.jena.sparql.core.Var;

import java.util.List;

public class TranslationSQ2LQP {

    private String query;

    public TranslationSQ2LQP(String query){
        this.query = query;
    }

    public Op translationSQ2LQP() {
        AlgebraGenerator ag = new AlgebraGenerator();
        Op op = ag.compile(QueryFactory.create(this.query));

        if(op instanceof OpSlice) {
            OpSlice opSlice = (OpSlice) op;
            if(opSlice.getSubOp() instanceof OpDistinct) {
                OpDistinct opDistinct = (OpDistinct) opSlice.getSubOp();
                //OpDistinct opDistinct = (OpDistinct) ((OpSlice) op).getSubOp();
                if(opDistinct.getSubOp() instanceof OpProject) {
                    OpProject opProject = (OpProject) opDistinct.getSubOp();
                    if (opProject.getSubOp() instanceof OpOrder) {
                        TransformOrderByDistinctApplication tOBDA = new TransformOrderByDistinctApplication();
                        op = tOBDA.transform(opDistinct, opDistinct.getSubOp());
                        return op = new OpSlice(op, opSlice.getStart(), opSlice.getLength());
                    }
                }
            }
        } else if(op instanceof OpDistinct) {
            OpDistinct opDistinct = (OpDistinct) op;
            if(opDistinct.getSubOp() instanceof OpProject) {
                OpProject opProject = (OpProject) opDistinct.getSubOp();
                if(opProject.getSubOp() instanceof OpOrder) {
                    TransformOrderByDistinctApplication tOBDA = new TransformOrderByDistinctApplication();
                    op = tOBDA.transform(opDistinct, opDistinct.getSubOp());
                }
            }
        }
        return op;
    }
}
