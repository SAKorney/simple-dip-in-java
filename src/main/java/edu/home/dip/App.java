package edu.home.dip;

import java.io.IOException;
import java.util.Map;

import edu.home.dip.imageio.ImageIOSolution;

import java.util.HashMap;
import java.util.Arrays;

/*
 * Useful links:
 *  - https://www.baeldung.com/java-images
 *  - https://www.tutorialspoint.com/java_dip/index.htm
 *  - https://techvidvan.com/tutorials/java-digital-image-processing/
 */

public class App {
    private static final String IMAGE_IO_SOLUTION_NAME = "ImageIO";
    private static final String IMAGE_J_SOLUTION_NAME = "ImageJ";
    private static final String OPEN_IMAJ_SOLUTION_NAME = "OpenIMAJ";


    public static void main(String[] args) throws IOException{
        String firstFileName = "Lenna.png";
        String secondFileName = "Copy.png";

        runTest(firstFileName, secondFileName, 10);
    }

    private void runSingleTest(String firstFileName, String secondFileName) throws IOException {
        long start = System.nanoTime();
        ImageIOSolution.run(firstFileName, secondFileName);
        long end = System.nanoTime();
        printElapsedTime(IMAGE_IO_SOLUTION_NAME, start, end);

        start = System.nanoTime();
        ImageJSolution.run(firstFileName, secondFileName);
        end = System.nanoTime();
        printElapsedTime(IMAGE_J_SOLUTION_NAME, start, end);

        start = System.nanoTime();
        OpenIMAJSolution.run(firstFileName, secondFileName);
        end = System.nanoTime();
        printElapsedTime(OPEN_IMAJ_SOLUTION_NAME, start, end);
    }

    private static void runTest(String firstFileName, String secondFileName, int times) throws IOException {
        Map<String, long[]> statistics = new HashMap<>();
        statistics.put(IMAGE_IO_SOLUTION_NAME, new long[times]);
        statistics.put(IMAGE_J_SOLUTION_NAME, new long[times]);
        statistics.put(OPEN_IMAJ_SOLUTION_NAME, new long[times]);

        for (int i = 0; i < times; i++) {
            long start = System.nanoTime();
            ImageIOSolution.run(firstFileName, secondFileName);
            long end = System.nanoTime();
            statistics.get(IMAGE_IO_SOLUTION_NAME)[i] = end - start;

            start = System.nanoTime();
            ImageJSolution.run(firstFileName, secondFileName);
            end = System.nanoTime();
            statistics.get(IMAGE_J_SOLUTION_NAME)[i] =  end - start;

            start = System.nanoTime();
            OpenIMAJSolution.run(firstFileName, secondFileName);
            end = System.nanoTime();
            statistics.get(OPEN_IMAJ_SOLUTION_NAME)[i] = end - start;
        }

        printStatistics(IMAGE_IO_SOLUTION_NAME, statistics);
        printStatistics(IMAGE_J_SOLUTION_NAME, statistics);
        printStatistics(OPEN_IMAJ_SOLUTION_NAME, statistics);
    }

    private static void printElapsedTime(String solutionName, long start, long end)
    {
        long elapsedTime = end - start;
        System.out.println("Solution: " + solutionName);
        System.out.println("Elapsed time: " + elapsedTime);
    }

    private static void printStatistics(String solutionName, Map<String, long[]> statistics) {
        printElapsedTime(
            solutionName,
            Arrays.stream(statistics.get(solutionName))
                  .average()
                  .getAsDouble());
    }

    private static void printElapsedTime(String solutionName, double elapsedTime)
    {
        System.out.println("Solution: " + solutionName);
        System.out.println("Elapsed time: " + elapsedTime);
    }
}
