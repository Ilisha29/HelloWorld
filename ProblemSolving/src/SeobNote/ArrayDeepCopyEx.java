package SeobNote;

public class ArrayDeepCopyEx {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 7, 8}};
        int[][] b = new int[3][3];
        b = array.clone();
        b[0][0] = 9;
        b[0][1] = 9;
        b[0][2] = 9;
        b[1][0] = 8;
        b[1][1] = 6;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=================");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
