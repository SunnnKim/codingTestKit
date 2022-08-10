package greedy.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
입출력 예
number	k	return
"1924"	2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String n = "4177252841";
//        String n = "1231234";
        int k = 4;
//        int k = 3;
        String r = s.solution(n,k);
        System.out.println(r); //3234
    }
}

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int pick = number.length() - k ; // 뽑아야하는수
        while(pick>0){
            int max = 0;
            int index = 0;
            for (int i = 0; i < number.length()-pick+1; i++) {
                int tmpNum = Character.getNumericValue(number.charAt(i));
                if(tmpNum == 9){
                    max = tmpNum;
                    index=i;
                    break;
                }else{
                    if (max < tmpNum) {
                        max = tmpNum;
                        index = i;
                    }
                }

            }
            sb.append(String.valueOf(max));
            number = number.substring(index + 1);
            pick--;
        }
        return sb.toString();
    }
}
