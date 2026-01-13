package com.kmeans.code.ch01_string;

/**
 * 숫자만 추출
 * 설명
 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.

 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.

 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 * 예시 입력
 * g0en2T0s8eSoft
 * 예시 출력
 * 208
 */

import java.util.*;

public class onlyNum {

//    방법 1
//    public int solution(String s){
//        int answer = 0;
//        for (char x : s.toCharArray()) {
//            if(x>=48 && x<=57) answer=answer*10+(x-48);
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args){
//        onlyNum sol = new onlyNum();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        System.out.println(sol.solution(str));
//    }
//    방법 2
public int solution(String s){
    String answer = "";
    for (char x : s.toCharArray()) {
        if(Character.isDigit(x)) answer += x;
    }

    return Integer.parseInt(answer);
}

    public static void main(String[] args){
        onlyNum sol = new onlyNum();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(sol.solution(str));
    }
}
