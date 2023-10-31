import java.io.File;
import java.util.Scanner;
public class KnapsackRunner{


    public static void main(String[] args){
        File input = new File("input.txt");
        KnapsackSolver solver = new KnapsackSolver();
        try{
            Scanner sc = new Scanner(input);
            readInputFile(sc, solver);
            solver.dynamicSolver();
            sc.close();
        } catch(Exception e){
            System.out.println("Input file not found");
            return;
        }
    }

    private static void readInputFile(Scanner sc, KnapsackSolver solver){
        //read values from input file
        solver.setValues(sc.nextLine().split(", "));
        solver.setWeights(sc.nextLine().split(", "));
        solver.setLimit(sc.nextInt());
    }
}
