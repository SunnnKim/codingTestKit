package hash.a;

public class Main {

    // 30분 걸림
    public static void main(String[] args) {
        newSolution s = new newSolution();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String result =  s.solution(participant, completion);
        System.out.println(result);
    }
}
