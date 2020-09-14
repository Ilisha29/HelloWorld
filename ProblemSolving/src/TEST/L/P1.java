package TEST.L;

import java.util.HashMap;

public class P1 {
    public static void main(String[] args) {
        int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        System.out.println(solution(boxes));
    }

    public static int solution(int[][] boxes) {int answer = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < 2; j++) {
                hashMap.put(boxes[i][j], hashMap.getOrDefault(boxes[i][j], 0) + 1);
            }
        }
        int leftCount = 0;
        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) % 2 == 1) {
                leftCount++;
            }
        }
        answer = leftCount / 2;
        return answer;
    }
}

