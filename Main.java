import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        File file = new File("simple.txt");
        try {
            Scanner input = new Scanner(file);
            String content = "";
            while (input.hasNextLine()){
                content += input.nextLine();
            }
            LetterInventory inventory = new LetterInventory(content);
            System.out.print(inventory.toString());
        }
        catch (FileNotFoundException ex){
            System.out.println("No such file bru");
        }

       
    }
}