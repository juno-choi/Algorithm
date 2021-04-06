import java.util.Locale;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        String str = "8F3Z-2e-9-wabcdef";
        int k = 4;
        licenseKeyFormatting.solve(str, k);
    }

    /**
     * 1. 하이픈제거
     * 2. 대문자로 변경
     * 3. 끝에서 4자리(중요)
     *
     * String, StringBuffer, StringBuilder 차이점 장단점
     * 1. String + 연산이나 concat : 새로운 String 객체를 new로 만듦 (메모리 소비)
     * 2. StringBuffer, 멀티쓰레드 환경에서는 synchronized
     * 3. StringBuilder asynchronized 싱글 쓰레드 환경
     */

    public String solve(String str, int k){
        //하이픈 제거
        String newStr = str.replace("-","");
        System.out.println("newStr : "+ newStr);

        newStr = newStr.toUpperCase(Locale.ROOT);
        System.out.println("newStr : "+ newStr);

        int strLength = newStr.length();

        StringBuilder sb = new StringBuilder();
        sb.append(newStr);

        //k가 4일때 4,8,12로 잘라줘야함
        for(int i=k; i<strLength; i=i+k){
            sb.insert(strLength-i, '-');
        }
        System.out.println("sb : "+ sb);

        return newStr;
    }
}
