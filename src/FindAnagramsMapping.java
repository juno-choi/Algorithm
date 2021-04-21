import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    /**
     * map의 key, value 특성을 활용하여
     * 두개의 배열(값은 동일하지만 위치가 다른)을 비교하여
     * 같은 값이 위치하는 배열의 위치의 값을 반환한다.
     */
    public static void main(String[] args) {
        int[] A = {11, 27 ,45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
        int[] result = anagramMappings(A, B);
        for(int i : result){
            System.out.println(i);
        }
    }

    private static int[] anagramMappings(int[] A, int[] B) {
        //1 data structure
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap();
        //2 for while
        for(int i=0; i<B.length; i++){
            map.put(B[i],i);
        }
        for(int i=0; i<A.length; i++){
            result[i] = map.get(A[i]);
        }

        return result;
    }


}
