package coding.toast._01_string;

import java.util.Scanner;

public class _01_02_UpperLowerChange {

    public String solution(String inputString) {
        // String answer = "";

        if (inputString == null || inputString.length() > 100) {
            throw new IllegalArgumentException("argument string input must be less then 100 length");
        }

        char[] charArray = inputString.toCharArray();
        StringBuilder sb = new StringBuilder(charArray.length);

        for (char c : charArray) {
            if(Character.isUpperCase(c))  sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        String answer = new _01_02_UpperLowerChange().solution(inputString);
        System.out.println(answer);
    }
}
