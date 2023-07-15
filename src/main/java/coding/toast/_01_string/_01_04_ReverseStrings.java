package coding.toast._01_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_04_ReverseStrings {

    private List<String> solution(List<String> inputStrings) {
        ArrayList<String> answer = new ArrayList<>();

        for (String inputString : inputStrings) {
            String reverse = new StringBuilder(inputString).reverse().toString();
            answer.add(reverse);
        }

        return answer;
    }

    private List<String> solution2(List<String> inputStrings) {
        ArrayList<String> answer = new ArrayList<>();

        for (String token : inputStrings) {

            if (token == null || token.length() <= 1) {
                answer.add(token);
                continue;
            }

            char[] charArray = token.toCharArray();

            int leftPos = 0, rightPos = charArray.length - 1;
            while (rightPos - leftPos > 0) {
                char temp = charArray[leftPos];
                charArray[leftPos] = charArray[rightPos];
                charArray[rightPos] = temp;
                rightPos--;
                leftPos++;
            }

            /*
            for (int leftPos = 0, rightPos = charArray.length - 1;
                 (rightPos - leftPos) > 0;
                 leftPos++, rightPos--) {

                char temp = charArray[leftPos];
                charArray[leftPos] = charArray[rightPos];
                charArray[rightPos] = temp;
            }
            */


            answer.add(new String(charArray));
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int howManyWords = scanner.nextInt();
        ArrayList<String> inputStrings = new ArrayList<>();

        for (int i = 0; i < howManyWords; i++) {
            inputStrings.add(scanner.next());
        }

        List<String> answer = new _01_04_ReverseStrings().solution2(inputStrings);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
