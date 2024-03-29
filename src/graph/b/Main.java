package graph.b;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다.
권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.

선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때
정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
선수의 수는 1명 이상 100명 이하입니다.
경기 결과는 1개 이상 4,500개 이하입니다.
results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
모든 경기 결과에는 모순이 없습니다.
입출력 예
n	results	return
5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
입출력 예 설명
2번 선수는 [1, 3, 4] 선수에게 패배했고 5번 선수에게 승리했기 때문에 4위입니다.
5번 선수는 4위인 2번 선수에게 패배했기 때문에 5위입니다.

 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[][] results = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };
        int r = s.solution(n, results);
        System.out.println(r);
    }
}
// 그래프 간선의 최소값찾기
// 플로이드-와셜 알고리즘 사용
// 한 점에서 모든 점을 지나며 최솟값을 찾는 경우 사용
// 시간복잡도 O(n^3)
// for문 3번반복
// a->b 로
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n][n];
        for (int i = 0; i < results.length; i++) {
            // 4, 3
            int a = results[i][0];
            int b = results[i][1];
            graph[a-1][b-1] = 1;
            graph[b-1][a-1] = -1;
        }

        // 이긴경우
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graph[i][j] == 0){
                        if (graph[i][k] == 1 && graph[k][j] == 1){
                            graph[i][j] = 1;
                        }
                        else if (graph[i][k] == -1 && graph[k][j] == -1){
                            graph[i][j] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(graph[i][j]==0) count++;
            }
            if(count == 1) answer++;
        }

        return answer;
    }

}