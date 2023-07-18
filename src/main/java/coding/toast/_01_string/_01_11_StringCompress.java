package coding.toast._01_string;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * <h1>11. 문자열 압축</h1>
 *
 * <h2>설명</h2>
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는<br>
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.<br>
 * 단 반복횟수가 1인 경우 생략합니다.<br><br>
 *
 * <h2>입력</h2>
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.<br/><br/>
 *
 * <h2>출력</h2>
 * 첫 줄에 문자열이 주어진다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * KKHSSSSSSSE
 *
 * 예시 출력 1
 * K2HS7E
 * </pre>
 * <pre>
 * 예시 입력 1:
 * KSTTTSEEKFKKKDJJGG
 *
 * 예시 출력 1
 * KST3SE2KFK3DJ2G2
 * </pre>
 */
public class _01_11_StringCompress {

    private String solution(String input) {
        StringBuilder sb = new StringBuilder();
        String temp = input + Character.MAX_VALUE;
        char comparedChar = Character.MIN_VALUE;
        int cnt = 0;

        for (int i = 0; i < temp.length(); i++) {
            char idxChar = temp.charAt(i);
            if (idxChar == comparedChar) {
                cnt++;
            } else {
                if (comparedChar != Character.MIN_VALUE) {
                    sb.append(comparedChar);
                    if (cnt != 1) {
                        sb.append(cnt);
                    }
                }
                comparedChar = idxChar;
                cnt = 1;
            }
        }


        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = new _01_11_StringCompress().solution(input);
        System.out.println(answer);
    }
}
