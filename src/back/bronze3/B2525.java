package back.bronze3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class B2525 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine().trim();
        String[] inputs = input.split(" ");

        String after = bf.readLine().trim();

        sb.append(solve(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), after));
        System.out.println(sb);
    }

    public static String solve(int hour, int minute, String after){
        LocalDateTime time = LocalDateTime.of(1999, 1, 1, hour, minute);
        time = time.plusMinutes(Long.parseLong(after));
        return String.format("%d %d", time.getHour(), time.getMinute());
    }
}
