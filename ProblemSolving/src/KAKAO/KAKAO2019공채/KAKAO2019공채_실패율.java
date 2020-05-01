package KAKAO.KAKAO2019공채;

import java.util.ArrayList;
import java.util.Collections;

// 20 : 56
public class KAKAO2019공채_실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int N1 = 4;
        int[] stages1 = {4, 4, 4, 4};
        int[] answer = solution(N1, stages1);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    /*
    실패율은 다음과 같이 정의한다.
    스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
    실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

    제한사항
    스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
    stages의 길이는 1 이상 200,000 이하이다.
    stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
    각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
    단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
    만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
    스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
     */
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] clearNum = new int[N];
        int[] notClearNum = new int[N];
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1) {
                for (int j = 0; j < N; j++) {
                    clearNum[j]++;
                }
            } else {
                for (int j = 0; j < stages[i] - 1; j++) {
                    clearNum[j]++;
                }
                notClearNum[stages[i] - 1]++;
            }
        }
        double[] failRates = new double[N];
        for (int i = 0; i < failRates.length; i++) {
            if (notClearNum[i] == 0) {
                failRates[i] = 0;
            } else {
                failRates[i] = (double) notClearNum[i] / (notClearNum[i] + clearNum[i]);
            }
        }
        ArrayList<Stage> stageArrayList = new ArrayList<>();
        for (int i = 0; i < failRates.length; i++) {
            stageArrayList.add(new Stage(i, failRates[i]));
        }

        Collections.sort(stageArrayList);
        for (int i = 0; i < N; i++) {
            answer[i] = stageArrayList.get(i).stage + 1;
        }
        return answer;
    }
}

class Stage implements Comparable<Stage> {
    public int stage;
    public double failRate;

    Stage(int stage, double failRate) {
        this.stage = stage;
        this.failRate = failRate;
    }

    @Override
    public int compareTo(Stage o) {
        if (this.failRate > o.failRate) {
            return -1;
        } else if (this.failRate < o.failRate) {
            return 1;
        } else {
            return 0;
        }
    }
}
// 21 : 33  소요시간 37분 괜찮지만 30분정도 였으면 좋겠다.