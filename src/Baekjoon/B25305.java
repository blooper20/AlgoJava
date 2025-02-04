package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 1 초	1024 MB	45554	29960	27285	66.507%
 문제
 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에
 $N$명의 학생들이 응시했다.

 이들 중 점수가 가장 높은
 $k$명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.

 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

 입력
 첫째 줄에는 응시자의 수
 $N$과 상을 받는 사람의 수
 $k$가 공백을 사이에 두고 주어진다.

 둘째 줄에는 각 학생의 점수
 $x$가 공백을 사이에 두고 주어진다.

 출력
 상을 받는 커트라인을 출력하라.

 제한

 $1 ≤ N ≤ 1\,000$ 

 $1 ≤ k ≤ N$ 

 $0 ≤ x ≤ 10\,000$ 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        Arrays.sort(arr);

        System.out.println(arr[N - K]);
    }
}
