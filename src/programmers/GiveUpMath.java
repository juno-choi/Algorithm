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
public class GiveUpMath {

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        GiveUpMath giveUpMath = new GiveUpMath();
        int[] solution = giveUpMath.solution(answers);
        for (int i = 0; i < solution.length; i++) {
            int i1 = solution[i];
            System.out.println("i1 = " + i1);
        }
    }

    public int[] solution(int[] answers) {
        int length = answers.length;

        int[] first = new int[length];
        int[] second = new int[length];
        int[] third = new int[length];

        //1번 답안지 초기화
        for(int i=0; i<length; i++){
            first[i] = (i%5)+1;
        }
        //2번 답안지 초기화
        for(int i=1; i<=length; i++){
            int a = i%8;
            if(a%2 == 1){
                second[i-1] = 2;
            }
            if(a == 2){
                second[i-1] = 1;
            }else if(a == 4){
                second[i-1] = 3;
            }else if(a == 6){
                second[i-1] = 4;
            }else if(a == 0){
                second[i-1] = 5;
            }
        }

        //3번 답안지 초기화
        for(int i=0; i<length; i++){
            int input = 0;
            int a = i%10;
            //3, 3, 1, 1, 2, 2, 4, 4, 5, 5
            if(a<2){
                input = 3;
            }else if(a<4){
                input = 1;
            }else if(a<6){
                input = 2;
            }else if(a<8){
                input = 4;
            }else if(a<10){
                input = 5;
            }
            third[i] = input;
        }

        int firstScore = compare(answers, first);
        int secondScore = compare(answers, second);
        int thirdScore = compare(answers, third);

        int[] rank = new int[3];
        rank[0] = firstScore;
        rank[1] = secondScore;
        rank[2] = thirdScore;

        OptionalInt max = Arrays.stream(rank).max();
        int maxScore = max.getAsInt();
        ArrayList<Integer> ranking = new ArrayList<>();
        for(int i=0; i<rank.length; i++){
            if(maxScore == rank[i]){
                ranking.add(i+1);
            }
        }
        int rankingSize = ranking.size();
        int[] answer = new int[rankingSize];
        for(int i=0; i<rankingSize; i++){
            answer[i] = ranking.get(i);
        }

        return answer;
    }

    //정답일 경우 1 아닐 경우 0
    private int compare(int[] answers, int[] exam){
        int length = answers.length;
        int answer = 0;
        for(int i=0; i<length; i++){
            if(answers[i] == exam[i]) answer++;
        }
        return answer;
    }
}
