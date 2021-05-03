public class TraapingRainWater {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solve(nums));
    }

    /**
     * 비가오면 벽돌에 물이 찬다. 비가 올때 벽돌에 물이 차는 갯수를 구해라라
     */
    public static int solve(int[] height){

        //1 structure
        int result = 0;
        if(height ==null || height.length<=2){
            return result;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];


        //2 for while
        //left
        int max = height[0];
        left[0] = height[0];
        for(int i=1; i<height.length; i++){
            if(max<height[i]){
                left[i] = height[i];
                max = height[i];
            }else{
                left[i] = max;
            }
        }
        //right
        int end = height.length-1;
        max = height[end];
        right[end] = height[end];
        for(int i=end-1; i>=0; i--){
            if(max<height[i]){
                right[i] = height[i];
                max = height[i];
            }else{
                right[i] = max;
            }
        }
        //min
        for(int i=0; i<height.length; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}
