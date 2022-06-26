package hash.c;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        int result = s.solution(clothes);
        System.out.println(result);
    }
}
