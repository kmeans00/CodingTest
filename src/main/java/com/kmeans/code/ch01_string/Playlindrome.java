package com.kmeans.code.ch01_string;

/**
 *  회문 문자열 2
 *  설명
 *  앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 함
 *  문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하시오.
 *  단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않는다 알파벳 이외의 문자들은 무시함
 *
 *  예시 입력
 *  found7, time: study, Yduts; emit, 7Dnuof
 *  예시 출력
 *  yes
 */

import java.util.*;

public class Playlindrome {
    public String solution(String s){
        String answer = "NO";
        s=s.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(s).reverse().toString();
        if(tmp.equals(s)) return "YES";
        return answer;
    }

    public static void main(String[] args){
        Playlindrome sol = new Playlindrome();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(sol.solution(str));
    }
}
