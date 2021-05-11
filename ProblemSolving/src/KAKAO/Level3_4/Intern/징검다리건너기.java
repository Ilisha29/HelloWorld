package KAKAO.Level3_4.Intern;

public class 징검다리건너기 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < stones.length; i++) {
            end = Math.max(end, stones[i]);
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            int zeroNum = 0;
            int longestZero = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid <= 0) {
                    zeroNum++;
                } else {
                    longestZero = Math.max(longestZero, zeroNum);
                    zeroNum = 0;
                }
            }
            longestZero = Math.max(longestZero, zeroNum);
            if (longestZero <= k - 1) {

                answer = Math.max(mid, answer);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer + 1;
    }
}
