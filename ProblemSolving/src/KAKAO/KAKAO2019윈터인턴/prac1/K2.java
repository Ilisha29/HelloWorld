package KAKAO.KAKAO2019윈터인턴.prac1;

import java.util.*;

public class K2 {
    public static void main(String[] args) {
        String[] s =
                {
                        "{{2},{2,1},{2,1,3},{2,1,3,4}}",
                        "{{1,2,3},{2,1},{1,2,4,3},{2}}",
                        "{{20,111},{111}}",
                        "{{123}}",
                        "{{4,2,3},{3},{2,3,4,1},{2,3}}"
                };
        for (int i = 0; i < s.length; i++) {
            int[] answer = solution(s[i]);
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[j] + " ");
            }
        }
    }

    public static int[] solution(String s) {
        String[] splitS = s.substring(2, s.length() - 2).split("},\\{");
        List<Tuple> tupleList = new ArrayList<Tuple>();
        for (int i = 0; i < splitS.length; i++) {
            String[] split = splitS[i].split(",");
            int size = split.length;
            int sum = Arrays.stream(split).mapToInt(Integer::parseInt).sum();
            tupleList.add(new Tuple(sum, size));
        }
        Collections.sort(tupleList, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.size - o2.size;
            }
        });
        int[] answer = new int[tupleList.size()];
        answer[0] = tupleList.get(0).sum;
        for (int i = 1; i < tupleList.size(); i++) {
            answer[i] = tupleList.get(i).sum - tupleList.get(i - 1).sum;
        }
        return answer;
    }
}

class Tuple {
    int sum;
    int size;

    public Tuple(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}
