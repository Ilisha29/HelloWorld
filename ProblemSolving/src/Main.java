import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{2, 3, 1}, {3, 1, 2}, {1, 2, 3}};
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
