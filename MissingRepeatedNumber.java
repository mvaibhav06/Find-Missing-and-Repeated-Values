import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingRepeatedNumber {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        List<Integer> temp = new ArrayList<>();
        int[] out = new int[2];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!temp.contains(grid[i][j])){
                    temp.add(grid[i][j]);
                }else{
                    out[0] = grid[i][j];
                }
            }
        }

        Collections.sort(temp);
        int j = 0;
        int i = 0;
        for(i=1; i<=grid.length*grid.length; i++){
            if(j<temp.size() && temp.get(j) != i){
                out[1] = i;
                return out;
            }
            j++;
        }
        out[1] = grid.length*grid.length;
        return out;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(nums)));
    }
}
