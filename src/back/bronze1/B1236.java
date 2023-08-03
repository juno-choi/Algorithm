package back.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1236 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String mn = bf.readLine().trim();
        String[] mnSplit = mn.split(" ");
        int m = Integer.parseInt(mnSplit[0]);

        int result = 0;
        for(int i=0; i<m; i++){
            String str = bf.readLine().trim();
            if(!str.contains("X")){
                result++;
            }
        }

        System.out.println(result);
    }
}
