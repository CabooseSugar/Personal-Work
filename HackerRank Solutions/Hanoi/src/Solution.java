import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int numPegs = sc.nextInt();
            if (numPegs == -1)
                break;

            sc.nextLine();
            String line = sc.nextLine();
            line = line.replaceAll("\\s", "");
            char[] lineArr = line.toCharArray();

            Stack peg0 = new Stack();
            for (int i = 1; i < lineArr.length; i++){
                peg0.push((int)lineArr[i] - 48);
            }

            line = sc.nextLine();
            line = line.replaceAll("\\s", "");
            lineArr = line.toCharArray();

            Stack peg1 = new Stack();
            for (int i = 1; i < lineArr.length; i++){
                peg1.push((int)lineArr[i] - 48);
            }

            line = sc.nextLine();
            line = line.replaceAll("\\s", "");
            lineArr = line.toCharArray();

            Stack peg2 = new Stack();
            for (int i = 1; i < lineArr.length; i++){
                peg2.push((int)lineArr[i] - 48);
            }

            List<Stack> stacks = new ArrayList<>();
            List<List<Stack>> memo = new ArrayList<>();
            stacks.add(peg0);
            stacks.add(peg1);
            stacks.add(peg2);
            memo.add(stacks);
            int leastMoves = solver(stacks, memo, 0, Integer.MAX_VALUE, numPegs);
            System.out.println(leastMoves);
        }

    }

    static int solver(List<Stack> stacks, List<List<Stack>> memo, int moves, int lowestMoves, int numPegs){
        List<Integer[]> possibleMoves = new ArrayList<>();

        if (stacks.get(2).size() == numPegs){
            if (moves <= lowestMoves){
                return moves;
            }
            else{
                return lowestMoves;
            }
        }

        int peg0Top = Integer.MAX_VALUE;
        int peg1Top = Integer.MAX_VALUE;
        int peg2Top = Integer.MAX_VALUE;

        if (!stacks.get(0).isEmpty()) {
            peg0Top = (int) stacks.get(0).peek();
        }
        if (!stacks.get(1).isEmpty()) {
            peg1Top = (int) stacks.get(1).peek();
        }
        if (!stacks.get(2).isEmpty()) {
            peg2Top = (int) stacks.get(2).peek();
        }


        // Possible moves from peg 0
        if ((stacks.get(1).isEmpty() || peg1Top > peg0Top) && !stacks.get(0).isEmpty()){
            Integer[] t = {0,1};
            possibleMoves.add(t);
        }
        if ((stacks.get(2).isEmpty() || peg2Top > peg0Top) && !stacks.get(0).isEmpty()){
            Integer[] t = {0,2};
            possibleMoves.add(t);
        }

        // Possible moves from peg 1
        if ((stacks.get(0).isEmpty() || peg0Top > peg1Top) && !stacks.get(1).isEmpty()){
            Integer[] t = {1,0};
            possibleMoves.add(t);
        }
        if ((stacks.get(2).isEmpty() || peg2Top > peg1Top) && !stacks.get(1).isEmpty()){
            Integer[] t = {1,2};
            possibleMoves.add(t);
        }

        // Possible moves from peg 2
        if ((stacks.get(0).isEmpty() || peg0Top > peg2Top) && !stacks.get(2).isEmpty()){
            Integer[] t = {2,0};
            possibleMoves.add(t);
        }
        if ((stacks.get(1).isEmpty() || peg1Top > peg2Top) && !stacks.get(2).isEmpty()){
            Integer[] t = {2,1};
            possibleMoves.add(t);
        }

        // look through possible moves
        if (possibleMoves.isEmpty()){
            return Integer.MAX_VALUE;
        }

        int lowest = lowestMoves;
        for (int i = 0; i < possibleMoves.size(); i++){
            int from = possibleMoves.get(i)[0];
            int to = possibleMoves.get(i)[1];

            List<Stack> tempStacks = new ArrayList<>();

            Stack tempStack1 = (Stack) stacks.get(0).clone();
            Stack tempStack2 = (Stack) stacks.get(1).clone();
            Stack tempStack3 = (Stack) stacks.get(2).clone();
            tempStacks.add(tempStack1);
            tempStacks.add(tempStack2);
            tempStacks.add(tempStack3);

            int temp = (int) tempStacks.get(from).pop();
            tempStacks.get(to).push(temp);

            if (!memo.contains(tempStacks)) {
                memo.add(tempStacks);
                int tempLowest = solver(tempStacks, memo, moves + 1, lowestMoves, numPegs);
                if (tempLowest <= lowest) {
                    lowest = tempLowest;
                }
            }
        }

        return lowest;

    }
}


// problem with this is memo (not really a memo at all) does not allow for repeating states, but the way it gets to that state is not
// always the fastest way. A state being in memo might stop a higher level of recursion (less moves) from using it