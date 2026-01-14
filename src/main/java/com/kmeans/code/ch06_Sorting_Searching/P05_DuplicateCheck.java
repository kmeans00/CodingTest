package com.kmeans.code.ch06_Sorting_Searching;

import java.util.*;

/*
5. 중복 확인
설명

현수네 반에는 N명의 학생들이 있습니다.

선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.

만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,

N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.


입력

첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.

두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.


출력

첫 번째 줄에 D 또는 U를 출력한다.


예시 입력 1

8
20 25 52 30 39 33 43 33
예시 출력 1

D
 */

public class P05_DuplicateCheck {

    public String solution(int[] arr, int n){
        String answer = "U";
        Arrays.sort(arr);
        for(int i = 0; i < n-1; i++){
            if(arr[i] == arr[i+1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args) {
        P05_DuplicateCheck p = new P05_DuplicateCheck();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(p.solution(arr, n));
    }
}


/* hashset 사용
public class P06_DuplicateCheck {

    public String solution(int[] arr, int n){
        String answer = "U";
        // 중복을 허용하지 않는 자료구조인 HashSet 생성
        Set<Integer> set = new HashSet<>();

        for(int x : arr){
            // set.add(x)는 x가 이미 존재하면 false를 반환합니다.
            if(!set.add(x)) return "D";
        }

        return answer;
    }

    public static void main(String[] args) {
        P06_DuplicateCheck p = new P06_DuplicateCheck();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(p.solution(arr, n));
    }
}

 */