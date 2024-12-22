package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	112523	62986	55629	56.558%
문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2444 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(br.readLine());
        for(int i = 1; i <= input; i++) {
            for(int j = input-i ; j >= 1; j--) sb.append(" ");
            for(int k = 1; k <= 2*i - 1; k++) sb.append("*");
            sb.append("\n");
        }
        for(int i = input-1; i >= 1; i--) {
            for(int j = 1 ; j <= input-i; j++) sb.append(" ");
            for(int k = 1; k <= 2*i - 1; k++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
