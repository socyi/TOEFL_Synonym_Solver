package homework5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 * @author Socrates Yiannakou and John Charalambous
 * 
 */
public class SentenceList {

	/**This method reads a text file using the StringBuilder,File Reader and Buffered Reader, inside a try-catch block, 
	 * while changing the text to lower case.
	 * 
	 * Then using the StringTokenizer the text is split into sentences. Then with another StringTokenizer the sentences are split 
	 * into words and then a whitespace is added at the end of each word. The seperated words are stored in a 2D String array which is returned.
	 * 
	 * @param t name of a text file 
	 * @return 2D Array with sentences 
	 */
	static String[] getSentenceList(String t) {

		StringBuilder text = new StringBuilder();
		try {
			FileReader fr = new FileReader(t);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				text.append(line.toLowerCase());
				text.append("\n");

			}
			br.close();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}

		StringTokenizer stk = new StringTokenizer(text.toString(), "!.?");

		String table[] = new String[stk.countTokens()];

		for (int i = 0; i < table.length; i++) {
			table[i] = stk.nextToken();
			StringTokenizer stk2 = new StringTokenizer(table[i], "()@#$%^&*[\n\t,---:;!?.0123456789\"`' ]+");

			StringBuilder sentence = new StringBuilder();

			while (stk2.hasMoreTokens()) {
				sentence.append(stk2.nextToken());
				sentence.append(" ");

			}
			table[i] = sentence.toString();

		}
		return table;

	}

}
