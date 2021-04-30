package KAKAO.KAKAO2019윈터인턴.prac1;

public class K5 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        long answer = 0;
        long start = 1;
        long end = 200000000;
        while (start <= end) {
            long mid = (start + end) / 2;
            int tmpMax = 0;
            int tmpK = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid <= 0) {
                    tmpK++;
                } else {
                    tmpMax = Math.max(tmpK, tmpMax);
                    tmpK = 0;
                }
            }
            tmpMax = Math.max(tmpK, tmpMax);
            if (tmpMax < k) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) answer + 1;
    }
}