package Baekjoon;

/*
 단어 정렬 성공

 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 2 초	256 MB	216111	91716	68579	40.714%
 문제
 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

 길이가 짧은 것부터
 길이가 같으면 사전 순으로
 단, 중복된 단어는 하나만 남기고 제거해야 한다.

 입력
 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

 출력
 조건에 따라 정렬하여 단어들을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (!list.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list,(e1, e2) -> {
            if (e1.length() == e2.length()) {
                return e1.compareTo(e2);
            }
            return e1.length() - e2.length();
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
