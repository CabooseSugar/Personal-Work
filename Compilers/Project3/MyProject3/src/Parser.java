// Kyle Wolf and Danny Ruan
public class Parser
{
    public static final int ENDMARKER   =  0;
    public static final int LEXERROR    =  1;

    public static final int INT         = 11;
    public static final int BEGIN       = 12;
    public static final int END         = 13;
    public static final int LPAREN      = 14;
    public static final int RPAREN      = 15;
    public static final int BOOL        = 16;    
    public static final int ASSIGN      = 17;
    public static final int EXPROP      = 18;
    public static final int TERMOP      = 19;
    public static final int SEMI        = 20;
    public static final int INT_LIT     = 21;
    public static final int IDENT       = 22;
    public static final int BOOL_LIT    = 23;
    public static final int RELAOP      = 24;
    public static final int LBRACK      = 25;
    public static final int RBRACK      = 26;
    public static final int IF          = 27;
    public static final int ELSE        = 28;
    public static final int WHILE       = 29;
    public static final int COMMA       = 30;

    public class Token {
        public int       type;
        public ParserVal attr;
        public Token(int type, ParserVal attr) {
            this.type   = type;
            this.attr   = attr;
        }
    }

    public ParserVal yylval;
    Token _token;
    Lexer _lexer;
    public Parser(java.io.Reader r) throws Exception
    {
        _lexer = new Lexer(r, this);
        _token = null;
        Advance();
    }
    
    public void Advance() throws Exception
    {
        int token_type = _lexer.yylex();
        if(token_type ==  0)      _token = new Token(ENDMARKER , null  );
        else if(token_type == -1) _token = new Token(LEXERROR  , yylval);
        else                      _token = new Token(token_type, yylval);
    }

    public String Match(int token_type) throws Exception
    {
        boolean match = (token_type == _token.type);
        String errorToken = "";
        if(match == false)
        {
        	switch(token_type) {
            case 11:
                errorToken = "\"int\"";
                break;
            case 12:
            	errorToken = "\"{\"";
                break;
            case 13:
            	errorToken = "\"}\"";
                break;
            case 14:
            	errorToken = "\"(\"";
                break;
            case 15:
            	errorToken = "\")\"";
                break;
            case 16:
            	errorToken = "\"bool\"";
                break;
            case 17:
            	errorToken = "\"=\"";
                break;
            case 18:
            	errorToken = "\"+\", \"-\", or \"or\"";
                break;
            case 19:
            	errorToken = "\"*\", \"/\", or \"and\"";
                break;
            case 20:
            	errorToken = "\";\"";
                break;
            case 21:
            	errorToken = "An integer value";
                break;
            case 22:
            	errorToken = "An identifier";
                break;
            case 23:
            	errorToken = "A boolean value";
                break;
            case 24:
            	errorToken = "\">\", \"<\", \">=\", \"<=\", \"!=\", or \"==\"";
                break;
            case 25:
            	errorToken = "\"[\"";
                break;
            case 26:
            	errorToken = "\"]\"";
                break;
            case 27:
            	errorToken = "\"if\"";
                break;
            case 28:
            	errorToken = "\"else\"";
                break;
            case 29:
            	errorToken = "\"while\"";
                break;
            case 30:
            	errorToken = "\",\"";
        	}
            throw new Exception(errorToken + " is expected instead of \"" + _token.attr.obj + "\"");
        }
        else if (_token.type != ENDMARKER)
            Advance();

        return "";
    }

    public int yyparse() throws Exception
    {
        try
        {
            parse();
            System.out.println("Success: no syntax error is found.");
        }
        catch(Exception e)
        {
            System.out.println("Error: There is syntax error(s).");
            System.out.print(e.getMessage());
            
            _lexer.column -= _lexer.yytext().length();
            System.out.print(" at " + _lexer.lineno + ":" + _lexer.column + ".");
        }
        return 0;
    }

    public String parse() throws Exception
    {
        return program();
    }

