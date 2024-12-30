package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	164204	65670	55231	39.701%
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
import java.util.ArrayList;

public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();
        list = makePrimeArray(m, n);
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        int min = list.stream().min(Integer::compare).get();
        sb.append(sum).append("\n").append(min);

    }

    private static ArrayList<Integer> makePrimeArray(int m, int n) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        int sum = 0;
        int min;

        for (int i = m; i <= n; i++) {
            for (int j = 2 ; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    primeList.add(i);
                    sum += j;
                    min = j;
                    if (min == min) {

                    }
                }
            }
        }

        primeList.add(sum);
        return primeList;
    }
}
