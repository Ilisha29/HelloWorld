package KAKAO.KAKAO2020공채;

// 21 : 19 start
public class KAKAO2020공채_기둥과_보_설치 {
    public static void main(String[] args) {
        int n = 5;
        int[][] frames = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] frames1 = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        int[][] answer = solution(n, frames);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
    //프로그램은 2차원 가상 벽면에 기둥과 보를 이용한 구조물을 설치할 수 있는데,
    // 기둥과 보는 길이가 1인 선분으로 표현되며 다음과 같은 규칙을 가지고 있습니다.
    //1. 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
    //2. 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
    //단, 바닥은 벽면의 맨 아래 지면을 말합니다.

    //기둥과 보를 삭제하는 기능도 있는데 기둥과 보를 삭제한 후에 남은 기둥과 보들 또한 위 규칙을 만족해야 합니다.
    //만약, 작업을 수행한 결과가 조건을 만족하지 않는다면 해당 작업은 무시됩니다.

    /*
    n은 5 이상 100 이하인 자연수입니다.  -> 맵사이즈
    build_frame의 세로(행) 길이는 1 이상 1,000 이하입니다. -> 1000개의 작업
            build_frame의 가로(열) 길이는 4입니다.
    build_frame의 원소는 [x, y, a, b]형태입니다
    */

    //a는 설치 또는 삭제할 구조물의 종류를 나타내며, 0은 기둥, 1은 보를 나타냅니다.
    //b는 구조물을 설치할 지, 혹은 삭제할 지를 나타내며 0은 삭제, 1은 설치를 나타냅니다.

