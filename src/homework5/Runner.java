package homework5;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * 
 * @authors Socrates Yiannakou and John Charalambous
 * 
 *          This program first reads text files, given by the user. The words
 *          from the text are stored so then they can be used to answer TOEFL
 *          questions. Another text file is read which includes the question,
 *          the answer and potential answers. Finally, the AI's answers are
 *          printed on a text file along with the percentage of the correct
 *          answers.
 * 
 */
public class Runner {
	/**
	 * @authorS Socrates Yiannakou and John Charalambous
	 * 
	 *          Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String[] fileNames = new String[args.length - 1]; // Array with the names of the text files in the arguments
			int fileCount = 0; // Counter for the text files

			for (int i = 0; i < fileNames.length; i++) {
				fileNames[i] = args[i];
				fileCount++;
			}

			String[][] lists = FilesSentenceLists.get_sentence_lists_from_files(fileNames);

			HashMap<String, HashMap<String, Integer>> descriptors = SemanticDescriptors
					.build_semantic_descriptors(lists);

			SimilarityTest.run_similarity_test(args[fileCount], descriptors);
		}

		catch (NegativeArraySizeException e) {
			System.out.println("No input files");
		} catch (NoSuchElementException n) {
			System.out.println("Wrong file format");
		}

	}
}
