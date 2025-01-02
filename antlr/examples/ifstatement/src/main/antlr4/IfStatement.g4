grammar IfStatement;
  
start : (setdouble)* ifstmt | <EOF> ;

setdouble : 'set' Identifier '=' (expr | conditiongroup) # ASSSIGNMENT
;

ifstmt : IF conditiongroup 
            printstmt
            (elseifstmt)*
            elsestmt
            ENDIF
;

elseifstmt : ELSEIF conditiongroup 
            printstmt
;

elsestmt : ELSE 
            printstmt
;
            
conditiongroup : binarysign conditiongroup # BINARYGRP
        | conditiongroup logicalop conditiongroup # LOGICALGRPT
        | '(' conditiongroup ')'  # CONDITIONGRPT
        | condition # CONDITIONGRP
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

relop :  '==' | '!=' | '>' | '<' | '>=' | '<=';

logicalop : '||' | '&&' ;

printstmt : PRINT DOUBLE # PRINTSTMT
;

// lexer
IF: 'if';
ELSE: 'else';
ELSEIF: 'elseif';
ENDIF: 'endif';
PRINT: 'print';

DOUBLE : ('0' .. '9') + ('.' ('0' .. '9') +)? ;
Identifier : [a-zA-Z_] [a-zA-Z_0-9]* ;

WS : [ \r\n\t] + -> skip ;

