package org.univalle.rdf.mapper;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

import java.nio.file.Path;

public class ExecuteSQ {

    private String query;
    private Path dataset;

    public ExecuteSQ(String query, Path dataset){
        this.query = query;
        this.dataset = dataset;
    }

    public void executeSQ() {
        Model model = FileManager.get().loadModel(dataset.toString());
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSetRewindable results = ResultSetFactory.makeRewindable(qe.execSelect());
        ResultSetFormatter.out(System.out, results);
        results.reset();
        qe.close();
    }
}
