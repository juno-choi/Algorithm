package inflearn.pushupman;

import java.util.Stack;

public class DailyTemperature {
    /**
     * solution
     * 1. 문제를 정확히 이해
     * > 각 배열의 index값을 알아와서 -연산을 해준다.
     * 2. 담을 그릇을 정한다(stack 이용)
     * 3. for, while 돌리기 (알고리즘)
     */
    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dt.solve(nums);

        for(int i: res){
            System.out.print(i + " ");
        }

    }
    public int[] solve(int[] temper){
        //1. data structure (공간 복잡도)
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];

        //for(시간 복잡도)
        for(int i=0; i<temper.length; i++){

            while(!stack.isEmpty() && temper[stack.peek()] < temper[i]){
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }
        return result;
    }



}
