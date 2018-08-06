package org.univalle.rdf;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.jena.sparql.algebra.Op;
import org.univalle.rdf.mapper.*;

public class Sparql2Flink {

	public static void main(String[] args) throws Exception {
	    Path queryFile=null, datasetFile=null;

        if (args != null && args.length == 2) {
            // read the query file and dataset file from given parameter as input
            queryFile = Paths.get(args[0]);
            datasetFile = Paths.get(args[1]);
        } else {
            // get default query file and dataset
            System.out.println("\nExecuting sample with default Sparql Query and Dataset saved in data directory.\n" +
                    "You should to specify two arguments: query_file and dataset_file separate them by space.\n" +
                    "For example: path_query_file/query_file.rq path_dataset_file/dataset_file");
        }

        LoadSQFile sparqlQueryFile = new LoadSQFile(queryFile.toString());
        String queryString = sparqlQueryFile.loadSQFile();

        TranslationSQ2LQP sq2LQP = new TranslationSQ2LQP(queryString);
        Op lqp = sq2LQP.translationSQ2LQP();

        TransformLQP2FP lqp2FP = new TransformLQP2FP(lqp, datasetFile, queryFile);
        String fp = lqp2FP.lQP2FP();

        CreateFPFile jfp = new CreateFPFile(fp, queryFile);
        jfp.createFPFile();
	}
}
