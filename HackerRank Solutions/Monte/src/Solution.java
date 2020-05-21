import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(r.readLine());
        int[] blocks = new int[m + 2];
        for (int i = 1; i < blocks.length - 1; i++){
            int b = Integer.parseInt(r.readLine());;
            blocks[b] = 1;
        }

        for (int i = 1; i < blocks.length; i++){
            if (blocks[i] == 0){
                System.out.println(i);
                return;
            }

        }
    }
}
