package programmers;

/**
 * 문제 설명
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 * 입출력 예
 * arr	result
 * [2,6,8,14]	168
 * [1,2,3]	6
 */
public class ArrayEuclidean {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayEuclidean ae = new ArrayEuclidean();
        int solution = ae.solution(arr);
        System.out.println("solution = " + solution);
    }
    public int solution(int[] arr) {
        int answer = 0;
        for(int i : arr){
            if(answer == 0){
                answer = i;
                continue;
            }

            answer = cal(answer, i);
        }
        return answer;
    }

    private int cal(int a, int b){
        int res = 0;
        res = a*b/gcd(a,b);
        return res;
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}
