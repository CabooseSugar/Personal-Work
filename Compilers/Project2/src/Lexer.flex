/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2000 Gerwin Klein <lsf@jflex.de>                          *
 * All rights reserved.                                                    *
 *                                                                         *
 * Thanks to Larry Bell and Bob Jamison for suggestions and comments.      *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

%%

%class Lexer
%byaccj

%{

  public Parser   parser;
  public int      lineno;
  public int      column;

  public Lexer(java.io.Reader r, Parser parser) {
    this(r);
    this.parser = parser;
    this.lineno = 1;
    this.column = 1;
  }
%}

int        = [0-9]+
float      = [0-9]+[.][0-9]*
identifier = [a-z_][0-9]*
newline    = \n
whitespace = [ \t\r]+
comment    = "//".*
blockComment = "/*"[^*]*[*]+([^*/][^*]*[*]+)*"/"

%%

"main"                              { parser.yylval = new ParserVal(null            ); return Parser.MAIN   ; }
"print"                             { parser.yylval = new ParserVal(null            ); return Parser.PRINT  ; }
"bool"                             { parser.yylval = new ParserVal(null            ); return Parser.BOOL  ; }
"int"                               { parser.yylval = new ParserVal(null            ); return Parser.INT    ; }
"float"                             { parser.yylval = new ParserVal(null            ); return Parser.FLOAT  ; }
"struct"                             { parser.yylval = new ParserVal(null            ); return Parser.STRUCT  ; }
"size"                             { parser.yylval = new ParserVal(null            ); return Parser.SIZE  ; }
"new"                             { parser.yylval = new ParserVal(null            ); return Parser.NEW  ; }
"while"                             { parser.yylval = new ParserVal(null            ); return Parser.WHILE  ; }
"if"                             { parser.yylval = new ParserVal(null            ); return Parser.IF  ; }
"else"                             { parser.yylval = new ParserVal(null            ); return Parser.ELSE  ; }
"return"                             { parser.yylval = new ParserVal(null            ); return Parser.RETURN  ; }
"break"                             { parser.yylval = new ParserVal(null            ); return Parser.BREAK  ; }
"continue"                             { parser.yylval = new ParserVal(null            ); return Parser.CONTINUE  ; }
"true"                             { parser.yylval = new ParserVal(null            ); return Parser.TRUE ; }
"false"                             { parser.yylval = new ParserVal(null            ); return Parser.FALSE  ; }

"{"                                 { parser.yylval = new ParserVal(null            ); return Parser.BEGIN  ; }
"}"                                 { parser.yylval = new ParserVal(null            ); return Parser.END    ; }
"("                                 { parser.yylval = new ParserVal(null            ); return Parser.LPAREN ; }
")"                                 { parser.yylval = new ParserVal(null            ); return Parser.RPAREN ; }
"["                                 { parser.yylval = new ParserVal(null            ); return Parser.LBRACKET ; }
"]"                                 { parser.yylval = new ParserVal(null            ); return Parser.RBRACKET ; }
"="                                 { parser.yylval = new ParserVal(null            ); return Parser.ASSIGN ; }
"+"                                 { parser.yylval = new ParserVal((Object)"+"     ); return Parser.OP     ; }
"-"                                 { parser.yylval = new ParserVal((Object)"-"            ); return Parser.OP ; }
"*"                                 { parser.yylval = new ParserVal((Object)"*"            ); return Parser.OP ; }
"/"                                 { parser.yylval = new ParserVal((Object)"/"            ); return Parser.OP ; }
"%"                                 { parser.yylval = new ParserVal((Object)"%"            ); return Parser.OP ; }
"and"                                 { parser.yylval = new ParserVal((Object)"and"            ); return Parser.OP ; }
"or"                                 { parser.yylval = new ParserVal((Object)"or"            ); return Parser.OP ; }
"not"                                 { parser.yylval = new ParserVal((Object)"not"            ); return Parser.OP ; }
"=="                                 { parser.yylval = new ParserVal((Object)"=="            ); return Parser.RELOP  ; }
"!="                                 { parser.yylval = new ParserVal((Object)"!="            ); return Parser.RELOP  ; }
"<"                                 { parser.yylval = new ParserVal((Object)"<"            ); return Parser.RELOP  ; }
">"                                 { parser.yylval = new ParserVal((Object)">"            ); return Parser.RELOP  ; }
"<="                                 { parser.yylval = new ParserVal((Object)"<="           ); return Parser.RELOP  ; }
">="                                 { parser.yylval = new ParserVal((Object)">="            ); return Parser.RELOP  ; }
";"                                 { parser.yylval = new ParserVal(null            ); return Parser.SEMI   ; }
","                                 { parser.yylval = new ParserVal(null            ); return Parser.COMMA  ; }
"."                                 { parser.yylval = new ParserVal(null            ); return Parser.DOT   ; }
"&"                                 { parser.yylval = new ParserVal(null            ); return Parser.ADDR   ; }
{int}                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.INT_LIT; }
{float}                               { parser.yylval = new ParserVal((Object)yytext()); return Parser.FLOAT_LIT; }
{identifier}                        { parser.yylval = new ParserVal((Object)yytext()); return Parser.IDENT  ; }
{comment}                           { column += yytext().length(); System.out.print(yytext());  }
{blockComment}                       { System.out.print(yytext()); parser.yylval = new ParserVal((Object)yytext()); return Parser.BLOCK  ;  }
{newline}                           { lineno++; column = 1; System.out.println(); }
{whitespace}                        { System.out.print(yytext()); parser.yylval = new ParserVal(null            ); return Parser.SPACE; }



\b     { System.err.println("Sorry, backspace doesn't work"); }

/* error fallback */
[^]    { System.err.println("Error: unexpected character '"+yytext()+"'"); return -1; }
