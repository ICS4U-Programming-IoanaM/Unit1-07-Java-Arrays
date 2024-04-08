
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program calculates the mean and median.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-04-06
*/

public class ArraysJava {
    public static void main(String[] args) {
        try {
            // files
            File inFile = new File("Unit2/Unit2-03/Unit1-07-Java-Arrays/input.txt");
            File outFile = new File("Unit2/Unit2-03/Unit1-07-Java-Arrays/output.txt");

            // scanner and writer
            Scanner scanner = new Scanner(inFile);
            FileWriter writer = new FileWriter(outFile);

            // variable declaration
            ArrayList<Integer> fileContentsArrayList = new ArrayList<>();
            boolean isValid = true;

            // scanning file and storing contents in arraylist as ints 
            while (scanner.hasNext()) {
                try {
                    fileContentsArrayList.add(scanner.nextInt());

                    // non int value found in file 
                } catch (InputMismatchException e) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                // array declaration
                int[] fileContents = new int[fileContentsArrayList.size()];
                // array to arraylist
                for (int i = 0; i < fileContentsArrayList.size(); i++) {
                    fileContents[i] = fileContentsArrayList.get(i);
                }

                // calling functions
                double mean = calcMean(fileContents);
                String median = calcMedian(fileContents);

                // write to the output file
                writer.write("The mean is: " + mean + "\n");
                writer.write("The median is: " + median);

                // print to console the process is done
                System.out.println("Process successful");
            } else {
                writer.write("invalid input!");
                System.out.println("Invalid input found in file.");
            }

            // closing scanner and writer
            scanner.close();
            writer.close();

            // File could not be found
        } catch (IOException e) {
            System.out.println("Error: File not found or cannot be read.");
        }
    }

    public static double calcMean(int[] nums) {
        // variable declaration
        int sum = 0;

        // calculate sum of all the values
        for (int num : nums) {
            sum += num;
        }

        // return mean
        return sum / nums.length;
    }
    
    public static String calcMedian(int[] nums) {
        // variable declaration
        int half = nums.length / 2;

        // sorting array
        Arrays.sort(nums);

        // returning the medians
        return nums.length % 2 == 0 ? Integer.toString(nums[half + 1]) + ", " + Integer.toString(nums[half])
                : Integer.toString(half + 1);
    }
}
