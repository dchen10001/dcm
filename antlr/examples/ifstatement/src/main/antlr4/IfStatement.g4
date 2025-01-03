grammar IfStatement;
  
start : (assignment)* ifstmt | <EOF> ;

assignment : 'set' Identifier '=' expr # EXPRASSSIGNMENT
			 | 'set' Identifier '=' conditiongroup # CNDASSSIGNMENT
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

relop :  '==' | '!=' | '>' | '<' | '>=' | '<=';

logicalop : '||' | '&&' ;

printstmt : PRINT DOUBLE # PRINTDOUBLE
;

// lexer
IF: 'if';
ELSE: 'else';
ELSEIF: 'elseif';
ENDIF: 'endif';
PRINT: 'print';

BOOLEAN : 'true' | 'false' ;
DOUBLE : ('0' .. '9') + ('.' ('0' .. '9') +)? ;
Identifier : [a-zA-Z_] [a-zA-Z_0-9]* ;


WS : [ \r\n\t] + -> skip ;

