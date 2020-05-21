package write_to_file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WriteToFileTest {
    public static void main(String[] args) {

        //
        //
        String path = "C:\\Users\\Larry\\Desktop\\College\\2018-2019\\Fall\\CMPSC221\\Week7\\src\\write_to_file\\output.txt";

        //
        // CHECKED EXCEPTION -> requires a try/catch block to work
        try {
            PrintWriter printwriter = new PrintWriter(new FileOutputStream(path));
            printwriter.println("Assassin's Creed Origins");
            printwriter.println("Assassin's Creed Odyssey");
            printwriter.println("Assassin's Creed Black Flag");
            printwriter.close();
        }
        catch (FileNotFoundException ex) {

        }
    }
}
