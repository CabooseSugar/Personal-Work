%{
#include<stdio.h>
 int yylex(void);
 int yyerror(char *s);
%}
%token NUM
%%
S:
	S expr '\n' 	{ printf (" = %d\n", $2); }
	|
;
expr:
	expr '+' term 	{ $$ = $1 + $3 ;}
	| expr '-' term	{ $$ = $1 - $3 ;}
	| term		
;
term:
	term '*' factor	{ $$ = $1 * $3 ;}
	| term '/' factor { $$ = $1 / $3 ;}
	| factor	
;
factor:
	NUM 		{ $$ = $1; } 
	| '(' expr ')'	{ $$ = $2; }
	| '-' factor 	{ $$ = -$2; } 
;
%%
int yyerror(char *s) {
	fprintf(stderr, "%s\n", s);
	return 0;
}
int main(void) {
	yyparse();
	return 0;
}