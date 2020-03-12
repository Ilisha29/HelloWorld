public class Main {
    public static void main(String[] args) {
        int[][] map = new int[5][5];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        up(map);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void up(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
        }
    }
}
