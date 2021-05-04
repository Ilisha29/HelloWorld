package KAKAO.KAKAO2020인턴.prac;

public class k1 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder("");
        int[] leftXY = {3, 0};
        int[] rightXY = {3, 2};
        for (int i = 0; i < numbers.length; i++) {
            int X = 0;
            int Y = 0;
            if (numbers[i] == 0) {
                X = 3;
                Y = 1;
            } else {
                X = (numbers[i] - 1) / 3;
                Y = (numbers[i] - 1) % 3;
            }
            if (Y == 0) {
                leftXY[0] = X;
                leftXY[1] = Y;
                answer.append("L");

            } else if (Y == 2) {
                rightXY[0] = X;
                rightXY[1] = Y;
                answer.append("R");
            } else {
                int lengthL = Math.abs(X - leftXY[0]) + Math.abs(Y - leftXY[1]);
                int lengthR = Math.abs(X - rightXY[0]) + Math.abs(Y - rightXY[1]);
                if (lengthL == lengthR) {
                    if (hand.equals("left")) {
                        leftXY[0] = X;
                        leftXY[1] = Y;
                        answer.append("L");
                    } else {
                        rightXY[0] = X;
                        rightXY[1] = Y;
                        answer.append("R");
                    }
                } else if (lengthL > lengthR) {
                    rightXY[0] = X;
                    rightXY[1] = Y;
                    answer.append("R");
                } else {
                    leftXY[0] = X;
                    leftXY[1] = Y;
                    answer.append("L");
                }
            }
        }
        return answer.toString();
    }
}
