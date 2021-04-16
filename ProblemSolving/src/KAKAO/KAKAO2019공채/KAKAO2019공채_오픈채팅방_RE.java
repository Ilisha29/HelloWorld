package KAKAO.KAKAO2019공채;

import java.util.ArrayList;
import java.util.HashMap;

// 18 : 23 start
public class KAKAO2019공채_오픈채팅방_RE {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] answer = solution(record);
        for (String str : answer) {
            System.out.print(str + " ");
        }
    }

    public static String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] strings = record[i].split(" ");
            String id = strings[1];
            if (strings[0].equals("Enter")) {
                String nickName = strings[2];
                hashMap.put(id, nickName);
                arrayList.add(id + " 님이 들어왔습니다.");
            } else if (strings[0].equals("Leave")) {
                arrayList.add(id + " 님이 나갔습니다.");
            } else {
                String nickName = strings[2];
                hashMap.put(id, nickName);
            }
        }

        String[] answer = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            String[] key = arrayList.get(i).split(" ");
            answer[i] = hashMap.get(key[0]) + key[1] + " " + key[2];
        }
        return answer;
    }
}
// 18 : 42 end // 19분 걸림