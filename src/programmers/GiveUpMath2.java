package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class GiveUpMath2 {

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        GiveUpMath2 giveUpMath = new GiveUpMath2();
        int[] solution = giveUpMath.solution(answers);
        for (int i = 0; i < solution.length; i++) {
            int i1 = solution[i];
            System.out.println("i1 = " + i1);
        }
    }

    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        //1번 정답 갯수 확인
        firstScore = score(answers, first);

        //2번 정답 갯수 확인
        secondScore = score(answers, second);

        //3번 정답 갯수 확인
        thirdScore = score(answers, third);
        int maxScore = Math.max(firstScore, Math.max(secondScore, thirdScore));

        int[] rank = {firstScore, secondScore, thirdScore};
        ArrayList<Integer> rankArr = new ArrayList<>();
        for(int i=0; i<rank.length; i++){
            if(maxScore == rank[i]) rankArr.add(i+1);
        }
        int size = rankArr.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = rankArr.get(i);
        }
        return answer;
    }

    private int score(int[] answers, int[] exam){
        int standard = exam.length;
        int score = 0;
        for(int i=0; i< answers.length; i++){
            if(answers[i] == exam[i%standard]){
                score++;
            }
        }
        return score;
    }
}
