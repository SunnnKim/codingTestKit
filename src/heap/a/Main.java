package heap.a;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] sc =  {1, 2, 3, 9, 10, 12};
        int k = 7;

        int result = s.solution(sc, k);

        System.out.println(result);
    }

}
class Solution{

    public int solution(int[] scoville, int K) {
        if(scoville.length < 2) return -1;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) q.add(scoville[i]);
        int a, b, answer= 0;
        while(q.peek() < K){
            if(q.size() < 2) break;
            a = q.poll();
            b = q.poll();
            q.add(a + (b * 2));
            answer++;
        }
        if(q.peek() < K) return -1;
        else return answer;
    }
}





