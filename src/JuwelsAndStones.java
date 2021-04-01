import java.util.HashSet;
import java.util.Set;

public class JuwelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(solve(jewels, stones));
    }

    public static int solve(String jewels, String stones){
        //1. ds
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        for(char jewel : jewels.toCharArray()){
            set.add(jewel);
        }
        //2. for
        for(char stone : stones.toCharArray()){
            if(set.contains(stone)){
                cnt++;
            }
        }

        return cnt;
    }
}
