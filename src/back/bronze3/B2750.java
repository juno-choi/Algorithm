package back.bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class B2750 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.valueOf(bf.readLine().trim());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<input; i++){
            list.add(Integer.parseInt(bf.readLine().trim()));
        }

        sb.append(solve(list));
        System.out.println(sb);
    }

    public static String solve(List<Integer> list){
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(int i : collect){
            sb.append(i);
            sb.append("\n");
        }

        return sb.toString();
    }
}
