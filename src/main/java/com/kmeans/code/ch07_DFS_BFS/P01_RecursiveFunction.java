package com.kmeans.code.ch07_DFS_BFS;


import java.util.*;


public class P01_RecursiveFunction {
    public void DFS(int n){
        DFS(n-1);
    }

    public static void main(String[] args){
        P01_RecursiveFunction T = new P01_RecursiveFunction();
        T.DFS(3);
    }
}