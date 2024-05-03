import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BubbleSortVisualization {
    
    // Function to perform bubble sort
    public static <T extends Comparable<T>> void bubbleSort(List<T> arr) {
        int size = arr.size();
        for (int i = 0; i < size - 1; ++i) {
            for (int j = 0; j < size - i - 1; ++j) {
                if (arr.get(j + 1).compareTo(arr.get(j)) < 0) {
                    Collections.swap(arr, j, j + 1);
                    visualizeSortProgress(arr); // Visualize sorting progress
                    try {
                        Thread.sleep(100); // Introduce delay for visual effect
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // Function to visualize sorting progress
    public static <T> void visualizeSortProgress(List<T> arr) {
        System.out.print("Sorting in progress:\n");
        for (T val : arr) {
            System.out.print("*".repeat((Integer) val) + " "); // Display asterisks based on element value
        }
        System.out.println();
    }

    // Function to generate a list of random integers
    public static List<Integer> generateRandomIntegers(int size, int min, int max) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(rand.nextInt(max - min + 1) + min);
        }
        return randomNumbers;
    }

    public static void main(String[] args) {
        int size = 10;
        List<Integer> nums = generateRandomIntegers(size, 1, 100);

        System.out.println("Original array:");
        visualizeSortProgress(nums); // Display the original array visually

        bubbleSort(nums); // Sort the array using bubble sort algorithm

        System.out.println("\nSorted array (ascending order):");
        visualizeSortProgress(nums); // Display the sorted array in ascending order

        Collections.reverse(nums); // Reverse the sorted array to get descending order
        System.out.println("\nSorted array (descending order):");
        visualizeSortProgress(nums); // Display the sorted array in descending order
    }
}
