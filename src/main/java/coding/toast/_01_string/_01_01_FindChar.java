package coding.toast._01_string;

import java.util.Scanner;

/**
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 */
public class _01_01_FindChar {

    public int solution(String inputString, char findingChar) {
        int answer = 0;
        char[] charArray = inputString.toCharArray();



        answer = (int)
                inputString.toUpperCase()
                        .chars()
                        .filter(value -> value == Character.toUpperCase(findingChar))
                        .count();

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        char findingChar = sc.next().charAt(0);
        _01_01_FindChar findChar = new _01_01_FindChar();
        int solution = findChar.solution(inputString, findingChar);
        System.out.println(solution);
    }
}
