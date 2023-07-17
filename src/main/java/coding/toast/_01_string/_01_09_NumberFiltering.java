package coding.toast._01_string;

import java.util.Scanner;

/**
 * <h2>설명</h2>
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.<br>
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.<br>
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.<br><br>
 *
 * <h2>출력</h2>
 * 첫 줄에 자연수를 출력합니다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * g0en2T0s8eSoft
 *
 * 예시 출력 1
 * 208
 * </pre>
 */
public class _01_09_NumberFiltering {

    private String solution(String input) {
        String filteredString = input.replaceAll("[^0-9]", "");
        return filteredString.replaceFirst("^0+", "");
    }

    private int hintSolution(String input) {
        // x >= 48 && x <= 57 ==> 숫자!

        int answer = 0;
        int length = input.length();
        char[] charArray = input.toCharArray();

        for (int i = 0; i < length; i++) {
            char ch = charArray[i];
            if (ch >= 48 && ch <= 57) { // if (Character.isDigit(ch)) {
                answer = answer * 10 + (ch - 48);
            }
        }

        return answer;
    }

    private int teacherSolution(String input) {
        int answer = 0;
        for (char x : input.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }

    private int teacherSolution2(String input) {
        StringBuilder answer = new StringBuilder();
        for (char x : input.toCharArray()) {
            if (Character.isDigit(x)) {
                answer.append(x);
            }
        }
        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) {
        // g0en2T0s8eSoft
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Object answer = new _01_09_NumberFiltering().teacherSolution(input);
        System.out.println(answer);
    }

}
