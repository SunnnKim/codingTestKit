package bruthForth.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.

 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answers[] = {
                // 1, 3, 2, 4, 2
                // 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        };
        int[] r = s.solution(answers);
        System.out.println(Arrays.toString(r));
    }
}
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int [] p1 =  {1,2,3,4,5};
        int [] p2 =  {2,1,2,3,2,4,2,5};
        int [] p3 =  {3,3,1,1,2,2,4,4,5,5};

        int t1 = 0;
        int t2 = 0;
        int t3 = 0;

        // 패턴에 따른 답구하기
        for (int i = 0; i < answers.length; i++) {
            if(p1[(i % p1.length)] == answers[i]) t1++;
            if(p2[(i % p2.length)] == answers[i]) t2++;
            if(p3[(i % p3.length)] == answers[i]) t3++;
        }
        int[] ts = {t1, t2, t3};

        int max = 0;
        for (int i = 0; i < ts.length; i++) {
            if(ts[i] ==0) continue;
            if(max < ts[i]){
                list.clear();
                list.add(i+1);
                max=ts[i];
            }else if(max == ts[i]){
                list.add(i+1);
                max = ts[i];
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}