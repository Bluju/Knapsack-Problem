import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class KnapsackRunner{


    public static void main(String[] args){
        File input = new File("input.txt");
        try{
            Scanner sc = new Scanner(input);
            readInputFile();
            sc.close();
        } catch(Exception e){
            System.out.println("Input file not found");
            return;
        }
    }

    private static void readInputFile(){
        while(true){
            //read values from input file
            ArrayList<Integer> values = new ArrayList();

            //read weights from input file

            //read capacity from input file
        }
    }
}
