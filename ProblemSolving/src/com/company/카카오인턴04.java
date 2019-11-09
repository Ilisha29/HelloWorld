package com.company;

import java.util.ArrayList;

public class 카카오인턴04 {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long[] answer = new long[room_number.length];
        //방 초기화
        boolean[] roomPossible = new boolean[(int) k + 1];
        for (int i = 1; i < roomPossible.length; i++) {
            roomPossible[i] = true;
        }
        //배정하기
        for (int i = 0; i < room_number.length; i++) {
            //방이 비어있을 경우
            if (roomPossible[(int) room_number[i]]) {
                answer[i] = room_number[i];
                roomPossible[(int) room_number[i]] = false;
            }
            //방이 예약되어있을 경우
            else {
                for (int j = (int) room_number[i]; j < roomPossible.length; j++) {
                    if (roomPossible[j]) {
                        answer[i] = j;
                        roomPossible[j] = false;
                        break;
                    }
                }
            }
        }

    }
        /* 2진탐색 실패
        long[] answer = new long[room_number.length];
        ArrayList<Long> roomCheckIn = new ArrayList<>();
        for (long i = 1; i <= k; i++) {
            roomCheckIn.add(i);
        }

        for (int i = 0; i < room_number.length; i++) {
            long target = room_number[i];
            while(BSearch(roomCheckIn,target) == -1 ){
                target++;
            }
            answer[i] = target;
            roomCheckIn.remove(BSearch(roomCheckIn,target));
        }

    }

    public static int BSearch(ArrayList<Long> roomCheckIn, long target) {
        int low = 0;
        int high = roomCheckIn.size() - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (roomCheckIn.get(mid) == target)
                return mid;
            else if (roomCheckIn.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    */
}
