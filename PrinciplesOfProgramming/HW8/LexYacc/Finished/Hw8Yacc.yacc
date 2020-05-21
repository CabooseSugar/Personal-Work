%{
#include<stdio.h>
 int yylex(void);
 int yyerror(char *s);
%}
%token NUM
%%
S:
	S expr '\n' {printf("syntax correct !");}
	|
;
expr:
	expr '+' term
	| expr '-' term
	| term
;
term:
	term '*' factor
	| term '/' factor
	| factor
;
factor:
	NUM 
	| '(' expr ')'
	| '-' factor
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