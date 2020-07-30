package KAKAO.KAKAO2020인턴;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[][] numbers = {{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}};
        String[] hands = {"right", "left", "right"};
        for (int i = 0; i < hands.length; i++) {
            System.out.println(solution(numbers[i], hands[i]));
        }
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int Lx = 0;
        int Ly = 0;
        int Rx = 0;
        int Ry = 2;
        int[] keyx = {0, 3, 3, 3, 2, 2, 2, 1, 1, 1};
        int[] keyy = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 1) { //왼손
                Lx = keyx[numbers[i]];
                Ly = keyy[numbers[i]];
                answer += "L";
            } else if (numbers[i] != 0 && numbers[i] % 3 == 0) { //오른손  //0에 대한 처리가 중요했다.
                Rx = keyx[numbers[i]];
                Ry = keyy[numbers[i]];
                answer += "R";
            } else {
                int x = keyx[numbers[i]];
                int y = keyy[numbers[i]];
                int Llength = Math.abs(x - Lx) + Math.abs(y - Ly);
                int Rlength = Math.abs(x - Rx) + Math.abs(y - Ry);
                if (Llength < Rlength) {
                    Lx = x;
                    Ly = y;
                    answer += "L";
                } else if (Llength > Rlength) {
                    Rx = x;
                    Ry = y;
                    answer += "R";
                } else {
                    if (hand.equals("right")) {
                        Rx = x;
                        Ry = y;
                        answer += "R";
                    } else {
                        Lx = x;
                        Ly = y;
                        answer += "L";
                    }
                }
            }
        }
        return answer;
    }
}
// 약 20분 소요