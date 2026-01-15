package com.kmeans.code.ch08_DFS_BFS_2;

/*
14. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용)
설명

N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.

각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.

행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.

도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는

피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.

집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.

예를 들어, 도시의 지도가 아래와 같다면

Image1.jpg

(1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.

최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.

도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.

시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.

도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.


입력

첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.

둘째 줄부터 도시 정보가 입력된다.


출력

첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.


예시 입력 1

4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
예시 출력 1

6
 */

import java.util.*;


public class p14_DFS_Pizza {
    // n: 격자크기, m: 살릴 피자집 개수, len: 전체 피자집 개수, answer: 도시의 최소 피자배달거리
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi; // 선택된 피자집의 인덱스를 저장할 조합 배열
    static ArrayList<Point> pz, hs; // pz: 피자집 위치들, hs: 집 위치들

    // DFS를 이용한 조합 구하기 (L: 레벨/선택된 개수, s: 탐색 시작 인덱스)
    public void DFS(int L, int s) {
        // 1. 종료 조건: 피자집 M개를 모두 선택했을 때
        if (L == m) {
            int sum = 0; // 도시의 피자배달거리 (모든 집의 배달거리 합)

            // 모든 집에 대하여 가장 가까운 피자집과의 거리 계산
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE; // 개별 집의 피자배달거리

                // 현재 조합(combi)으로 선택된 M개의 피자집들과의 거리 중 최소값 찾기
                for (int i : combi) {
                    // 거리 계산 공식: |x1-x2| + |y1-y2|
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis; // 해당 집의 최소 거리를 도시 전체 합에 누적
            }
            // 2. 최솟값 갱신: 여러 피자집 조합 중 도시의 배달거리가 가장 작은 경우 저장
            answer = Math.min(sum, answer);
        }
        else {
            // 전체 피자집(len) 중에서 M개를 뽑는 조합 로직
            for (int i = s; i < len; i++) {
                combi[L] = i;      // 피자집 인덱스 저장
                DFS(L + 1, i + 1); // 다음 피자집 선택을 위해 재귀 호출 (중복 방지를 위해 i+1)
            }
        }
    }

    public static void main(String[] args) {
        p14_DFS_Pizza T = new p14_DFS_Pizza();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pz = new ArrayList<>(); // 피자집 좌표 리스트
        hs = new ArrayList<>(); // 집 좌표 리스트

        // 도시 정보 입력 및 집(1), 피자집(2) 위치 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // 주의: j < m이 아니라 j < n이어야 함 (N*N 격자)
                int tmp = sc.nextInt();
                if (tmp == 1) hs.add(new Point(i, j));      // 집 위치 추가
                else if (tmp == 2) pz.add(new Point(i, j)); // 피자집 위치 추가
            }
        }

        len = pz.size();     // 전체 피자집 개수
        combi = new int[m];  // 살릴 피자집 M개의 인덱스를 담을 배열

        T.DFS(0, 0);         // 조합 탐색 시작
        System.out.println(answer);
    }
}