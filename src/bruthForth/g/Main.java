package bruthForth.g;

import java.util.Arrays;

/*
사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

제한사항
word의 길이는 1 이상 5 이하입니다.
word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
입출력 예
word	result
"AAAAE"	6
"AAAE"	10
"I"	1563
"EIO"	1189
입출력 예 설명
입출력 예 #1

사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어입니다.

입출력 예 #2

"AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어입니다.

입출력 예 #3

"I"는 1563번째 단어입니다.

입출력 예 #4

"EIO"는 1189번째 단어입니다.
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String word= "I";
        int r = s.solution(word);
        System.out.println(r);
    }
}
class Solution {
    int total = 5 * 6 * 6 * 6 * 6 ;
    String base[] = {"A", "E", "I", "O", "U"};
    int count = 0;
    public int solution(String word) {
        // A E I O U
        // 1 2 3 4 5
        int answer = 0;
        String[] w = word.split("");
        System.out.println(total);
        fun(word);
        System.out.println(count);
        for (int i = 0; i < total; i++) {
        }

        return answer;
    }
    // 시작단어, 지정글자, 자리수, 카운트
    int fun(String word){
        boolean b = false;
        int idx = 0;
        int point = 0;
        String str = "";
        boolean incline = true;
        int length = 5; // 전체글자수
        for(int k = 0; k < total; k ++){
                // 첫 글자
                for (int i = 0; i < length; i++) {
                    if(str.equals(word)) return count;
                    str += base[idx];
                    count++;
                    System.out.println(str);
                }
                // 하나씩빼기
                for (int i = length - 1; i > 0 ; i--) {
                    for (int j = 0; j < length; j++) {
                        if(j == idx)continue;
                        if(str.equals(word)) return count;
                        str = str.substring(0, i);
                        str+= base[j];
                        System.out.println(str);
                        count++;
                    }
                }
                System.out.println("----------------------");

                idx = 0;
                if(str.equals(word)){
                    break;
                }
                if( count > total){
                    break;
                }

        }

        return count;
    }

}