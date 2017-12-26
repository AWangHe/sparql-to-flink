package org.univalle.rdf.mapper;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.univalle.rdf.compiler.SparqlLexer;
import org.univalle.rdf.compiler.SparqlParser;

public class TransformLQPToFP {

    private String lqp;
    private String nC;
    private String dS;

    public TransformLQPToFP(String lqp, String dS, String nC){
        this.lqp = lqp;
        this.nC = nC;
        this.dS = dS;
    }

    public String lQPToFlinkOperator(){
        SparqlLexer lexer = new SparqlLexer(new ANTLRInputStream(this.lqp));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SparqlParser parser = new SparqlParser(tokens);
        SparqlParser.LqpContext tree = parser.lqp();
        return parser.getProgram();
    }

    public String lQPToFlinkProgram() {
        String flinkProgram = "";

        flinkProgram = "package org.univalle.rdf;\n\n" +
                "import org.apache.flink.api.java.ExecutionEnvironment;\n" +
                "import org.apache.flink.api.java.DataSet;\n" +
                "import org.apache.flink.api.java.tuple.*;\n" +
                "import org.univalle.rdf.operators.*;\n" +
                "import org.univalle.rdf.runner.LoadTransformTriples;\n\n";

        flinkProgram += "public class "+getNameClass()+"{\n" +
                "\tpublic static void main(String[] args) throws Exception{\n" +
                "\t\tfinal ExecutionEnvironment bEnv = ExecutionEnvironment.getExecutionEnvironment();\n" +
                "\t\tDataSet<Tuple3<String, String, String>> staticRdfDataset = LoadTransformTriples" +
                ".loadTriplesFromDataset(bEnv, "+"\""+this.dS+"\");\n\n";

        flinkProgram += lQPToFlinkOperator()+"\n\n";

        flinkProgram += "\t\tqueryResult.print();\n";

        flinkProgram += "\t}\n" +
                "}\n\n";

        return flinkProgram;
    }

    public String getNameClass(){
        return this.nC;
    }

}
