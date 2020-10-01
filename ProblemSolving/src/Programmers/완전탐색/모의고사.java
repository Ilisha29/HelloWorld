package Programmers.완전탐색;

public class 모의고사 {
    public static void main(String[] args) {


    }

    public int[] solution(int[] answers) {
        int[] answerNum = new int[3];
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        int answerIndex = 0;
        while (answerIndex != answers.length) {
            if (aIndex == first.length) aIndex = 0;
            if (bIndex == second.length) bIndex = 0;
            if (cIndex == third.length) cIndex = 0;

            if (first[aIndex] == answers[answerIndex]) {
                answerNum[0]++;
            }
            if (second[bIndex] == answers[answerIndex]) {
                answerNum[1]++;
            }
            if (third[cIndex] == answers[answerIndex]) {
                answerNum[2]++;
            }
            aIndex++;
            bIndex++;
            cIndex++;
            answerIndex++;
        }
        int max = Math.max(answerNum[0], answerNum[1]);
        max = Math.max(max, answerNum[2]);
        int num = 0;
        for (int i = 0; i < answerNum.length; i++) {
            if (answerNum[i] == max) {
                num++;
            }
        }
        int[] answerArray = new int[num];
        int idx = 0;
        for (int i = 0; i < answerNum.length; i++) {
            if (answerNum[i] == max) {
                answerArray[idx++] = i+1;
            }
        }
        return answerArray;
    }
}