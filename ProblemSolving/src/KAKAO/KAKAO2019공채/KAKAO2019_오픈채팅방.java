package KAKAO.KAKAO2019공채;

import java.util.ArrayList;
import java.util.HashMap;

// 22 : 15
public class KAKAO2019_오픈채팅방 {
    //record ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
    //result ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        for (String string : solution(record)) {
            System.out.println(string);
        }
    }

    private static String[] solution(String[] record) {
        ArrayList<String> userArrayList = new ArrayList<>();
        ArrayList<Boolean> inNoutArrayList = new ArrayList<>();
        HashMap<String, String> userHashMap = new HashMap<>();
        for (String oneRecord : record) {
            String[] strings = oneRecord.split(" ");
            if (strings[0].equals("Enter")) {
                userArrayList.add(strings[1]);
                inNoutArrayList.add(true);
                boolean isExist = false;
                int index = 0;
                userHashMap.put(strings[1], strings[2]);
            } else if (strings[0].equals("Leave")) {
                userArrayList.add(strings[1]);
                inNoutArrayList.add(false);
            } else { //change
                userHashMap.put(strings[1], strings[2]);
            }
        }
        String[] answer = new String[userArrayList.size()];
        for (int i = 0; i < userArrayList.size(); i++) {
            String inNout;
            if (inNoutArrayList.get(i)) {
                inNout = "들어왔";
            } else {
                inNout = "나갔";
            }
            answer[i] = userHashMap.get(userArrayList.get(i)) + "님이 " + inNout + "습니다.";
        }
        return answer;
    }
}
// 23 : 00 구현 완료 But 역시 HashMap으로 접근했어야..... 시간초과 났다. 역시 해시맵 썼어야했다.
// 해시맵 사용한게 더 코드도 줄고 깔끔하다.