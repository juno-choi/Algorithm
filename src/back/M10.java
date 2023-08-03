package back;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class M10 {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;

        FileReader fileReader = new FileReader("/Users/juno/Desktop/juno/test.txt");
        BufferedReader br = new BufferedReader(fileReader);

        String line;
        Map<String, Integer> countMap = new LinkedHashMap<>();
        while((line = br.readLine()) != null){
            String resultData = line.substring(line.lastIndexOf("[")+1, line.lastIndexOf("]") - "-0400".length()).trim();
            countMap.put(resultData, countMap.getOrDefault(resultData, 0)+1);
        }

        Set<String> set = countMap.keySet();
        for(String key : set){
            Integer count = countMap.get(key);
            if(count>1){
                System.out.println(key);
            }
        }

        System.out.println("test");
    }
}
