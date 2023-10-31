import java.util.ArrayList;
public class KnapsackSolver{

    private ArrayList<Integer> values;
    private ArrayList<Double> packedValues;
    private ArrayList<Integer> weights;
    private ArrayList<Double> packedWeights;
    private double limit;
    private double totalValue; //Value of all the items packed together under the limit
    private double totalWeight;

    public KnapsackSolver(){
        //constructor
        
        values = new ArrayList<Integer>();
        weights = new ArrayList<Integer>();
        packedValues = new ArrayList<Double>();
        packedWeights = new ArrayList<Double>();
        limit = 0;
        totalValue = 0;
        totalWeight = 0;


    }

    public void dynamicSolver(){
        //using dynamic programming solve the knapsack problem
        packedValues.add(2.5);
        packedValues.add(4.0);
        packedWeights.add(5.0);
        packedWeights.add(10 + 0.2);
        output();
    }

    public void dynamicFractionalSolver(){

    }

    public void greedySolver(){

    }

    public void greedyFractionalSolver(){

    } 

    public void setValues(String[] in){
        for(String s : in){
            values.add(Integer.parseInt(s));
        }
    }
    
    public void setWeights(String[] in){
        for(String s : in){
            weights.add(Integer.parseInt(s));
        }
    }

    public void setLimit(int in){
        limit = in;
    }

    private void output(){
        System.out.println("Total value: " + totalValue);
        System.out.println("Total weight: " + totalWeight);
        System.out.print("Packed items: ");
        outputPackedItems();
        System.out.print("Packed weights: ");
        outputPackedWeights();
    }

    private void outputPackedItems(){
        for(double v : packedValues){
            System.out.print(v + " ");
        }
        System.out.println();
    }
    private void outputPackedWeights(){
        for(double w : packedWeights){
             System.out.print(w + " ");
        }
        System.out.println();
    }
}
