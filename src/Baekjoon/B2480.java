package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 입력 받은 값을 list에 저장 후 집합으로 변환
        List<Integer> list = Arrays.asList(a, b, c);
        Set<Integer> set = new HashSet<Integer>(list);

        if (list.size() == set.size()) { // 리스트의 크기와 집합의 크기가 같으면 중복이 없다
            Collections.sort(list, Collections.reverseOrder()); // 오름차순으로 리스트 정렬
            System.out.println(list.get(0) * 100);
        } else if (set.size() == 2) {
            if (Collections.frequency(list, a) == 2) { // 리스트에 a 값이 중복일 때 (a == b), (a == c)
                System.out.println(a * 100 + 1000);
            } else { // (b == c)
                System.out.println(b * 100 + 1000);
            }
        } else {
            System.out.println(list.get(0) * 1000 + 10000);
        }
    }
}
