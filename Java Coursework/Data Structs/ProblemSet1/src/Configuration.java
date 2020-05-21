public class Configuration {
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
