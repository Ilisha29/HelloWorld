package KAKAO.KAKAO2018공채.prac;

public class k5 {
    public static void main(String[] args) {
        int[] n = {2, 16, 16, 16};
        int[] t = {4, 16, 16, 100};
        int[] m = {2, 2, 2, 20};
        int[] p = {1, 1, 2, 3};
        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], t[i], m[i], p[i]));
            System.out.println();
        }
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder("");
        int max = t * m;
        int NUM = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        while (stringBuilder.length() < max) {
            makeString(stringBuilder, n, NUM++);
        }
        String answerSheet = stringBuilder.toString();
        for (int i = 0; i < answerSheet.length(); i++) {
            if (i % m + 1 == p) {
                answer.append(answerSheet.charAt(i));
            }
            if (answer.length() == t) {
                break;
            }
        }
        return answer.toString();
    }

    private static void makeString(StringBuilder stringBuilder, int n, int i) {
        if (i / n == 0) {
            stringBuilder.append(changeN(i));
            return;
        }
        makeString(stringBuilder, n, i / n);
        stringBuilder.append(changeN(i % n));
    }

    private static String changeN(int i) {
        if (i >= 10) {
            return Character.toString(('A' + i - 10));
        }
        return Integer.toString(i);
    }
}
