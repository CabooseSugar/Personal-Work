import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int[] board = {1,2,3,4,5,6,7,8,9};

        Scanner sc = new Scanner(System.in);
        List<Integer> madeMoves = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            String line = sc.nextLine();

            if(line.equals("1 1")){
                board[0] = 0;
                madeMoves.add(0);
            }
            if(line.equals("1 2")){
                board[1] = 0;
                madeMoves.add(1);
            }
            if(line.equals("1 3")){
                board[2] = 0;
                madeMoves.add(2);
            }
            if(line.equals("2 1")){
                board[3] = 0;
                madeMoves.add(3);
            }
            if(line.equals("2 2")){
                board[4] = 0;
                madeMoves.add(4);
            }
            if(line.equals("2 3")){
                board[5] = 0;
                madeMoves.add(5);
            }
            if(line.equals("3 1")){
                board[6] = 0;
                madeMoves.add(6);
            }
            if(line.equals("3 2")){
                board[7] = 0;
                madeMoves.add(7);
            }
            if(line.equals("3 3")){
                board[8] = 0;
                madeMoves.add(8);
            }

            if (foundStrat(board)){
                break;
            }
        }

        int responseMoves = 0;
        for(int i = 0; i < 9; i++){
            if (!(madeMoves.contains(i))){
                if(i == 0){
                    System.out.println("1 1");
                }
                if(i == 1){
                    System.out.println("1 2");
                }
                if(i == 2){
                    System.out.println("1 3");
                }
                if(i == 3){
                    System.out.println("2 1");
                }
                if(i == 4){
                    System.out.println("2 2");
                }
                if(i == 5){
                    System.out.println("2 3");
                }
                if(i == 6){
                    System.out.println("3 1");
                }
                if(i == 7){
                    System.out.println("3 2");
                }
                if(i == 8){
                    System.out.println("3 3");
                }
                responseMoves++;
            }

            if (responseMoves == madeMoves.size() -1){
                break;
            }

        }
    }

    static boolean foundStrat(int[] b){
        if (b[0] == 0 && b[1] == 0 && b[2] == 0){
            return true;
        }
        if (b[3] == 0 && b[4] == 0 && b[5] == 0){
            return true;
        }
        if (b[6] == 0 && b[7] == 0 && b[8] == 0){
            return true;
        }
        if (b[0] == 0 && b[3] == 0 && b[6] == 0){
            return true;
        }
        if (b[1] == 0 && b[4] == 0 && b[7] == 0){
            return true;
        }
        if (b[2] == 0 && b[5] == 0 && b[8] == 0){
            return true;
        }
        if (b[0] == 0 && b[4] == 0 && b[8] == 0){
            return true;
        }
        if (b[2] == 2 && b[4] == 0 && b[6] == 0){
            return true;
        }
        return false;
    }
}
