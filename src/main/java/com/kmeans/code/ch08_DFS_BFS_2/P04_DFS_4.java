package com.kmeans.code.ch08_DFS_BFS_2;

import java.util.*;

public class P04_DFS_4 {
    static int[] pm;
    static int n, m;
    public void DFS(int L){
        if(L == m){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else{
            for (int i = 1; i<=n; i++){
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args){
        P04_DFS_4 T = new P04_DFS_4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}

