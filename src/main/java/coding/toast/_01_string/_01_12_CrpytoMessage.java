package coding.toast._01_string;

import java.util.Scanner;

/**
 * <h1>12. 암호</h1>
 *
 * <h2>설명</h2>
 *
 * 현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.<br/>
 * 비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있습니다.<br/>
 * 비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.<br/>
 * 만약 현수가 “#*****#”으로 구성된 문자를 보냈다면 영희는 현수와 약속한 규칙대로 다음과 같이 해석합니다.<br/>
 * 1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.<br/>
 * 2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.<br/>
 * 3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.<br/>
 * 참고로 대문자들의 아스키 번호는 'A'는 65번, ‘B'는 66번, ’C'는 67번 등 차례대로 1씩 증가하여 ‘Z'는 90번입니다.<br/>
 * 현수가 4개의 문자를 다음과 같이 신호로 보냈다면<br/>
 *<br/>
 * #****###**#####**#####**##**<br/>
 *<br/>
 * 이 신호를 4개의 문자신호로 구분하면<br/>
 *<br/>
 * #****## --> 'C'<br/>
 *<br/>
 * #**#### --> 'O'<br/>
 *<br/>
 * #**#### --> 'O'<br/>
 *<br/>
 * #**##** --> 'L'<br/>
 *<br/>
 * 최종적으로 “COOL"로 해석됩니다.<br/>
 * 현수가 보낸 신호를 해석해주는 프로그램을 작성해서 영희를 도와주세요.<br/><br/>
 *
 * <h2>입력</h2>
 * 첫 줄에는 보낸 문자의 개수(10을 넘지 안습니다)가 입력된다.<br/>
 * 다음 줄에는 문자의 개수의 일곱 배 만큼의 #또는 * 신호가 입력됩니다.<br/><br/>
 *
 * <h2>출력</h2>
 * 영희가 해석한 문자열을 출력합니다.<br><br>
 *
 *
 * <h2>예시</h2>
 * <pre>
 * 예시 입력 1:
 * 4<br>
 * #****###**#####**#####**##**
 *
 * 예시 출력 1
 * COOL
 * </pre>
 */
public class _01_12_CrpytoMessage {

    private String solution(int charCnt, String input2) {
        StringBuilder answer = new StringBuilder();
        String s1 = input2.replaceAll("#", "1").replaceAll("\\*", "0");
        int cuttingLength = 7;
        for (int i = 0; i < charCnt; i++) {
            String substring = s1.substring(i * cuttingLength, (i + 1) * cuttingLength);
            char decryptChar = (char) Integer.parseInt(substring, 2);
            answer.append(decryptChar);
        }
        return answer.toString();
    }

    private String teacherSolution(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s = s.substring(0, 7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        String input2 = sc.next();
        String answer = new _01_12_CrpytoMessage().solution(input1, input2);
        System.out.println(answer);
    }
}
