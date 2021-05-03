package KAKAO.KAKAO2019윈터인턴;

public class 징검다리_건너기 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3; // 답 : 3
        System.out.println(solution(stones, k));
    }

    /*
    [제한사항]
    stones 배열의 크기는 1 이상 200,000 이하입니다.
    stones 배열 각 원소들의 값은 1 이상 200,000,000 이하인 자연수입니다.
    */
    private static int solution(int[] stones, int k) {
        /*int answer = 0;
        int[] newStones = new int[stones.length + 2];
        for (int i = 0; i < stones.length; i++) {
            newStones[i + 1] = stones[i];
        }
        newStones[newStones.length - 1] = 2000000000;
        while (true) {
            int index = 0;
            while (index != newStones.length - 1) {
                if (newStones[index + 1] != 0) {
                    newStones[++index] -= 1;
                } else {
                    for (int i = 1; i <= k - 1; i++) {
                        int newIndex = index + 1 + i;
                        if (newIndex <= newStones.length - 1 && newStones[newIndex] > 0) {
                            index = newIndex;
                            newStones[index]--;
                            break;
                        } else {
                            if (i == k - 1) {
                                return answer;
                            }
                        }
                    }
                }
            }
            answer++;
        }*/
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= stones.length - k; i++) {
            int temp = i;
            int stone = stones[i];
            for (int j = i; j < i + k; j++) {
                if (stones[j] > stone) {
                    stone = stones[j];
                    temp = j;
                }
            }
            if (answer > stone) {
                answer = stone;
            }
            i = temp;

        }
        return answer;
    }
}
