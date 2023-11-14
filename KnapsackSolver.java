import java.util.ArrayList;
public class KnapsackSolver{

    private int[] values;
    private int[] weights;
    private int limit;
    private int n;
    private int totalValue; //Value of all the items packed together under the limit
    private int totalWeight;
    private int[][] packedItems;

    public KnapsackSolver(int[] values, int[] weights, int limit, int n){
        //constructor
        this.values = values;
        this.weights = weights;
        this.limit = limit;
        this.n = n;
        totalValue = 0;
        totalWeight = 0;


    }

    public void dynamicSolver(){
        // n is the size of values[]
        //using dynamic programming solve the knapsack problem

        output();
    }

    public void dynamicFractionalSolver(){

    }

    public void greedySolver(){

    }

    public void greedyFractionalSolver(){

    } 



    private void output(){
        System.out.println("Total value: " + totalValue);
        System.out.println("Total weight: " + totalWeight);
        System.out.print("Packed values: ");
        outputPackedValues();
        System.out.print("Packed weights: ");
        outputPackedWeights();
    }

    private void outputPackedValues(){
        for(int v = 0;  v < packedItems.length; v++){
            System.out.print(packedItems[v][0] + " ");
        }
        System.out.println();
    }
    private void outputPackedWeights(){
        for(int w = 0; w < packedItems.length; w++){
             System.out.print(w + " ");
        }
        System.out.println();
    }
}
