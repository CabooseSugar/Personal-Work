import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char board[][] = new char[8][8];
        for (int i = 0; i < 8; i++){
            String line = sc.nextLine();
            char[] lineArr = line.toCharArray();
            for (int j = 0; j < 8; j++){
                board[i][j] = lineArr[j];
            }
        }

        int currI = 0;
        int currJ = 0;

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (board[i][j] == '*'){
                    if (!check(board, i, j)){
                        System.out.println("invalid");
                        return;
                    }
                }

            }
        }

        System.out.println("valid");
    }

    static boolean check (char[][] board, int qi, int qj){
        // check column
        for (int i = 0; i < 8; i++){
            if (board[i][qj] == '*' && i != qi){
                return false;
            }
        }

        // check row
        for (int j = 0; j < 8; j++){
            if (board[qi][j] == '*' && j != qj){
                return false;
            }
        }

        // check top left - bottom right diag
        int i = qi - 1;
        int j = qj - 1;
        while(i >= 0 && j >= 0){
            if (board[i][j] == '*') {
                return false;
            }

            i--;
            j--;
        }

        i = qi + 1;
        j = qj + 1;
        while(i <= 7 && j <= 7){
            if (board[i][j] == '*') {
                return false;
            }

            i++;
            j++;
        }

        // check top right - bottom left diag
        i = qi - 1;
        j = qj + 1;
        while(i >= 0 && j <= 7){
            if (board[i][j] == '*') {
                return false;
            }

            i--;
            j++;
        }

        i = qi + 1;
        j = qj - 1;
        while(i <= 7 && j >= 0){
            if (board[i][j] == '*') {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
