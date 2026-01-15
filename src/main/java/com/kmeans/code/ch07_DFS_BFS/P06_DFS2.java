package com.kmeans.code.ch07_DFS_BFS;


public class P06_DFS2 {

    static int n;
    static int[] ch;

    public void DFS(int L){
        if(L == n+1){
            String tmp="";
            for(int i=1; i<=n; i++){
                if(ch[i]==1) tmp+=(i+" ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }else{
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args){
        P06_DFS2 T = new P06_DFS2();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
