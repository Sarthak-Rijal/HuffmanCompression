import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        
        try {
            FileInputStream input = new FileInputStream("simple.txt");
            int[] count = new int[255];
            int n = input.read();
            while (n != -1) {
                count[n]++;
                n = input.read();
            }
        }
        catch (FileNotFoundException ex, IOException e){
            System.out.println("No such file bru");
        }

       
    }
}