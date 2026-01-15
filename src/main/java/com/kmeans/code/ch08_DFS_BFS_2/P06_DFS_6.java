package com.kmeans.code.ch08_DFS_BFS_2;

import java.util.*;
/* 순열 구하기
*
* 입력 예제
* 3 2
* 3 6 9
*
* 출력 예제
* 3 6
* 3 9
* 6 3
* 6 9
* 9 3
* 9 6
*
* */


public class P06_DFS_6 {
    static int[] pm, ch, arr;
    static int n, m;
    public void DFS(int L){
        if(L == m){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else{
            for(int i=0; i<n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[L]=arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        P06_DFS_6 T = new P06_DFS_6();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        ch=new int[n];
        pm=new int[n];
        T.DFS(0);
    }
}

