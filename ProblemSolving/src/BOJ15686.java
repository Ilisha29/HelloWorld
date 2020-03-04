import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16: 40 start
public class BOJ15686 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int maxChick = Integer.parseInt(stringTokenizer.nextToken());
        int chickNum = 0;
        int minGap = 2147483600;
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
                if (map[i][j] == 2) chickNum++;
            }
        }
        //최대 매장갯수 선택
        int[] chickX = new int[chickNum];
        int[] chickY = new int[chickNum];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 2) {
                    chickX[index] = i;
                    chickY[index] = j;
                    index++;
                }
            }
        }

        //1 2 4 8 16 32 64
        for (int i = 0; i < Math.pow(2, chickNum); i++) {
            int N = i;
            int[] array = new int[chickNum];
            int index2 = 0;
            while (N >= 2) {
                array[index2++] = N % 2;
                N /= 2;
            }
            array[index2] = N;

            int oneNum = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1) {
                    oneNum++;
                }
            }

            if (oneNum == maxChick) {
                int[][] tmpMap = new int[size][size]; //How deep copy?
                for (int j = 0; j < tmpMap.length; j++) {
                    for (int k = 0; k < tmpMap.length; k++) {
                        tmpMap[j][k] = map[j][k];
                    }
                }
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 0) {
                        tmpMap[chickX[j]][chickY[j]] = 0;
                    }
                }

                int tmpGap = 0;
                for (int j = 0; j < tmpMap.length; j++) {
                    for (int k = 0; k < tmpMap.length; k++) {
                        if (tmpMap[j][k] == 1) {
                            int oneGap = size + size;
                            for (int l = 0; l < tmpMap.length; l++) {
                                for (int m = 0; m < tmpMap.length; m++) {
                                    if (tmpMap[l][m] == 2) {
                                        oneGap = Math.abs(j - l) + Math.abs(k - m) < oneGap ? Math.abs(j - l) + Math.abs(k - m) : oneGap;
                                    }
                                }
                            }
                            tmpGap += oneGap;
                        }

                    }
                }
                /*for (int j = 0; j < tmpMap.length; j++) {
                    for (int k = 0; k < tmpMap.length; k++) {
                        System.out.print(tmpMap[j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println("tmpGap : " + tmpGap);
                */
                minGap = (tmpGap < minGap) ? tmpGap : minGap;
            }
            /*
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
            */
        }
        System.out.println(minGap);
        bufferedReader.close();
    }
}
//19 : 25 end
