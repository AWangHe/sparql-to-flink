
//****************************************************
//Defin a grammar called Sparql
//****************************************************

grammar Sparql;

@parser::header {
import java.util.List;
import java.util.ArrayList;
}

@parser::members{
private String program="";

public String getProgram(){
    return program;
};
}

lqp : 
	OPEN_PARENTHESIS selectQuery whereClause CLOSE_PARENTHESIS
	{
		if($whereClause.bGP != null){
			program += $whereClause.bGP.execute();
		}
		if($whereClause.lJU != null){
			program += $whereClause.lJU.execute();
		}
		program += $selectQuery.p.execute();
	};

selectQuery returns [Project p]: 
	operator OPEN_PARENTHESIS
		{List<String> vars=new ArrayList<String>();} 
	(VARIABLE {vars.add($VARIABLE.text);})+ 
	CLOSE_PARENTHESIS
		{$p=new Project($operator.op, vars);};

whereClause returns [Bgp bGP, LeftJoinUnion lJU, ]:
	groupGraphPatternA 
		{$bGP=$groupGraphPatternA.gGP;} | 
	groupGraphPatternB
		{$lJU=$groupGraphPatternB.lJU;};

groupGraphPatternA returns [Bgp gGP]: 
	OPEN_PARENTHESIS
		{List<TriplesBlock> lTB=new ArrayList<TriplesBlock>();}
	operator 
		(triplesBlock {lTB.add($triplesBlock.tB);})+ 
	CLOSE_PARENTHESIS
		{$gGP=new Bgp($operator.op, lTB);};

groupGraphPatternB returns [LeftJoinUnion lJU]:
	OPEN_PARENTHESIS 
		{List<Bgp> lBGP=new ArrayList<Bgp>();}
	operator 
		(groupGraphPatternA {lBGP.add($groupGraphPatternA.gGP);})+ 
	CLOSE_PARENTHESIS
		{$lJU=new LeftJoinUnion($operator.op, lBGP);};

triplesBlock returns [TriplesBlock tB]: OPEN_PARENTHESIS operator triplePattern CLOSE_PARENTHESIS
		{$tB=new TriplesBlock($operator.op, $triplePattern.tP);};

operator returns [Operator op]: 
	PROJECT {$op=new Operator($PROJECT.text);} | 
	BGP {$op=new Operator($BGP.text);} | 
	LEFTJOIN {$op=new Operator($LEFTJOIN.text);} | 
	UNION {$op=new Operator($UNION.text);} | 
	TRIPLE {$op=new Operator($TRIPLE.text);};

triplePattern returns [TriplePattern tP]: subject predicate object
	{$tP=new TriplePattern($subject.s, $predicate.p, $object.o);};

subject returns [SubjectTerm s]:
    VARIABLE {$s=new SubjectTerm($VARIABLE.text);} |
    URIREF {$s=new SubjectTerm($URIREF.text);};

predicate returns [PredicateTerm p]:
    VARIABLE {$p=new PredicateTerm($VARIABLE.text);} |
    URIREF {$p=new PredicateTerm($URIREF.text);};

object returns [ObjectTerm o]:
    VARIABLE {$o=new ObjectTerm($VARIABLE.text);} |
    URIREF {$o=new ObjectTerm($URIREF.text);};


//****************************************************
// Define a list of Tokens
//****************************************************

OPEN_PARENTHESIS        :       '(';
CLOSE_PARENTHESIS       :       ')';

PROJECT		: 	'project';
BGP		    :	'bgp';
TRIPLE		:	'triple';
LEFTJOIN	:	'leftjoin';
UNION		: 	'union';

VARIABLE	:	'?' [a-zA-Z0-9_]*;
URIREF		:	'<' (.)+? '>';
WS		    :	[ \t\r\n]+ -> skip;
