package KAKAO.KAKAO2019윈터인턴;

import java.util.ArrayList;
import java.util.HashMap;

// 01 : 35
public class 호텔_방_배정 {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long[] solution = solution(k, room_number);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i] + " ");
        }
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long, Long> hashMap = new HashMap<>();// key는 배정된 방번호 , value는 초기신청 방번호
        for (int i = 0; i < room_number.length; i++) {
            long wishRoomNum = room_number[i];
            if (hashMap.containsKey(room_number[i])) {
                ArrayList<Long> arrayList = new ArrayList<>();
                while (hashMap.containsKey(wishRoomNum)) {
                    arrayList.add(wishRoomNum);
                    wishRoomNum = hashMap.get(wishRoomNum);
                }
                answer[i] = wishRoomNum;
                arrayList.add(wishRoomNum);
                for (long key : arrayList) {
                    hashMap.put(key, wishRoomNum + 1);
                }
            } else {
                hashMap.put(wishRoomNum, wishRoomNum + 1);
                answer[i] = wishRoomNum;
            }
        }
        return answer;
    }
}