package inflearn.pushupman;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k= 2;
        System.out.println(solve_pq(nums, k));
    }
    /**
     * 최대값에서 2번째 수를 구하라
     * 1. 배열 오름차순 정렬 후 전체 크기에서 2번째를 구하면 됨
     * 2. PriorityQueue
     */
    //1
    public static int solve_arr(int[] nums, int k){
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length-k];
    }
    //2
    public static int solve_pq(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);
        for(int i : nums){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    };

}
