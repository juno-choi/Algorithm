import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * 이차원 배열을 나선형으로 값을 체크하고 싶을때
     */
    public static void main(String[] args) {
        int[][] nums = {
                            {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                        };
        System.out.println(spiralOrder(nums));
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        // structure
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length==0) return result;

        int rowStart = 0;
        int rowEnd = matrix.length -1;  //세로 사이즈

        int colStart = 0;
        int colEnd = matrix[0].length -1;   //가로 사이즈

        //for while
        while(rowStart <= rowEnd && colStart <= colEnd){
            // right
            for(int i= colStart; i<=colEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for(int i=rowStart; i<=rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left
            if(rowStart<= rowEnd){  //while 내부에서 rowStart값이 증가하기 때문에 내부에서 한번 더 체크
                for(int i=colEnd; i>=colStart; i--){
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // up
            if(colStart<=colEnd){
                for(int i=rowEnd; i>=rowStart; i--){
                    result.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return result;
    }
}
