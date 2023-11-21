import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class DynamicSolver {
    public static class Item{
        public int value;
        public int weight;
        public Item(int v, int w){
            value = v;
            weight = w;
        }
    }

    //global variables
    static ArrayList<Item> itemList = new ArrayList<Item>();
    static int capacity;
    static int profit; //total value of items that are put into the knapsack

    public static void solve(){

        int[] dp = new int[capacity + 1];
        for(int i = 0; i < itemList.size(); i++){
            for( int currCap = capacity; currCap >= 0; currCap--){
                if(itemList.get(i).weight <= currCap){
                    dp[currCap] = Math.max(dp[currCap], dp[currCap - itemList.get(i).weight] + itemList.get(i).value);
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
