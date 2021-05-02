package KAKAO.KAKAO2019공채.try1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class K19_2 {
    public static void main(String[] args) {
        int[] n = {5, 4};
        int[][] stages = {{2, 1, 2, 6, 2, 4, 3, 3}, {4, 4, 4, 4, 4}};
        for (int i = 0; i < n.length; i++) {
            int[] r = solution(n[i], stages[i]);
            for (int j = 0; j < r.length; j++) {
                System.out.print(r[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] success = new int[N + 2];
        int[] stay = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            for (int j = 1; j < stages[i]; j++) {
                success[j]++;
            }
            stay[stages[i]]++;
        }
        ArrayList<Stage> arrayList = new ArrayList<>();
        for (int i = 1; i < success.length - 1; i++) {
            if (stay[i] == 0) {
                arrayList.add(new Stage(0, i));
            } else {
                double failRate = (double) stay[i] / (success[i] + stay[i]);
                arrayList.add(new Stage(failRate, i));
            }
        }
        Collections.sort(arrayList, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if (o1.failRate == o2.failRate) {
                    return o1.stage - o2.stage;
                } else {
                    if (o1.failRate < o2.failRate) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i).stage;
        }
        return answer;
    }
}

class Stage {
    double failRate;
    int stage;

    public Stage(double failRate, int stage) {
        this.failRate = failRate;
        this.stage = stage;
    }
}