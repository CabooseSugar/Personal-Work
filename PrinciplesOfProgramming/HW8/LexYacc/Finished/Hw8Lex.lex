%{
#include <stdlib.h>
#include "y.tab.h"
%}
%%
[0-9]+ return NUM;
.|\n return yytext[0];
%%
int yywrap(void) {
	return 1;
}