// Muhammad Raza and Denis Arsenev, 12/3/2025
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class PartnerQuiz {
	public static void main(String[] args) {
	long startTime = System.currentTimeMillis();

	try {
		BufferedReader reader = new BufferedReader(new FileReader("shaky.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("shaky2.txt"));
		String line = "";
		while ((line=reader.readLine())!=null) {
			String upperLine = line.toUpperCase();
			writer.write(upperLine);
			writer.newLine();
			//System.out.println(line);
		}
	} catch (Exception e) {}

	// alice stuff
	try {
			BufferedReader reader = new BufferedReader(new FileReader("alice.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("alice2.txt"));
			String line = "";
			while ((line=reader.readLine())!=null) {
				String upperLine = line.toUpperCase();
				writer.write(upperLine);
				writer.newLine();
				//System.out.println(line);
			}
		} catch (Exception e) {}

		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime; // time in milliseconds
		System.out.println("Time taken: " + duration + " ms");
}
}