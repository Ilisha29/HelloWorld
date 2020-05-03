package KAKAO.KAKAO2018공채;

import java.util.ArrayList;
import java.util.HashMap;

// 10 : 04
public class KAKAO2018공채_뉴스_클러스터링2 {
    public static void main(String[] args) {
        String[][] strs = {{"FRANCE", "french"},    //16384
                {"handshake", "shake hands"},    //65536
                {"aa1+aa2", "AAAA12"},    //43690
                {"E=M*C^2", "e=m*c^2"}};    //65536
        for (int i = 0; i < strs.length; i++) {
            System.out.println(solution(strs[i][0], strs[i][1]));
        }
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            arrayList1.add(str1.substring(i, i + 2));
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            arrayList2.add(str2.substring(i, i + 2));
        }
        ArrayList<String> arrayList11 = new ArrayList<>();
        ArrayList<String> arrayList22 = new ArrayList<>();
        for (int i = 0; i < arrayList1.size(); i++) {
            String[] strings = arrayList1.get(i).split("");
            if (65 <= strings[0].charAt(0) && strings[0].charAt(0) <= 90 && 65 <= strings[1].charAt(0) && strings[1].charAt(0) <= 90) {
                arrayList11.add(arrayList1.get(i));
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            String[] strings = arrayList2.get(i).split("");
            if (65 <= strings[0].charAt(0) && strings[0].charAt(0) <= 90 && 65 <= strings[1].charAt(0) && strings[1].charAt(0) <= 90) {
                arrayList22.add(arrayList2.get(i));
            }
        }
        arrayList1.clear();
        arrayList2.clear();
        if (arrayList11.size() == 0 && arrayList22.size() == 0) {
            return 65536;
        } else {
            HashMap<String, Integer> hashMapStr1 = new HashMap<>();
            HashMap<String, Integer> hashMapStr2 = new HashMap<>();
            for (int i = 0; i < arrayList11.size(); i++) {
                if (hashMapStr1.containsKey(arrayList11.get(i))) {
                    hashMapStr1.put(arrayList11.get(i), hashMapStr1.get(arrayList11.get(i)) + 1);
                } else {
                    hashMapStr1.put(arrayList11.get(i), 1);
                }
            }
            for (int i = 0; i < arrayList22.size(); i++) {
                if (hashMapStr2.containsKey(arrayList22.get(i))) {
                    hashMapStr2.put(arrayList22.get(i), hashMapStr2.get(arrayList22.get(i)) + 1);
                } else {
                    hashMapStr2.put(arrayList22.get(i), 1);
                }
            }
            arrayList11.clear();
            arrayList22.clear();
            HashMap<String, Integer> samePart = new HashMap<>();
            for (String key : hashMapStr1.keySet()) {
                if (hashMapStr2.containsKey(key)) {
                    int min = hashMapStr1.get(key) < hashMapStr2.get(key) ? hashMapStr1.get(key) : hashMapStr2.get(key);
                    hashMapStr1.put(key, hashMapStr1.get(key) - min);
                    hashMapStr2.put(key, hashMapStr2.get(key) - min);
                    samePart.put(key, min);
                }
            }
            double leftNum = 0;
            double rightNum = 0;
            double centerNum = 0;
            for (String key : hashMapStr1.keySet()) {
                leftNum += hashMapStr1.get(key);
            }
            for (String key : hashMapStr2.keySet()) {
                rightNum += hashMapStr2.get(key);
            }
            for (String key : samePart.keySet()) {
                centerNum += samePart.get(key);
            }
            double tmpAswer = centerNum / (leftNum + rightNum + centerNum);
            return (int) (tmpAswer * 65536);
        }
    }
}
// 10 : 33 end