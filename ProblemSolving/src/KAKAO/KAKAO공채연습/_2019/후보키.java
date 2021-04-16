package KAKAO.KAKAO공채연습._2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 후보키 {
    public static void main(String[] args) {
        String[][] relations = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        System.out.println(solution(relations));
    }

    public static int solution(String[][] relation) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < relation.length; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(i);
            queue.offer(arrayList);
        }
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        while (queue.isEmpty()) {
            ArrayList<Integer> arrayList = queue.poll();
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < relation.length; i++) {
                String tmp = "";
                for (int j = 0; j < arrayList.size(); j++) {
                    tmp += relation[i][arrayList.get(j)] + " ";
                }

            }
        }
        int[] array = {1, 2, 3};
        return 0;
    }
}

/*
private static void DFS(String[][] relation, boolean[] check, int depth, int beforeIndex) {
        boolean isCandidate = false;
        HashMap<String, Integer> hashMap = new HashMap<>();
        String candidateSet = "";
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                candidateSet += i;
            }
        }
        for (int i = 0; i < relation.length; i++) {
            String tmpAnswer = "";
            for (int j = 0; j < relation[0].length; j++) {
                if (check[j]) {
                    tmpAnswer += relation[i][j];
                    tmpAnswer += " ";
                }
            }
            hashMap.put(tmpAnswer, hashMap.getOrDefault(tmpAnswer, 0) + 1);
        }
        if (hashMap.size() == relation.length) {
            isCandidate = true;
        }
        if (isCandidate) {
            answer++;
            return;
        }
        if (depth == relation.length - 1) {
            return;
        }
        for (int i = beforeIndex + 1; i < check.length; i++) {
            if (!check[i]) {
                boolean[] newCheck = check.clone();
                newCheck[i] = true;
                DFS(relation, newCheck, depth + 1, i);
            }
        }
    }
 */