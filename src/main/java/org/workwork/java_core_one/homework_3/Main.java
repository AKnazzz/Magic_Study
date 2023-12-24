import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList <Integer> array = new ArrayList<>(Arrays.asList(0 ,0 ,0, 0, 0));
        int k = 2;

        getRollingAverage(array, k);
    }

//    public static void getRollingAverage(ArrayList <Integer> array, int k) {
//        ArrayList <Double> result = new ArrayList<>();
//        LinkedList<Integer> miniArray = new LinkedList<>();
//
//        double sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += array.get(i);
//            miniArray.add(array.get(i));
//        }
//        result.add(sum/k);
//
//        for (int i = k; i < array.size(); i++) {
//
//            miniArray.add(array.get(i));
//            miniArray.remove();
//            sum = 0;
//            for (int j = 0; j < miniArray.size(); j++) {
//                sum += miniArray.get(j);
//
//            }
//            result.add(sum/k);
//        }
//
//        System.out.println(result);
public static void getRollingAverage(List<Integer> array, int k) {
    if (array.size() < k) {
        throw new IllegalArgumentException("Array size must be greater than or equal to k.");
    }

    List<Double> result = new ArrayList<>();
    int[] window = new int[k];
    double sum = 0;

    // Initialize the window and calculate the initial sum
    for (int i = 0; i < k; i++) {
        window[i] = array.get(i);
        sum += window[i];
    }
    result.add(sum / k);

    // Slide the window and calculate the rolling average for each position
    for (int i = k; i < array.size(); i++) {
        sum -= window[0];
        System.arraycopy(window, 1, window, 0, k - 1);
        window[k - 1] = array.get(i);
        sum += window[k - 1];
        result.add(sum / k);
    }

    System.out.println(result);

    }
}
