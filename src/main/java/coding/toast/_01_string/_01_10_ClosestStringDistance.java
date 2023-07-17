package coding.toast._01_string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * <h1>10. 가장 짧은 문자거리</h1>
 *
 * <h2>설명</h2>
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.<br><br>
 *
 * <h2>입력</h2>
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.<br/>
 * 문자열의 길이는 100을 넘지 않는다.<br/><br/>
 *
 * <h2>출력</h2>
 * 첫 줄에 자연수를 출력합니다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * teachermode e
 *
 * 예시 출력 1
 * 1 0 1 2 1 0 1 2 2 1 0
 * </pre>
 */
public class _01_10_ClosestStringDistance {

  /*  private void solution(String input, char criteria) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        
        for (char c : input.toCharArray()) {
            // System.out.printf("%d ", Math.abs(c - criteria));
            stringJoiner.add(String.valueOf(Math.abs(c - criteria)));
        }
        System.out.println(stringJoiner);
    }
    */
    
    private void solution(String input, char criteria) {
        int minPos = 0;
        int maxPos = 0;
        int[] stringDistance = new int[input.length()];
        System.out.println(maxPos = input.indexOf(criteria));
        while ((maxPos = input.indexOf(criteria)) != -1) {
            String substring = input.substring(minPos, minPos + maxPos);
            
            
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char criteria = sc.next().charAt(0) ;
        new _01_10_ClosestStringDistance().solution(input, criteria);
        // System.out.println(answer);
    }

}
