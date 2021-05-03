package KAKAO.KAKAO2019윈터인턴;

public class 징검다리_건너기2 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

    public static int solution(int[] stones, int k) {
        int start = 1;
        int end = 200000000;
        while (start <= end) {
            int mid = (start + end) / 2;
            int maxZeroLength = 0;
            boolean isReadingZero = false;
            int tmpMaxZeroLength = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] <= mid) {
                    isReadingZero = true;
                    tmpMaxZeroLength++;
                    if (i == stones.length - 1){
                        maxZeroLength = Math.max(maxZeroLength, tmpMaxZeroLength);
                    }
                } else {
                    if (isReadingZero) {
                        maxZeroLength = Math.max(maxZeroLength, tmpMaxZeroLength);
                        tmpMaxZeroLength = 0;
                        isReadingZero = false;
                    }
                }
            }
            if (maxZeroLength < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
