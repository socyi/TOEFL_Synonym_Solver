package homework5;

import java.util.HashMap;

/**
 * 
 * @author Socrates Yiannakou and John Charalambous
 *
 */
public class SemanticDescriptors {

	/**This method splits the words of the sentences inside an Array. Then it checks if each word is an existing key; 
	 * if it is not then it is added as a key and a new HashMap is created as the value. Every other word inside the sentence 
	 * with our key word is added in the secondary HashMap with the count as the value.
	 * 
	 * 
	 * @param lists 2D Array with the sentences from the texts
	 * @return HashMap with words as keys and Hashmaps as values
	 */
	static HashMap<String, HashMap<String, Integer>> build_semantic_descriptors(String[][] lists) {

		HashMap<String, HashMap<String, Integer>> map = new HashMap<>();

		for (int i = 0; i < lists.length; i++) {
			for (int j = 0; j < lists[i].length; j++) {
				String[] words = lists[i][j].split(" ");

				for (int k = 0; k < words.length; k++) {

					if (!map.containsKey(words[k])) {
						HashMap<String, Integer> map2 = new HashMap<>();
						map.put(words[k], map2);
					}
					for (int g = k + 1; g < words.length; g++) {
						if (map.get(words[k]).containsKey(words[g])) {
							map.get(words[k]).put(words[g], map.get(words[k]).get(words[g]) + 1);
						} else {
							map.get(words[k]).put(words[g], 1);

						}

						if (!map.containsKey(words[g])) {
							HashMap<String, Integer> map2 = new HashMap<String, Integer>();
							map.put(words[g], map2);
						}
						if (map.get(words[g]).containsKey(words[k])) {
							map.get(words[g]).put(words[k], map.get(words[g]).get(words[k]) + 1);
						}

						else {
							map.get(words[g]).put(words[k], 1);
						}

					}

				}
			}
		}

		return map;

	}

}
