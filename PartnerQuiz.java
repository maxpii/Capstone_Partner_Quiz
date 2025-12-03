import java.io.*;
import java.util.ArrayList;

public class PartnerQuiz {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Runnable task for shaky.txt
        Runnable shakyTask = () -> processFile("shaky.txt", "shaky_out.txt");

        // Runnable task for toy.txt
        Runnable toyTask = () -> processFile("toy.txt", "toy_out.txt");

        // Create threads
        Thread thread1 = new Thread(shakyTask);
        Thread thread2 = new Thread(toyTask);

        // Start threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    // Method to process a file: slow uppercasing + ArrayList of words + CPU-heavy loop
    private static void processFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String upperLine = "";
                ArrayList<String> words = new ArrayList<>();

                // Split line into words
                String[] wordArray = line.split("\\s+");
                for (String word : wordArray) {
                    words.add(word); // store original word

                    // Uppercase each character individually (slow O(n^2))
                    for (int i = 0; i < word.length(); i++) {
                        char c = Character.toUpperCase(word.charAt(i));

                        // Append to string (still slow)
                        upperLine = upperLine + c;

                        // CPU-heavy loop to make threading matter
                        for (int j = 0; j < 10000; j++) {
                            Math.sqrt(j); // intentional computation
                        }
                    }
                    upperLine = upperLine + " "; // preserve spaces
                }

                writer.write(upperLine);
                writer.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}