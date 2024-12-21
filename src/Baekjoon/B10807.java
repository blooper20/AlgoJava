package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < a; i++) {
            if(Integer.parseInt(st.nextToken()) == c) {
                count += 1;
            }
        }
        System.out.print(count);
    }
}
