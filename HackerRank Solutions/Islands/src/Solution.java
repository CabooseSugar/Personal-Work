import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        char[][] board = new char[n][m];

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            char[] arr = line.toCharArray();
            for (int j = 0; j < m; j++){
                board[i][j] = arr[j];
            }
        }

        minIslands(board);
        System.out.println(islandCount(board));
    }


    private static int islandCount(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        int c = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'L' && visited[i][j] == 0) {
                    c++;
                    recExplore(board, i, j, visited);
                }
            }
        }
        return c;
    }

    private static void recExplore(char[][] board, int i, int j, int[][] visited){
        visited[i][j] = 1;

        // check up
        if (i - 1 >= 0 && board[i-1][j] == 'L' && visited[i-1][j] != 1){
            recExplore(board, i - 1, j, visited);
        }

        // check down
        if (i + 1 < board.length && board[i+1][j] == 'L' && visited[i+1][j] != 1){
            recExplore(board, i + 1, j, visited);
        }

        // check left
        if (j - 1 >= 0 && board[i][j-1] == 'L' && visited[i][j-1] != 1){
            recExplore(board, i, j - 1, visited);
        }

        // check right
        if (j + 1 < board[0].length && board[i][j+1] == 'L' && visited[i][j+1] != 1){
            recExplore(board, i, j+1, visited);
        }
    }


    private static void minIslands(char[][] board) {
        boolean changeMade = true;

        while (changeMade){
            changeMade = false;
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){

                    // check up
                    if (board[i][j] == 'L' && i - 1 >= 0 && board[i-1][j] == 'C'){
                        board[i-1][j] = 'L';
                        changeMade = true;
                    }
                    // check down
                    if (board[i][j] == 'L' && i + 1 < board.length && board[i+1][j] == 'C'){
                        board[i+1][j] = 'L';
                        changeMade = true;
                    }
                    // check left
                    if (board[i][j] == 'L' && j - 1 >= 0 && board[i][j - 1] == 'C'){
                        board[i][j-1] = 'L';
                        changeMade = true;
                    }
                    // check right
                    if (board[i][j] == 'L' && j + 1 < board[0].length && board[i][j+1] == 'C'){
                        board[i][j+1] = 'L';
                        changeMade = true;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'C') {
                    board[i][j] = 'W';
                }
            }
        }
    }
}
