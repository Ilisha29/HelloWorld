package 코테대비책.구현;

public class 시각 {
    public static void main(String[] args) {
        int N = 5;
        int answer = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String string = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
                    if (string.contains("3")) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
