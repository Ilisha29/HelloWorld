package KAKAO.KAKAO2019윈터인턴;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 호텔_방_배정2 {
    public static void main(String[] args) {
        long k = 10;
        long[] room_num = {1, 3, 4, 1, 3, 1};
        long[] answer = solution(k, room_num);
        Arrays.stream(answer).forEach(System.out::println);
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> reservationMap = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            long wishRoom = room_number[i];
            if (reservationMap.containsKey(wishRoom)) {
                long room = find(reservationMap, wishRoom);
                answer[i] = room;
                reservationMap.put(room, setting(reservationMap, room));
            } else {
                answer[i] = wishRoom;
                reservationMap.put(wishRoom, wishRoom + 1);
            }
        }
        return answer;
    }

    private static Long find(Map<Long, Long> reservationMap, long l) {
        if (reservationMap.containsKey(l))
            reservationMap.put(l, find(reservationMap, reservationMap.get(l)));
        return reservationMap.containsKey(l) ? reservationMap.get(l) : l;
    }

    private static Long setting(Map<Long, Long> reservationMap, long l) {
        if (reservationMap.containsKey(l))
            reservationMap.put(l, find(reservationMap, reservationMap.get(l)));
        return reservationMap.containsKey(l) ? reservationMap.get(l) : l + 1;
    }
}
