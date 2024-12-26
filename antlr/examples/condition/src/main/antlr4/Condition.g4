grammar Condition;
  
start : conditiongroup | <EOF> ;

// set : 'set' Identifier '=' expr ;

conditiongroup : binarysign conditiongroup # BINARYGRP
        | conditiongroup logicalop conditiongroup # LOGICALGRPT
        | '(' conditiongroup ')'  # CONDITIONGRPT
        | condition # CONDITIONGRP
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

relop :  '==' | '!=' | '>' | '<' | '>=' | '<=';

logicalop : '||' | '&&' ;

// lexer
DOUBLE : ('0' .. '9') + ('.' ('0' .. '9') +)? ;
Identifier : [a-zA-Z_] [a-zA-Z_0-9]* ;

WS : [ \r\n\t] + -> skip ;

