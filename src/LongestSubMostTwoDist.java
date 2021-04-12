import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist {
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(solve(s));
    }
    public static int solve(String s){
        //1 data structure
        int start = 0;
        int end = 0;
        int length = 0;
        int counter = 0;

        Map<Character, Integer> map = new HashMap<>();

        //2 for, while
        while(end < s.length()){
            char endChar = s.charAt(end);
            //c=2, a=2, b=3
            map.put(endChar, map.getOrDefault(endChar, 0)+1);
            if(map.get(endChar) ==  1) counter++;
            end++;

            while(counter>2){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);
                if(map.get(startChar)==0)counter--;
                start++;
            }

            length = Math.max(length, end-start);

        }
        return length;
    }
}
