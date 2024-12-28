package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	126005	69625	53864	53.853%
문제
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.

출력
N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) { // 2부터 시작하여 n까지 반복
            while (n % i == 0) { // i로 나누어 떨어지면
                sb.append(i).append("\n"); // i를 출력
                n /= i; // n을 i로 나눔
            }
        }

        System.out.println(sb);
    }
}
