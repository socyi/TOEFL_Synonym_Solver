package homework5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author JOHN CHARALAMBOUS and SOCRATES YIANNAKOU
 *
 */
public class SimilarityTest {

	/**
	 * @param filename
	 * @param descriptors
	 * @literal In this method we are testing the quiz file and we calculate the
	 *          percentage of the correct answers.
	 */
	static void run_similarity_test(String filename, HashMap<String, HashMap<String, Integer>> descriptors) {

		LinkedList<String> answers = new LinkedList<>();
		double percentage;
		float questionCount = 0;
		float correctCount = 0;
		/**
		 * @literal Read the quiz file
		 */

		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line;
			LinkedList<String> list;
			while ((line = br.readLine()) != null) {
				questionCount++;
				list = new LinkedList<>(Arrays.asList(line.toString().split("\\s+")));

				String word = list.poll();
				String solution = list.poll();
				String answer = SimilarWords.most_similar_word(word, list, descriptors);
				answers.add(answer);
				if (answer.equals(solution))
					correctCount++;
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/**
		 * @literal Prints the correct answers of the quiz in a new file.
		 */
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("results.txt"), 32768);
			percentage = 100 * (correctCount / questionCount);
			out.write("Answers: ");
			out.write(answers.toString());
			out.newLine();
			out.newLine();
			out.write("Correct answers : " + percentage + "% (" + String.valueOf((int) correctCount) + "/"
					+ String.valueOf((int) questionCount) + ")");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}