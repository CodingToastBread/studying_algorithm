package coding.toast._02_array;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>01. 큰 수 출력하기</h1>
 *
 * <h2>설명</h2>
 *
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.<br/>
 * (첫 번째 수는 무조건 출력한다)<br/>
 * <br/>
 *
 * <h2>입력</h2>
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.<br/><br/>
 *
 * <h2>출력</h2>
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * 6
 * 7 3 9 5 6 12
 *
 * 예시 출력 1:
 * 7 9 6 12
 * </pre>
 */
public class _02_01_PrintBigNumber {

    private List<Integer> solution(int[] arrayOfNum) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(arrayOfNum[0]);

        for (int i = 1; i < arrayOfNum.length; i++) {
            int intRight = arrayOfNum[i];
            int intLeft = arrayOfNum[i - 1];
            if (intLeft < intRight) {
                intList.add(intRight);
            }
        }

        return intList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] ints = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            String next = sc.next();
            ints[i] = Integer.parseInt(next);
        }

        List<Integer> answer = new _02_01_PrintBigNumber().solution(ints);
        for (Integer integer : answer) {
            System.out.printf("%d ", integer);
        }
    }
}
