package 코테대비책.이분탐색;

import java.util.ArrayList;
import java.util.Collections;

public class 가사검색 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] answers = solution(words, queries);
        for (int i = 0; i < answers.length; i++) {
            System.out.print(answers[i]);
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int maxSize = 0;
        for (int i = 0; i < words.length; i++) {
            int size = words[i].length();
            maxSize = size > maxSize ? size : maxSize;
        }
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < maxSize + 1; i++) {
            ArrayList<String> AL = new ArrayList<>();
            arrayLists.add(AL);
        }
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            arrayLists.get(length).add(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (query.charAt(0) == '?' && query.charAt(query.length() - 1) == '?') {
                int queryLength = query.length();
                answer[i] = arrayLists.get(queryLength).size();
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                int queryLength = query.length();
                int index = 0;
                if (query.charAt(0) != '?') {
                    for (int j = 0; j < query.length(); j++) {
                        if (query.charAt(j) == '?') {
                            index = j;
                            break;
                        }
                    }
                    query = query.substring(0, index);
                    for (int j = 0; j < arrayLists.get(queryLength).size(); j++) {
                        arrayList.add(arrayLists.get(queryLength).get(j).substring(0, index));
                    }
                } else {
                    for (int j = 0; j < query.length(); j++) {
                        if (query.charAt(j) != '?') {
                            index = j;
                            break;
                        }
                    }
                    query = query.substring(index);
                    for (int j = 0; j < arrayLists.get(queryLength).size(); j++) {
                        arrayList.add(arrayLists.get(queryLength).get(j).substring(index));
                    }
                }
                Collections.sort(arrayList);
                int a = binarySearchL(arrayList, query, 0, arrayList.size() - 1);
                if (a == -1) {
                    answer[i] = 0;
                } else {
                    int b = binarySearchR(arrayList, query, 0, arrayList.size() - 1);
                    answer[i] = b - a + 1;
                }
            }
        }
        return answer;
    }

    private static int binarySearchR(ArrayList<String> arrayList, String query, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arrayList.get(mid).equals(query)) {
                if (mid == arrayList.size() - 1 || !arrayList.get(mid + 1).equals(query)) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (arrayList.get(mid).compareTo(query) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchL(ArrayList<String> arrayList, String query, int i, int size) {
        while (i <= size) {
            int mid = (i + size) / 2;
            if (arrayList.get(mid).equals(query)) {
                if (mid == 0 || !arrayList.get(mid - 1).equals(query)) {
                    return mid;
                } else {
                    size = mid - 1;
                }
            } else if (arrayList.get(mid).compareTo(query) < 0) {
                i = mid + 1;
            } else {
                size = mid - 1;
            }
        }
        return -1;
    }
}