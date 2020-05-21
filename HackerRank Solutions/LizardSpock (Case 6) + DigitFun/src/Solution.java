import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            Move p1 = new Move();
            Move p2 = new Move();
            String name1 = sc.next();
            p1.setName(name1);
            String move1 = sc.next();
            p1.setAction(move1);
            String name2 = sc.next();
            p2.setName(name2);
            String move2 = sc.next();
            p2.setAction(move2);
            if(sc.hasNextLine())
                sc.nextLine();

            String winner;
            if (p1.beats(p2)) {
                winner = p1.name;
            }
            else{
                winner = p2.name;
            }

            System.out.println(winner + " wins!");

        }

    }

    private static class Move{
        String name;
        String action;

        boolean beats(Move m){
            String[] legitMoves = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
            List<String> l = new ArrayList<>(Arrays.asList(legitMoves));

            if (action.equals("Scissors") && m.action.equals("Paper"))
                return true;
            if (action.equals("Paper") && m.action.equals("Rock"))
                return true;
            if (action.equals("Rock") && m.action.equals("Lizard"))
                return true;
            if (action.equals("Lizard") && m.action.equals("Spock"))
                return true;
            if (action.equals("Spock") && m.action.equals("Scissors"))
                return true;
            if (action.equals("Scissors") && m.action.equals("Lizard"))
                return true;
            if (action.equals("Lizard") && m.action.equals("Paper"))
                return true;
            if (action.equals("Paper") && m.action.equals("Spock"))
                return true;
            if (action.equals("Spock") && m.action.equals("Rock"))
                return true;
            if (action.equals("Rock") && m.action.equals("Scissors"))
                return true;

            if (action.equals(m.action)){
                if (name.compareTo(m.name) < 0)
                    return true;
                else
                    return false;
            }

            if (!(l.contains(action)) || !(l.contains(m.action)) ) {
                if (!(l.contains(action)) && !(l.contains(m.action))) {
                    if (name.compareTo(m.name) > 0)
                        return true;
                    else
                        return false;
                }

                if (!(l.contains(action)) && (l.contains(m.action)))
                    return false;
                if ((l.contains(action)) && !(l.contains(m.action)))
                    return true;

            }

            return false;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }

}

