package com.kmeans.code.ch07_DFS_BFS;
import java.util.*;

public class P02_Binary {
    public void DFS(int n){
        if(n==0) return;
        else{
            DFS(n/2);
            System.out.println(n%2+ " ");
        }
    }

    public static void main(String[] args){
      P02_Binary T = new P02_Binary();
      T.DFS(11);
    }
}
