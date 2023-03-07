package homework5;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author JOHN CHARALAMBOUS and SOCRATES YIANNAKOU
 */
public class SimilarWords {

	/**
	 * @param word
	 * @param choices
	 * @param descriptors
	 * @return  the most similar word out of the given choices
	 * @literal In this method we calculate the similarity of a word with the
	 *          choices of the quiz file. We use the cosine_similarity and norm method.
	 */
	static String most_similar_word(String word, LinkedList<String> choices,
			HashMap<String, HashMap<String, Integer>> descriptors) {

		String answer = choices.getFirst();
		double max = -1;

		if (!descriptors.containsKey(word))
			return answer;

		HashMap<String, Integer> vec1 = new HashMap<>(descriptors.get(word));

		while (!choices.isEmpty()) {

			double similarity;
			if (!descriptors.containsKey(choices.getFirst()))
				similarity = -1;
			else {
				HashMap<String, Integer> vec2 = new HashMap<>(descriptors.get(choices.getFirst()));
				similarity = cosine_similarity(vec1, vec2);
				if (word.equals("ocstracize"))
					System.out.println(similarity + "  " + choices.getFirst());

			}

			if (similarity > max) {
				max = similarity;
				answer = choices.getFirst();
			}

			choices.poll();

		}
		return answer;
	}

	/**
	 * Calculates the norm of the vector of a word
	 *
	 * @param vec HashMap of a word
	 * @return norm of the vector
	 */
	static double norm(HashMap<String, Integer> vec) {
		double sum = 0;
		for (String i : vec.keySet()) {
			int x = vec.get(i);
			sum += x * x;
		}
		return Math.sqrt(sum);
	}

	/**
	 * Calculates the similarity of 2 words
	 *
	 * @param vec1 HashMap of the first word	
	 * @param vec2 HashMap of the second word
	 * @return similarity
	 */
	static double cosine_similarity(HashMap<String, Integer> vec1, HashMap<String, Integer> vec2) {

		double dot_product = 0;
		for (String i : vec1.keySet()) {
			if (vec2.containsKey(i))
				dot_product += vec1.get(i) * vec2.get(i);
		}

		return dot_product / (norm(vec1) * norm(vec2));

	}

}
