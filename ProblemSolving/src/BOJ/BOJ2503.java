package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i != j && j != k && k != i) {
                        integerQueue.offer(i * 100 + j * 10 + k);
                    }
                }
            }
        }
        int rep = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        for (int i = 0; i < rep; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(stringTokenizer.nextToken());
            int strike = Integer.parseInt(stringTokenizer.nextToken());
            int ball = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < integerQueue.size(); j++) {
                int tmp = integerQueue.poll();
                if (check(num, strike, ball, tmp)) {
                    integerQueue.offer(tmp);
                }
            }
        }
        System.out.println(integerQueue.size());
        bufferedReader.close();
    }

    private static boolean check(int num, int strike, int ball, int tmp) {
        int num1 = num / 100;
        int num2 = (num % 100) / 10;
        int num3 = num % 10;
        int tmp1 = tmp / 100;
        int tmp2 = (tmp % 100) / 10;
        int tmp3 = tmp % 10;
        int tmpStrike = 0;
        int tmpBall = 0;
        if (tmp1 == num1) {
            tmpStrike++;
        } else {
            if (tmp1 == num2) {
                tmpBall++;
            } else {
                if (tmp1 == num3) {
                    tmpBall++;
                }
            }
        }
        if (tmp2 == num2) {
            tmpStrike++;
        } else {
            if (tmp2 == num1) {
                tmpBall++;
            } else {
                if (tmp2 == num3) {
                    tmpBall++;
                }
            }
        }
        if (tmp3 == num3) {
            tmpStrike++;
        } else {
            if (tmp3 == num1) {
                tmpBall++;
            } else {
                if (tmp3 == num2) {
                    tmpBall++;
                }
            }
        }
        System.out.println("tmp : " + tmp + " tmpStrike : " + tmp+"tmp : " + tmp+"tmp : " + tmp);
        if (tmpBall == ball && tmpStrike == strike) {
            return true;
        }
        return false;
    }
}
