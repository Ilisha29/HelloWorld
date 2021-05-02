package KAKAO.KAKAO2019공채.try1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class K19_1 {
    public static void main(String[] args) {
        String[] strings = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = solution(strings);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static String[] solution(String[] record) {
        Map<String, String> hashMap = new HashMap<>();
        ArrayList<String> uid = new ArrayList<>();
        ArrayList<String> inOut = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] splitRecord = record[i].split(" ");
            if (splitRecord[0].equals("Enter")) {
                uid.add(splitRecord[1]);
                inOut.add("님이 들어왔습니다.");
                hashMap.put(splitRecord[1], splitRecord[2]);
            } else if (splitRecord[0].equals("Leave")) {
                uid.add(splitRecord[1]);
                inOut.add("님이 나갔습니다.");
            } else {
                hashMap.put(splitRecord[1], splitRecord[2]);
            }
        }
        String[] answer = new String[uid.size()];
        for (int i = 0; i < uid.size(); i++) {
            answer[i] = hashMap.get(uid.get(i)) + inOut.get(i);
        }
        return answer;
    }
}
