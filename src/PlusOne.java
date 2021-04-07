public class PlusOne {

    public static void main(String[] args) {
        //int[] digits = {1,2,3};
        //int[] digits = {9,9,9};
        int[] digits = {2,1,9,9,9};

        int[] result = plusOne(digits);
        for(int i : result){
            System.out.println("val = "+i);
        }
    }

    public static int[] plusOne(int[] digits){
        // 1. data structure
        int index = digits.length-1;
        int carry = 1;

        // 2. for while
        while(index >= 0 && carry > 0){
            digits[index] = (digits[index] + 1) % 10;   //10으로 나눈 나머지로
            if(digits[index] != 0){
                carry = 0;
            }
            index--;
        }
        if(carry == 1){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }


}


