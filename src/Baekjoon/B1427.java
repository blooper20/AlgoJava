package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	110030	72214	59424	65.923%
문제
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] text = str.toCharArray();

        int[] arr = new int[text.length];

        for (int i = 0; i < text.length; i++) {
            arr[i] = text[i] - '0';
        }

        Arrays.sort(arr);

        for (int i = text.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}
