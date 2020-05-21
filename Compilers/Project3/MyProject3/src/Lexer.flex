//Kyle Wolf and Danny Ruan

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

  public Parser   yyparser;
  public int      lineno;
  public int      column;

  public Lexer(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
    this.lineno   = 1;
    this.column = 1;
  }
%}

int        = [0-9]+
identifier = [a-zA-Z_][a-zA-Z0-9_]*
newline    = \n
whitespace = [ \t\r]+
comment    = "//".*

%%

"int"                               { yyparser.yylval = new ParserVal((Object)yytext()); column+= 3               ; return Parser.INT     ; }
"bool"                              { yyparser.yylval = new ParserVal((Object)yytext()); column+= 4               ; return Parser.BOOL    ; }
"true"                              { yyparser.yylval = new ParserVal((Object)yytext()); column+= 4               ; return Parser.BOOL_LIT; }
"false"                             { yyparser.yylval = new ParserVal((Object)yytext()); column+= 5               ; return Parser.BOOL_LIT; }
"if"                                { yyparser.yylval = new ParserVal((Object)yytext()); column+= 2               ; return Parser.IF      ; }
"else"                              { yyparser.yylval = new ParserVal((Object)yytext()); column+= 4               ; return Parser.ELSE    ; }
"while"                             { yyparser.yylval = new ParserVal((Object)yytext()); column+= 5               ; return Parser.WHILE   ; }
","                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.COMMA   ; }
"{"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.BEGIN   ; }
"}"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.END     ; }
"("                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.LPAREN  ; }
")"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.RPAREN  ; }
"["                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.LBRACK  ; }
"]"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.RBRACK  ; }
"="                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.ASSIGN  ; }
"+"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.EXPROP  ; }
"-"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.EXPROP  ; }
"or"                                { yyparser.yylval = new ParserVal((Object)yytext()); column+= 2               ; return Parser.EXPROP  ; }
"*"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.TERMOP  ; }
"/"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.TERMOP  ; }
"and"                               { yyparser.yylval = new ParserVal((Object)yytext()); column+= 3               ; return Parser.TERMOP  ; }
">"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.RELAOP  ; }
"<"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.RELAOP  ; }
">="                                { yyparser.yylval = new ParserVal((Object)yytext()); column+= 2               ; return Parser.RELAOP  ; }
"<="                                { yyparser.yylval = new ParserVal((Object)yytext()); column+= 2               ; return Parser.RELAOP  ; }
"!="                                { yyparser.yylval = new ParserVal((Object)yytext()); column+= 2               ; return Parser.RELAOP  ; }
"=="                                { yyparser.yylval = new ParserVal((Object)yytext()); column+= 2               ; return Parser.RELAOP  ; }
";"                                 { yyparser.yylval = new ParserVal((Object)yytext()); column++                 ; return Parser.SEMI    ; }
{int}                               { yyparser.yylval = new ParserVal((Object)yytext()); column+=yytext().length(); return Parser.INT_LIT ; }
{identifier}                        { yyparser.yylval = new ParserVal((Object)yytext()); column+=yytext().length(); return Parser.IDENT   ; }
{comment}                           { column+=yytext().length(); }
{newline}                           { lineno++; column = 1     ; }
{whitespace}                        { column+=yytext().length(); }


\b     { System.err.println("Sorry, backspace doesn't work"); }

/* error fallback */
[^]    { System.err.println("Error: unexpected character '"+yytext()+"'"); return -1; }
