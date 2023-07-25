package coding.toast._02_array;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>03. 가위 바위 보</h1>
 *
 * <h2>설명</h2>
 *
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.<br>
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.<br>
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.<br><br>
 *
 * <h2>입력</h2>
 * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.<br>
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.<br>
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.<br><br>
 *
 * <h2>출력</h2>
 * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 *
 * 예시 출력 1:
 * A
 * B
 * A
 * B
 * D
 * </pre>
 */
public class _02_03_RockPaperScissor {

    private List<String> solution(int[] a, int[] b) {
        List<String> answer = new ArrayList<>();
        int cnt = a.length;

        for (int i = 0; i < cnt; i++) {
            int aVal = a[i];
            int bVal = b[i];

            int abs = Math.abs(aVal - bVal);
            if (aVal == bVal) {
                answer.add("D");
            } else if (abs == 2 && (aVal > bVal)) {
                answer.add("B");
            } else if (abs == 2) {
                answer.add("A");
            } else if (abs == 1 && (aVal > bVal)) {
                answer.add("A");
            } else if (abs == 1) {
                answer.add("B");
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] a = new int[cnt];
        int[] b = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            String next = sc.next();
            a[i] = Integer.parseInt(next);
        }

        for (int i = 0; i < cnt; i++) {
            String next = sc.next();
            b[i] = Integer.parseInt(next);
        }

        List<String> answer = new _02_03_RockPaperScissor().solution(a, b);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