    //최종 구조물의 상태는 아래 규칙에 맞춰 return 해주세요.
    //return 하는 배열은 가로(열) 길이가 3인 2차원 배열로, 각 구조물의 좌표를 담고있어야 합니다.
    //return 하는 배열의 원소는 [x, y, a] 형식입니다.
    //x, y는 기둥, 보의 교차점 좌표이며, [가로 좌표, 세로 좌표] 형태입니다.
    //기둥, 보는 교차점 좌표를 기준으로 오른쪽, 또는 위쪽 방향으로 설치되어 있음을 나타냅니다.
    //a는 구조물의 종류를 나타내며, 0은 기둥, 1은 보를 나타냅니다.
    //return 하는 배열은 x좌표 기준으로 오름차순 정렬하며, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬해주세요.
    //x, y좌표가 모두 같은 경우 기둥이 보보다 앞에 오면 됩니다.
    //{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
    public static int[][] solution(int n, int[][] build_frame) {
        Contructure[][] map = new Contructure[n + 1][n + 1];
        int structureNum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = new Contructure();
            }
        }
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2]; // 0 : 기둥 / 1 : 보
            int installOrDelete = build_frame[i][3]; // 0 : 삭제 / 1 : 설치
            if (type == 0) { ///기둥
                //1. 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
                if (installOrDelete == 0) { // 삭제
                    map[x][y].colRemove();
                    if (isAllConstructOk(map)) {
                        structureNum--;
                    } else {
                        map[x][y].colInstall();
                    }
                    /*if (y + 1 < map.length && map[x][y + 1].isColInstalled) {
                        if ((x - 1 >= 0 && y + 1 < map.length && !map[x - 1][y + 1].isRowInstalled) && !map[x][y + 1].isRowInstalled) {
                            continue;
                        }
                    }

                    if (x - 1 >= 0 && y + 1 < map.length && map[x - 1][y + 1].isRowInstalled) {
                        if (!map[x - 1][y].isColInstalled && !((x - 2 >= 0 && y + 1 < map.length && map[x - 2][y + 1].isRowInstalled) && (map[x][y + 1].isRowInstalled))) {
                            continue;
                        }
                    }

                    if (y + 1 < map.length && map[x][y + 1].isRowInstalled) {
                        if (!(x + 1 < map.length && map[x + 1][y].isColInstalled) && !((x - 1 >= 0 && y + 1 < map.length && map[x - 1][y + 1].isRowInstalled) && (x + 1 < map.length && y + 1 < map.length && map[x + 1][y + 1].isRowInstalled))) {
                            continue;
                        }
                    }*/

                } else { // 설치
                    if (y == 0) {
                        map[x][y].colInstall();
                        structureNum++;
                    } else if (y - 1 >= 0 && map[x][y - 1].isColInstalled) {
                        map[x][y].colInstall();
                        structureNum++;
                    } else if (map[x][y].isRowInstalled || (x - 1 >= 0 && map[x - 1][y].isRowInstalled)) {
                        map[x][y].colInstall();
                        structureNum++;
                    }
                }
            } else { // 보
                //2. 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
                if (installOrDelete == 0) { // 삭제
                    map[x][y].rowRemove();
                    if (isAllConstructOk(map)) {
                        structureNum--;

                    } else {
                        map[x][y].rowInstall();
                    }
                    /*if (x - 1 >= 0 && map[x - 1][y].isRowInstalled) {
                        if (y - 1 >= 0 && !map[x][y - 1].isColInstalled && x - 1 >= 0 && y - 1 >= 0 && !map[x - 1][y - 1].isColInstalled) {
                            continue;
                        }
                    }
                    if (x + 1 < map.length && map[x + 1][y].isRowInstalled) {
                        if (y - 1 >= 0 && x + 1 < map.length && !map[x + 1][y - 1].isColInstalled && x + 2 < map.length && y - 1 >= 0 && !map[x + 2][y - 1].isColInstalled) {
                            continue;
                        }
                    }
                    if (map[x][y].isColInstalled) {
                        if (y - 1 >= 0 && !map[x][y - 1].isColInstalled && x - 1 >= 0 && !map[x - 1][y].isRowInstalled) {
                            continue;
                        }
                    }
                    if (x + 1 < map.length && map[x + 1][y].isColInstalled) {
                        if (x + 1 < map.length && !map[x + 1][y].isRowInstalled && y - 1 >= 0 && !map[x + 1][y - 1].isColInstalled) {
                            continue;
                        }
                    }*/
                } else { // 설치
                    if (y - 1 >= 0 && map[x][y - 1].isColInstalled) {
                        map[x][y].rowInstall();
                        structureNum++;
                    } else if (x + 1 < map.length && y - 1 >= 0 && map[x + 1][y - 1].isColInstalled) {
                        map[x][y].rowInstall();
                        structureNum++;
                    } else if ((x - 1 >= 0 && map[x - 1][y].isRowInstalled) && (x + 1 < map.length && map[x + 1][y].isRowInstalled)) {
                        map[x][y].rowInstall();
                        structureNum++;
                    }
                }
            }
        }

        int[][] answer = new int[structureNum][3];
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j].isColInstalled) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index][2] = 0;
                    index++;
                }
                if (map[i][j].isRowInstalled) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index][2] = 1;
                    index++;
                }
            }
        }
        return answer;
    }

    private static boolean isAllConstructOk(Contructure[][] contructures) {
        for (int i = 0; i < contructures.length; i++) {
            for (int j = 0; j < contructures.length; j++) {
                if (contructures[i][j].isColInstalled) {
                    if (j != 0 && !(contructures[i][j - 1].isColInstalled) && !contructures[i][j].isRowInstalled && !(i - 1 >= 0 && contructures[i - 1][j].isRowInstalled)) {
                        return false;
                    }
                }

                if (contructures[i][j].isRowInstalled) {
                    if (!(j - 1 >= 0 && contructures[i][j - 1].isColInstalled) && !(i + 1 < contructures.length && j - 1 >= 0 && contructures[i + 1][j - 1].isColInstalled) && !(i + 1 < contructures.length && contructures[i + 1][j].isRowInstalled && i - 1 >= 0 && contructures[i - 1][j].isRowInstalled)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}

class Contructure {
    public boolean isColInstalled;
    public boolean isRowInstalled;

    public Contructure() {
        this.isRowInstalled = false;
        this.isColInstalled = false;
    }

    public void colInstall() {
        this.isColInstalled = true;
    }

    public void rowInstall() {
        this.isRowInstalled = true;
    }

    public void colRemove() {
        this.isColInstalled = false;
    }

    public void rowRemove() {
        this.isRowInstalled = false;
    }
}