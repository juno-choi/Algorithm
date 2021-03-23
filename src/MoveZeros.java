public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,3,2,0,8,5};
        int index = 0;

        //0이 아닌 수들을 nums array에 다시 넣어준다.
        for(int i : nums){
            if(i != 0){
                nums[index] = i;
                index++;
            }
        }
        //0이 아닌 수들을 다 넣은 후 남은 자리에 0으로 넣어준다.
        while(index < nums.length){
            nums[index] = 0;
            index ++;
        }
        System.out.println("result");
        for(int i : nums){
            System.out.println(i);
        }

    }
}
