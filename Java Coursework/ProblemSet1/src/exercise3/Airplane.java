package exercise3;

import java.util.Scanner;

public class Airplane {
    public static void main(String[] args) {
        //Declaring objects and variables
        Airplane testPlane = new Airplane();
        String entry;

        Scanner keyboard = new Scanner(System.in);

        // Makes loop run until all seats are full
        while(testPlane.allFull() == false) {

            testPlane.displaySeats();

            // While loop to catch forbidden entry "X" (breaks program if allowed to go through)
            while (true) {
                System.out.print("Enter seat designation: ");
                entry = keyboard.next();
                if (entry.equals("X")) {
                    System.out.println("Forbidden entry.\n");
                    continue;
                }
                // Catches already reserved seats
                else if (testPlane.searchSeats(entry) == false) {
                    System.out.println("Seat unavailable/taken.");
                    break;
                }
                else {
                    System.out.println("Seat reserved.");
                    break;
                }
            }
        }

        testPlane.displaySeats();
        System.out.println("All seats full.");
    }

    // INSTANCE DATA
    private String seats[] = {
            "1A", "1B", "1C", "1D", //3
            "2A", "2B", "2C", "2D", // 7
            "3A", "3B", "3C", "3D", // 11
            "4A", "4B", "4C", "4D",
            "5A", "5B", "5C", "5D",
            "6A", "6B", "6C", "6D",
            "7A", "7B", "7C", "7D"};

    // MUTATOR METHODS
    // Search all seats to see if entry matches an available one
    public boolean searchSeats(String seat) {
        for (int i =0; i < 28; i++) {
            if (this.seats[i].equals(seat)) {
                this.seats[i] = " X"; // handles changing seat to X for reserved when seat is found
                return true;
            }
        }
        return false;
    }

    // Checks if all seats are full
    public boolean allFull() {
        for (int i =0; i < 28; i++) {
            if (!this.seats[i].equals("X"))
                return false;
        }
        return true;
    }

    // Prints seat grid to screen
    public void displaySeats(){
        int rowCount = 0;

        System.out.print("\n");

        for (int i = 0; i < 28; i++) {
            System.out.print(seats[i] + " ");
            if (i == 3 || i == (3+4*rowCount)) {
                System.out.print("\n");
                rowCount++;
            }
        }
    }

}

/*
1A 1B 1C 1D
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C 5D
6A 6B 6C 6D
7A 7B 7C 7D
Enter seat designation: 1A
Seat reserved.

 X 1B 1C 1D
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C 5D
6A 6B 6C 6D
7A 7B 7C 7D
Enter seat designation: 1A
Seat unavailable/taken.

 X 1B 1C 1D
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C 5D
6A 6B 6C 6D
7A 7B 7C 7D
Enter seat designation: X
Forbidden entry.

Enter seat designation: 1B
Seat reserved.

 X  X 1C 1D
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C 5D
6A 6B 6C 6D
7A 7B 7C 7D
Enter seat designation: 1C
Seat reserved.

 X  X  X 1D
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C 5D
6A 6B 6C 6D
7A 7B 7C 7D
Enter seat designation: 1D
Seat reserved.

 X  X  X  X
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C 5D
6A 6B 6C 6D
7A 7B 7C 7D
Enter seat designation: 6C
Seat reserved.

 X  X  X  X
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C 5D
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 5D
Seat reserved.

 X  X  X  X
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 6C
Seat unavailable/taken.

 X  X  X  X
2A 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 2A
Seat reserved.

 X  X  X  X
 X 2B 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 2B
Seat reserved.

 X  X  X  X
 X  X 2C 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 2C
Seat reserved.

 X  X  X  X
 X  X  X 2D
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 2D
Seat reserved.

 X  X  X  X
 X  X  X  X
3A 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 3A
Seat reserved.

 X  X  X  X
 X  X  X  X
 X 3B 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 3B
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X 3C 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 3C
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X 3D
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 3D
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
4A 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 4A
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X 4B 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 4B
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X 4C 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 4C
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X 4D
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 4D
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
5A 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 5A
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X 5B 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 5B
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X 5C  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 5C
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
6A 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 6A
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X 6B  X 6D
7A 7B 7C 7D
Enter seat designation: 6B
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X 6D
7A 7B 7C 7D
Enter seat designation: 6D
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
7A 7B 7C 7D
Enter seat designation: 7A
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X 7B 7C 7D
Enter seat designation: 7B
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X 7C 7D
Enter seat designation: 7C
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X 7D
Enter seat designation: 7D
Seat reserved.

 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
 X  X  X  X
All seats full.
 */