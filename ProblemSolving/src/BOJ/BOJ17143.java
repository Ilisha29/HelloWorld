package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 19 : 10
public class BOJ17143 {
    static Queue<Shark> sharkQueue;
    static ArrayList<Shark> catchedSharkList;
    static int[][] map;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[R][C];
        sharkQueue = new LinkedList<>();
        catchedSharkList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            sharkQueue.offer(new Shark(Integer.parseInt(stringTokenizer1.nextToken()) - 1, Integer.parseInt(stringTokenizer1.nextToken()) - 1, Integer.parseInt(stringTokenizer1.nextToken()), Integer.parseInt(stringTokenizer1.nextToken()), Integer.parseInt(stringTokenizer1.nextToken())));
        }

        //1번째 행위
        for (int i = 0; i < C; i++) {
            ArrayList<Shark> sharkArrayList = new ArrayList<>();
            //2번째 행위
            for (int j = 0; j < sharkQueue.size(); j++) {
                Shark shark = sharkQueue.poll();
                if (shark.y == i) {
                    sharkArrayList.add(shark);
                } else {
                    sharkQueue.offer(shark);
                }
            }

            if (sharkArrayList.size() >= 2) {
                Collections.sort(sharkArrayList);
            }

            if (sharkArrayList.size() == 1) {
                catchedSharkList.add(sharkArrayList.get(0));
            } else if (sharkArrayList.size() >= 2) {
                catchedSharkList.add(sharkArrayList.get(0));
                for (int j = 1; j < sharkArrayList.size(); j++) {
                    sharkQueue.offer(sharkArrayList.get(j));
                }
            }

            //3번째 행위 1 상어 움직임
            for (int j = 0; j < sharkQueue.size(); j++) {
                Shark shark = sharkQueue.poll();
                moveShark(shark);
                sharkQueue.offer(shark);
            }

            //3번째 행위 2 큰놈만남기
            Shark[][] sharks = new Shark[R][C];
            for (int j = 0; j < sharkQueue.size(); j++) {
                Shark shark = sharkQueue.poll();
                if (sharks[shark.x][shark.y] == null) {
                    sharks[shark.x][shark.y] = shark;
                } else {
                    Shark originShark = sharks[shark.x][shark.y];
                    if (shark.size > originShark.size) {
                        sharks[shark.x][shark.y] = shark;
                    }
                }
            }
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (sharks[j][k] != null) {
                        sharkQueue.offer(sharks[j][k]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < catchedSharkList.size(); i++) {
            answer += catchedSharkList.get(i).size;
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static void moveShark(Shark shark) {
        for (int i = 0; i < shark.speed; i++) {
            if (shark.direction == 1) { //위
                if (shark.x - 1 < 0) {
                    shark.setX(shark.x + 1);
                    shark.direction = 2;
                } else {
                    shark.setX(shark.x - 1);
                }
            } else if (shark.direction == 2) { //아래
                if (shark.x + 1 == R) {
                    shark.setX(shark.x - 1);
                    shark.direction = 1;
                } else {
                    shark.setX(shark.x + 1);
                }
            } else if (shark.direction == 3) { //우
                if (shark.y + 1 == C) {
                    shark.setY(shark.y - 1);
                    shark.direction = 4;
                } else {
                    shark.setY(shark.y + 1);
                }
            } else { //좌
                if (shark.y - 1 < 0) {
                    shark.setY(shark.y + 1);
                    shark.direction = 3;
                } else {
                    shark.setY(shark.y - 1);
                }
            }
        }
    }
}

class Shark implements Comparable<Shark> {
    int x;
    int y;
    int speed;
    int direction; //d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
    int size;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSize(int size) {
        this.size = size;
    }

    Shark(int x, int y, int speed, int direction, int size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }

    @Override
    public int compareTo(Shark shark) {
        if (this.x > shark.x) {
            return 1;
        } else if (this.x < shark.x) {
            return -1;
        } else {
            return 0;
        }
    }
}
