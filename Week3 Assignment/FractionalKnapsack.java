import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    private static int number;
    private static int[] values;
    private static int[] weights;
    private static double[] ratios;
    private static double[] helper;
    
    public static void sort() {
        ratios = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            ratios[i] = (double) values[i] / weights[i];
        }
        number = values.length;
        mergesort(0, number - 1);
    }

    private static void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }
    
    private static void merge(int low, int middle, int high) {

        helper = Arrays.copyOf(ratios, ratios.length);
        int[] valuesCopy = Arrays.copyOf(values, values.length);
        int[] weighsCopy = Arrays.copyOf(weights, weights.length);
        
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] >= helper[j]) {
                ratios[k] = helper[i];
                values[k] = valuesCopy[i];
                weights[k] = weighsCopy[i];
                i++;
            } else {
                ratios[k] = helper[j];
                values[k] = valuesCopy[j];
                weights[k] = weighsCopy[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            ratios[k] = helper[i];
            values[k] = valuesCopy[i];
            weights[k] = weighsCopy[i];
            k++;
            i++;
        }

    }
    
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        for (int i = 0; i < ratios.length; ++i) {
            if(capacity==0) return value;
            if(capacity < weights[i]) {
                value+=(capacity*ratios[i]);
                capacity=0;
            }
            else {
                value+=(ratios[i]*weights[i]);
                capacity -= weights[i];
            }
        }
        return value;
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        values = new int[n];
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        sort();
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 