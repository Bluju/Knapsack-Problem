import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class DynamicFracSolver {
    public static class Item{
        public int value;
        public int weight;
        public double valueWeightRatio;
        public Item(int v, int w){
            value = v;
            weight = w;
            valueWeightRatio = (double)v / (double)w;
        }
    }

    //global variables
    static ArrayList<Item> itemList = new ArrayList<Item>();
    static int capacity;
    static double profit; //total value of items that are put into the knapsack

    public static void solve(){

        double[] dp = new double[capacity + 1];
        for(int i = 0; i < itemList.size(); i++){
            for( int currCap = capacity; currCap >= 0; currCap--){
                //currCap is the capacity of the subproblem
                if(itemList.get(i).weight <= currCap){
                    //if the weight of the current item fits
                    dp[currCap] = Math.max(dp[currCap], dp[currCap - itemList.get(i).weight] + itemList.get(i).value);
                }
                else if(currCap != 0){
                    //add a fraction of the item that fits
                    dp[currCap] = Math.max(dp[currCap], dp[0] + (currCap * itemList.get(i).valueWeightRatio));
                }
            }
        }
        profit = dp[capacity]; // maximum value
    }

    public static void main(String[] args){
        File input = new File("input2.txt");
        try{
            Scanner sc = new Scanner(input);
            readInputFile(sc); 
            solve();
            System.out.println("Total Value: " + profit);
            sc.close();
        } catch(Exception e){
            System.out.println(e);
            return;
        }
    }

    private static void readInputFile(Scanner sc){
        String[] values = sc.nextLine().split(", ");
        String[] weights  = sc.nextLine().split(", ");
    
        for(int i = 0; i < values.length; i++){
            //create then add item to itemList
            itemList.add(new Item(Integer.parseInt(values[i]), Integer.parseInt(weights[i])));
        }

        capacity = sc.nextInt(); //get the maximum capacity of the knapsack
    }
}
