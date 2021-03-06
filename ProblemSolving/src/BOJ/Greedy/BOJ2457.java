package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Flower> flowers = new ArrayList<Flower>();
        for (int i = 0; i < rep; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int start = MMDDtoDays(input[0], input[1]);
            int end = MMDDtoDays(input[2], input[3]);
            if (start <= 334 && end > 60) {
                if (start < 60) start = 60;
                if (end > 335) end = 335;
                flowers.add(new Flower(start, end));
            }
        }
        if (flowers.isEmpty()) {
            System.out.println(0);
        } else {
            Collections.sort(flowers, new Comparator<Flower>() {
                @Override
                public int compare(Flower o1, Flower o2) {
                    if (o1.start == o2.start) {
                        return (o2.end - o2.start) - (o1.end - o1.start);
                    }
                    return o1.start - o2.start;
                }
            });
            System.out.println(calculateResult(flowers));
        }
        bufferedReader.close();
    }

    private static int calculateResult(ArrayList<Flower> flowers) {
        int tmpEnd = 60;
        int count = 0;
        for (int i = 0; i < flowers.size(); i++) {
            int index = 0;
            boolean findCondition = false;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < flowers.size(); j++) {
                if (flowers.get(j).start <= tmpEnd && flowers.get(j).end > tmpEnd) {
                    max = Math.max(flowers.get(j).end, max);
                    if (!findCondition) {
                        findCondition = true;
                    }
                } else if (flowers.get(j).start > tmpEnd) {
                    index = j;
                    break;
                }
            }
            if (!findCondition) {
                return 0;
            }
            count++;
            if (max == 335) {
                return count;
            } else {
                tmpEnd = max;
                i = index - 1;
            }
        }
        return 0;
    }

    private static int MMDDtoDays(String month, String day) {
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for (int i = 0; i < Integer.parseInt(month); i++) {
            days += months[i];
        }
        days += Integer.parseInt(day);
        return days;
    }
}

class Flower {
    int start;
    int end;

    Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }
}