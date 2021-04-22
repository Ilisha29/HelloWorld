package Programmers.이분탐색;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        long tmp = 1000000000;
        long answer = tmp * tmp;
        long start = 1;
        long end = tmp * tmp;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            if (count < n) {
                start = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
        }
        return answer;
    }
}
