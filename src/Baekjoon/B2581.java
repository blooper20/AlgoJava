package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	164278	65702	55257	39.702%
문제
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.

입력
입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.

M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

출력
M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.

단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine()); //M이상
        int N = Integer.parseInt(br.readLine()); //N이하
        int sum = 0;
        int min = N;

        x : for (int i = M; i <= N; i++) { //N회만큼 반복
            if (i == 1) { //1은 소수가 아님
                continue;
            }

            for (int j = 2; j < i; j++) { //2~i-1까지의 수랑 i랑 나눠서 나머지가 0이면 소수가 아니므로 for문 스킵.
                if (i % j == 0) {
                    continue x;
                }
            }
            sum += i;

            if (min > i) {
                min = i;
            }
        }

        if (sum == 0 ) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum + "\n" + min);
    }
}