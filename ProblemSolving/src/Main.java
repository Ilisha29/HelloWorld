import java.util.Arrays;

public class Main {
    static int[][] map;
    static int babySharkSize;
    static int length;
    static int SHARKX;
    static int SHARKY;
    static int FISHX;
    static int FISHY;
    static int answer;
    static int ateFishNum;
    static int[][] lengthMap;
    static int I;
    static int J;
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
    private static void findLength(int sharkX, int sharkY, int tmpLength, boolean[][] check) {
        if (sharkX == I && sharkY == J) {
            if (tmpLength < length) {
                length = tmpLength;
                FISHX = I;
                FISHY = J;
            }
            return;
        }
        if (tmpLength >= length) { return;} // 시간 단축 }
        if (check[sharkX][sharkY]) { return; }
        check[sharkX][sharkY] = true;
        if (tmpLength > lengthMap[sharkX][sharkY]) { return; }
        if (tmpLength < lengthMap[sharkX][sharkY]) { lengthMap[sharkX][sharkY] = tmpLength; }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int X = sharkX + dx[i];
            int Y = sharkY + dy[i];
            if (X >= 0 && X < map.length && Y >= 0 && Y < map.length && map[X][Y] <= babySharkSize && !check[X][Y]) {
                findLength(X, Y, tmpLength + 1, check);
                /*놓친부분2*/
                check[X][Y] = false; //ㅠㅠ 이부분 초기화 해줘야된다.... true값이 였었다.......... 안그럼 같은 깊이에서 다른 깊이에서 영향 받은 boolean값이 넘어옴 초기화 제대로
                /*놓친부분2*/
            }
        }
    }
}
