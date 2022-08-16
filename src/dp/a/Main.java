package dp.a;
/*
아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
이처럼 숫자 N과 number가 주어질 때,
N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.

제한사항
N은 1 이상 9 이하입니다.
number는 1 이상 32,000 이하입니다.
수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
최솟값이 8보다 크면 -1을 return 합니다.
입출력 예
N	number	return
5	12  	4
2	11  	3
입출력 예 설명
예제 #1
문제에 나온 예와 같습니다.

예제 #2
11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 2;
        int num = 11;
        int r = s.solution(N,num);
        System.out.println(r);
    }
}
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 9 ; i++) { // 8보다 크면 -1
            list.add(new HashSet<>());
        }
        list.get(1).add(N);

        if(N==1) return 1;
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= i / 2; j++) {
                unionSet(list.get(i), list.get(i-j), list.get(j));
                unionSet(list.get(i), list.get(j), list.get(i-j));
            }
            String num = Integer.toString(N);
            list.get(i).add(Integer.parseInt(num.repeat(i)));
            for(int n : list.get(i)){
                if(n==number) return i;
            }
//            if(list.get(i).contains(number)) return i;
        }

        return -1;
    }
    void unionSet(Set<Integer> unionSet, Set<Integer> set1, Set<Integer> set2) {
        for (int a : set1){
            for (int b : set2) {
                unionSet.add(a+b);
                unionSet.add(a-b);
                unionSet.add(a*b);
                if(b>0) unionSet.add(a/b);
            }
        }
    }

}