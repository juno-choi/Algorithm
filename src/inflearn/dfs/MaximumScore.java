package inflearn.dfs;

import java.util.Scanner;

/**
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 *
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 *
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 *
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 */
public class MaximumScore {
    static int n,m=0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] scores = new int[n];
        int[] times = new int[n];
        for(int i=0; i<n; i++){
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }
        solution(scores, times);
        System.out.println(max);
    }
    public static void solution(int[] scores, int[] times){
        dfs(0,0,0, scores, times);
    }
    public static void dfs(int level, int time, int score, int[] scores, int[] times){
        if(time > m) return;
        if(level==n){
            max = Math.max(max, score);
        }else{
            dfs(level+1, time+times[level], score+scores[level], scores, times);
            dfs(level+1, time, score, scores, times);
        }
    }
}
