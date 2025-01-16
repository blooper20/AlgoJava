package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	315184	125290	74141	38.319%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visitedDFS;
    static boolean[] visitedBFS;
    static List<Integer> resultDFS = new ArrayList<>();
    static List<Integer> resultBFS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N + 1];
        visitedBFS = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list.get(i));
        }

        dfs(V);
        bfs(V);

        StringBuilder sb = new StringBuilder();

        for (int node : resultDFS) {
            sb.append(node).append(" ");
        }

        sb.append("\n");

        for (int node : resultBFS) {
            sb.append(node).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int V) {
        visitedDFS[V] = true;
        resultDFS.add(V);
        for (int next : list.get(V)) {
            if (!visitedDFS[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        visitedBFS[V] = true;
        queue.add(V);
        resultBFS.add(V);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : list.get(current)) {
                if (!visitedBFS[next]) {
                    queue.add(next);
                    visitedBFS[next] = true;
                    resultBFS.add(next);
                }
            }
        }
    }
}
