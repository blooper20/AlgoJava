package Baekjoon;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	96514	58635	49569	60.903%
문제
알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.

팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.

level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.

입력
첫째 줄에 단어가 주어진다. 단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.

출력
첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        String str1;
        String str2;

        if (str.length() % 2 == 0) {
            str1 = str.substring(0, (str.length() / 2));
            str2 = str.substring((str.length() / 2), str.length());
        } else {
            str1 = str.substring(0, (str.length() / 2));
            str2 = str.substring((str.length() / 2) + 1, str.length());
        }

        String reverse = new StringBuilder(str2).reverse().toString();

        if (str1.equals(reverse)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
