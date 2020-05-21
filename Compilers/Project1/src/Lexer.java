// GROUP SUBMISSION: Kyle Wolf & Dominique Nicholas
import java.io.IOException;
import java.util.ArrayList;

public class Lexer
{
    private static final char EOF        =  0;

    private Parser         yyparser; // parent parser object
    private java.io.Reader reader;   // input stream
    public int             lineno;   // line number
    public char[]          buffer1 = new char[10];
    public char[]          buffer2 = new char[10];
    int                    currentBuffer;
    int                    f;
    boolean                error; // remains false unless error is found while tokenizing
                                  // when yylex is next called, will return -1 immediately


    public Lexer(java.io.Reader reader, Parser yyparser) throws java.io.IOException
    {
        this.reader   = reader;
        this.yyparser = yyparser;
        lineno = 1;
        currentBuffer = 1;
        f = -1;
        error = false;

        for (int i = 0; i < 10; i++){
            int data = reader.read();
            if (data == -1){ // eof
                buffer1[i] = EOF;
                return;
            }
            buffer1[i] = (char)data;
        }
    }

    public void loadNextBuffer() throws IOException{
        if (currentBuffer == 1){
            currentBuffer = 2;
            for (int i = 0; i < 10; i++){
                int data = reader.read();
                if (data == -1){ // eof
                    buffer2[i] = EOF;
                    return;
                }
                buffer2[i] = (char)data;
            }

            return;
        }

        else {
            currentBuffer = 1;
            for (int i = 0; i < 10; i++){
                int data = reader.read();
                if (data == -1){ // eof
                    buffer1[i] = EOF;
                    return;
                }
                buffer1[i] = (char)data;
            }

            return;
        }
    }


    public char NextChar() throws IOException
    {
        f++;
        // http://tutorials.jenkov.com/java-io/readers-writers.html
        if (f == 10){
            f = 0;
            loadNextBuffer();
        }
        if (currentBuffer == 1){
            return (char)buffer1[f];
        }
        else{
            return (char)buffer2[f];
        }

    }

