package com.kmeans.code.ch08_DFS_BFS_2;
import java.util.*;

public class P09_DFS_9 {
    static int[] combi;
    static int n, m;
    public void DFS(int L, int s){
        if(L==m){
            for(int x : combi) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=s; i<=n; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args){
        P09_DFS_9 T = new P09_DFS_9();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[n];
        T.DFS(0,1);
    }
}
