public class SubExpression {
    String expression;

    public SubExpression(String input) {
        expression = input;
    }

    public boolean evaluate(Configuration config){
        char[] expArr = expression.toCharArray();
        for (int i = 0; i < expArr.length; i++){
            if (expArr[i] == ' '){
                continue;
            }

            if (expArr[i] == '!'){
                if (config.values[expArr[i+1] - 'A'] == 1){
                    i++;
                    continue;
                }
                else{
                    i++;
                    return true;
                }
            }

            if (config.values[expArr[i] - 'A'] == 0){
                    continue;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
