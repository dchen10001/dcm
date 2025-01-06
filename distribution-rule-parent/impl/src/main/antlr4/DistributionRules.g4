grammar DistributionRules;

/* routing rule set is the top rule set */

start : execution | <EOF> ;

execution: routingRuleSet
;

routingRuleSet: routingRuleGroup (routingWaitingRuleGroup)*
;

routingWaitingRuleGroup: waitRule routingRuleGroup
;

routingRuleGroup: (routingRule)+
;

routingRule: ruleAction (queue_status)? orSkills priority
;

/* if we have new action, such as ROUTE_TO, 
* we can add it here as 
* ruleAction: QUEUE_TO | ROUTE_TO;
*/
ruleAction: QUEUE_TO #ACTQUEUETO
;

orSkills: skillOrSet ('and' skillOrSet)* #SKILLSETOR
;

skillOrSet: skill #ORSKILL
	| skillSet #ORSKILLSET
;

skillSet: '(' skill (',' skill)+ ')' #SKILLANDSET
;

skill: '@S:' entity_identifier (levelCondition)? #SKILLCONDITION
;

levelCondition:
           'level' binaryOperator NUMBER #BINARYOP
           | 'level' sqlOperator NUMBER '..' NUMBER #SQLOP
       ;

binaryOperator: 
	LESS_THAN 
	| LESS_THAN_EQUAL 
	| EQUAL 
	| NOT_EQUAL 
	| GREATER_THAN | GREATER_THAN_EQUAL;

sqlOperator: IN | NOT_IN;

entity_identifier: UUID_OR_HEXA #OIDHEX
	| NUMBER #OIDNUMBER
;

priority: 'with' 'priority' NUMBER;

waitRule: 'wait' NUMBER;

/* if we have new agent status, 
* we can add it here as 
* queue_status: LEAST_BUSY_OF;
*/
queue_status: LEAST_BUSY_OF #QSLEASTBUSYOF
;

// lexer
LESS_THAN: '<';
LESS_THAN_EQUAL: '<=';
EQUAL: '=';
NOT_EQUAL: NE1 | NE2;
GREATER_THAN: '>';
GREATER_THAN_EQUAL: '>=';

NE1: '!=';
NE2: '<>';

IN: 'in';
NOT_IN: 'not' [' ']+ 'in';

// Agent status
LEAST_BUSY_OF: 'least' [' ']+ 'busy' [' ']+ 'of';

// rule Action
QUEUE_TO: 'queue' [' ']+ 'to';
// new action value can be added here, such as ROUTE_TO
//ROUTE_TO: 'route to';

NUMBER: [1-9]([0-9]*);
UUID_OR_HEXA: ([0-9a-fA-F]+('-')?)+;
WHITESPACE: [ \t\n\r]+ -> skip;
