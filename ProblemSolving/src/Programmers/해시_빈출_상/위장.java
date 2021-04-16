package Programmers.해시_빈출_상;

import java.util.HashMap;

// 19 : 00
public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            if (hashMap.containsKey(type)) {
                hashMap.put(type, hashMap.get(type) + 1);
            } else {
                hashMap.put(type, 1);
            }
        }
        //경우의 수를 구하는 공식은 4종류의 옷과 그 옷이 {n, m, o, p}의 개수로 있을 때 아래와 같다.
        //(n + 1) * (m + 1) * (o + 1) * (p + 1) - 1
        for (String key : hashMap.keySet()) {
            answer *= (hashMap.get(key) + 1);
        }
        /*for (int i = 0; i < Math.pow(2, hashMap.size()); i++) {
            int num = i;
            int[] array = new int[hashMap.size()];
            int index = 0;
            while (num >= 2) {
                array[index++] = num % 2;
                num /= 2;
            }
            array[index] = num;

            int oneNum = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1) {
                    oneNum++;
                }
            }

            index = 0;
            int tmpAnswer = 0;
            for (String key : hashMap.keySet()) {
                if (oneNum != 0) {
                    if (array[index++] == 1) {
                        if (tmpAnswer == 0) {
                            tmpAnswer += hashMap.get(key);
                        } else {
                            tmpAnswer *= hashMap.get(key);
                        }
                        oneNum--;
                    }
                }
            }
            answer += tmpAnswer;
        }*/
        return --answer;
    }
}