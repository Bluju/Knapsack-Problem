import java.io.File;
import java.util.Scanner;
public class KnapsackRunner{

    static int[] values;
    static int[] weights;
    static int limit;
    static int n;

    public static void main(String[] args){
        File input = new File("input.txt");
        KnapsackSolver solver = new KnapsackSolver(values, weights, limit, n);
        try{
            Scanner sc = new Scanner(input);
            readInputFile(sc, solver);
            solver.dynamicSolver(n);
            sc.close();
        } catch(Exception e){
            System.out.println("Input file not found");
            return;
        }
    }

    private static void readInputFile(Scanner sc, KnapsackSolver solver){
        String[] input = sc.nextLine().split(", ");

        //read values from input file
        values = new int[input.length];
        for(int i = 0; i < values.length;i++){
            values[i] = Integer.parseInt(input[i]);
        }

        input = sc.nextLine().split(", ");
        //read weights from input file
        weights = new int[input.length];
        for(int i = 0; i < weights.length;i++){
            weights[i] = Integer.parseInt(input[i]);
        }

        limit = sc.nextInt(); //get the maximum capacity of the knapsack
        n = values.length; //the amount of values is needed for recursion
    }
}
