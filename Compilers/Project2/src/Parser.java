// Kyle Wolf + Danny Ruan
import java.util.HashMap;

public class Parser
{
    public static final int MAIN        = 10;
    public static final int PRINT       = 11;
    public static final int BOOL        = 12;
    public static final int INT         = 13;
    public static final int FLOAT       = 14;
    public static final int STRUCT      = 15;
    public static final int SIZE        = 16;
    public static final int NEW         = 17;
    public static final int WHILE       = 18;
    public static final int IF          = 19;
    public static final int ELSE        = 20;
    public static final int RETURN      = 21;
    public static final int BREAK       = 22;
    public static final int CONTINUE    = 23;
    public static final int TRUE        = 24;
    public static final int FALSE       = 25;
    public static final int BEGIN       = 26;
    public static final int END         = 27;
    public static final int LPAREN      = 28;
    public static final int RPAREN      = 29;
    public static final int LBRACKET    = 30;
    public static final int RBRACKET    = 31;
    public static final int COMMA       = 32;
    public static final int DOT         = 33;
    public static final int ADDR        = 34;
    public static final int ASSIGN      = 35;
    public static final int OP          = 36;
    public static final int RELOP       = 37;
    public static final int SEMI        = 38;
    public static final int INT_LIT     = 39;
    public static final int FLOAT_LIT   = 40;
    public static final int IDENT       = 41;
    public static final int BLOCK       = 42;
    public static final int SPACE       = 43;


    public Parser(java.io.Reader r) throws java.io.IOException
    {
        this.lexer    = new Lexer(r, this);
    }

    Lexer   lexer;
    public ParserVal yylval;
    java.util.HashMap<String, Integer> symboltable = new HashMap<>();
    Integer tablePlace = 0;

    public int yyparse() throws java.io.IOException
    {
        while ( true )
        {
            int token = lexer.yylex();
            if(token == 0)
            {
                // EOF is reached
                return 0;
            }
            if(token == -1)
            {
                // error
                return -1;
            }
            if (token == 10){
                System.out.print("<MAIN" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 4;
            }
            if (token == 11){
                System.out.print("<PRINT" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 5;
            }
            if (token == 12){
                System.out.print("<BOOL" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 4;
            }
            if (token == 13){
                System.out.print("<INT" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 3;
            }
            if (token == 14){
                System.out.print("<FLOAT" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 5;
            }
            if (token == 15){
                System.out.print("<STRUCT" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 6;
            }
            if (token == 16){
                System.out.print("<SIZE" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 4;
            }
            if (token == 17){
                System.out.print("<NEW" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 3;
            }
            if (token == 18){
                System.out.print("<WHILE" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 5;
            }
            if (token == 19){
                System.out.print("<IF" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 2;
            }
            if (token == 20){
                System.out.print("<ELSE" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 4;
            }
            if (token == 21){
                System.out.print("<RETURN" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 6;
            }
            if (token == 22){
                System.out.print("<BREAK" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 5;
            }
            if (token == 23){
                System.out.print("<CONTINUE" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 8;
            }
            if (token == 24){
                System.out.print("<TRUE" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 4;
            }
            if (token == 25){
                System.out.print("<FALSE" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 5;
            }
            if (token == 26){
                System.out.print("<BEGIN" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 27){
                System.out.print("<END" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 28){
                System.out.print("<LPAREN" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 29){
                System.out.print("<RPAREN" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 30){
                System.out.print("<LBRACKET" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 31){
                System.out.print("<RBRACKET" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 32){
                System.out.print("<COMMA" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 33){
                System.out.print("<DOT" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 34){
                System.out.print("<ADDR" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 35){
                System.out.print("<ASSIGN" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 36){
                Object attr = yylval.obj;
                System.out.print("<OP, " + attr + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 37){
                Object attr = yylval.obj;
                System.out.print("<RELOP, " + attr + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += lexer.yytext().length();
            }
            if (token == 38){
                System.out.print("<SEMI" + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += 1;
            }
            if (token == 39){
                Object attr = yylval.obj;
                System.out.print("<INT, " + attr + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += lexer.yytext().length();
            }
            if (token == 40){
                Object attr = yylval.obj;
                System.out.print("<FLOAT, " + attr + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                lexer.column += lexer.yytext().length();
            }
            if (token == 41){
                Object attr = yylval.obj;
                if (symboltable.containsKey(attr.toString())){
                    System.out.print("<ID, " + symboltable.get(attr.toString()) + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                }
                else{
                    symboltable.put(attr.toString(), tablePlace);
                    System.out.print("<< add \"" + attr + "\" into symbol table at " + tablePlace + " >>");
                    System.out.print("<ID, " + symboltable.get(attr.toString()) + " :"+ lexer.lineno +":" + lexer.column  + ">" );
                    tablePlace++;
                }
                lexer.column += lexer.yytext().length();
            }
            if (token == 42){
                Object attr = yylval.obj;
                for (char c: attr.toString().toCharArray()){
                    if (c == '\n'){
                        lexer.lineno++;
                        lexer.column = 1;
                    }
                    else{
                        lexer.column++;
                    }
                }
            }
            if (token == 43){
                lexer.column += lexer.yytext().length();
            }

        }
    }
}
