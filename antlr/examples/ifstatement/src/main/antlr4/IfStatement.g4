grammar IfStatement;
  
start : execution | <EOF>;

execution : assignment* ifstmt # EXECUTEIF
        | doRule # EXECUTERULE
;

assignment : 'set' Identifier '=' expr # EXPRASSSIGNMENT
			 | 'set' Identifier '=' conditiongroup # CNDASSSIGNMENT
;

ifstmt : IF conditiongroup 
            doRule
            (elseifstmt)*
            elsestmt
            ENDIF
;

elseifstmt : ELSEIF conditiongroup 
            doRule
;

elsestmt : ELSE 
            doRule
;
            
conditiongroup : binarysign conditiongroup # BINARYGRP
        | conditiongroup logicalop conditiongroup # LOGICALGRPT
        | '(' conditiongroup ')'  # CONDITIONGRPT
        | condition # CONDITIONGRP
        | BOOLEAN      # BOOLEAN
        | Identifier # VARIABLEGRP
        ;

condition : expr relop expr	 	# RELOPGRP
          | '(' condition ')' 	# CNDPARENGRP
          ;


expr : arithmeticsign expr  # SIGNGRP
   | expr mulop expr # MULOPGRP
   | expr addop expr # ADDOPGRP
   | '(' expr ')'   # EXPPARENGRP
   | DOUBLE      # DOUBLE
   | Identifier  # VARIABLE
   ;
      
binarysign : '!';

arithmeticsign : '-';

addop : '+' | '-';
 
mulop : '*' | '/' | '%' ;

relop : DEQUAL | NE1 | GREATER_THAN | LESS_THAN | GREATER_THAN_EQUAL | LESS_THAN_EQUAL;

logicalop : '||' | '&&' ;

doRule : PRINT DOUBLE # DOPRINT
;

// lexer
IF: 'if';
ELSE: 'else';
ELSEIF: 'elseif';
ENDIF: 'endif';
PRINT: 'print';

// Agent status
LEAST_BUSY_OF: 'least' [' ']+ 'busy' [' ']+ 'of';

// rule Action
QUEUE_TO: 'queue' [' ']+ 'to';
// new action value can be added here, such as ROUTE_TO
//ROUTE_TO: 'route to';


BOOLEAN : 'true' | 'false' ;
DOUBLE : ('0' .. '9') + ('.' ('0' .. '9') +)? ;
NUMBER: [1-9]([0-9]*);

Identifier : [a-zA-Z_] [a-zA-Z_0-9]* ;

UUID_OR_HEXA: ([0-9a-fA-F]+('-')?)+;

LESS_THAN: '<';
LESS_THAN_EQUAL: '<=';
EQUAL: '=';
DEQUAL: '==';
GREATER_THAN: '>';
GREATER_THAN_EQUAL: '>=';

NE1: '!=';
NE2: '<>';

IN: 'in';
NOT_IN: 'not' [' ']+ 'in';

WS : [ \r\n\t] + -> skip ;
