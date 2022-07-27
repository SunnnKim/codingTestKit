package bruthForth.b;

import java.util.*;

/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
입출력 예
numbers	return
"17"	3
"011"	2
입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.
 */
public class Main {
    public static void main(String[] args) {
        String numbers = "1231";
        Solution s = new Solution();
        int r = s.solution(numbers);
        System.out.println(r);
    }
}
class Solution {
    public int solution(String numbers) {
        // 소수만들기
        int answer = 0;
        int[] array = new int[numbers.length()];
        // 따로 떼어내기
        int totalIndex = 0;
        for (int i = 0; i < numbers.length(); i++) {
            array[i] = Integer.valueOf(String.valueOf(numbers.charAt(i)));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
            recursion(array, array[i], i, set);
        }
        System.out.println(set);

        return answer;
    }
    // 재귀함수
    void recursion(int[] array, int num, int times, Set<Integer> set){
        for (int i = 0; i < array.length; i++) {
            if( i != times) {
                set.add(num + array[i]);
            recursion(array, (int)Math.pow(10, i+1) * array[times++], i, set);
            }
        }



//        else{
//            int a = array[times];
//            set.add(a);
//            recursion(array, a, ++times, set);
//        }
    }
}
