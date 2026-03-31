import java.util.*;
public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int counter = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] < 0){
                    counter++;
                }
            }
        }
        return counter;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        CountNegativeNumbersInSortedMatrix obj = new CountNegativeNumbersInSortedMatrix();
        int result = obj.countNegatives(grid);
        System.out.println(result);
        sc.close();
    }
}