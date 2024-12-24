grammar Function;
  
start : expr | <EOF> ;

expr : '-' expr     # UMINUS
   | expr mulop expr # MULOPGRP
   | expr addop expr # ADDOPGRP
   | '(' expr ')'   # PARENGRP
   | NUMBER      # DOUBLE
   | Identifier  # VARIABLE
   ;
   
addop : '+' | '-';
 
mulop : '*' | '/' | '%' ;

// lexer
NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;
Identifier : [a-zA-Z_] [a-zA-Z_0-9]* ;

WS : [ \r\n\t] + -> skip ;

