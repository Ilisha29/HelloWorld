package KAKAO.KAKAO2020인턴;

public class 키패드누르기2 {
    public static void main(String[] args) {
        int[][] num = {{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}};
        String[] mainHands = {"right", "left", "right"};
        for (int i = 0; i < num.length; i++) {
            System.out.println(solution(num[i], mainHands[i]));
        }
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder("");
        int[] rightXY = {3, 2};
        int[] leftXY = {3, 0};
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i] - 1;
            int numX = num / 3;
            int numY = num % 3;
            if (num == -1) {
                numX = 3;
                numY = 1;
            }
            int lengthR = Math.abs(rightXY[0] - numX) + Math.abs(rightXY[1] - numY);
            int lengthL = Math.abs(leftXY[0] - numX) + Math.abs(leftXY[1] - numY);
            if (numY == 2) {
                rightXY[0] = numX;
                rightXY[1] = numY;
                answer.append("R");
            } else if (numY == 0) {
                leftXY[0] = numX;
                leftXY[1] = numY;
                answer.append("L");
            } else if (numY == 1) {
                if (lengthL < lengthR) {
                    leftXY[0] = numX;
                    leftXY[1] = numY;
                    answer.append("L");
                } else if (lengthL > lengthR) {
                    rightXY[0] = numX;
                    rightXY[1] = numY;
                    answer.append("R");
                } else {
                    if (hand.equals("right")) {
                        rightXY[0] = numX;
                        rightXY[1] = numY;
                        answer.append("R");
                    } else {
                        leftXY[0] = numX;
                        leftXY[1] = numY;
                        answer.append("L");
                    }
                }
            }
        }
        return answer.toString();
    }
}