package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	232036	110319	88245	47.329%
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int total = 0;

        int size = 0;
        while (n > size) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) {
                total++;
            }
            size++;
        }
        System.out.println(total);
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false; // 2보다 작은 수는 소수가 아님
        for (int i = 2; i <= Math.sqrt(num); i++) { // 제곱근까지만 확인
            if (num % i == 0) return false; // 나누어떨어지면 소수가 아님
        }
        return true; // 나누어떨어지지 않으면 소수
    }
}
