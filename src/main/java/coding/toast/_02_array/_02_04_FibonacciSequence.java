package coding.toast._02_array;


import java.util.Scanner;

/**
 * <h1>04. 피보나치 수열</h1>
 *
 * <h2>설명</h2>
 *
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.<br>
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.<br><br>
 *
 * <h2>입력</h2>
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.<br><br>
 *
 * <h2>출력</h2>
 * 첫 줄에 피보나치 수열을 출력합니다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * 10
 *
 * 예시 출력 1:
 * 1 1 2 3 5 8 13 21 34 55
 * </pre>
 */
public class _02_04_FibonacciSequence {

    private int[] solution(int cnt) {
        int[] answer = new int[cnt];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < cnt; i++) {
            int currentNum = answer[i - 1] + answer[i - 2];
            answer[i] = currentNum;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[] answer = new _02_04_FibonacciSequence().solution(cnt);
        for (int s : answer) {
            System.out.printf("%d ", s);
        }
    }
}