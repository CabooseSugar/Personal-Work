import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] board = new int[8][8];

        //ArrayList<Integer> usedRows = new ArrayList<>();
        ArrayList<Integer> usedCols = new ArrayList<>();
        ArrayList<Integer> usedDiags = new ArrayList<>();


        for(int i = 0; i < 8; i++){
            char[] row = sc.nextLine().toCharArray();
            int queensInRow = 0;
            int queenCol = -1;
            for (int j = 0; j < 8; j++){
                if (row[j] == '*'){
                    if (usedCols.contains(j)){
                        System.out.print("invalid");
                        return;
                    }
                    queenCol = j;
                    usedCols.add(j);
                    queensInRow++;
                }
            }
            if (queensInRow > 1){
                System.out.print("invalid");
                return;
            }
            if (queenCol == -1){
                continue;
            }


            // ROW 1
            //
            //
            if (i == 0 && queenCol == 0){
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

            if (i == 0 && queenCol == 1){
                if (usedDiags.contains(2)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(2);
                if (usedDiags.contains(3)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(3);
            }

            if (i == 0 && queenCol == 2){
                if (usedDiags.contains(4)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(4);
                if (usedDiags.contains(5)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(5);
            }

            if (i == 0 && queenCol == 3){
                if (usedDiags.contains(6)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(6);
                if (usedDiags.contains(7)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(7);
            }

            if (i == 0 && queenCol == 4){
                if (usedDiags.contains(8)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(8);
                if (usedDiags.contains(9)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(9);
            }

            if (i == 0 && queenCol == 5){
                if (usedDiags.contains(10)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(10);
                if (usedDiags.contains(11)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(11);
            }

            if (i == 0 && queenCol == 6){
                if (usedDiags.contains(12)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(12);
                if (usedDiags.contains(13)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(13);
            }

            if (i == 0 && queenCol == 7){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
            }

            // ROW 2
            //
            //
            if (i == 1 && queenCol == 0){
                if (usedDiags.contains(15)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(15);
                if (usedDiags.contains(2)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(2);
            }

            if (i == 1 && queenCol == 1){
                if (usedDiags.contains(4)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(4);
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

            if (i == 1 && queenCol == 2){
                if (usedDiags.contains(6)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(6);
                if (usedDiags.contains(3)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(3);
            }

            if (i == 1 && queenCol == 3){
                if (usedDiags.contains(8)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(8);
                if (usedDiags.contains(5)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(5);
            }

            if (i == 1 && queenCol == 4){
                if (usedDiags.contains(10)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(10);
                if (usedDiags.contains(7)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(7);
            }

            if (i == 1 && queenCol == 5){
                if (usedDiags.contains(12)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(12);
                if (usedDiags.contains(9)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(9);
            }

            if (i == 1 && queenCol == 6){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
                if (usedDiags.contains(11)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(11);
            }

            if (i == 1 && queenCol == 7){
                if (usedDiags.contains(16)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(16);
                if (usedDiags.contains(13)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(13);
            }

            // ROW 3
            //
            //
            if (i == 2 && queenCol == 0){
                if (usedDiags.contains(17)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(17);
                if (usedDiags.contains(4)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(4);
            }

            if (i == 2 && queenCol == 1){
                if (usedDiags.contains(6)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(6);
                if (usedDiags.contains(15)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(15);
            }

            if (i == 2 && queenCol == 2){
                if (usedDiags.contains(8)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(8);
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

            if (i == 2 && queenCol == 3){
                if (usedDiags.contains(10)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(10);
                if (usedDiags.contains(3)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(3);
            }

            if (i == 2 && queenCol == 4){
                if (usedDiags.contains(12)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(12);
                if (usedDiags.contains(5)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(5);
            }

            if (i == 2 && queenCol == 5){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
                if (usedDiags.contains(7)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(7);
            }

            if (i == 2 && queenCol == 6){
                if (usedDiags.contains(16)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(16);
                if (usedDiags.contains(9)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(9);
            }

            if (i == 2 && queenCol == 7){
                if (usedDiags.contains(18)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(18);
                if (usedDiags.contains(11)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(11);
            }

            // ROW 4
            //
            //
            if (i == 3 && queenCol == 0){
                if (usedDiags.contains(19)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(19);
                if (usedDiags.contains(6)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(6);
            }

            if (i == 3 && queenCol == 1){
                if (usedDiags.contains(8)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(8);
                if (usedDiags.contains(17)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(17);
            }

            if (i == 3 && queenCol == 2){
                if (usedDiags.contains(10)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(10);
                if (usedDiags.contains(15)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(15);
            }

            if (i == 3 && queenCol == 3){
                if (usedDiags.contains(12)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(12);
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

            if (i == 3 && queenCol == 4){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
                if (usedDiags.contains(3)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(3);
            }

            if (i == 3 && queenCol == 5){
                if (usedDiags.contains(16)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(16);
                if (usedDiags.contains(5)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(5);
            }

            if (i == 3 && queenCol == 6){
                if (usedDiags.contains(18)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(18);
                if (usedDiags.contains(7)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(7);
            }

            if (i == 3 && queenCol == 7){
                if (usedDiags.contains(20)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(20);
                if (usedDiags.contains(9)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(9);
            }

            // ROW 5
            //
            //
            if (i == 4 && queenCol == 0){
                if (usedDiags.contains(8)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(8);
                if (usedDiags.contains(21)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(21);
            }

            if (i == 4 && queenCol == 1){
                if (usedDiags.contains(10)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(10);
                if (usedDiags.contains(19)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(19);
            }

            if (i == 4 && queenCol == 2){
                if (usedDiags.contains(12)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(12);
                if (usedDiags.contains(17)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(17);
            }

            if (i == 4 && queenCol == 3){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
                if (usedDiags.contains(15)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(15);
            }

            if (i == 4 && queenCol == 4){
                if (usedDiags.contains(16)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(16);
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

            if (i == 4 && queenCol == 5){
                if (usedDiags.contains(18)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(18);
                if (usedDiags.contains(3)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(3);
            }

            if (i == 4 && queenCol == 6){
                if (usedDiags.contains(20)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(20);
                if (usedDiags.contains(5)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(5);
            }

            if (i == 4 && queenCol == 7){
                if (usedDiags.contains(22)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(22);
                if (usedDiags.contains(7)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(7);
            }

            // ROW 6
            //
            //
            if (i == 5 && queenCol == 0){
                if (usedDiags.contains(10)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(10);
                if (usedDiags.contains(23)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(23);
            }

            if (i == 5 && queenCol == 1){
                if (usedDiags.contains(12)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(12);
                if (usedDiags.contains(21)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(21);
            }

            if (i == 5 && queenCol == 2){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
                if (usedDiags.contains(19)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(19);
            }

            if (i == 5 && queenCol == 3){
                if (usedDiags.contains(16)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(16);
                if (usedDiags.contains(17)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(17);
            }

            if (i == 5 && queenCol == 4){
                if (usedDiags.contains(18)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(18);
                if (usedDiags.contains(15)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(15);
            }

            if (i == 5 && queenCol == 5){
                if (usedDiags.contains(20)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(20);
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

            if (i == 5 && queenCol == 6){
                if (usedDiags.contains(22)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(22);
                if (usedDiags.contains(3)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(3);
            }

            if (i == 5 && queenCol == 7){
                if (usedDiags.contains(24)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(24);
                if (usedDiags.contains(5)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(5);
            }

            // ROW 7
            //
            //
            if (i == 6 && queenCol == 0){
                if (usedDiags.contains(25)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(25);
                if (usedDiags.contains(12)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(12);
            }

            if (i == 6 && queenCol == 1){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
                if (usedDiags.contains(23)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(23);
            }

            if (i == 6 && queenCol == 2){
                if (usedDiags.contains(16)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(16);
                if (usedDiags.contains(21)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(21);
            }

            if (i == 6 && queenCol == 3){
                if (usedDiags.contains(18)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(18);
                if (usedDiags.contains(19)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(19);
            }

            if (i == 6 && queenCol == 4){
                if (usedDiags.contains(20)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(20);
                if (usedDiags.contains(17)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(17);
            }

            if (i == 6 && queenCol == 5){
                if (usedDiags.contains(22)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(22);
                if (usedDiags.contains(15)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(15);
            }

            if (i == 6 && queenCol == 6){
                if (usedDiags.contains(24)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(24);
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

            if (i == 6 && queenCol == 7){
                if (usedDiags.contains(26)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(26);
                if (usedDiags.contains(3)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(3);
            }

            // ROW 8
            //
            //
            if (i == 7 && queenCol == 0){
                if (usedDiags.contains(14)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(14);
            }

            if (i == 7 && queenCol == 1){
                if (usedDiags.contains(16)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(16);
                if (usedDiags.contains(25)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(25);
            }

            if (i == 7 && queenCol == 2){
                if (usedDiags.contains(18)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(18);
                if (usedDiags.contains(23)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(23);
            }

            if (i == 7 && queenCol == 3){
                if (usedDiags.contains(20)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(20);
                if (usedDiags.contains(21)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(21);
            }

            if (i == 7 && queenCol == 4){
                if (usedDiags.contains(22)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(22);
                if (usedDiags.contains(19)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(19);
            }

            if (i == 7 && queenCol == 5){
                if (usedDiags.contains(24)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(24);
                if (usedDiags.contains(17)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(17);
            }

            if (i == 7 && queenCol == 6){
                if (usedDiags.contains(26)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(26);
                if (usedDiags.contains(15)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(15);
            }

            if (i == 7 && queenCol == 7){
                if (usedDiags.contains(1)){
                    System.out.print("invalid");
                    return;
                }
                usedDiags.add(1);
            }

        }
        System.out.print("valid");


    }
}
