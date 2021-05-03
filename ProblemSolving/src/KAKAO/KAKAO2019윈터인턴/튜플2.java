package KAKAO.KAKAO2019윈터인턴;

import java.util.Arrays;
import java.util.Comparator;

public class 튜플2 {
    public static void main(String[] args) {
        String[] strings = {"{{2},{2,1},{2,1,3},{2,1,3,4}}", "{{1,2,3},{2,1},{1,2,4,3},{2}}", "{{20,111},{111}}", "{{123}}", "{{4,2,3},{3},{2,3,4,1},{2,3}}"};
        for (int i = 1; i < 2; i++) {
            int[] result = solution(strings[i]);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] splitString = s.split("},\\{");
        Arrays.sort(splitString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int[] eachTupleSum = new int[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            int[] intTuple = Arrays.stream(splitString[i].split(",")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int j = 0; j < intTuple.length; j++) {
                sum += intTuple[j];
            }
            eachTupleSum[i] = sum;
        }
        int num = 0;
        int[] answer = new int[eachTupleSum.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = eachTupleSum[i] - num;
            num = eachTupleSum[i];
        }
        return answer;
    }
}
