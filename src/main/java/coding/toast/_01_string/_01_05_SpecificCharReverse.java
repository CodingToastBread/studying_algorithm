package coding.toast._01_string;

import java.util.Scanner;

/**
<h2>설명</h2>

영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,<br>

특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


 <h2>입력</h2>
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


 <h2>출력</h2>
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

 <br>

 <pre>
 예시 입력 1:
 a#b!GE*T@S

 예시 출력 1:
 S#T!EG*b@a
 </pre>
 */
public class _01_05_SpecificCharReverse {

    // 나의 풀이1. 양방향에서 쌍으로 알파벳일 때만 동작함! 문제가 원하는 건 이게 아님!
    private String solution(String input) {
        String answer = "";

        if (input == null || input.length() <= 1) {
            return input;
        }


        char[] charArray = input.toCharArray();
        int leftPos = 0;
        int rightPos = charArray.length - 1;

        while ((rightPos - leftPos) > 0) {

            char leftChar = charArray[leftPos];
            char rightChar = charArray[rightPos];

            if (Character.isAlphabetic(leftChar) && Character.isAlphabetic(rightChar)) {
                charArray[leftPos] = rightChar;
                charArray[rightPos] = leftChar;
            }

            rightPos--;
            leftPos++;
        }

        return new String(charArray);
    }

    // 나의 풀이 2 (정답!)
    private String solution2(String input) {

        if (input == null || input.length() > 100) {
            throw new IllegalArgumentException("null 이거나 길이가 100을 넘는 문자열은 처리하지 못합니다.");
        }

        String answer = "";
        char[] charArray = input.toCharArray();

        int leftPos = 0;
        int rightPos = charArray.length - 1;

        while ((rightPos - leftPos) > 0) {

            if (!Character.isAlphabetic(charArray[leftPos])) {
                leftPos++;
                continue;
            } else if (!Character.isAlphabetic(charArray[rightPos])) {
                rightPos--;
                continue;
            }

            char temp = charArray[leftPos];
            charArray[leftPos] = charArray[rightPos];
            charArray[rightPos] = temp;

            rightPos--;
            leftPos++;
        }

        return new String(charArray);

    }


    // 선생님의 풀이
    private String teacherSolution(String input) {

        String answer = "";
        char[] charArray = input.toCharArray();

        int leftPos = 0;
        int rightPos = charArray.length - 1;

        while (rightPos > leftPos) {
            if(!Character.isAlphabetic(charArray[leftPos])) leftPos++;
            else if(!Character.isAlphabetic(charArray[rightPos])) rightPos--;
            else {
                char temp = charArray[leftPos];
                charArray[leftPos] = charArray[rightPos];
                charArray[rightPos] = temp;
                leftPos++;
                rightPos--;
            }
        }

        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = new _01_05_SpecificCharReverse().solution2(input);
        System.out.println(answer);
    }
}
