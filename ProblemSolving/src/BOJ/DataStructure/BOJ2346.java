package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Balloon> balloons = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            balloons.add(new Balloon(i + 1, array[i]));
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 0;
        while (true) {
            Balloon balloon = balloons.get(i);
            stringBuilder.append(balloon.number + " ");
            balloon.visit = true;
            if (balloonsAllVisited(balloons)) {
                break;
            }
            int move = balloon.moveValue;
            if (move > 0) {
                while (move > 0) {
                    i++;
                    if (i == balloons.size()) {
                        i = 0;
                    }
                    if (!balloons.get(i).visit) {
                        move--;
                    }
                }
            } else {
                while (move < 0) {
                    i--;
                    if (i == -1) {
                        i = balloons.size() - 1;
                    }
                    if (!balloons.get(i).visit) {
                        move++;
                    }
                }
            }
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    private static boolean balloonsAllVisited(ArrayList<Balloon> balloons) {
        int n = balloons.size();
        for (int i = 0; i < n; i++) {
            Balloon balloon = balloons.get(i);
            if (!balloon.visit) {
                return false;
            }
        }
        return true;
    }
}

class Balloon {
    int number;
    int moveValue;
    boolean visit;

    public Balloon(int number, int moveValue) {
        this.number = number;
        this.moveValue = moveValue;
        this.visit = false;
    }
}