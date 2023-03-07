package homework5;

/**
 * @author JOHN CHARALAMBOUS and SOCRATES YIANNAKOU
 */
public class FilesSentenceLists {

	/**
	 * @param fileNames
	 * @return
	 * @literal We create the lists of each text file into an array
	 */
	static String[][] get_sentence_lists_from_files(String[] fileNames) {

		String[][] lists = new String[fileNames.length][];
		for (int i = 0; i < fileNames.length; i++)
			lists[i] = SentenceList.getSentenceList(fileNames[i]);

		return lists;
	}
}