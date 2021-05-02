package KAKAO.KAKAO2019공채.try1;

import java.util.*;

public class K19_3 {
    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(solution(relation));
    }

    public static int solution(String[][] relation) {
        int answer = 0;
        int tupleSize = relation[0].length;
        List<String> tmp = new ArrayList<>();
        for (int i = 1; i < Math.pow(2, tupleSize); i++) {
            StringBuilder stringBuilder = new StringBuilder("");
            String s = Integer.toBinaryString(i);
            for (int j = 0; j < tupleSize - s.length(); j++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(s);
            String binaryString = stringBuilder.toString();
            String tupleSet = "";
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    tupleSet += Integer.toString(j);
                }
            }
            tmp.add(tupleSet);
        }
        Collections.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < tmp.size(); i++) {
            queue.add(tmp.get(i));
        }
        while (!queue.isEmpty()) {
            String tupleSet = queue.poll();
            if (isAnswer(tupleSet, relation)) {
                answer++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String tmpTupleSet = queue.poll();
                    if (!isContain(tmpTupleSet, tupleSet)) {
                        queue.add(tmpTupleSet);
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isAnswer(String tupleSet, String[][] relation) {
        Set<String> strings = new HashSet<>();
        int relationSize = relation.length;
        for (int i = 0; i < relation.length; i++) {
            int[] tuple = Arrays.stream(tupleSet.split("")).mapToInt(Integer::parseInt).toArray();
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = 0; j < tuple.length; j++) {
                stringBuilder.append(relation[i][tuple[j]]);
            }
            strings.add(stringBuilder.toString());
        }
        if (relationSize == strings.size()) {
            return true;
        }
        return false;
    }

    private static boolean isContain(String tmpTupleSet, String tupleSet) {
        String[] tmp = tmpTupleSet.split("");
        String[] tuple = tupleSet.split("");
        boolean[] check = new boolean[tuple.length];
        for (int i = 0; i < tuple.length; i++) {
            boolean isContain = false;
            for (int j = 0; j < tmp.length; j++) {
                if (tuple[i].equals(tmp[j])) {
                    isContain = true;
                    break;
                }
            }
            check[i] = isContain;
        }
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                return false;
            }
        }
        return true;
    }
}
