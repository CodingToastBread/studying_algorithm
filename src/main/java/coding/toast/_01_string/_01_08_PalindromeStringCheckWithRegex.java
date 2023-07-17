package coding.toast._01_string;

import java.util.Scanner;

/**
 * <h2>설명</h2>
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.<br/>
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.<br/>
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.<br/>
 * 알파벳 이외의 문자들의 무시합니다.<br/><br/>
 *
 * <h2>출력</h2>
 * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * found7, time: study; Yduts; emit, 7Dnuof
 *
 * 예시 출력 1
 * YES
 * </pre>
 */
public class _01_08_PalindromeStringCheckWithRegex {

    private String solution(String input) {

        // found7, time: study; Yduts; emit, 7Dnuof

        int length = input.length();
        int leftPos = 0;
        int rightPos = length - 1;

        while ((rightPos - leftPos) > 0) {

            char leftChar = input.charAt(leftPos);
            char rightChar = input.charAt(rightPos);

            if (!Character.isAlphabetic(leftChar)) {
                rightPos--;
            } else if (!Character.isAlphabetic(rightChar)) {
                leftPos++;
            } else {
                if (!String.valueOf(leftChar).equalsIgnoreCase(String.valueOf(rightChar))) {
                    System.out.println("leftChar = " + leftChar);
                    System.out.println("rightChar = " + rightChar);
                    return "NO";
                }
                rightPos--;
                leftPos++;
            }
        }

        return "YES";
    }


    private String teacherSolution(String input) {
        String answer = "NO";
        String testStr = input.toUpperCase().replaceAll("[^A-Z]", "");

        String reversedStr = new StringBuilder(testStr).reverse().toString();

        if (testStr.equals(reversedStr)) {
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String answer = new _01_08_PalindromeStringCheckWithRegex().teacherSolution(input);
        System.out.println(answer);
    }

}
