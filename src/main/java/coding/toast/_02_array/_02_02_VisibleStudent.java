package coding.toast._02_array;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>02. 보이는 학생</h1>
 *
 * <h2>설명</h2>
 *
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는<br>
 * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)<br><br/>
 *
 * <h2>입력</h2>
 * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다..<br/><br/>
 *
 * <h2>출력</h2>
 * 선생님이 볼 수 있는 최대학생수를 출력한다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * 8
 * 130 135 148 140 145 150 150 153
 *
 * 예시 출력 1:
 * 5
 * </pre>
 */
public class _02_02_VisibleStudent {

    private int solution(int[] arrayOfNum) {
        int answer = 0;
        int maxHeight = Integer.MIN_VALUE;

        for (int j : arrayOfNum) {
            if (j > maxHeight) {
                answer++;
                maxHeight = j;
            }
        }

        return answer;
    }

    private int teacherSolution(int n, int[] arr) {
        int answer = 1;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            answer++;
            max = arr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] ints = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            String next = sc.next();
            ints[i] = Integer.parseInt(next);
        }

        int answer = new _02_02_VisibleStudent().solution(ints);
        System.out.println(answer);
    }
}
