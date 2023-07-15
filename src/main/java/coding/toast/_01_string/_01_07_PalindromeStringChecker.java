package coding.toast._01_string;

import java.util.Scanner;

/**
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.<br>
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.<br>
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.<br>
 *
 * <pre>
 * 예시입력: gooG
 * 출력예시: YES
 * (첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.)
 * </pre>
 */
public class _01_07_PalindromeStringChecker {

    private String solution(String input) {
        char[] charArray = input.toUpperCase().toCharArray();
        int leftPos = 0;
        int rightPos = charArray.length - 1;

        while (rightPos > leftPos) {

            if (charArray[rightPos] != charArray[leftPos]) {
                return "NO";
            }

            rightPos--;
            leftPos++;
        }

        return "YES";
    }

    private String teacherSolution(String input) {
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            char left = input.charAt(i);
            char right = input.charAt(length - 1 - i);
            if (left != right) {
                return "NO";
            }
        }

        return "YES";
    }

    private String teacherSolution2(String input) {
        String reversedInput = new StringBuilder(input).reverse().toString();
        if (input.equalsIgnoreCase(reversedInput)) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = new _01_07_PalindromeStringChecker().solution(input);
        System.out.println(answer);
    }
}
