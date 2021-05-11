package KAKAO.Level3_4.Intern;

import java.util.HashMap;
import java.util.Map;

public class 호텔방배정 {
    public static void main(String[] args) {
        long k = 10;
        long[] room = {1, 3, 4, 1, 3, 1};
        long[] result = solution(k, room);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> roomMap = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            long wishRoom = room_number[i];
            if (!roomMap.containsKey(room_number[i])) {
                answer[i] = wishRoom;
                roomMap.put(wishRoom, wishRoom + 1);
            } else {
                long findRoom = find(roomMap, wishRoom);
                answer[i] = findRoom;
                roomMap.put(wishRoom, setting(roomMap, findRoom));
            }
        }
        return answer;
    }

    private static long setting(Map<Long, Long> roomMap, long wishRoom) {
        if (roomMap.containsKey(wishRoom)) {
            roomMap.put(wishRoom, find(roomMap, roomMap.get(wishRoom)));
        }
        return roomMap.getOrDefault(roomMap.get(wishRoom), wishRoom + 1);
    }

    private static long find(Map<Long, Long> roomMap, long wish) {
        if (roomMap.containsKey(wish)) {
            roomMap.put(wish, find(roomMap, roomMap.get(wish)));
        }
        return roomMap.getOrDefault(roomMap.get(wish), wish);
    }

}
