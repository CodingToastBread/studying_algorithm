package coding.toast._01_string;

import java.util.Scanner;

/**
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * <pre>
 *  예시입력: ksekkset
 *  출력입력: kset
 * </pre>
 */
public class _01_06_EliminateDuplicateChar {

    private String solution(String input) {
        char[] charArray = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private String teacherSolution(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            // System.out.println("%s %d %d".formatted(input.charAt(i), i, input.indexOf(input.charAt(i))));
            /*
            t 0 0
            e 1 1
            a 2 2
            c 3 3
            h 4 4
            e 5 1 ==> 중복 문자는 이게 다르다!
            r 6 6
            */
            if (i == input.indexOf(input.charAt(i))) {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = new _01_06_EliminateDuplicateChar().teacherSolution(input);
        System.out.println(answer);
    }
}
