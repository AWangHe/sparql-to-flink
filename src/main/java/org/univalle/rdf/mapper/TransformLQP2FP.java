package org.univalle.rdf.mapper;

import org.apache.jena.sparql.algebra.Op;

public class TransformLQP2FP {

    private Op lqp;
    private String cN;
    private String dS;

    public TransformLQP2FP(Op lqp, String dS, String cN){
        this.lqp = lqp;
        this.cN = cN;
        this.dS = dS;
    }

    public String lQP2FP() {
        String fp = "";

        fp += "import org.apache.flink.api.java.DataSet;\n" +
                "import org.apache.flink.api.common.operators.Order;\n" +
                "import org.apache.flink.api.java.ExecutionEnvironment;\n" +
                "import org.apache.jena.datatypes.RDFDatatype;\n" +
                "import org.apache.jena.graph.Triple;\n" +
                "import org.univalle.rdf.runner.functions.*;\n" +
                "import org.univalle.rdf.runner.LoadTransformTriples;\n" +
                "import org.univalle.rdf.runner.functions.order.*;\n" +
                "import java.math.*;\n" +
                "\npublic class "+getNameClass()+" {\n" +
                "\tpublic static void main(String[] args) throws Exception {\n\n" +
                "\t\t//************ Environment (DataSet) and Source (static RDF dataset) ************\n" +
                "\t\tfinal ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();\n" +
                "\t\tDataSet<Triple> dataset = LoadTransformTriples.loadTriplesFromDataset(env, \""+dS+"\");\n\n" +
                "\t\t//************ Applying Transformations ************\n";

        lqp.visit(new ConvertLQP2FP());

        fp += ConvertLQP2FP.getFp();

        fp += "\t\t//************ Sink  ************\n" +
                "\t\tsm"+(SolutionMapping.getIndice()-1)+".print();\n" +
                "\t}\n}";

        return fp;
    }

    public String getNameClass(){
        return this.cN;
    }

}
