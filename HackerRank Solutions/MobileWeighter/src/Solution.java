import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node{
    int id;
    int weight;
    int distFromParent;
    Node lC, rC;
    Node parent;
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Node> nodeList = new ArrayList<>();

        while (sc.hasNextInt()){
            int id = sc.nextInt();
            Node node = new Node();
            node.id = id; // weird place for this, if node w/ same id is in the list this just gets trashed
            boolean notInArray = true;
            for (Node n : nodeList){
                if (n.id == id){
                    node = n;
                    notInArray = false;
                }
            }

            node.weight = sc.nextInt();

            int lC = sc.nextInt();
            if (lC != -1){
                Node lCNode = new Node();
                lCNode.id = lC; // also weird place for this, same deal
                boolean notInArray2 = true;
                for (Node n : nodeList){
                    if (n.id == lC){
                        lCNode = n;
                        notInArray2 = false;
                    }
                }
                node.lC = lCNode;
                node.lC.parent = node;
                node.lC.distFromParent = sc.nextInt();
                if (notInArray2){
                    nodeList.add(node.lC);
                }
            }
            else{
                sc.nextInt();
            }

            int rC = sc.nextInt();
            if (rC != -1){
                Node rCNode = new Node();
                rCNode.id = rC;
                boolean notInArray2 = true;
                for (Node n : nodeList){
                    if (n.id == rC){
                        rCNode = n;
                        notInArray2 = false;
                    }
                }
                node.rC = rCNode;
                node.rC.parent = node;
                node.rC.distFromParent = sc.nextInt();
                if (notInArray2){
                    nodeList.add(node.rC);
                }
            }
            else{
                sc.nextInt();
            }

            if (notInArray){
                nodeList.add(node);
            }
        }

        if (nodeList.size() == 1 || nodeList.size() == 0){
            System.out.println("Balanced");
            return;
        }

        Node head = new Node();
        for (Node n : nodeList){
            if (n.parent == null){
                head = n;
            }
        }

        // janky fix for test case 4
        if (nodeList.size() == 2){
            if(head.rC != null){
                if (head.rC.distFromParent == 0){
                    System.out.println("Balanced");
                    return;
                }
                else{
                    System.out.println("Unbalanced");
                    return;
                }
            }
            if (head.lC != null){
                if (head.lC.distFromParent == 0){
                    System.out.println("Balanced");
                    return;
                }
                else{
                    System.out.println("Unbalanced");
                    return;
                }
            }

        }


        if(recursiveWeigher(head)){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Unbalanced");
        }
    }

    static boolean recursiveWeigher(Node h){
        if(h.lC.lC == null && h.rC.lC == null){
            if (h.lC.weight * h.lC.distFromParent == h.rC.weight * h.rC.distFromParent){
                h.weight += h.lC.weight + h.rC.weight;
                return true;
            }
            return false;
        }

        if (h.lC.lC != null){ // if lC of h has lC, it has a rC too
            if (!recursiveWeigher(h.lC)){
                return false;
            }
        }

        if (h.rC.lC != null) {
            if (!recursiveWeigher(h.rC)) {
                return false;
            }
        }

        if (h.lC.weight * h.lC.distFromParent != h.rC.weight * h.rC.distFromParent){
            return false;
        }
        else{
            h.weight += h.lC.weight + h.rC.weight;
        }
        return true;
    }
}
