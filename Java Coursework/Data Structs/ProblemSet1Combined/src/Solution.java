import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Configuration> validConfigs = new ArrayList<>();
        Configuration config = new Configuration(m);
        scanner.nextLine();


        String line = scanner.nextLine();
        SubExpression exp = new SubExpression(line);

        do {
            if (exp.evaluate(config)) {
                Configuration x = new Configuration(m);
                for (int i = 0; i < m; i++){
                    x.values[i] = config.values[i];
                }
                validConfigs.add(x);
            }
        } while(!config.incrementConfig());

        for (int i = 1; i < n; i++){
            line = scanner.nextLine();
            SubExpression newExp = new SubExpression(line);
            validConfigs.removeIf(c -> !newExp.evaluate(c));
        }

        System.out.println(validConfigs.size());

        if (validConfigs.isEmpty()){
            return;
        }

        boolean allZeros = true;
        for (int i = 0; i < m; i++){
            if (validConfigs.get(0).values[i] != 0){
                allZeros = false;
                break;
            }
        }
        if(allZeros){
            return;
        }

        List<String> validConfigsAlpha = new ArrayList<>();
        for (Configuration c: validConfigs){
            StringBuilder configAlpha = new StringBuilder();
            for (int i = 0; i < m; i++){
                if (c.values[i] == 1) {
                    configAlpha.append(Character.toChars('A' + i));
                }
            }
            if (!configAlpha.equals("")) {
                String s = configAlpha.toString();
                validConfigsAlpha.add(s);
            }
        }

        Collections.sort(validConfigsAlpha);

        System.out.println(validConfigsAlpha.get(0));
    }
}

class Configuration {
    int values[];

    public Configuration(int numVars) {
        int values[] = new int[numVars];
        for (int i = 0; i < numVars; i++){
            values[i] = 0;
        }
        this.values = values;
    }

    public boolean incrementConfig(){
        boolean noZeros = true;
        for (int i = values.length - 1; i >= 0; i--){
            if (values[i] == 0){
                noZeros = false;
                values[i] = 1;
                for (int j = i + 1; j < values.length; j++){
                    values[j] = 0;
                }
                break;
            }
        }
        return noZeros;
    }

}

class SubExpression {
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



