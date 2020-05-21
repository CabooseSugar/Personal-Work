import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.util.Random;
public class TestGen{

    public static void main(String []args) throws IOException, FileNotFoundException  {
        int num = 10000;
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Larry\\Desktop\\College\\2019-2020\\CMPSC463\\" +
                "ProblemSet5Full\\test14.txt"));
        Random random = new Random();
        writer.write(Integer.toString(num));
        writer.newLine();
        for (int i = 0; i< num; i++){
            int randomInt = random.nextInt(10);
            //System.out.println(randomInt);
            writer.write(Integer.toString(randomInt));
            //writer.write(Integer.toString(i));
            writer.write(" a");
            writer.newLine();

        }
        writer.close();
    }
}