package TEST.L;

public class P3 {
    public static void main(String[] args) {
        int[] ns = {100000, 73425, 10007, 9, 999999999};
        for (int i = 0; i < ns.length; i++) {
            int[] result = solution(ns[i]);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static int[] solution(int n) {
        int[] answer = new int[2];
        int count = 0;
        while (n / 10 != 0) {
            String numString = Integer.toString(n);
            int splitIndex = 1;
            int min = Integer.MAX_VALUE;
            while (splitIndex < numString.length()) {
                String first = numString.substring(0, splitIndex);
                String second = numString.substring(splitIndex);
                if (second.length() == 1 || second.charAt(0) != '0') {
                    int sum = Integer.parseInt(first) + Integer.parseInt(second);
                    min = sum < min ? sum : min;
                }
                splitIndex++;
            }
            n = min;
            count++;
        }
        answer[0] = count;
        answer[1] = n;
        return answer;
    }
}
