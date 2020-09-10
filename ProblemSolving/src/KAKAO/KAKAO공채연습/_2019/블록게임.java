package KAKAO.KAKAO공채연습._2019;

public class 블록게임 {
    public static void main(String[] args) {
        int[][] map = {
                //{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                //{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 7, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 7, 7, 7, 0, 0, 0, 0, 0, 0},
                {6, 6, 0, 0, 0, 0, 4, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}
        };
        System.out.println(solution(map));
    }

    static int type;

    public static int solution(int[][] board) {
        int answer = 0;
        type = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (checkTwoByTree(i, j, board) && board[i + 1][j] != 0 && board[i + 1][j + 1] != 0) {
                    int[][] tmpArray = new int[2][3];
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 3; l++) {
                            tmpArray[k][l] = board[k + i][l + j];
                        }
                    }
                    if (isCanErase2X3(tmpArray)) {
                        boolean clearUp = true;
                        if (type == 1) {
                            for (int k = 0; k < i; k++) {
                                if (board[k][j + 1] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                            for (int k = 0; k < i; k++) {
                                if (board[k][j + 2] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                        } else if (type == 2) {
                            for (int k = 0; k < i; k++) {
                                if (board[k][j] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                            for (int k = 0; k < i; k++) {
                                if (board[k][j + 2] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                        } else if (type == 3) {
                            for (int k = 0; k < i; k++) {
                                if (board[k][j] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                            for (int k = 0; k < i; k++) {
                                if (board[k][j + 1] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                        }
                        if (clearUp) {
                            for (int k = 0; k < 2; k++) {
                                for (int l = 0; l < 3; l++) {
                                    board[k + i][l + j] = 0;
                                }
                            }
                            answer++;
                            j = -1;
                        }
                        type = 0;
                    }
                } else if (checkTreeByTwo(i, j, board)) {
                    int[][] tmpArray = new int[3][2];
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 2; l++) {
                            tmpArray[k][l] = board[k + i][l + j];
                        }
                    }
                    if (isCanErase3X2(tmpArray)) {
                        boolean clearUp = true;
                        if (type == 4) {
                            for (int k = 0; k < i; k++) {
                                if (board[k][j + 1] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                        } else if (type == 5) {
                            for (int k = 0; k < i; k++) {
                                if (board[k][j] != 0) {
                                    clearUp = false;
                                    break;
                                }
                            }
                        }
                        if (clearUp) {
                            for (int k = 0; k < 3; k++) {
                                for (int l = 0; l < 2; l++) {
                                    board[k + i][l + j] = 0;
                                }
                            }
                            answer++;
                            j = -1;
                        }
                        type = 0;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isCanErase3X2(int[][] tmpArray) {
        if (tmpArray[0][0] != 0 &&
                tmpArray[0][0] == tmpArray[1][0] &&
                tmpArray[1][0] == tmpArray[2][0] &&
                tmpArray[2][0] == tmpArray[2][1] &&
                tmpArray[0][1] == 0 && tmpArray[1][1] == 0) {
            type = 4;
            return true;
        } else if (tmpArray[0][1] != 0 &&
                tmpArray[0][1] == tmpArray[1][1] &&
                tmpArray[1][1] == tmpArray[2][1] &&
                tmpArray[2][1] == tmpArray[2][0] &&
                tmpArray[0][0] == 0 && tmpArray[1][0] == 0) {
            type = 5;
            return true;
        }
        return false;
    }

    private static boolean isCanErase2X3(int[][] tmpArray) {
        if (tmpArray[0][0] != 0 &&
                tmpArray[0][0] == tmpArray[1][0] &&
                tmpArray[1][0] == tmpArray[1][1] &&
                tmpArray[1][1] == tmpArray[1][2] &&
                tmpArray[0][1] == 0 && tmpArray[0][2] == 0) {
            type = 1;
            return true;
        } else if (tmpArray[0][1] != 0 &&
                tmpArray[0][1] == tmpArray[1][1] &&
                tmpArray[1][1] == tmpArray[1][0] &&
                tmpArray[1][1] == tmpArray[1][2] &&
                tmpArray[0][0] == 0 && tmpArray[0][2] == 0) {
            type = 2;
            return true;
        } else if (tmpArray[0][2] != 0 &&
                tmpArray[0][2] == tmpArray[1][2] &&
                tmpArray[1][2] == tmpArray[1][1] &&
                tmpArray[1][1] == tmpArray[1][0] &&
                tmpArray[0][0] == 0 && tmpArray[0][1] == 0) {
            type = 3;
            return true;
        }
        return false;
    }

    private static boolean checkTreeByTwo(int i, int j, int[][] board) {
        if (i + 2 < board.length && j + 1 < board[0].length) {
            return true;
        }
        return false;
    }

    private static boolean checkTwoByTree(int i, int j, int[][] board) {
        if (i + 1 < board.length && j + 2 < board[0].length) {
            return true;
        }
        return false;
    }
}