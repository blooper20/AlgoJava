package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	77475	50234	43492	64.668%
문제
자연수
\(N\)과 정수
\(K\)가 주어졌을 때 이항 계수
\(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.

입력
첫째 줄에
\(N\)과
\(K\)가 주어진다. (1 ≤
\(N\) ≤ 10, 0 ≤
\(K\) ≤
\(N\))

출력

\(\binom{N}{K}\)를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int son = 1;
        int parents = 1;
        for (int i = N - K + 1; i <= N; i++) {
            son *= i;
        }

        for (int i = 1; i <= K; i++) {
            parents *= i;
        }

        System.out.println(son/parents);
    }
}
