package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	205326	93061	59107	43.128%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2667 {
    static int N;
    static int cnt = 0;
    static int res = 0;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    res = 0;
                    dfs(i, j);
                    if (res != 0) {
                        list.add(res);
                        cnt++;
                    }
                }
            }
        }

        Collections.sort(list);

        sb.append(cnt).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int vI, int vJ) {
        if (!isValid(vI, vJ) || visited[vI][vJ]) return;
        if (!(graph[vI][vJ] == 1)) return;
        visited[vI][vJ] = true;

        res++;
        if (isValid(vI, vJ - 1)) {
            dfs(vI, vJ - 1);
        }

        if (isValid(vI, vJ + 1)) {
            dfs(vI, vJ + 1);
        }

        if (isValid(vI + 1, vJ)) {
            dfs(vI + 1, vJ);
        }

        if (isValid(vI - 1, vJ)) {
            dfs(vI - 1, vJ);
        }
    }
        static boolean isValid(int vI, int vJ) {
        return (vI >= 0 && vI < N && vJ >= 0 && vJ < N);
    }
}
