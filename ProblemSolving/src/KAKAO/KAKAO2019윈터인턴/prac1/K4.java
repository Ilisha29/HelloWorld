package KAKAO.KAKAO2019윈터인턴.prac1;

import java.util.HashMap;

public class K4 {
    public static void main(String[] args) {
        long k = 10;
        long[] room = {1, 3, 4, 1, 3, 1};
        long[] tmpAnswer = solution(k, room);
        for (int i = 0; i < tmpAnswer.length; i++) {
            System.out.print(tmpAnswer[i] + " ");
        }
    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashMap<Long, Long> room = new HashMap<>();
        for (int i = 0; i < room_number.length; i++) {
            long wishRoom = room_number[i];
            if (room.containsKey(wishRoom)) {
                long serveRoom = find(room, wishRoom);
                answer[i] = serveRoom;
                room.put(serveRoom, setting(room, serveRoom));
            } else {
                answer[i] = wishRoom;
                room.put(wishRoom, wishRoom + 1);
                find(room, wishRoom);
            }
        }
        return answer;
    }

    private static Long find(HashMap<Long, Long> room, long l) {
        if (room.containsKey(l)) {
            room.put(l, find(room, room.get(l)));
        }
        return room.containsKey(l) ? room.get(l) : l;
    }

    private static Long setting(HashMap<Long, Long> room, long l) {
        if (room.containsKey(l)) {
            room.put(l, find(room, room.get(l)));
        }
        return room.containsKey(l) ? room.get(l) : l + 1;
    }
}
