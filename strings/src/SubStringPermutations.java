import java.util.ArrayList;

public class SubStringPermutations {

	static int CHARS = 26;
	public static ArrayList<String> getSubPermutations(String line, String pattern) {

		ArrayList<String> result = new ArrayList<String>();
		int[] pStr = new int[CHARS];
		int[] sStr = new int[CHARS];

		for (int i = 0; i < CHARS; i++) {
			pStr[i] = 0;
			sStr[i] = 0;
		}
		
		for (int i = 0; i < pattern.length(); i++) {
			pStr[ (int) pattern.charAt(i) - 97 ]++;
			sStr[ (int) line.charAt(i) - 97 ]++;
		}

		int start = 0;
		int end = pattern.length();
		while (end < line.length()) {
			
			if(containsPattern(pStr, sStr ,true))
				result.add(line.substring(start, end));
			
			sStr[(int)line.charAt(start++) - 97]--;
			sStr[(int)line.charAt(end++)- 97]++;
		}
		
		if(containsPattern(pStr, sStr ,true))
			result.add(line.substring(start, end));    

		return result;
	}

	public static boolean containsPattern(int[] one, int[] two, boolean match) {
		for (int i = 0; i < one.length; i++) {
			if (!match && one[i] > two[i])
				return false;
			if (match && one[i] != two[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		ArrayList<String> permutes = getSubPermutations("abcdeanuragbdc", "dcb");
		for (String str : permutes)
			System.out.println(str);

	}
}