    public String program() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
            	decl_list();
            case ENDMARKER:
                return "";
        }
        throw new Exception("Invalid start of program");
    }
    public String decl_list() throws Exception
    {
        switch(_token.type)
        {
        	case INT:
        	case BOOL:
        		decl_list_();
        	case ENDMARKER:
        		return "";
        }
        throw new Exception("Invalid declarations");
    }
    public String decl_list_() throws Exception
    {
        switch(_token.type)
        {
        	case INT:
        	case BOOL:
        		fun_decl();
        		decl_list_();
        	case ENDMARKER:
        		return "";
        }
        throw new Exception("An incorrect function format is declared");
    }
    public String type_spec() throws Exception
    {
    	switch(_token.type)
        {
            case INT:
                Match(INT);
                type_spec_();
                return "";
            case BOOL:
                Match(BOOL);
                type_spec_();
                return "";
            case IDENT:
                throw new Exception("There is an expression error");
        }
        throw new Exception("Need an int or a bool declaration");
    }
    public String fun_decl() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
                type_spec();    
                Match(IDENT);   
                Match(LPAREN);  
                params();       
                Match(RPAREN);  
                compound_stmt();
                return "";
            case ENDMARKER:
                throw new Exception("There is an expression error");
        }
        throw new Exception("Need an int or a bool declaration");
    }
    public String params() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
                param_list();
            case RPAREN:
                return "";
        }
        throw new Exception("Invalid parameters");
    }
    public String compound_stmt() throws Exception
    {
    	switch(_token.type)
        {
            case INT:
            case BOOL:
            case END:
            case IF:
            case ELSE:
            case WHILE:
            case SEMI:
            case IDENT:
            case ENDMARKER:
                throw new Exception("There is an expression error");
            case BEGIN:
                Match(BEGIN);
                local_decls();
                stmt_list();
                Match(END);
                return "";
        }
        throw new Exception("\"{\" is expected instead of \"" + _token.attr.obj + "\"");
    }
    public String arg_list() throws Exception
    {
        switch(_token.type)
        {
            case LPAREN:
            case IDENT:
            case INT_LIT:
            case BOOL_LIT:
                expr();
                arg_list_();
                return "";
        }
        throw new Exception("An incorrect function format is declared");
    }
    public String arg_list_() throws Exception
    {
        switch(_token.type)
        {
            case COMMA:
                Match(COMMA);
                expr();
                arg_list_();
            case RPAREN:
                return "";
        }
        throw new Exception("There is a wrong argument format");
    }
    public String args() throws Exception
    {
        switch(_token.type)
        {
            case LPAREN:
            case IDENT:
            case INT_LIT:
            case BOOL_LIT:
                expr();
                arg_list_();
            case RPAREN:
                return "";
        }
        throw new Exception("An incorrect function format is declared");
    }
    public String expr() throws Exception
    {
        switch(_token.type)
        {
            case LPAREN:
            case IDENT:
            case INT_LIT:
            case BOOL_LIT:
                term();
                expr_();
                return"";
            case RPAREN:
                throw new Exception("There is an expression error");
            case RBRACK:
                throw new Exception("There is an expression error");
            case COMMA:
                throw new Exception("There is an expression error");
            case SEMI:
                throw new Exception("There is an expression error");
        }
        throw new Exception("There is an incorrect parameter format of a function");
    }
    public String expr_() throws Exception
    {
        switch(_token.type)
        {
            case EXPROP:
                Match(EXPROP);
                term();
                expr_();
                return "";
            case RELAOP:
                Match(RELAOP);
                term();
                expr_();
            case COMMA:
            case SEMI:
            case RPAREN:
            case RBRACK:
                return "";
        }
        throw new Exception("There is a wrong argument format");
    }
    public String expr_stmt() throws Exception
    {
        switch(_token.type)
        {
            case IDENT:
                Match(IDENT);
                Match(ASSIGN);
                expr();
                return "";
            case SEMI:
                throw new Exception("There is an expression error");
        }
        throw new Exception("There is a wrong argument format");
    }
    public String factor() throws Exception
    {
        switch(_token.type) {
        case LPAREN:
            Match(LPAREN);
            expr();
            Match(RPAREN);
            return"";
        case IDENT:
            Match(IDENT);
            factor_();
            return "";
        case INT_LIT:
            Match(INT_LIT);
            return "";
        case BOOL_LIT:
            Match(BOOL_LIT);
            return "";
        case RPAREN:
        case RBRACK:
        case EXPROP:
        case TERMOP:
        case RELAOP:
        case COMMA:
        case SEMI:
            throw new Exception("There is an expression error");
    }
    throw new Exception("There is an expression error");
    }
    public String factor_() throws Exception
    {
        switch(_token.type) {
        case LPAREN:
            Match(LPAREN);
            args();
            Match(RPAREN);
            return"";
        case LBRACK:
            Match(LBRACK);
            expr();
            Match(RBRACK);
        case RBRACK:
        case EXPROP:
        case TERMOP:
        case RELAOP:
        case COMMA:
        case SEMI:
        case RPAREN:
            return "";
    }
    throw new Exception("There is an expression error");
    }
    public String if_stmt() throws Exception
    {
        switch(_token.type)
        {
            case IF:
                Match(IF);
                Match(LPAREN);
                expr();
                Match(RPAREN);
                stmt();
                Match(ELSE);
                stmt();
                return "";
            case ELSE:
            case SEMI:
            case IDENT:
            case BEGIN:
            case END:
                throw new Exception("There is an expression error");
        }
        throw new Exception("There is a wrong argument format");
    }
    public String local_decl() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
                type_spec();
                Match(IDENT);
                Match(SEMI);
                return "";
            case BEGIN:
            case END:
            case IF:
            case WHILE:
            case SEMI:
            case IDENT:
                throw new Exception("There is an expression error");
        }
        throw new Exception("There is an incorrect parameter format of a function");
    }
    public String local_decls() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
                local_decls_();
                return "";
            case BEGIN:
            case END:
            case IF:
            case WHILE:
            case SEMI:
            case IDENT:
                return "";
        }
        throw new Exception("An incorrect function format is declared");
    }
    public String local_decls_() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
                local_decl();
                local_decls_();
            case BEGIN:
            case END:
            case IF:
            case WHILE:
            case SEMI:
            case IDENT:
                return "";
        }
        throw new Exception("An incorrect function format is declared");
    }
    public String param() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
                type_spec();
                Match(IDENT);
                return "";
            case RPAREN:
            case COMMA:
                throw new Exception("There is an expression error");
        }
        throw new Exception("There is an incorrect parameter format of a function");
    }
    public String param_list() throws Exception
    {
        switch(_token.type)
        {
            case INT:
            case BOOL:
                param();
                param_list_();
                return "";
            case RPAREN:
                throw new Exception("There is an expression error");
        }
        throw new Exception("There is an incorrect parameter format of a function");
    }
    public String param_list_() throws Exception
    {
        switch(_token.type)
        {
            case COMMA:
                Match(COMMA);
                param();
                param_list_();
            case RPAREN:
                return "";
        }
        throw new Exception("There is an incorrect parameter format of a function");
    }
    public String stmt() throws Exception
    {
        switch(_token.type)
        {
            case BEGIN:
                compound_stmt();
                return "";
            case IF:
                if_stmt();
                return "";
            case WHILE:
                while_stmt();
                return "";
            case SEMI:
                Match(SEMI);
                return "";
            case IDENT:
                expr_stmt();
                Match(SEMI);
                return "";
            case END:
            case ELSE:
                throw new Exception("There is an expression error");
        }
        throw new Exception("Need an identifier");
    }
    public String stmt_list() throws Exception
    {
        switch(_token.type)
        {
            case BEGIN:
            case IF:
            case WHILE:
            case SEMI:
            case IDENT:
                stmt_list_();
            case END:
                return "";
        }
        throw new Exception("There is an incorrect parameter format of a function");
    }
    public String stmt_list_() throws Exception
    {
        switch(_token.type)
        {
            case BEGIN:
            case IF:
            case WHILE:
            case SEMI:
            case IDENT:
                stmt();
                stmt_list_();
            case END:
                return "";
        }
        throw new Exception("There must be a (if, while, assignment, or compound) statement");
    }
    public String term() throws Exception
    {
        switch(_token.type)
        {
            case LPAREN:
            case IDENT:
            case INT_LIT:
            case BOOL_LIT:
                factor();
                term_();
                return "";
            case RPAREN:
            case RBRACK:
            case EXPROP:
            case RELAOP:
            case COMMA:
            case SEMI:
                throw new Exception("There is an expression error");
        }
        throw new Exception("An incorrect function format is declared");
    }
    public String term_() throws Exception
    {
        switch(_token.type) {
            case TERMOP:
                Match(TERMOP);
                factor();
                term_();
            case RELAOP:
            case COMMA:
            case SEMI:
            case RPAREN:
            case RBRACK:
            case EXPROP:
                return "";
        }
        throw new Exception("There is an expression error");
    }
    public String type_spec_() throws Exception
    {
        switch(_token.type)
        {
            case LBRACK:
                Match(LBRACK);
                Match(RBRACK);
                type_spec_();
            case IDENT:
                return "";
        }
        throw new Exception("An incorrect type format is declared");
    }
    public String while_stmt() throws Exception
    {
        switch(_token.type)
        {
            case WHILE:
                Match(WHILE);
                Match(LPAREN);
                expr();
                Match(RPAREN);
                stmt();
                return "";
            case SEMI:
            case IDENT:
            case BEGIN:
            case END:
            case IF:
            case ELSE:
                throw new Exception("There is an expression error");
        }
        throw new Exception("There is a wrong argument format");
    }
}
