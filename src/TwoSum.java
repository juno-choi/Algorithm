import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Map, Array
     * 문제의 flow
     * Array Index 0부터 끝까지 for돌려서 target과 비교
     * Map(숫자, 배열의 번호)
     * 배열의 번호만 리턴한다
     */
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums= {2,8,11,14};
        int target = 16;
        int[] result = twoSum.solve(nums, target);
        for(int i:result){
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] nums, int target){
        //1. data structure 담을 그릇
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        //2. for
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                result[0] = value+1;
                result[1] = i+1;

            }else{
                map.put(target-nums[i], i);
            }
        }

        return result;
    }
}
