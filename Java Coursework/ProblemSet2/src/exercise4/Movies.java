package exercise4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Movies {
    public static void main(String[] args) throws IOException {
        Movies test1 = new Movies("C:\\Users\\Kyle\\Desktop\\College\\2018-2019\\Fall\\CMPSC221\\ProblemSet2\\src\\exercise4\\movieList1.txt");
        Movies test2 = new Movies("C:\\Users\\Kyle\\Desktop\\College\\2018-2019\\Fall\\CMPSC221\\ProblemSet2\\src\\exercise4\\movieList2.txt");

        test1.printInfo();
        System.out.println();
        test2.printInfo();
    }

    // INSTANCE DATA
    private Map<String, Integer> movieRatingMap = new HashMap<>();
    private Map<String, Integer> movieOccurrenceMap = new HashMap<>();


    // CONSTRUCTOR - calls readInfo, new objects must pass the filePath
    public Movies(String filePath) throws IOException {
        readInfo(filePath);
    }

    // READS ALL RELEVANT INFO FROM .TXT FILE AND PUTS IT ALL IN movieMap
    public void readInfo(String filePath) throws IOException {
        File myFile = new File(filePath);
        BufferedReader buffRead = new BufferedReader(new FileReader(myFile));
        int temp;
        String line;

        int numMovies = Integer.parseInt(buffRead.readLine()); // gets number of entries for the for loop from top of file

        for (int i = 0; i < numMovies; i++) {
            line = buffRead.readLine();
            if (movieOccurrenceMap.containsKey(line)) { // if name of duplicate movie (key) appears...
                temp = movieOccurrenceMap.get(line);    // sets temp = to its current concurrence Integer value...
                temp++;                                 // and adds one to hashmap for movie occurrence...
                movieOccurrenceMap.put(line, temp);     // then puts info back into hashmap (new key w/ same name will overwrite old info)

                temp = movieRatingMap.get(line);        // Also reads the next line (rating number) and adds it to hashmap for movie rating sum
                temp += Integer.parseInt(buffRead.readLine());
                movieRatingMap.put(line, temp);
            }
            else {                                      // if movie title is being added for the first time, sets occurrences...
                movieOccurrenceMap.put(line, 1);        // to 1 and rating to next Line
                movieRatingMap.put(line, Integer.parseInt(buffRead.readLine()));
            }
        }
    }

    // CALCULATES AND RETURNS AVERAGE OF MOVIE RATINGS (movie determined by key)
    public double calcAverage(String key){
        double average;

        average = (double)movieRatingMap.get(key);
        average /= movieOccurrenceMap.get(key);

        return average;
    }

    // PRINTS RESULT TO SCREEN
    public void printInfo() {
        double average;
        for (String key : movieRatingMap.keySet())  // iterates through the keySet with for-each loop (to retrieve each key individually)
            System.out.printf(key + ": %s reviews, average of %.1f / 5\n", movieOccurrenceMap.get(key), calcAverage(key)); // calcAverage() call
    }
}

/*
The Thing: 2 reviews, average of 3.5 / 5
Alien: 3 reviews, average of 3.3 / 5
Lord of the Rings: Fellowship of the Ring: 1 reviews, average of 4.0 / 5
Drive: 3 reviews, average of 4.3 / 5
Bladerunner: 1 reviews, average of 5.0 / 5

Iron Man: 1 reviews, average of 2.0 / 5
Platoon: 3 reviews, average of 4.3 / 5
Gladiator: 2 reviews, average of 2.5 / 5
The Martian: 1 reviews, average of 1.0 / 5
Whiplash: 2 reviews, average of 4.0 / 5

Process finished with exit code 0
 */
