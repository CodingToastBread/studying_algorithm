package coding.toast._01_string;

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
 * <pre>
 * 예시 입력 1:
 * fkdgkjdflkgjljslgjkfldjlkfdg f
 *
 * 예시 출력 1
 * 0 1 2 3 3 2 1 0 1 2 3 4 5 6 5 4 3 2 1 0 1 2 3 2 1 0 1 2
 * </pre>
 */
public class _01_10_ClosestStringDistance {


    private void solution(String input, char criteria) {
        int minPos = 0;
        int maxPos = 0;
        int[] stringDistance = new int[input.length()];
        while ((maxPos = input.indexOf(criteria, minPos + 1)) != -1) {
            String substring = input.substring(minPos, maxPos);
            for (int i = minPos; i <= maxPos; i++) {
                if (minPos != 0) {
                    stringDistance[i] = Math.min(Math.abs(i - minPos), Math.abs(i - maxPos));
                } else {
                    stringDistance[i] = Math.abs(i - maxPos);
                }
            }
            minPos = maxPos;
        }
        
        if (input.length() - 1 != maxPos && minPos != 0) {
            String substring = input.substring(minPos + 1);
            for (int i = minPos + 1; i <= input.length() - 1; i++) {
                stringDistance[i] = Math.abs(i - minPos);
            }
        }
        
        // 남은 문자열 후속 조치
        // System.out.println(Arrays.toString(stringDistance));
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i : stringDistance) {
            stringJoiner.add(String.valueOf(i));
        }
        
        System.out.println(stringJoiner);
    }

    // retry!
    private int[] solution2(String input, char criteria) {
        char[] charArray = input.toCharArray();
        int[] answer = new int[input.length()];
        String t = String.valueOf(criteria);

        for (int i = 0; i < charArray.length; i++) {
            // 같은 값이면 무시
            if (charArray[i] == criteria) {
                // answer[i] = 0;
                continue;
            }

            // 같은 값이 아니면...
            if (i == 0) { // 맨 앞자리 검사면...
                String rightSide = input.substring(i + 1);
                int rightIndex = rightSide.indexOf(criteria) + (i + 1); // i + 1 은 offset 같은 거다.;
                int rightDistance = Math.abs(i - rightIndex);
                answer[i] = rightDistance;
            } else if (i == (charArray.length - 1)) { // 맨 마지막 문자열 검사면...
                String leftSide = input.substring(0, i);
                int leftIndex = leftSide.lastIndexOf(criteria);
                leftIndex = leftIndex == -1 ? Integer.MAX_VALUE : leftIndex;
                int leftDistance = Math.abs(i - leftIndex);
                answer[i] = leftDistance;
            } else { // 맨 앞/뒤가 아닌 중간 지점이면
                String leftSide = input.substring(0, i);
                String rightSide = input.substring(i + 1);

                int leftIndex = leftSide.lastIndexOf(criteria);
                leftIndex = leftIndex == -1 ? Integer.MAX_VALUE : leftIndex;
                int rightIndex = rightSide.indexOf(criteria); // i + 1 은 offset 같은 거다.
                rightIndex = (rightIndex == -1 ? Integer.MAX_VALUE : rightIndex + (i + 1));

                int leftDistance = Math.abs(i - leftIndex);
                int rightDistance = Math.abs(i - rightIndex);

                answer[i] = Math.min(leftDistance, rightDistance);
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char criteria = sc.next().charAt(0) ;
        int[] ints = new _01_10_ClosestStringDistance().solution2(input, criteria);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int anInt : ints) {
            stringJoiner.add(String.valueOf(anInt));
        }
        System.out.println(stringJoiner);
    }

}
