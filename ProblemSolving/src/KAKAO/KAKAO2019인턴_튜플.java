package KAKAO;

import java.util.HashMap;
import java.util.Map;

// 16 : 40
public class KAKAO2019인턴_튜플 {
    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}"; //[2, 1, 3, 4]
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}"; //[2, 1, 3, 4]
        String s3 = "{{20,111},{111}}"; //[111, 20]
        String s4 = "{{123}}"; //[123]
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}"; //[3, 2, 4, 1]
        for (int a : solution(s1)) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static int[] solution(String s) {
        String[] newString = s.substring(1, s.length() - 1).split("");
        boolean commaCount = false;
        int commaNum = 0;
        int tmpSum = 0;
        int num = 0;
        Map<Integer, Integer> hasMap = new HashMap<>();
        for (int i = 0; i < newString.length; i++) {
            if (newString[i].equals("{")) {
                commaCount = true;
            } else if (newString[i].equals(",")) {
                if (commaCount) {
                    commaNum++;
                    tmpSum += num;
                    num = 0;
                }
            } else if (newString[i].equals("}")) {
                tmpSum += num;
                commaCount = false;
                hasMap.put(commaNum + 1, tmpSum);
                tmpSum = 0;
                num = 0;
                commaNum = 0;
            } else {
                num *= 10;
                num += Integer.parseInt(newString[i]);
            }
        }
        int[] answer = new int[hasMap.size()];
        answer[0] = hasMap.get(1);
        if (hasMap.size() == 1) {
            return answer;
        } else {
            for (int i = 2; i <= hasMap.size(); i++) {
                answer[i - 1] = hasMap.get(i) - hasMap.get(i - 1);
            }
            return answer;
        }
        /* 잘못짠 코드
        for (int i = 0; i < splitStep1.length; i++) {
            if (splitStep1[i].equals(",")) {
                if (splitStep1[i - 1].equals("}") && splitStep1[i + 1].equals("{")) {
                    splitStep1[i] = "/";
                }
            }
        }
        String newString = "";
        for (int i = 0; i < splitStep1.length; i++) {
            newString += splitStep1[i];
        }

        String[] splitStep2 = newString.split("/");
        int[] tmpAnswer = new int[splitStep2.length];
        for (int i = 0; i < splitStep2.length; i++) {
            String[] integers = splitStep2[i].substring(1, splitStep2[i].length() - 1).split(",");
            int size = integers.length;
            int[] tmpInts = new int[size];
            for (int j = 0; j < tmpInts.length; j++) {

            }
            int sum = 0;
            for (int j = 0; j < integers.length; j++) {
                sum += Integer.parseInt(integers[j]);
            }
            tmpAnswer[size - 1] = sum;
        }
        if (tmpAnswer.length == 1) {
            return tmpAnswer;
        } else {
            int[] answer = new int[tmpAnswer.length];
            answer[0] = tmpAnswer[0];
            for (int i = 1; i < tmpAnswer.length; i++) {
                answer[i] = tmpAnswer[i] - tmpAnswer[i - 1];
            }
            return answer;
        }
        */
    }
}
// 17 : 22 end But시간초과;;;
// string 한번 읽으면 계산 다 되도록 log(1)정도로 변경 hint는 구간합이였고, 갯수자체가 1~n까지 있는 오름차순 그대로여서 바로 접근가능 (hashMap)탐색에 최적.