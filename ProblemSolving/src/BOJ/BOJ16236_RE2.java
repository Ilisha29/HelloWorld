/*
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236_RE2 {
    static int N;
    static int[][] startMap;
    static int answerSeconds;
    static ArrayList<Fish> fishList;
    static int sharkSize;
    static int eatenFishNum;
    static int sharkX;
    static int sharkY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        startMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                startMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        answerSeconds = 0;
        fishList = new ArrayList<>();
        sharkSize = 2;
        eatenFishNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (startMap[i][j] != 0 && startMap[i][j] != 9) {
                    fishList.add(new Fish(i, j, startMap[i][j]));
                }
                if (startMap[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }
        if (fishList.size() > 1) {
            Collections.sort(fishList);
        }
        while (true) {
            if (fishList.size() == 0) {
                break;
            }
            LinkedList<Fish> smallerFishes = new LinkedList<>();
            for (Fish fish : fishList) {
                if (fish.size < sharkSize) {
                    smallerFishes.add(fish);
                }
            }
            if (smallerFishes.size() == 0) {
                break;
            }
            for(Iterator<Fish> iterator = smallerFishes.iterator(); iterator.hasNext();){
                Fish fish = iterator.next();
                if(!isCanEat(startMap,fish)){
                    iterator.remove();
                }
            }
            if (smallerFishes.size() == 0) {
                break;
            } else {
                //제일가까운거 먹고 startMap 재설정;
                int answerReach = Integer.MAX_VALUE;
                for (Fish fish : smallerFishes) {
                    answerReach = fish.reach < answerReach ? fish.reach : answerReach;
                }
                int willEatenFishX = N;
                int willEatenFishY = N;
                for (Fish fish : smallerFishes) {
                    if (fish.reach == answerReach) {
                        if (willEatenFishX > fish.x) {
                            willEatenFishX = fish.x;
                            willEatenFishY = fish.y;
                        } else if (willEatenFishX == fish.x) {
                            if (willEatenFishY > fish.y) {
                                willEatenFishX = fish.x;
                                willEatenFishY = fish.y;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }

                    }
                }
                for (Fish fish : fishList) {
                    if (fish.x == willEatenFishX && fish.y == willEatenFishY) {
                        startMap[sharkX][sharkY] = 0;
                        sharkX = fish.x;
                        sharkY = fish.y;
                        startMap[sharkX][sharkY] = 9;
                        fishList.remove(fish);
                        break;
                    }
                }
                answerSeconds += answerReach;
                eatenFishNum++;
                if (eatenFishNum == sharkSize) {
                    eatenFishNum = 0;
                    sharkSize++;
                }
            }
        }
        System.out.println(answerSeconds);
        bufferedReader.close();
    }

    static boolean isCanEat(int[][] tmpMap, Fish fish) {
        boolean[][] visitMap = new boolean[N][N];
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        Queue<Integer> queueReach = new LinkedList<>();
        visitMap[sharkX][sharkY] = true;
        queueX.add(sharkX);
        queueY.add(sharkY);
        queueReach.add(0);
        while (!queueX.isEmpty()) {
            int tmpSharkX = queueX.poll();
            int tmpSharkY = queueY.poll();
            int tmpReach = queueReach.poll();
            if (tmpSharkX == fish.x && tmpSharkY == fish.y) {
                fish.reach = tmpReach;
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int X = tmpSharkX + dx[i];
                int Y = tmpSharkY + dy[i];
                if (X >= 0 && X < N && Y >= 0 && Y < N && !visitMap[X][Y] && tmpMap[X][Y] <= sharkSize) {
                    visitMap[X][Y] = true;
                    queueX.add(X);
                    queueY.add(Y);
                    queueReach.add(tmpReach + 1);
                }
            }
        }
        return false;
    }
}

class Fish implements Comparable<Fish> {
    int x;
    int y;
    int size;
    int reach;

    public Fish(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.reach = 0;
    }

    @Override
    public int compareTo(Fish fish) {
        if (this.size > fish.size) {
            return 1;
        } else if (this.size < fish.size) {
            return -1;
        } else {
            return 0;
        }
    }
}
*/
