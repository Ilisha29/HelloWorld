package KAKAO.KAKAO2020인턴;

import java.util.HashMap;

public class 보석쇼핑 {
    public static void main(String[] args) {
        //String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        //String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        //String[] gems = {"XYZ", "XYZ", "XYZ"};
        int[] answer = new int[2];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            hashMap.put(gems[i], 0);
        }
        int gemNum = hashMap.size();
        hashMap.clear();
        int l = 0;
        int r = 0;

        while (true){

        }
        //System.out.println(answer[0] + " " + answer[1]);
        //return answer;
    }

    private static boolean check(HashMap<String, Integer> hashMap) {
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean allCheck(HashMap<String, Integer> hashMap) {
        int n = hashMap.size();
        int count = 0;
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                count++;
            }
        }
        if (n == count) {
            return true;
        }
        return false;
    }
}
/*
    public static void main(String[] args) {
        //String[] germs = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] germs = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] answer = new int[2];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < germs.length; i++) {
            hashMap.put(germs[i], 0);
        }
        int length = germs.length + 1;
        for (int i = 0; i < germs.length; i++) {
            int tmpLength = 0;
            setDefaultHashMap(hashMap);
            for (int j = i; j < germs.length; j++) {
                hashMap.put(germs[j], 1);
                tmpLength++;
                if (tmpLength > length){
                    break;
                }
                if (allCheck(hashMap)) {
                    if (tmpLength == hashMap.size()){
                        answer[0] = i + 1;
                        answer[1] = j + 1;
                        //return answer;
                    }
                    if (tmpLength < length) {
                        length = tmpLength;
                        answer[0] = i + 1;
                        answer[1] = j + 1;
                    }
                    break;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        //return answer;
    }

    private static void setDefaultHashMap(HashMap<String, Integer> hashMap) {
        for (String key : hashMap.keySet()) {
            hashMap.put(key, 0);
        }
    }

    private static boolean allCheck(HashMap<String, Integer> hashMap) {
        int n = hashMap.size();
        int sum = 0;
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                sum++;
            }
        }
        if (n == sum) {
            return true;
        }
        return false;
    }
    */