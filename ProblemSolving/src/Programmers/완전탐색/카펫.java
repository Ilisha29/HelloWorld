package Programmers.완전탐색;

public class 카펫 {
    // 16 : 00
    public static void main(String[] args) {
        int[][] input = {{10, 2}, {8, 1}, {24, 24}};
        for (int i = 0; i < input.length; i++) {
            int[] result = solution(input[i][0], input[i][1]);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = yellow; i >= 1; i--) {
            if (yellow % i == 0) {
                if (i >= (yellow / i)) {
                    int row = i;
                    int col = yellow / i;
                    if (row * 2 + col * 2 + 4 == brown) {
                        answer[0] = row + 2;
                        answer[1] = col + 2;
                    }
                }
            }
        }
        return answer;
    }
}