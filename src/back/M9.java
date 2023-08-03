package back;

import java.io.*;
import java.util.*;

public class M9 {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;

        Set<String> set = new HashSet<>();

        FileReader fileReader = new FileReader("/Users/juno/Desktop/juno/test.txt");
        BufferedReader br = new BufferedReader(fileReader);

        String line;
        while((line = br.readLine()) != null){
            String resultCode = line.substring(line.lastIndexOf("HTTP/1.0") + "HTTP/1.0".length()+2, line.lastIndexOf("HTTP/1.0") + "HTTP/1.0".length()+5);
            if(Integer.parseInt(resultCode) != 200){
                continue;
            }

            String resultData = line.substring(line.lastIndexOf("GET") + "GET".length()+1, line.lastIndexOf("HTTP/1.0")).trim();
            String file = resultData.substring(resultData.lastIndexOf("/") + 1);

            if(!file.isEmpty()){
                set.add(file.trim());
            }
        }

        for(String s : set){
            System.out.println(s);
        }
    }
}
