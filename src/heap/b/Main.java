package heap.b;

/*
하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다.
디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다.
가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.

예를들어

- 0ms 시점에 3ms가 소요되는 A작업 요청
- 1ms 시점에 9ms가 소요되는 B작업 요청
- 2ms 시점에 6ms가 소요되는 C작업 요청
와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.
Screen Shot 2018-09-13 at 6.34.58 PM.png

한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
Screen Shot 2018-09-13 at 6.38.52 PM.png

- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.

하지만 A → C → B 순서대로 처리하면
Screen Shot 2018-09-13 at 6.41.42 PM.png

- A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
- C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
- B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.

각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면
평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)

제한 사항
jobs의 길이는 1 이상 500 이하입니다.
jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
입출력 예
jobs	return
[[0, 3], [1, 9], [2, 6]]	9
입출력 예 설명
문제에 주어진 예와 같습니다.

0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] sc = {
                {24, 10},
                {28, 39},
                {43, 20},
                {37, 5},
                {47, 22},
                {20, 47},
                {15, 34},
                {15, 2},
                {35, 43},
                {26, 1}
        };
        int result = s.solution(sc);

        System.out.println(result);
    }

}
class Solution{

    public int solution(int[][] jobs) {
        int count = 0; // 총 잡의 횟수
        int jobIdx = 0; // 현재 잡의 인덱스
        int end = 0; // 잡이 걸리는 시간
        int len = 0; // 최종길이

        Arrays.sort(jobs, (o1, o2)-> o1[0]-o2[0]); // 오름차순 정렬
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]); // 두번째 배열값 오름차순인 우선순위 큐


        // 잡의 단위 별로 실행한다
        while (count < jobs.length){
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end){
                q.add(jobs[jobIdx++]);
            }
            if(q.isEmpty()){
                // 다음 잡이 없는 경우
                end = jobs[jobIdx][0];

            }else{
                // 잡이 있는 경우
                int[] a = q.poll();
                len += a[1] + end - a[0];
                end += a[1];
                count++;
            }

        }

        return (int)Math.floor(len/ jobs.length);
    }
}
//
//
//    public int solution(int[][] jobs) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        PriorityQueue<Integer> q2 = new PriorityQueue<>();
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < jobs.length; i++) {
//            q.add(jobs[i][0]); // 숫자
//            q2.add(jobs[i][1]); // 숫자
//            map.put(jobs[i][0], jobs[i][1]);
//        }
//
//        int len = 0, node =0, total = 0;
//        boolean isProcessing = false;
//
//        int count = 0;
//        // 1순위 : 시작순서
//        // 2순위 : 걸리는시간
//        while(count < jobs.length){
//            // 실행중이 아닌경우
//            if(!isProcessing){
//                int tmp = q.poll();
//                total += map.get(tmp);
//                node += map.get(tmp);
//                q2.remove(map.get(tmp));
//            }else{
//                int time = q2.poll();
//                for(int i : map.keySet()){
//                    if(map.get(i) == time) {
//                        total += node + time - i;
//                        node = node + time; // len
//                        q.remove(i);
//                        break;
//                    }
//                }
//            }
//
//            if(q.peek() != null && q.peek() > node) isProcessing = false;
//            else isProcessing = true;
//            count++;
//        }
//        return (int)Math.ceil(total/jobs.length);
//    }


