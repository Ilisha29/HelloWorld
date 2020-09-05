package SeobNote;

public class rotate_a_matrix_by_90_degree {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        rotate_a_matrix_by_90_degree(matrix);
        rotate_a_matrix_by_90_degree(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void rotate_a_matrix_by_90_degree(int[][] matrix) {
        int length = matrix.length;
        int[][] new_matrix = new int[length][length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                new_matrix[i][j] = matrix[length - 1 - j][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = new_matrix[i][j];
            }
        }
    }
}
