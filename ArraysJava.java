import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A program that calculates the mean and median of a set of values.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-04-06
 */

@SuppressWarnings("HideUtilityClassConstructor")
public class ArraysJava {

  /** Constructor. */
  public ArraysJava() {
    // empty constructor
  }

  /**
   * Main method to calculate mean and median from file input.
   *
   * @param args The command-line arguments (not used in this program)
   */
  
  public static void main(final String[] args) {
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
        writer.write("Invalid input!");
        System.out.println("Invalid input found in file.");
      }

      // closing scanner and writer
      scanner.close();
      writer.close();

    } catch (IOException e) {
      System.out.println("Error: File not found or cannot be read.");
    }
  }

  /**
   * Calculates the mean of an array of integers.
   *
   * @param nums The array of integers
   * @return The mean value as a double
   */
  public static double calcMean(final int[] nums) {
    // variable declaration
    int sum = 0;

    // calculate sum of all the values
    for (int num : nums) {
      sum += num;
    }

    // return mean
    return (double) sum / nums.length;
  }

  /**
   * Calculates the median of an array of integers.
   *
   * @param nums The array of integers
   * @return The median value as a formatted string
   */
  public static String calcMedian(final int[] nums) {
    // variable declaration
    int half = nums.length / 2;

    // sorting array
    Arrays.sort(nums);

    // returning the median(s)
    if (nums.length % 2 == 0) {
      return nums[half] + ", " + nums[half - 1];
    }
    return Integer.toString(nums[half]);
  }
}
