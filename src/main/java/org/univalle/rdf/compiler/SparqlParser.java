// Generated from /Users/oscar/myapps/sparql-to-flink/src/main/java/org/univalle/rdf/compiler/Sparql.g4 by ANTLR 4.7
package org.univalle.rdf.compiler;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import org.univalle.rdf.operators.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SparqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN_PARENTHESIS=1, CLOSE_PARENTHESIS=2, PROJECT=3, BGP=4, TRIPLE=5, LEFTJOIN=6, 
		UNION=7, VARIABLE=8, URIREF=9, WS=10;
	public static final int
		RULE_lqp = 0, RULE_selectQuery = 1, RULE_whereClause = 2, RULE_groupGraphPatternA = 3, 
		RULE_groupGraphPatternB = 4, RULE_triplesBlock = 5, RULE_operator = 6, 
		RULE_triplePattern = 7, RULE_subject = 8, RULE_predicate = 9, RULE_object = 10;
	public static final String[] ruleNames = {
		"lqp", "selectQuery", "whereClause", "groupGraphPatternA", "groupGraphPatternB", 
		"triplesBlock", "operator", "triplePattern", "subject", "predicate", "object"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'project'", "'bgp'", "'triple'", "'leftjoin'", "'union'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", "PROJECT", "BGP", "TRIPLE", 
		"LEFTJOIN", "UNION", "VARIABLE", "URIREF", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sparql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private String program="";

	public String getProgram(){
	    return program;
	};

	public SparqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LqpContext extends ParserRuleContext {
		public SelectQueryContext selectQuery;
		public WhereClauseContext whereClause;
		public TerminalNode OPEN_PARENTHESIS() { return getToken(SparqlParser.OPEN_PARENTHESIS, 0); }
		public SelectQueryContext selectQuery() {
			return getRuleContext(SelectQueryContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(SparqlParser.CLOSE_PARENTHESIS, 0); }
		public LqpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lqp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterLqp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitLqp(this);
		}
	}

	public final LqpContext lqp() throws RecognitionException {
		LqpContext _localctx = new LqpContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lqp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(OPEN_PARENTHESIS);
			setState(23);
			((LqpContext)_localctx).selectQuery = selectQuery();
			setState(24);
			((LqpContext)_localctx).whereClause = whereClause();
			setState(25);
			match(CLOSE_PARENTHESIS);

					if(((LqpContext)_localctx).whereClause.bGP != null){
						program += ((LqpContext)_localctx).whereClause.bGP.execute();
					}
					if(((LqpContext)_localctx).whereClause.lJU != null){
						program += ((LqpContext)_localctx).whereClause.lJU.execute();
					}
					program += ((LqpContext)_localctx).selectQuery.p.execute();
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectQueryContext extends ParserRuleContext {
		public Project p;
		public OperatorContext operator;
		public Token VARIABLE;
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESIS() { return getToken(SparqlParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(SparqlParser.CLOSE_PARENTHESIS, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(SparqlParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(SparqlParser.VARIABLE, i);
		}
		public SelectQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSelectQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSelectQuery(this);
		}
	}

	public final SelectQueryContext selectQuery() throws RecognitionException {
		SelectQueryContext _localctx = new SelectQueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((SelectQueryContext)_localctx).operator = operator();
			setState(29);
			match(OPEN_PARENTHESIS);
			List<String> vars=new ArrayList<String>();
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				((SelectQueryContext)_localctx).VARIABLE = match(VARIABLE);
				vars.add((((SelectQueryContext)_localctx).VARIABLE!=null?((SelectQueryContext)_localctx).VARIABLE.getText():null));
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VARIABLE );
			setState(37);
			match(CLOSE_PARENTHESIS);
			((SelectQueryContext)_localctx).p = new Project(((SelectQueryContext)_localctx).operator.op, vars);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public Bgp bGP;
		public LeftJoinUnion lJU;
		public GroupGraphPatternAContext groupGraphPatternA;
		public GroupGraphPatternBContext groupGraphPatternB;
		public GroupGraphPatternAContext groupGraphPatternA() {
			return getRuleContext(GroupGraphPatternAContext.class,0);
		}
		public GroupGraphPatternBContext groupGraphPatternB() {
			return getRuleContext(GroupGraphPatternBContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_whereClause);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				((WhereClauseContext)_localctx).groupGraphPatternA = groupGraphPatternA();
				((WhereClauseContext)_localctx).bGP = ((WhereClauseContext)_localctx).groupGraphPatternA.gGP;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				((WhereClauseContext)_localctx).groupGraphPatternB = groupGraphPatternB();
				((WhereClauseContext)_localctx).lJU = ((WhereClauseContext)_localctx).groupGraphPatternB.lJU;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternAContext extends ParserRuleContext {
		public Bgp gGP;
		public OperatorContext operator;
		public TriplesBlockContext triplesBlock;
		public TerminalNode OPEN_PARENTHESIS() { return getToken(SparqlParser.OPEN_PARENTHESIS, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(SparqlParser.CLOSE_PARENTHESIS, 0); }
		public List<TriplesBlockContext> triplesBlock() {
			return getRuleContexts(TriplesBlockContext.class);
		}
		public TriplesBlockContext triplesBlock(int i) {
			return getRuleContext(TriplesBlockContext.class,i);
		}
		public GroupGraphPatternAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPatternA; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupGraphPatternA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupGraphPatternA(this);
		}
	}

	public final GroupGraphPatternAContext groupGraphPatternA() throws RecognitionException {
		GroupGraphPatternAContext _localctx = new GroupGraphPatternAContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_groupGraphPatternA);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(OPEN_PARENTHESIS);
			List<TriplesBlock> lTB=new ArrayList<TriplesBlock>();
			setState(50);
			((GroupGraphPatternAContext)_localctx).operator = operator();
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				((GroupGraphPatternAContext)_localctx).triplesBlock = triplesBlock();
				lTB.add(((GroupGraphPatternAContext)_localctx).triplesBlock.tB);
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPEN_PARENTHESIS );
			setState(58);
			match(CLOSE_PARENTHESIS);
			((GroupGraphPatternAContext)_localctx).gGP = new Bgp(((GroupGraphPatternAContext)_localctx).operator.op, lTB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupGraphPatternBContext extends ParserRuleContext {
		public LeftJoinUnion lJU;
		public OperatorContext operator;
		public GroupGraphPatternAContext groupGraphPatternA;
		public TerminalNode OPEN_PARENTHESIS() { return getToken(SparqlParser.OPEN_PARENTHESIS, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(SparqlParser.CLOSE_PARENTHESIS, 0); }
		public List<GroupGraphPatternAContext> groupGraphPatternA() {
			return getRuleContexts(GroupGraphPatternAContext.class);
		}
		public GroupGraphPatternAContext groupGraphPatternA(int i) {
			return getRuleContext(GroupGraphPatternAContext.class,i);
		}
		public GroupGraphPatternBContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupGraphPatternB; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterGroupGraphPatternB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitGroupGraphPatternB(this);
		}
	}

	public final GroupGraphPatternBContext groupGraphPatternB() throws RecognitionException {
		GroupGraphPatternBContext _localctx = new GroupGraphPatternBContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_groupGraphPatternB);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(OPEN_PARENTHESIS);
			List<Bgp> lBGP=new ArrayList<Bgp>();
			setState(63);
			((GroupGraphPatternBContext)_localctx).operator = operator();
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				((GroupGraphPatternBContext)_localctx).groupGraphPatternA = groupGraphPatternA();
				lBGP.add(((GroupGraphPatternBContext)_localctx).groupGraphPatternA.gGP);
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPEN_PARENTHESIS );
			setState(71);
			match(CLOSE_PARENTHESIS);
			((GroupGraphPatternBContext)_localctx).lJU = new LeftJoinUnion(((GroupGraphPatternBContext)_localctx).operator.op, lBGP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplesBlockContext extends ParserRuleContext {
		public TriplesBlock tB;
		public OperatorContext operator;
		public TriplePatternContext triplePattern;
		public TerminalNode OPEN_PARENTHESIS() { return getToken(SparqlParser.OPEN_PARENTHESIS, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TriplePatternContext triplePattern() {
			return getRuleContext(TriplePatternContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(SparqlParser.CLOSE_PARENTHESIS, 0); }
		public TriplesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplesBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplesBlock(this);
		}
	}

	public final TriplesBlockContext triplesBlock() throws RecognitionException {
		TriplesBlockContext _localctx = new TriplesBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_triplesBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(OPEN_PARENTHESIS);
			setState(75);
			((TriplesBlockContext)_localctx).operator = operator();
			setState(76);
			((TriplesBlockContext)_localctx).triplePattern = triplePattern();
			setState(77);
			match(CLOSE_PARENTHESIS);
			((TriplesBlockContext)_localctx).tB = new TriplesBlock(((TriplesBlockContext)_localctx).operator.op, ((TriplesBlockContext)_localctx).triplePattern.tP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public Operator op;
		public Token PROJECT;
		public Token BGP;
		public Token LEFTJOIN;
		public Token UNION;
		public Token TRIPLE;
		public TerminalNode PROJECT() { return getToken(SparqlParser.PROJECT, 0); }
		public TerminalNode BGP() { return getToken(SparqlParser.BGP, 0); }
		public TerminalNode LEFTJOIN() { return getToken(SparqlParser.LEFTJOIN, 0); }
		public TerminalNode UNION() { return getToken(SparqlParser.UNION, 0); }
		public TerminalNode TRIPLE() { return getToken(SparqlParser.TRIPLE, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operator);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((OperatorContext)_localctx).PROJECT = match(PROJECT);
				((OperatorContext)_localctx).op = new Operator((((OperatorContext)_localctx).PROJECT!=null?((OperatorContext)_localctx).PROJECT.getText():null));
				}
				break;
			case BGP:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				((OperatorContext)_localctx).BGP = match(BGP);
				((OperatorContext)_localctx).op = new Operator((((OperatorContext)_localctx).BGP!=null?((OperatorContext)_localctx).BGP.getText():null));
				}
				break;
			case LEFTJOIN:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				((OperatorContext)_localctx).LEFTJOIN = match(LEFTJOIN);
				((OperatorContext)_localctx).op = new Operator((((OperatorContext)_localctx).LEFTJOIN!=null?((OperatorContext)_localctx).LEFTJOIN.getText():null));
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				((OperatorContext)_localctx).UNION = match(UNION);
				((OperatorContext)_localctx).op = new Operator((((OperatorContext)_localctx).UNION!=null?((OperatorContext)_localctx).UNION.getText():null));
				}
				break;
			case TRIPLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				((OperatorContext)_localctx).TRIPLE = match(TRIPLE);
				((OperatorContext)_localctx).op = new Operator((((OperatorContext)_localctx).TRIPLE!=null?((OperatorContext)_localctx).TRIPLE.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriplePatternContext extends ParserRuleContext {
		public TriplePattern tP;
		public SubjectContext subject;
		public PredicateContext predicate;
		public ObjectContext object;
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TriplePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triplePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterTriplePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitTriplePattern(this);
		}
	}

	public final TriplePatternContext triplePattern() throws RecognitionException {
		TriplePatternContext _localctx = new TriplePatternContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_triplePattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((TriplePatternContext)_localctx).subject = subject();
			setState(93);
			((TriplePatternContext)_localctx).predicate = predicate();
			setState(94);
			((TriplePatternContext)_localctx).object = object();
			((TriplePatternContext)_localctx).tP = new TriplePattern(((TriplePatternContext)_localctx).subject.s, ((TriplePatternContext)_localctx).predicate.p, ((TriplePatternContext)_localctx).object.o);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubjectContext extends ParserRuleContext {
		public SubjectTerm s;
		public Token VARIABLE;
		public Token URIREF;
		public TerminalNode VARIABLE() { return getToken(SparqlParser.VARIABLE, 0); }
		public TerminalNode URIREF() { return getToken(SparqlParser.URIREF, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitSubject(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_subject);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((SubjectContext)_localctx).VARIABLE = match(VARIABLE);
				((SubjectContext)_localctx).s = new SubjectTerm((((SubjectContext)_localctx).VARIABLE!=null?((SubjectContext)_localctx).VARIABLE.getText():null));
				}
				break;
			case URIREF:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				((SubjectContext)_localctx).URIREF = match(URIREF);
				((SubjectContext)_localctx).s = new SubjectTerm((((SubjectContext)_localctx).URIREF!=null?((SubjectContext)_localctx).URIREF.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PredicateTerm p;
		public Token VARIABLE;
		public Token URIREF;
		public TerminalNode VARIABLE() { return getToken(SparqlParser.VARIABLE, 0); }
		public TerminalNode URIREF() { return getToken(SparqlParser.URIREF, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_predicate);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				((PredicateContext)_localctx).VARIABLE = match(VARIABLE);
				((PredicateContext)_localctx).p = new PredicateTerm((((PredicateContext)_localctx).VARIABLE!=null?((PredicateContext)_localctx).VARIABLE.getText():null));
				}
				break;
			case URIREF:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				((PredicateContext)_localctx).URIREF = match(URIREF);
				((PredicateContext)_localctx).p = new PredicateTerm((((PredicateContext)_localctx).URIREF!=null?((PredicateContext)_localctx).URIREF.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectContext extends ParserRuleContext {
		public ObjectTerm o;
		public Token VARIABLE;
		public Token URIREF;
		public TerminalNode VARIABLE() { return getToken(SparqlParser.VARIABLE, 0); }
		public TerminalNode URIREF() { return getToken(SparqlParser.URIREF, 0); }
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SparqlListener ) ((SparqlListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_object);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				((ObjectContext)_localctx).VARIABLE = match(VARIABLE);
				((ObjectContext)_localctx).o = new ObjectTerm((((ObjectContext)_localctx).VARIABLE!=null?((ObjectContext)_localctx).VARIABLE.getText():null));
				}
				break;
			case URIREF:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				((ObjectContext)_localctx).URIREF = match(URIREF);
				((ObjectContext)_localctx).o = new ObjectTerm((((ObjectContext)_localctx).URIREF!=null?((ObjectContext)_localctx).URIREF.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\fv\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\6\3$\n\3\r\3\16\3%"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\6\59\n\5\r\5\16\5:\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6F\n\6\r\6"+
		"\16\6G\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\nh\n\n\3\13"+
		"\3\13\3\13\3\13\5\13n\n\13\3\f\3\f\3\f\3\f\5\ft\n\f\3\f\2\2\r\2\4\6\b"+
		"\n\f\16\20\22\24\26\2\2\2u\2\30\3\2\2\2\4\36\3\2\2\2\6\60\3\2\2\2\b\62"+
		"\3\2\2\2\n?\3\2\2\2\fL\3\2\2\2\16\\\3\2\2\2\20^\3\2\2\2\22g\3\2\2\2\24"+
		"m\3\2\2\2\26s\3\2\2\2\30\31\7\3\2\2\31\32\5\4\3\2\32\33\5\6\4\2\33\34"+
		"\7\4\2\2\34\35\b\2\1\2\35\3\3\2\2\2\36\37\5\16\b\2\37 \7\3\2\2 #\b\3\1"+
		"\2!\"\7\n\2\2\"$\b\3\1\2#!\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3"+
		"\2\2\2\'(\7\4\2\2()\b\3\1\2)\5\3\2\2\2*+\5\b\5\2+,\b\4\1\2,\61\3\2\2\2"+
		"-.\5\n\6\2./\b\4\1\2/\61\3\2\2\2\60*\3\2\2\2\60-\3\2\2\2\61\7\3\2\2\2"+
		"\62\63\7\3\2\2\63\64\b\5\1\2\648\5\16\b\2\65\66\5\f\7\2\66\67\b\5\1\2"+
		"\679\3\2\2\28\65\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\4"+
		"\2\2=>\b\5\1\2>\t\3\2\2\2?@\7\3\2\2@A\b\6\1\2AE\5\16\b\2BC\5\b\5\2CD\b"+
		"\6\1\2DF\3\2\2\2EB\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7"+
		"\4\2\2JK\b\6\1\2K\13\3\2\2\2LM\7\3\2\2MN\5\16\b\2NO\5\20\t\2OP\7\4\2\2"+
		"PQ\b\7\1\2Q\r\3\2\2\2RS\7\5\2\2S]\b\b\1\2TU\7\6\2\2U]\b\b\1\2VW\7\b\2"+
		"\2W]\b\b\1\2XY\7\t\2\2Y]\b\b\1\2Z[\7\7\2\2[]\b\b\1\2\\R\3\2\2\2\\T\3\2"+
		"\2\2\\V\3\2\2\2\\X\3\2\2\2\\Z\3\2\2\2]\17\3\2\2\2^_\5\22\n\2_`\5\24\13"+
		"\2`a\5\26\f\2ab\b\t\1\2b\21\3\2\2\2cd\7\n\2\2dh\b\n\1\2ef\7\13\2\2fh\b"+
		"\n\1\2gc\3\2\2\2ge\3\2\2\2h\23\3\2\2\2ij\7\n\2\2jn\b\13\1\2kl\7\13\2\2"+
		"ln\b\13\1\2mi\3\2\2\2mk\3\2\2\2n\25\3\2\2\2op\7\n\2\2pt\b\f\1\2qr\7\13"+
		"\2\2rt\b\f\1\2so\3\2\2\2sq\3\2\2\2t\27\3\2\2\2\n%\60:G\\gms";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}