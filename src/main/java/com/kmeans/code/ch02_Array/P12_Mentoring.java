package com.kmeans.code.ch02_Array;

/*

12. 멘토링
설명

현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.

멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.

선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.

만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.

M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.


입력

첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.

두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.

만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.


출력

첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.


예시 입력 1

4 3
3 4 1 2
4 3 2 1
3 1 4 2

예시 출력 1

3

 */

import java.util.*;

public class P12_Mentoring {
    /**
     * @param n 학생 수
     * @param m 테스트 횟수
     * @param arr 테스트 결과 데이터 (m x n 배열)
     * @return 가능한 멘토-멘티 순서쌍의 개수
     */
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        // 1. 모든 가능한 (멘토, 멘티) 조합을 생성합니다. (i: 멘토 후보, j: 멘티 후보)
        // 학생 번호가 1번부터 n번까지이므로 1부터 n까지 순회합니다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // i와 j가 같으면 안 되지만, 아래 pi < pj 조건에서 자연스럽게 걸러지므로
                // 별도의 if(i == j) 처리는 안 해도 무방합니다.

                int cnt = 0; // m번의 테스트 중 멘토(i)가 멘티(j)보다 앞선 횟수

                // 2. 모든 테스트(k)를 돌며 i와 j의 등수를 비교합니다.
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0; // pi: 멘토의 등수, pj: 멘티의 등수

                    // 3. 해당 테스트(k) 내에서 학생들의 위치(s: 인덱스 = 등수)를 찾습니다.
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) pi = s; // 멘토 후보 i의 등수 저장
                        if (arr[k][s] == j) pj = s; // 멘티 후보 j의 등수 저장
                    }

                    // 4. 멘토의 등수가 멘티보다 앞서면(숫자가 작으면) 카운트 증가
                    if (pi < pj) cnt++;
                }

                // 5. 모든 테스트(m번)에서 멘토가 앞섰다면 정답 카운트
                if (cnt == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P12_Mentoring sol = new P12_Mentoring();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(); // 학생 수
        int m = kb.nextInt(); // 테스트 횟수

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(sol.solution(n, m, arr));
    }
}
