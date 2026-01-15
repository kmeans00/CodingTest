package com.kmeans.code.ch07_DFS_BFS;

public class P09_Distance_DFS {
    Node root;
    public int DFS(int L, Node root){
        if(root.lt==null && root.rt==null) return L;
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }

    public static void main(String[] args) {
        P09_Distance_DFS tree = new P09_Distance_DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.rt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
