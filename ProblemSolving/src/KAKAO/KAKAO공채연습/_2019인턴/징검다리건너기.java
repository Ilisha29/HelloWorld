package KAKAO.KAKAO공채연습._2019인턴;

public class 징검다리건너기 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;
        int start = 0;
        int end = 200000000;
        while (start <= end) {
            int mid = (start + end) / 2;
            int tmpLength = 0;
            boolean isAnswer = true;
            for (int i = 0; i < stones.length; i++) {
                int num = stones[i] - mid;
                if (num < 0) {
                    tmpLength++;
                } else {
                    tmpLength = 0;
                }
                if (tmpLength >= k) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer) {
                answer = mid > answer ? mid : answer;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
}