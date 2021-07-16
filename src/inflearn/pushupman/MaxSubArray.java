package inflearn.pushupman;

public class MaxSubArray {
    /**
     * array 중 합이 제일 큰수
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){
        //1
        int newSum = nums[0];
        int max = nums[0];

        //2 fow while
        for(int i=1; i<nums.length; i++){
            newSum = Math.max(nums[i], newSum+nums[i]);
            max = Math.max(newSum, max);
        }
        return max;
    }

}
