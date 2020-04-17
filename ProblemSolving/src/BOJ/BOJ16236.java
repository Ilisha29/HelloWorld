package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {
    static int N;
    static int[][] map;
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
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        answerSeconds = 0;
        fishList = new ArrayList<>();
        sharkSize = 2;
        eatenFishNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && map[i][j] != 9) {
                    fishList.add(new Fish(i, j, map[i][j]));
                }
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }
        Collections.sort(fishList);

        while (true) {
            boolean canEat = false;
            if (fishList.size() == 0) {
                break;
            }
            LinkedList<Fish> smallerFishes = new LinkedList<>();
            for (Fish fish : fishList) {
                if (fish.getSize() < sharkSize) {
                    smallerFishes.add(fish);
                }
            }
            if (smallerFishes.size() == 0) {
                break;
            }
            /*for (Fish fish : smallerFishes) {
                if (!isCanEat(startMap, fish)) {
                    smallerFishes.remove(fish);
                }
            }*/
            for(Iterator<Fish> iterator = smallerFishes.iterator(); iterator.hasNext();){
                Fish fish = iterator.next();
                if(!isCanEat(map,fish)){
                    iterator.remove();
                }
            }
            if (smallerFishes.size() == 0) {
                break;
            } else {
                //제일가까운거 먹고 startMap 재설정;
                int answerReach = Integer.MAX_VALUE;
                for (Fish fish : smallerFishes) {
                    answerReach = fish.getReach() < answerReach ? fish.getReach() : answerReach;
                }
                int willEatenFishX = N;
                int willEatenFishY = N;
                for (Fish fish : smallerFishes) {
                    if (fish.getReach() == answerReach) {
                        if (willEatenFishX > fish.getX()) {
                            willEatenFishX = fish.getX();
                            willEatenFishY = fish.getY();
                        } else if (willEatenFishX == fish.getX()) {
                            if (willEatenFishY > fish.getY()) {
                                willEatenFishX = fish.getX();
                                willEatenFishY = fish.getY();
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }

                    }
                }
                for (Fish fish : fishList) {
                    if (fish.getX() == willEatenFishX && fish.getY() == willEatenFishY) {
                        map[sharkX][sharkY] = 0;
                        sharkX = fish.getX();
                        sharkY = fish.getY();
                        map[sharkX][sharkY] = 9;
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

    private static boolean isCanEat(int[][] tmpMap, Fish fish) {
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
            if (tmpSharkX == fish.getX() && tmpSharkY == fish.getY()) {
                fish.setReach(tmpReach);
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
    private int x;
    private int y;
    private int size;
    private int reach;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    Fish(int x, int y, int size) {
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
