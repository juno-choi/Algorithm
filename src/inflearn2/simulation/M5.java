package inflearn2.simulation;

import java.util.ArrayList;
import java.util.List;

public class M5 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 1, 5, 3, 2, 1, 1};
        System.out.println(solution(nums));
    }
    public static int solution(int[] nums){
        int result = 0;
        List<Integer> list = new ArrayList<>();

        // 봉우리 값 찾기
        for(int i=1; i<nums.length-1; i++){
            int lt = nums[i-1];
            int rt = nums[i+1];
            int target = nums[i];

            if(target>lt && target>rt){
                list.add(i);
            }
        }

        // 바이토닉 구하기
        for(int target : list){
            int lt = target - 1;
            int rt = target + 1;

            int beforeLt = nums[target];
            int beforeRt = nums[target];

            int count = 0;

            // 작아진다.
            while (lt >= 0){
                int n = nums[lt];
                if(n < beforeLt){
                    beforeLt = n;
                    lt--;
                    count++;
                }else{
                    break;
                }
            }
            // 커진다.
            while (rt < nums.length){
                int n = nums[rt];
                if(n < beforeRt){
                    beforeRt = n;
                    rt++;
                    count++;
                }else{
                    break;
                }
            }

            result = Math.max(result, count+1);
        }

        return result;
    }
}
