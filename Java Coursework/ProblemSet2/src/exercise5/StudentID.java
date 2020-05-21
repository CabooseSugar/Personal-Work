package exercise5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentID {
    public static void main(String[] args) {
        StudentID test = new StudentID();
        int id;
        String course;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter student ID, a space, and a course");
        System.out.println("Enter -1 as an ID to stop entering data:");

        while(true) {
            id = keyboard.nextInt();
            if (id == -1)
                break;
            course = keyboard.next();
            test.addToMap(id, course);
        }

        test.printResult();

    }

    // INSTANCE DATA
    private Map<Integer, ArrayList<String>> students = new HashMap<>();

    // CONSTRUCTOR
    public StudentID() {
    }

    // ADDS IDs AND COURSES TO HASHMAP
    public void addToMap(int id, String course) {
        // retrieves courseList ArrayList from the key (IDs) of the HashMap
        ArrayList<String> courseList = students.get(id);

        // if retrieved courseList ArrayList is empty, makes new ArrayList and adds course to it. Puts this ArrayList into HashMap.
        if (courseList == null) {
            courseList = new ArrayList<>();
            courseList.add(course);
            students.put(id, courseList);
        }
        // else, if retrieved courseList isn't empty, and if courseList doesn't contain course already, adds course to courseList (avoids duplicates)
        else {
            if (!courseList.contains(course))
                courseList.add(course);
        }
    }

    // PRINTS FINAL RESULT TO SCREEN
    public void printResult() {
        System.out.println("\nID | COURSE");
        for (Integer key : students.keySet()) // for - each loop iterates through all keys in keySet of HashMap
            for (String course : students.get(key)) // for - each loop iterates through all courses in ArrayList inside HashMap
                System.out.println(" " + key + " | " + course);
    }
}

/*
Enter student ID, a space, and a course
Enter -1 as an ID to stop entering data:
1 CS100
2 MATH210
2 CS105
1 CS200
3 MATH360
1 MATH360
3 BIO101
4 PHYS212
3 LIT155
-1

ID | COURSE
 1 | CS100
 1 | CS200
 1 | MATH360
 2 | MATH210
 2 | CS105
 3 | MATH360
 3 | BIO101
 3 | LIT155
 4 | PHYS212
 */