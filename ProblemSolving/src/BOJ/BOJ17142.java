package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 03 : 50 start
public class BOJ17142 {
    static int[][] map;
    static int answer;
    static Queue<Integer> X;
    static Queue<Integer> Y;
    static int[][] tmpMap;
    static boolean[][] virusCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        answer = N * N;
        //입력 끝

        int virusCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    virusCnt++;
                }
            }
        }

        int[] virusX = new int[virusCnt];
        int[] virusY = new int[virusCnt];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    virusX[index] = i;
                    virusY[index] = j;
                    index++;

                }
            }
        }
        //변수 저장

        boolean existAnswer = false;
        for (int i = 0; i < Math.pow(2, virusCnt); i++) {
            int tmp = i;
            int[] array = new int[virusCnt];
            int idx = 0;
            while (tmp > 1) {
                array[idx++] = tmp % 2;
                tmp /= 2;
            }
            array[idx] = tmp;

            int oneCnt = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1) {
                    oneCnt++;
                }
            }

            //핵심 로직
            // 0 공간 1 벽 2 바이러스 장소
            if (oneCnt == M) {
                tmpMap = new int[N][N];
                virusCheck = new boolean[N][N];

                //virusCheck초기화
                for (int j = 0; j < map.length; j++) {
                    for (int k = 0; k < map.length; k++) {
                        if (map[j][k] == 2) {
                            virusCheck[j][k] = true;
                        }
                        if (map[j][k] == 1) {
                            virusCheck[j][k] = true;
                        }
                    }
                }


                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (map[j][k] == 1) {
                            tmpMap[j][k] = -1;
                        }
                        if (map[j][k] == 0) {
                            tmpMap[j][k] = N * N;
                        }
                    }
                }
                X = new LinkedList<>();
                Y = new LinkedList<>();
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 0) { //비활성화
                        tmpMap[virusX[j]][virusY[j]] = N * N;
                    }
                    if (array[j] == 1) { //활성화
                        X.offer(virusX[j]);
                        Y.offer(virusY[j]);
                        tmpMap[virusX[j]][virusY[j]] = 0;
                    }
                }
                BFS();

                boolean allVIRUS = true;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (!virusCheck[j][k]) {
                            allVIRUS = false;
                        }
                    }
                }

                if (allVIRUS) {
                    existAnswer = true;
                    int tmpAnswer = 0;
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            if (tmpMap[j][k] != N * N && tmpMap[j][k] != 0) {
                                tmpAnswer = tmpMap[j][k] > tmpAnswer ? tmpMap[j][k] : tmpAnswer;
                            }
                        }
                    }
                    answer = tmpAnswer < answer ? tmpAnswer : answer;
                } else {

                }
                /*int NNcnt = 0;

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (tmpMap[j][k] == -2) {
                            tmpMap[j][k] = 0;
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (tmpMap[j][k] == N * N) {
                            NNcnt++;
                        }
                    }
                }


                if (NNcnt == 0) {
                    existAnswer = true;
                    int tmpAnswer = 0;
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < N; k++) {
                            if (tmpMap[j][k] != N * N && tmpMap[j][k] != 0) {
                                tmpAnswer = tmpMap[j][k] > tmpAnswer ? tmpMap[j][k] : tmpAnswer;
                            }
                        }
                    }
                    answer = tmpAnswer < answer ? tmpAnswer : answer;
                }*/
            }
        }
        if (!existAnswer) {
            System.out.println(-1);

        } else {
            System.out.println(answer);

        }
        bufferedReader.close();
    }

    private static void BFS() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x;
        int y;
        int tmpTime = 0;
        while (!X.isEmpty()) {
            /*boolean allVirus = true;
            for (int i = 0; i < tmpMap.length; i++) {
                for (int j = 0; j < tmpMap.length; j++) {
                    if (!virusCheck[i][j]) {
                        allVirus = false;
                    }
                }
            }
            if (allVirus) {
                break;
            }*/
            x = X.poll();
            y = Y.poll();
            tmpTime = tmpMap[x][y];
            virusCheck[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int x2 = x + dx[i];
                int y2 = y + dy[i];
                if (x2 >= 0 && x2 < map.length && y2 >= 0 && y2 < map[0].length && tmpMap[x2][y2] != -1 && !virusCheck[x2][y2]) {
                    if (tmpTime + 1 < tmpMap[x2][y2]) {
                        X.offer(x2);
                        Y.offer(y2);
                        tmpMap[x2][y2] = tmpTime + 1;
                    }
                }
            }
        }
    }
}
