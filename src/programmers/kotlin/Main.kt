package programmers.kotlin

class Main {
}
fun main(){
    var survey = arrayOf("AN", "CF", "MJ", "RT", "NA");
    var choices = intArrayOf(5, 3, 2, 7, 5)
    var result = solution(survey, choices);
    println(result)
}
fun solution(survey: Array<String>, choices: IntArray): String {
    var answer: String = ""
    var score:Int = 0;
    for (i in choices.indices){
        if(choices[i] > 4){
            score = choices[i] - 4;
        }
    }
    return answer
}