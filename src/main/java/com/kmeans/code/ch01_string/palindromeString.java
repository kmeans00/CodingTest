package com.kmeans.code.ch01_string;

/**
 *  회문 문자열
 *  설명
 *  앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 함
 *  문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 "NO"를 출력하는 프로그램을 작성하시오.
 *  단 회문을 검사할 때 대소문자를 구분하지 않음
 *
 *  예시 입력 : gooG
 *  예시 출력 : YES
 *
 */
import java.util.*;

public class palindromeString {

//  방법 1
//    public String solution(String str){
//        String answer = "YES";
//        str = str.toUpperCase();
//        int len = str.length();
//        for (int i = 0; i < len/2; i++){
//            if(str.charAt(i) != str.charAt(len-1-i)) answer = "NO";
//        }
//        return answer;
//    }
//
//    public static void main(String[] args){
//        palindromeString T = new palindromeString();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        System.out.println(T.solution(str));
//    }

// 방법 2
    public String solution(String str){
        String answer = "YES";
        String tmp = new StringBuilder(str).reverse().toString();
        if(!str.equalsIgnoreCase(tmp)) return "NO";
        return answer;
    }

    public static void main(String[] args){
        palindromeString T = new palindromeString();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
