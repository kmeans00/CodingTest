package com.kmeans.code.ch07_DFS_BFS;

public class P03_Factorial {
    public int DFS(int n){
        if(n==1) return 1;
        else return n*DFS(n-1);
    }

    public static void main(String[] args){
        P03_Factorial T = new P03_Factorial();
        T.DFS(5);
    }
}