    public int yylex() throws java.io.IOException
    {
        // this error handling is used in niche cases only
        if (error){
            return -1;
        }

        int state = 0;

        StringBuilder token = new StringBuilder();
        while(true)
        {
            char c;
            switch(state)
            {
                case 0:
                    c = NextChar();
                    if (c == EOF){return 0;} // look for eof
                    else if (c == ';'){state = 1; continue;} // look for ;

                    else if (isNum(c)){ state = 2; token.append(c); continue; } // begin looking for num

                    else if (c == 'm'){ state = 4; token.append(c); continue; } // begin looking for main
                    else if (c == 'p'){ state = 8; token.append(c); continue; } // begin looking for print
                    else if (c == 'i'){ state = 13; token.append(c); continue; } // begin looking for if
                    else if (c == 'e'){ state = 15; token.append(c); continue; } // begin looking for else
                    // above cases lead to state 19 if they do not complete the full keyword or go beyond the full keyword

                    else if (isLetterOr_(c)) {state = 19; token.append(c); continue;} // begin looking for an ID

                    else if (c == ' ' || c == '\t' || c == '\r'){ continue;} // skip whitespace
                    else if (c == '\n') {lineno++; continue;}               // skip newlines, add to lineno counter

                    // below handled similarly to ;
                    else if (c == '{') {state = 20; continue;}
                    else if (c == '}') {state = 21; continue;}
                    else if (c == '(') {state = 22; continue;}
                    else if (c == ')') {state = 23; continue;}
                    // skip = for now because that could also lead into ==
                    else if (c == '+') {state = 24; continue;}
                    else if (c == '-') {state = 25; continue;}
                    else if (c == '*') {state = 26; continue;}
                    else if (c == '/') {state = 27; continue;}
                    else if (c == ',') {state = 28; continue;}

                    else if (c == '=') {state = 29; token.append(c); continue;} // = or ==
                    else if (c == '!') {state = 30; token.append(c); continue;} // !=
                    else if (c == '<') {state = 31; token.append(c); continue;} // < or <=
                    else if (c == '>') {state = 32; token.append(c); continue;} // > or >=

                    else{
                        return -1;
                    }


                // ; case
                case 1:
                    yyparser.yylval = new ParserVal((Object)";");   // set token-attribute to yyparser.yylval
                    return Parser.SEMI;                             // return token-name

                // nums before decimal
                case 2:
                    c = NextChar();
                    if (isNum(c)){
                        token.append(c);
                        continue;
                    }
                    else if (c == '.'){
                        state = 33;
                        token.append(c);
                        continue;
                    }
                    else if (isOther(c)){ // NOTE: in isOther, "Other" is composed of VALID token enders
                       f--;
                       yyparser.yylval = new ParserVal((Object)token.toString());
                       return Parser.NUM;
                    }
                    else{
                       return -1;
                    }

                // below makes sure there's a num after .
                // added after error testing - hence why this isn't case 4
                case 33:
                    c = NextChar();
                    if (isNum(c)){
                        token.append(c);
                        state = 3;
                        continue;
                    }
                    else{
                        return -1;
                    }


                // nums after decimal
                case 3:
                    c = NextChar();
                    if (isNum(c)){
                        token.append(c);
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.NUM;
                    }
                    // below is done the way it is since still have to return partially correct token as in testcase8
                    else {
                        error = true;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.NUM;
                    }

                // can make main?
                case 4:
                    c= NextChar();
                    if (c == 'a'){ state = 5; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        error = true;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }

                case 5:
                    c= NextChar();
                    if (c == 'i'){ state = 6; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                       return -1;
                    }

                case 6:
                    c= NextChar();
                    if (c == 'n'){ state = 7; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 7:
                    c = NextChar();
                    if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.MAIN;
                    }
                    else{
                        return -1;
                    }

                // can make print?
                case 8:
                    c= NextChar();
                    if (c == 'r'){ state = 9; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 9:
                    c= NextChar();
                    if (c == 'i'){ state = 10; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 10:
                    c= NextChar();
                    if (c == 'n'){ state = 11; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 11:
                    c= NextChar();
                    if (c == 't'){ state = 12; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 12:
                    c = NextChar();
                    if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.PRINT;
                    }
                    else{
                        return -1;
                    }

                // can make if?
                case 13:
                    c= NextChar();
                    if (c == 'f'){ state = 14; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 14:
                    c = NextChar();
                    if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.IF;
                    }
                    else{
                        return -1;
                    }

                // can make else?
                case 15:
                    c= NextChar();
                    if (c == 'l'){ state = 16; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 16:
                    c= NextChar();
                    if (c == 's'){ state = 17; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 17:
                    c= NextChar();
                    if (c == 'e'){ state = 18; token.append(c); continue;}
                    else if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 18:
                    c = NextChar();
                    if (isNum(c) || isLetterOr_(c)){
                        token.append(c);
                        state = 19;
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ELSE;
                    }
                    else{
                        return -1;
                    }

                // ID
                case 19:
                    c = NextChar();
                    if (isLetterOr_(c) || isNum(c)){
                        token.append(c);
                        continue;
                    }
                    else if (isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)token.toString());
                        return Parser.ID;
                    }
                    else{
                        return -1;
                    }

                case 20:
                    yyparser.yylval = new ParserVal((Object)"{");
                    return Parser.BEGIN;

                case 21:
                    yyparser.yylval = new ParserVal((Object)"}");
                    return Parser.END;

                case 22:
                    yyparser.yylval = new ParserVal((Object)"(");
                    return Parser.LPAREN;

                case 23:
                    yyparser.yylval = new ParserVal((Object)")");
                    return Parser.RPAREN;

                case 24:
                    yyparser.yylval = new ParserVal((Object)"+");
                    return Parser.OP;

                case 25:
                    yyparser.yylval = new ParserVal((Object)"-");
                    return Parser.OP;

                case 26:
                    yyparser.yylval = new ParserVal((Object)"*");
                    return Parser.OP;

                case 27:
                    yyparser.yylval = new ParserVal((Object)"/");
                    return Parser.OP;

                case 28:
                    yyparser.yylval = new ParserVal((Object)",");
                    return Parser.COMMA;

                case 29:
                    c = NextChar();
                    if (c == '='){
                        yyparser.yylval = new ParserVal((Object)"==");
                        return Parser.RELOP;
                    }
                    else if(isNum(c) || isLetterOr_(c) || isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)"=");
                        return Parser.ASSIGN;
                    }
                    // handled like errors are in case 3, if ">!" which is invalid, still return ">" ?
                    else{
                        error = true;
                        yyparser.yylval = new ParserVal((Object)"=");
                        return Parser.ASSIGN;
                    }

                case 30:
                    c = NextChar();
                    if (c == '='){
                        yyparser.yylval = new ParserVal((Object)"!=");
                        return Parser.RELOP;
                    }
                    else {
                        return -1;
                    }

                case 31:
                    c = NextChar();
                    if (c == '='){
                        yyparser.yylval = new ParserVal((Object)"<=");
                        return Parser.RELOP;
                    }
                    else if(isNum(c) || isLetterOr_(c) || isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)"<");
                        return Parser.RELOP;
                    }
                    else{
                        error = true;
                        yyparser.yylval = new ParserVal("<");
                        return Parser.RELOP;
                    }

                case 32:
                    c = NextChar();
                    if (c == '='){
                        yyparser.yylval = new ParserVal((Object)">=");
                        return Parser.RELOP;
                    }
                    else if(isNum(c) || isLetterOr_(c) || isOther(c)){
                        f--;
                        yyparser.yylval = new ParserVal((Object)">");
                        return Parser.RELOP;
                    }
                    else{
                        error = true;
                        yyparser.yylval = new ParserVal((Object)">");
                        return Parser.RELOP;
                    }


            }
        }
    }



    public boolean isNum(char c){
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
            return true;
        }
        return false;
    }

    public boolean isLetterOr_(char c){
        if (c >= (char)65 && c <= (char)90 || c >= (char)97 && c <= (char)122 || c == '_'){
            return true;
        }
        return false;
    }

    public boolean isOther(char c){
        if (c == ')' || c == '(' || c == '=' || c == '-' || c == '*' || c == '/' || c == ';' || c == ',' || c == '<' || c == '>' || c == '=' || c == '!' || c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == EOF){
            return true;
        }
        return false;

    }
}
