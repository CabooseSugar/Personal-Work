package exercise6;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
        // Constructing the maze
        Node nodeA = new Node('A'); // creates A as the starting node
        Node nodeE = new Node('E'); // creates E
        nodeA.connectToBottom(nodeE, "top"); // connects bottom of A to top of E

        Node nodeI = new Node('I');
        nodeE.connectToBottom(nodeI, "top");

        Node nodeJ = new Node('J');
        nodeI.connectToRight(nodeJ, "left");

        Node nodeB = new Node('B');
        nodeA.connectToRight(nodeB, "left");

        Node nodeF = new Node('F');
        nodeB.connectToBottom(nodeF, "top");

        Node nodeG = new Node('G');
        nodeF.connectToRight(nodeG, "left" );

        Node nodeK = new Node('K');
        nodeG.connectToBottom(nodeK, "top");

        Node nodeC = new Node('C');
        nodeG.connectToTop(nodeC, "bottom");

        Node nodeD = new Node ('D');
        nodeC.connectToRight(nodeD, "left");

        Node nodeH = new Node ('H');
        nodeG.connectToRight(nodeH, "left");

        Node nodeL = new Node('L', true); // end of maze node
        nodeH.connectToBottom(nodeL, "top");


        // Rest of code
        Node currentNode = nodeA;

        while(currentNode.isEnd() != true) {
            printNodeInfo(currentNode);
            currentNode = move(currentNode);
        }

        System.out.println("You've reached the end!");
    }

    // Print info about node player is currently in
    static void printNodeInfo(Node currentNode) {
        System.out.print("You are in room " + currentNode.getName() +
                " of a maze of twisty little passages, all alike. ");
        if (currentNode.getTop() != null)
            System.out.print("You can go North. ");
        if (currentNode.getLeft() != null)
            System.out.print("You can go West. ");
        if (currentNode.getRight() != null)
            System.out.print("You can go East. ");
        if (currentNode.getBottom() != null)
            System.out.print("You can go South. ");
        System.out.print("\n");
    }

    // Accepts entry for player movement direction
    static Node move(Node currentNode) {
        Scanner keyboard = new Scanner(System.in);
        Character entry;

        while(true) {
            System.out.println("Enter the direction you wish to go.");
            System.out.println("(N for North, S for South, E for East, W for West)");
            System.out.print("Entry: ");

            entry = keyboard.next().charAt(0);

            // Handling cases where player enters direction they can't move in
            if (entry.toUpperCase(entry) == 'N' && currentNode.getTop() == null) {
                System.out.println("Can't go that way!");
                continue;
            }
            if (entry.toUpperCase(entry) == 'W' && currentNode.getLeft() == null) {
                System.out.println("Can't go that way!");
                continue;
            }
            if (entry.toUpperCase(entry) == 'E' && currentNode.getRight() == null) {
                System.out.println("Can't go that way!");
                continue;
            }
            if (entry.toUpperCase(entry) == 'S' && currentNode.getBottom() == null) {
                System.out.println("Can't go that way!");
                continue;
            }

            // Moving
            if (entry.toUpperCase(entry) == 'N') {
                Node newLocation = currentNode.getTop();
                System.out.println(); // just so console output looks more presentable
                return newLocation;
            }
            if (entry.toUpperCase(entry) == 'W') {
                Node newLocation = currentNode.getLeft();
                System.out.println();
                return newLocation;
            }
            if (entry.toUpperCase(entry) == 'E') {
                Node newLocation = currentNode.getRight();
                System.out.println();
                return newLocation;
            }
            if (entry.toUpperCase(entry) == 'S') {
                Node newLocation = currentNode.getBottom();
                System.out.println();
                return newLocation;
            }
        }
    }
}

/*
You are in room A of a maze of twisty little passages, all alike. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: n
Can't go that way!
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: W
Can't go that way!
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: S

You are in room E of a maze of twisty little passages, all alike. You can go North. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  S

You are in room I of a maze of twisty little passages, all alike. You can go North. You can go East.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: E

You are in room J of a maze of twisty little passages, all alike. You can go West.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  W

You are in room I of a maze of twisty little passages, all alike. You can go North. You can go East.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  N

You are in room E of a maze of twisty little passages, all alike. You can go North. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  N

You are in room A of a maze of twisty little passages, all alike. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  E

You are in room B of a maze of twisty little passages, all alike. You can go West. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  S

You are in room F of a maze of twisty little passages, all alike. You can go North. You can go East.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  E

You are in room G of a maze of twisty little passages, all alike. You can go North. You can go West. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  S

You are in room K of a maze of twisty little passages, all alike. You can go North.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  N

You are in room G of a maze of twisty little passages, all alike. You can go North. You can go West. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  N

You are in room C of a maze of twisty little passages, all alike. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: E

You are in room D of a maze of twisty little passages, all alike. You can go West.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: W

You are in room C of a maze of twisty little passages, all alike. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: S

You are in room G of a maze of twisty little passages, all alike. You can go North. You can go West. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: W

You are in room F of a maze of twisty little passages, all alike. You can go North. You can go East.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  E

You are in room G of a maze of twisty little passages, all alike. You can go North. You can go West. You can go East. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry:  E

You are in room H of a maze of twisty little passages, all alike. You can go West. You can go South.
Enter the direction you wish to go.
(N for North, S for South, E for East, W for West)
Entry: S

You've reached the end!

Process finished with exit code 0

 */