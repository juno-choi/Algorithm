import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Java_Static_Initializer_Block {
/**
 * java의 main method보다 더 먼저 실행되는 정적 초기화 블럭에 대해 알아보기
 */
static boolean flag = false;
static int B = 0;
static int H = 0;
static{
   Scanner sc = new Scanner(System.in);
   B = sc.nextInt();
   H = sc.nextInt();
   
   if(B<=0 || H<=0){
      System.out.println("java.lang.Exception: Breadth and height must be positive");
   }else{
      flag = true;
   }
}

public static void main(String[] args){
      if(flag){
         int area=B*H;
         System.out.print(area);
      }
      
   }//end of main

}//end of class