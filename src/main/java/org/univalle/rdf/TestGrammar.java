package org.univalle.rdf;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import org.univalle.rdf.compiler.SparqlLexer;
import org.univalle.rdf.compiler.SparqlParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestGrammar {

    public static final String INPUT_LQP="../data/lqp-to-flink/lqp-04.txt";

    public static void main( String[] args )
    {
        FileInputStream fis;
        try{
            fis = new FileInputStream(INPUT_LQP);
        }catch (FileNotFoundException e){
            System.err.println("Input file not found ... ");
            return;
        }

        SparqlLexer lexer;
        try{
            lexer = new SparqlLexer(new ANTLRInputStream(fis));
        }catch (IOException e){
            e.printStackTrace();
            return;
        }

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SparqlParser parser = new SparqlParser(tokens);

        SparqlParser.LqpContext tree = parser.lqp();
        //SparqlVisitor visitor = new SparqlVisitor(tree);

        String p = parser.getProgram();


        //ParserRuleContext ruleContext = parser.lqp();
        //Trees.inspect(tree, parser);
        System.out.println(p);
    }
}
