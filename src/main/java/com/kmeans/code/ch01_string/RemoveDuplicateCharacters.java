package com.kmeans.code.ch01_string;

/**
 * 설명
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램
 * 중복이 제거된 문자열의 각 문자는 원래의 문자열의 순서를 유지함
 *
 * 예시 입력 : ksekkser
 * 예시 출력 : kset
 */

import java.util.*;

public class RemoveDuplicateCharacters {
    public String solution(String str){
        String answer = "";

        // 1. 문자열의 처음부터 끝까지 한 글자씩 순회합니다.
        for(int i = 0; i < str.length(); i++){
            /*
             * [원리 설명]
             * 예: "ksekkser" 일 때 i=3인 경우 (문자 'k')
             * - i = 3
             * - str.charAt(i) = 'k'
             * - str.indexOf('k') = 0 (k가 가장 처음 나타난 위치는 0번 인덱스)
             * 결과: 3 == 0 은 거짓(false)이므로 answer에 추가되지 않음 (중복 제거)
             */

            // 현재 인덱스(i)와 해당 문자가 처음 발견된 인덱스가 일치할 때만 결과에 포함
            if(str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        RemoveDuplicateCharacters sol = new RemoveDuplicateCharacters();
        Scanner kb = new Scanner(System.in);

        // 콘솔에서 문자열 입력 받기
        String str = kb.next();

        // 결과 출력
        System.out.println(sol.solution(str));
    }
}