import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class GreedySolver{

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
    static int profit; //total value of items that are put into the knapsack

    public static void solve(){
        //sort itemList in ascending order by value/weight ratio 
        quickSort(itemList, 0, itemList.size());

        //starting from the item with the greatest value/weight ratio
        for(int i = itemList.size() - 1; i > 0; i--){
            //check if weight <= capacity
            if(itemList.get(i).weight <= capacity){
                capacity -= itemList.get(i).weight;
                profit += itemList.get(i).value; 
            }
            if(capacity == 0){
                break;
            }
        }
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

    public static void quickSort(ArrayList<Item> itList, int p, int r){
        if(p < r){
            int q = partition(itList, p, r);
            quickSort(itList, p, q-1);
            quickSort(itList, q+1, r);
        }
    }

    public static int partition(ArrayList<Item> itList, int p, int r){
        double x = itList.get(r-1).valueWeightRatio;
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(itList.get(j).valueWeightRatio <= x){
                ++i;
                //exchange A[i] with A[j]
                Item temp = itList.get(i);
                itList.set(i,itList.get(j));
                itList.set(j, temp);   
            }
        }
        return i + 1;
    }
}
