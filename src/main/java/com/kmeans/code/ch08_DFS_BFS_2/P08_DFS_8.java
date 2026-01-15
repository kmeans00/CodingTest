package com.kmeans.code.ch08_DFS_BFS_2;

/*
    8. 수열 추측하기
설명

가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.

예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.

Image1.jpg

N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.

단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.


입력

첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.

N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.


출력

첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.

답이 존재하지 않는 경우는 입력으로 주어지지 않는다.


예시 입력 1

4 16
예시 출력 1

3 1 2 4
 */



import java.util.*;

public class P08_DFS_8 {
    // b: 조합 값(계수) 저장 배열, p: 만든 순열 저장 배열, ch: 중복 체크 배열
    static int[] b, p, ch;
    static int n, f; // n: 숫자의 개수, f: 최종 합계
    boolean flag = false; // 답을 찾으면 재귀를 즉시 종료하기 위한 플래그
    int[][] dy = new int[35][35]; // 메모이제이션(Memoization)을 위한 배열

    // 조합(nCr) 값을 구하는 메서드 (메모이제이션 활용)
    public int combi(int n, int r){
        if(dy[n][r] > 0) return dy[n][r]; // 이미 계산된 값이면 반환
        if(n == r || r == 0) return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    // DFS를 이용한 순열 생성 및 합계 체크
    public void DFS(int L, int sum){
        if(flag) return; // 답을 이미 찾았다면 더 이상 탐색하지 않음

        if(L == n){ // 순열이 완성된 경우
            if(sum == f){ // 완성된 순열의 최종 합이 f와 같다면
                for(int x : p) System.out.print(x + " "); // 정답 출력
                flag = true; // 이후 재귀 종료를 위해 플래그 설정
            }
        }
        else{
            // 1부터 n까지의 숫자를 사용하여 순열 만들기
            for(int i=1; i<=n; i++){
                if(ch[i] == 0){ // 아직 사용하지 않은 숫자라면
                    ch[i] = 1; // 사용 표시
                    p[L] = i;  // 순열 배열의 L번째 위치에 숫자 저장

                    // 핵심: (현재 숫자 * 해당 위치의 조합 계수)를 더하며 다음 단계로 진행
                    DFS(L + 1, sum + (p[L] * b[L]));

                    ch[i] = 0; // 재귀 복귀 후 사용 표시 해제 (백트래킹)
                }
            }
        }
    }

    public static void main(String[] args){
        P08_DFS_8 T = new P08_DFS_8();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        b = new int[n];      // 각 자리에 곱해질 조합 계수 배열
        p = new int[n];      // 현재 생성 중인 순열 배열
        ch = new int[n+1];   // 숫자 사용 여부 체크 (1~n)

        // 1. 파스칼의 삼각형 원리에 따라 미리 조합 계수를 계산해둠
        // 예: n=4이면 3C0, 3C1, 3C2, 3C3 순으로 b배열에 저장
        for(int i=0; i<n; i++){
            b[i] = T.combi(n-1, i);
        }

        // 2. DFS 탐색 시작 (Level 0, 합계 0)
        T.DFS(0, 0);
    }
}