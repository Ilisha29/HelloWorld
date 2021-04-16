package KAKAO.KAKAO공채연습._2020;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class 가사검색 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "???"};
        int[] result = solution(words, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> reverseArrayList = new ArrayList<>();
        ArrayList<Integer> lengthArrayList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            arrayList.add(words[i]);
            reverseArrayList.add(new StringBuffer(words[i]).reverse().toString());
            lengthArrayList.add(words[i].length());
        }
        Collections.sort(arrayList);
        Collections.sort(reverseArrayList);
        Collections.sort(lengthArrayList);
        for (int i = 0; i < queries.length; i++) {
            String tmp = queries[i];
            int tmpAnswer = 0;
            if (tmp.charAt(0) == '?') {
                if (tmp.charAt(tmp.length() - 1) == '?') {
                    int target = tmp.length();
                    int min = 0;
                    int max = 0;
                    int start = 0;
                    int end = words.length - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        if (lengthArrayList.get(mid) == target) {
                            if (mid == 0 || lengthArrayList.get(mid - 1) != target) {
                                min = mid;
                                break;
                            } else {
                                end = mid - 1;
                            }
                        } else if (lengthArrayList.get(mid) > target) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                    start = 0;
                    end = words.length - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        if (lengthArrayList.get(mid) == target) {
                            if (mid == words.length - 1 || lengthArrayList.get(mid + 1) != target) {
                                max = mid;
                                break;
                            } else {
                                start = mid + 1;
                            }
                        } else if (lengthArrayList.get(mid) > target) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                    tmpAnswer = max - min + 1;
                } else {
                    tmp = new StringBuffer(queries[i]).reverse().toString();
                    for (int j = 0; j < tmp.length(); j++) {
                        if (tmp.charAt(j) != '?') {
                            tmp = tmp.substring(0, j);
                            break;
                        }
                    }
                    int start = 0;
                    int end = words.length - 1;
                    int left = 0;
                    int right = 0;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        String editString = reverseArrayList.get(mid);
                        if (editString.length() > tmp.length()) {
                            editString = editString.substring(0, tmp.length());
                        }
                        if (tmp.compareTo(editString) == 0) {
                            if (mid == 0 || !reverseArrayList.get(mid - 1).contains(tmp)) {
                                left = mid;
                                break;
                            } else {
                                start = mid + 1;
                            }
                        /*else if (mid == arrayList.size() - 1 || !arrayList.get(mid + 1).contains(tmp)) {

                        } */
                        } else if (tmp.compareTo(editString) > 0) {
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    }
                    start = 0;
                    end = words.length - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        String editString = reverseArrayList.get(mid);
                        if (editString.length() > tmp.length()) {
                            editString = editString.substring(0, tmp.length());
                        }
                        if (tmp.compareTo(editString) == 0) {
                            if (mid == arrayList.size() - 1 || !reverseArrayList.get(mid + 1).contains(tmp)) {
                                right = mid;
                                break;
                            } else {
                                end = mid - 1;
                            }
                        } else if (tmp.compareTo(editString) > 0) {
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    }
                    for (int j = left; j <= right; j++) {
                        String string = reverseArrayList.get(left);
                        string = string.substring(0, tmp.length());
                        if (tmp.equals(string) && queries[i].length() == reverseArrayList.get(j).length()) {
                            tmpAnswer++;
                        }
                    }
                }
            } else {
                for (int j = 0; j < tmp.length(); j++) {
                    if (tmp.charAt(j) != '?') {
                        tmp = tmp.substring(0, j);
                        break;
                    }
                }
                int start = 0;
                int end = words.length - 1;
                int left = 0;
                int right = 0;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    String editString = arrayList.get(mid);
                    if (editString.length() > tmp.length()) {
                        editString = editString.substring(0, tmp.length());
                    }
                    if (tmp.compareTo(editString) == 0) {
                        if (mid == 0 || !arrayList.get(mid - 1).contains(tmp)) {
                            left = mid;
                            break;
                        } else {
                            start = mid + 1;
                        }
                        /*else if (mid == arrayList.size() - 1 || !arrayList.get(mid + 1).contains(tmp)) {

                        } */
                    } else if (tmp.compareTo(editString) > 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                start = 0;
                end = words.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    String editString = arrayList.get(mid);
                    if (editString.length() > tmp.length()) {
                        editString = editString.substring(0, tmp.length());
                    }
                    if (tmp.compareTo(editString) == 0) {
                        if (mid == arrayList.size() - 1 || !arrayList.get(mid + 1).contains(tmp)) {
                            right = mid;
                            break;
                        } else {
                            end = mid - 1;
                        }
                    } else if (tmp.compareTo(editString) > 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                for (int j = left; j <= right; j++) {
                    String string = arrayList.get(left);
                    string = string.substring(0, tmp.length());
                    if (tmp.equals(string) && queries[i].length() == arrayList.get(j).length()) {
                        tmpAnswer++;
                    }
                }
            }
            answer[i] = tmpAnswer;
        }
        return answer;
    }
}