package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
 *
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 배열 arr의 크기 : 1,000,000 이하의 자연수
 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 * 입출력 예
 * arr	answer
 * [1,1,3,3,0,1,1]	[1,3,0,1]
 * [4,4,4,3,3]	[4,3]
 * 입출력 예 설명
 * 입출력 예 #1,2
 * 문제의 예시와 같습니다.
 */
public class HateSameNumber {
    public static void main(String[] args) {
        HateSameNumber hsn = new HateSameNumber();
        int[] arr = {1,1,3,3,0,1,1};
        int[] solution = hsn.solution(arr);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
    public int[] solution(int []arr) {
        //숫자를 넣어둘 stack
        Stack<Integer> stack = new Stack<>();
        List<Integer> basket = new LinkedList<>();

        for(int i : arr){
            if(!stack.isEmpty()){
                int stackSu = stack.peek();
                if(stackSu!=i){
                    stack.push(i);
                    basket.add(i);
                }
            }else{
                stack.push(i);
                basket.add(i);
            }
        }
        int[] answer = new int[basket.size()];
        int idx = 0;
        for(int i : basket){
            answer[idx++] = i;
        }

        return answer;
    }
}
