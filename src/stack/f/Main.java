package stack.f;

/*
괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

"()()" 또는 "(())()" 는 올바른 괄호입니다.
")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때,
문자열 s가 올바른 괄호이면 true를 return 하고,
올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

제한사항
문자열 s의 길이 : 100,000 이하의 자연수
문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
입출력 예
s	answer
"()()"	true
"(())()"	true
")()("	false
"(()("	false
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "())(";
        boolean b = s.solution(str);
        System.out.println(b);
    }
}
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int left = 0;
        int right = 0;
        boolean change = false;
        Queue<Character> queue = new LinkedList<>();

        if(s.length() % 2 != 0) return false; // 짝 안맞는 경우
        if(s.length() == 2) return s.equals("()"); // 2개인경우
        if(s.charAt(0) == ')') return false;

        queue.offer(s.charAt(0));
        // 그 외 케이스
        for (int i = 1; i < s.length() ; i++) {
            if(queue.isEmpty()){
                if(s.charAt(i) == ')') return false;
                else{
                    queue.add(s.charAt(i));
                }
            }else{
                if(s.charAt(i) == ')') queue.poll();
                else queue.add(s.charAt(i));
            }
        }
        return queue.isEmpty();
    }
}