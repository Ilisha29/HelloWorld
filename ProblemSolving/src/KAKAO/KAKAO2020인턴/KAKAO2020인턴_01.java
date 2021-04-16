package KAKAO.KAKAO2020인턴;

public class KAKAO2020인턴_01 {
    public static void main(String[] args) {
        int[][] numbers = {{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}};
        String[] hands = {"left", "right"};
        for (int i = 0; i < 2; i++) {
            System.out.println(solution(numbers[i], hands[i]));
        }
    }

    /*
    엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
    왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
    오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
    가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
    4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
     */
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        Hand LeftHand = new Hand(3, 0);
        Hand RightHand = new Hand(3, 2);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                numbers[i] -= 1;
                LeftHand.x = numbers[i] / 3;
                LeftHand.y = 0;
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                numbers[i] -= 1;
                RightHand.x = numbers[i] / 3;
                RightHand.y = 2;
            } else {
                int X = 0;
                int Y = 0;
                if (numbers[i] == 0) {
                    X = 3;
                    Y = 1;
                } else {
                    numbers[i] -= 1;
                    X = numbers[i] / 3;
                    Y = 1;
                }

                int Llength = LengthToHand(X, Y, LeftHand.x, LeftHand.y);
                int Rlength = LengthToHand(X, Y, RightHand.x, RightHand.y);

                if (Llength > Rlength) {
                    answer += "R";
                    RightHand.x = X;
                    RightHand.y = Y;
                } else if (Llength < Rlength) {
                    answer += "L";
                    LeftHand.x = X;
                    LeftHand.y = Y;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        RightHand.x = X;
                        RightHand.y = Y;
                    } else {
                        answer += "L";
                        LeftHand.x = X;
                        LeftHand.y = Y;
                    }
                }
            }
        }
        return answer;
    }

    private static int LengthToHand(int X, int Y, int handX, int handY) {
        int length = 0;
        length += Math.abs(X - handX) + Math.abs(Y - handY);
        return length;
    }
}

class Hand {
    public int x;
    public int y;

    public Hand(int x, int y) {
        this.x = x;
        this.y = y;
    }
}