package codility;

import java.util.Arrays;

public class C6M2 {
    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6};
        int solution = solution(A);
        System.out.println(solution);
    }

    public static int solution(int[] A){
        int length = A.length;
        Integer[] array = new Integer[length];
        for(int i=0; i<length; i++){
            array[i] = A[i];
        }

        Arrays.sort(array, (a1, a2) -> a2 - a1);

        return Math.max(array[0] * array[1] * array[2], array[0] * array[length-1] * array[length-2]);
    }
}
