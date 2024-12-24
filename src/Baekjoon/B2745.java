package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	70030	34297	28996	48.598%
문제
B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

입력
첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)

B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

출력
첫째 줄에 B진법 수 N을 10진법으로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        br.close();

        int indexSize = n.length();     // 주어진 n의 자리크기를 파악
        int tenBase = 0;
        int tmp = 1;

        for (int i = indexSize - 1; i >= 0; i--) { // 주어진 n의 첫번째 문자열은 해당 진법의 가장 큰 자릿수를 의미해 역순으로 for문 실행
            Character ch = n.charAt(i);

            if ('A' <= ch && ch<= 'Z') {
                tenBase += (ch - 'A' + 10) * tmp;
            } else {
                tenBase += (ch - '0') * tmp;
            }
            tmp *= b;
        }
        System.out.println(tenBase);
    }
}