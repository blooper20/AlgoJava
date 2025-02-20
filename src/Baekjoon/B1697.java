package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	273561	81625	52007	26.277%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    static int N;
    static int K;
    static boolean[] visited = new boolean[100001];
    static int[] road = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs(N);

        System.out.println(road[K]);
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (2 * cur <= 100000 && !visited[2 * cur]) {
                q.offer(2 * cur);
                visited[2 * cur] = true;
                road[2 * cur] = road[cur] + 1;
            }

            if (cur + 1 <= 100000 && !visited[cur + 1]) {
                q.offer(cur + 1);
                visited[cur + 1] = true;
                road[cur + 1] = road[cur] + 1;
            }

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                q.offer(cur - 1);
                visited[cur - 1] = true;
                road[cur - 1] = road[cur] + 1;
            }
        }
    }
}