package coding.toast._01_string;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문장이 주어지면 가장 긴 단어를 출력, 문장 속 각 단어는 공백으로 구분.
 */
public class _01_03_FindLongestString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String answer = new _01_03_FindLongestString().solution3(inputString);
        System.out.println(answer);
    }

    private String solution(String inputString) {
        StringTokenizer tokenizer = new StringTokenizer(inputString, " ");
        int maxLength = 0;
        String answer = "";

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int tokenLength = token.length();
            if(maxLength < tokenLength) {
                maxLength = tokenLength;
                answer = token;
            }
        }

        return answer;
    }

    private String solution2(String inputString) {
        String[] split = inputString.split(" +");
        int maxLength = -1;
        String answer = null;

        for (String word : split) {
            int wordLength = word.length();
            if (maxLength < wordLength) {
                maxLength = wordLength;
                answer = word;
            }
        }

        return answer;
    }

    private String solution3(String inputString) {
        String answer = "";
        int pos;
        int maxLength = -1;
        while ((pos = inputString.trim().indexOf(" ")) != -1) {
            String substring = inputString.substring(0, pos);

            if (maxLength < substring.length()) {
                maxLength = substring.length();
                answer = substring;
            }

            inputString = inputString.substring(pos+1).trim();
        }

        if (maxLength < inputString.length()) {
            answer = inputString;
        }

        return answer;
    }
}
