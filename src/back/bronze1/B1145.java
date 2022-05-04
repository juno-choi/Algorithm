package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1145 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bf.readLine().trim();

        solve(input1);
    }
    public static void solve(String input1){
        String[] s = input1.split(" ");
        dfs(1, s);
    }
    public static void dfs(int level, String[] s){
        int check = 0;
        if(level % Integer.valueOf(s[0]) == 0) check++;
        if(level % Integer.valueOf(s[1]) == 0) check++;
        if(level % Integer.valueOf(s[2]) == 0) check++;
        if(level % Integer.valueOf(s[3]) == 0 && check<3) check++;
        if(level % Integer.valueOf(s[4]) == 0 && check<3) check++;
        if(check >=3) {
            System.out.println(level);
            return;
        }
        dfs(++level, s);
    }
}
