// Generated from /Users/oscar/myapps/sparql-to-flink/src/main/java/org/univalle/rdf/compiler/Sparql.g4 by ANTLR 4.7
package org.univalle.rdf.compiler;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SparqlParser}.
 */
public interface SparqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SparqlParser#lqp}.
	 * @param ctx the parse tree
	 */
	void enterLqp(SparqlParser.LqpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#lqp}.
	 * @param ctx the parse tree
	 */
	void exitLqp(SparqlParser.LqpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#selectQuery}.
	 * @param ctx the parse tree
	 */
	void enterSelectQuery(SparqlParser.SelectQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#selectQuery}.
	 * @param ctx the parse tree
	 */
	void exitSelectQuery(SparqlParser.SelectQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(SparqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(SparqlParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#groupGraphPatternA}.
	 * @param ctx the parse tree
	 */
	void enterGroupGraphPatternA(SparqlParser.GroupGraphPatternAContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#groupGraphPatternA}.
	 * @param ctx the parse tree
	 */
	void exitGroupGraphPatternA(SparqlParser.GroupGraphPatternAContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#groupGraphPatternB}.
	 * @param ctx the parse tree
	 */
	void enterGroupGraphPatternB(SparqlParser.GroupGraphPatternBContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#groupGraphPatternB}.
	 * @param ctx the parse tree
	 */
	void exitGroupGraphPatternB(SparqlParser.GroupGraphPatternBContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#triplesBlock}.
	 * @param ctx the parse tree
	 */
	void enterTriplesBlock(SparqlParser.TriplesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#triplesBlock}.
	 * @param ctx the parse tree
	 */
	void exitTriplesBlock(SparqlParser.TriplesBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(SparqlParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(SparqlParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#triplePattern}.
	 * @param ctx the parse tree
	 */
	void enterTriplePattern(SparqlParser.TriplePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#triplePattern}.
	 * @param ctx the parse tree
	 */
	void exitTriplePattern(SparqlParser.TriplePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#subject}.
	 * @param ctx the parse tree
	 */
	void enterSubject(SparqlParser.SubjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#subject}.
	 * @param ctx the parse tree
	 */
	void exitSubject(SparqlParser.SubjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SparqlParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SparqlParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparqlParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(SparqlParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparqlParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(SparqlParser.ObjectContext ctx);
}