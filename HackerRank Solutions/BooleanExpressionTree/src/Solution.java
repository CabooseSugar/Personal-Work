import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node {
    Character val;
    Node parent;
    Node leftChild;
    Node rightChild;
}


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for (int i = 0; i < n; i++){
            int s = sc.nextInt();
            sc.nextLine();

            List<Character> syms = new ArrayList<>();
            for (int j = 0; j < s; j++){
                Character next = sc.next().charAt(0);
                syms.add(next);
            }


            Node head = new Node();
            Node p = head;
            for (int j = syms.size() -1; j >= 0; j--){
                if (syms.get(j) == '^'){
                    p.val = '^';
                    
                }


            }






        }
    }
}
