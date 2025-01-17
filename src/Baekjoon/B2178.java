package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	192 MB	225312	105086	66105	44.996%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String strLine = br.readLine();

            int[] intArray = strLine.chars()
                    .map(cha -> cha - '0')
                    .toArray();

            for (int j = 0; j < M; j++) {
                graph[i][j] = intArray[j];
            }
        }

        bfs(0, 0);
        System.out.println(graph[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();

        queue.add(new int [] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (isValid(curX - 1, curY) && !visited[curX - 1][curY] && graph[curX - 1][curY] == 1) {
                queue.add(new int [] {curX - 1, curY});
                visited[curX - 1][curY] = true;
                graph[curX - 1][curY] = graph[curX][curY] + 1;
            }

            if (isValid(curX + 1, curY) && !visited[curX + 1][curY] && graph[curX + 1][curY] == 1) {
                queue.add(new int [] {curX + 1, curY});
                visited[curX + 1][curY] = true;
                graph[curX + 1][curY] =graph[curX][curY] + 1;
            }

            if (isValid(curX, curY - 1) && !visited[curX][curY - 1] && graph[curX][curY - 1] == 1) {
                queue.add(new int [] {curX, curY - 1});
                visited[curX][curY - 1] = true;
                graph[curX][curY - 1] = graph[curX][curY] + 1;
            }

            if (isValid(curX, curY + 1) && !visited[curX][curY + 1] && graph[curX][curY + 1] == 1) {
                queue.add(new int [] {curX, curY + 1});
                visited[curX][curY + 1] = true;
                graph[curX][curY + 1] = graph[curX][curY] + 1;
            }
        }
    }

    static boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}
