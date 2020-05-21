import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static class Bob {
        String currentMove;
        int wins;
        int ties;
        int loses;
        int lastRes;

        public Bob(String currentMove) {
            this.currentMove = currentMove;
            this.wins = 0;
            this.ties = 0;
            this.loses = 0;
        }
    }

    static class Alice {
        String currentMove;
        int wins;
        int ties;
        int loses;

        public Alice(String currentMove) {
            this.currentMove = currentMove;
            this.wins = 0;
            this.ties = 0;
            this.loses = 0;
        }
    }

    static class gameRules{
        Map<String, String[]> xBeatsY = new HashMap();
        Map<String, String[]> xIsBeatenByY = new HashMap();

        public gameRules() {
            String[] scissorsBeats = {"Paper", "Lizard"};
            xBeatsY.put("Scissors", scissorsBeats);
            String[] paperBeats = {"Rock", "Spock"};
            xBeatsY.put("Paper", paperBeats);
            String[] rockBeats = {"Lizard", "Scissors"};
            xBeatsY.put("Rock", rockBeats);
            String[] lizardBeats = {"Spock", "Paper"};
            xBeatsY.put("Lizard", lizardBeats);
            String[] spockBeats = {"Scissors", "Rock"};
            xBeatsY.put("Spock", spockBeats);

            String[] scissorsBeatenBy = {"Rock", "Spock"};
            xIsBeatenByY.put("Scissors",scissorsBeatenBy);
            String[] paperBeatenBy = {"Scissors", "Lizard"};
            xIsBeatenByY.put("Paper", paperBeatenBy);
            String[] rockBeatenBy = {"Paper", "Spock"};
            xIsBeatenByY.put("Rock", rockBeatenBy);
            String[] lizardBeatenBy = {"Rock", "Scissors"};
            xIsBeatenByY.put("Lizard", lizardBeatenBy);
            String[] spockBeatenBy = {"Lizard", "Paper"};
            xIsBeatenByY.put("Spock", spockBeatenBy);
        }

        public int gameRes(String aShape, String bShape){
            if (aShape.equals(bShape)){
                return 3;
            }
            else if (xBeatsY.get(aShape)[0].equals(bShape) || xBeatsY.get(aShape)[1].equals(bShape)){
                return 1;
            }
            else {
                return 2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++){
            String AliceShape = sc.next();
            String BobShape = sc.next();
            int games = sc.nextInt();
            findWinner(AliceShape, BobShape, games);
        }
    }

    private static void findWinner(String firstA, String firstB, int games) {
        Alice a = new Alice(firstA);
        Bob b = new Bob(firstB);
        gameRules g = new gameRules();
        int count;

        if (b.currentMove.equals("Spock")){
            count = 1;
        }
        else {
            count = 0;
        }

        for (int i = 0; i < games; i++) {
            switch (g.gameRes(a.currentMove, b.currentMove)) {
                case 1:
                    a.wins++;
                    b.loses++;
                    b.lastRes = 2;
                    break;

                case 2:
                    String beatsBob1 = g.xIsBeatenByY.get(b.currentMove)[0];
                    String beatsBob2 = g.xIsBeatenByY.get(b.currentMove)[1];
                    if (g.gameRes(beatsBob1, beatsBob2) == 1){
                        a.currentMove = beatsBob1;
                    }
                    else {
                        a.currentMove = beatsBob2;
                    }
                    a.loses++;
                    b.wins++;
                    b.lastRes = 1;
                    break;

                case 3:
                    a.ties++;
                    String beatsAlice1 = g.xIsBeatenByY.get(a.currentMove)[0];
                    String beatsAlice2 = g.xIsBeatenByY.get(a.currentMove)[1];
                    if (g.gameRes(beatsAlice1, beatsAlice2) == 1){
                        a.currentMove = beatsAlice1;
                    }
                    else {
                        a.currentMove = beatsAlice2;
                    }
                    b.ties++;
                    b.lastRes = 3;
                    break;
            }
            count++;

            if (count % 2 == 0){
                if (b.lastRes == 1){
                    b.currentMove = "Rock";
                }
                if (b.lastRes == 2){
                    b.currentMove = "Paper";

                }
                if (b.lastRes == 3){
                    b.currentMove = "Lizard";
                }
            }
            else {
                b.currentMove = "Spock";
            }

        }

        if (a.wins > b.wins){
            System.out.println("Alice wins, by winning " + a.wins + " game(s) and tying " + a.ties + " game(s)");
        }
        if (a.wins == b.wins){
            System.out.println("Alice and Bob tie, each winning " + a.wins + " game(s) and tying " + a.ties + " game(s)");
        }
        if (a.wins < b.wins){
            System.out.println("Bob wins, by winning " + b.wins + " game(s) and tying " + b.ties + " game(s)");
        }
    }
}
