public class ex {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};

        for (int i = 0; i < 4; i++) {
            print(key);
            System.out.println("=======");
            key = rotateKey(key);
        }
    }

    private static void print(int[][] key) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                System.out.print(key[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newKey[j][key.length - 1 - i] = key[i][j];
            }
        }
        return newKey;
    }
}
