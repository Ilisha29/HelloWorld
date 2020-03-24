package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*내가 놓친 테스트 케이스
4 2
0 1 1 0
2 1 1 2
2 1 1 2
0 1 1 0
*/


public class BOJ17142_re {
    static int[][] map;
    static Queue<Integer> locationQueueX;
    static Queue<Integer> locationQueueY;
    static Queue<Integer> secondsQueue;
    static boolean[][] checkMap;
    static int[][] tmpMap;
    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int selectVirus = Integer.parseInt(stringTokenizer.nextToken());
        int totalVirus = 0;
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(stringTokenizer1.nextToken());
                map[i][j] = num;
                if (num == 2) {
                    totalVirus++;
                }
            }
        }
        int[][] virusLocation = new int[totalVirus][2];
        int virusLocationIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    virusLocation[virusLocationIndex][0] = i;
                    virusLocation[virusLocationIndex][1] = j;
                    virusLocationIndex++;
                }
            }
        }
        //입력 끝

        for (int i = 0; i < Math.pow(2, totalVirus); i++) {
            int arrayNum = i;
            int[] array = new int[totalVirus];
            int index = 0;
            while (arrayNum > 1) {
                array[index++] = arrayNum % 2;
                arrayNum /= 2;
            }
            array[index] = arrayNum;
            int oneNum = 0;
            for (int a = 0; a < array.length; a++) {
                if (array[a] == 1) {
                    oneNum++;
                }
            }
            if (oneNum == selectVirus) {
                //로직 시작
                locationQueueX = new LinkedList<>();
                locationQueueY = new LinkedList<>();
                secondsQueue = new LinkedList<>();
                tmpMap = new int[N][N];
                checkMap = new boolean[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (map[j][k] == 1) {
                            checkMap[j][k] = true;
                            tmpMap[j][k] = -1;
                        }
                        if (map[j][k] == 2) {
                            checkMap[j][k] = true;
                            tmpMap[j][k] = 0;
                        }
                        if (map[j][k] == 0) {
                            tmpMap[j][k] = N * N;
                        }
                    }
                }
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 1) {
                        locationQueueX.offer(virusLocation[j][0]);
                        locationQueueY.offer(virusLocation[j][1]);
                        secondsQueue.offer(0);
                    }
                }

                while (!locationQueueY.isEmpty()) {
                    int currentX = locationQueueX.poll();
                    int currentY = locationQueueY.poll();
                    int currentSeconds = secondsQueue.poll();
                    int[] dx = {-1, 0, 1, 0};
                    int[] dy = {0, 1, 0, -1};
                    for (int j = 0; j < 4; j++) {
                        int nextX = currentX + dx[j];
                        int nextY = currentY + dy[j];
                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && tmpMap[nextX][nextY] != -1) {
                            if (tmpMap[nextX][nextY] != 0) {
                                if (!checkMap[nextX][nextY] || (tmpMap[nextX][nextY] != -1 && checkMap[nextX][nextY] && tmpMap[nextX][nextY] > currentSeconds + 1)) {
                                    checkMap[nextX][nextY] = true;
                                    locationQueueY.offer(nextY);
                                    locationQueueX.offer(nextX);
                                    tmpMap[nextX][nextY] = currentSeconds + 1;
                                    secondsQueue.offer(currentSeconds + 1);
                                }
                            } else {
                                boolean canGo = false;
                                for (int k = 0; k < 4; k++) {
                                    int nextX2 = nextX + dx[k];
                                    int nextY2 = nextY + dy[k];
                                    if (nextX2 >= 0 && nextX2 < N && nextY2 >= 0 && nextY2 < N && tmpMap[nextX2][nextY2] != -1 && (currentX != nextX2 || currentY != nextY2)) {
                                        //놓친 테스트 케이스를 고려했지만 조건에서 || 를 했어야 했는데 이거 하나때문에 틀렸었다 ㅜㅜ
                                        if (!checkMap[nextX2][nextY2]) {
                                            canGo = true;
                                            break;
                                        }
                                    }
                                }
                                if (canGo) {
                                    locationQueueX.offer(nextX);
                                    locationQueueY.offer(nextY);
                                    tmpMap[nextX][nextY] = currentSeconds + 1;
                                    secondsQueue.offer(currentSeconds + 1);
                                }
                            }
                        }
                    }
                }
                boolean fulled = true;  //
                int tmpAsnwer = 0;  //
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (!checkMap[j][k]) {
                            fulled = false;
                        }
                        if (tmpMap[j][k] > tmpAsnwer) {
                            tmpAsnwer = tmpMap[j][k];
                        }
                    }
                }
                if (fulled) {
                    answer = tmpAsnwer < answer ? tmpAsnwer : answer;
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
        bufferedReader.close();
    }
}
