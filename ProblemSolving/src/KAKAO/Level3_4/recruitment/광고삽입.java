package KAKAO.Level3_4.recruitment;

import java.util.LinkedList;
import java.util.Queue;

public class 광고삽입 {
    public static void main(String[] args) {
        String[] play_time = {
                "02:03:55",
                "99:59:59",
                "50:00:00"
        };
        String[] adv_time = {
                "00:14:15",
                "25:00:00",
                "50:00:00"
        };
        String[][] logs = {
                {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"},
                {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"},
                {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}
        };
        for (int i = 0; i < play_time.length; i++) {
            System.out.println(solution(play_time[i], adv_time[i], logs[i]));
        }
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        long playtime = timeToInt(play_time);
        long advTime = timeToInt(adv_time);
        long answerTimeStartTime = playtime;
        long answerScore = 0;
        long[] table = new long[(int)playtime];
        for (int i = 0; i < logs.length; i++) {
            String[] splitLog = logs[i].split("-");
            int startTime = timeToInt(splitLog[0]);
            int endTime = timeToInt(splitLog[1]);
            for (int j = startTime; j < endTime; j++) {
                table[j]++;
            }
        }
        long tmpSum = 0;
        Queue<Ad> queue = new LinkedList<>();
        for (int i = 0; i < advTime; i++) {
            tmpSum += table[i];
            queue.add(new Ad(table[i], i));
        }
        if (tmpSum > answerScore) {
            answerScore = tmpSum;
            answerTimeStartTime = 0;
        }
        for (int i = (int)advTime; i < playtime - advTime; i++) {
            Ad ad = queue.poll();
            tmpSum -= ad.value;
            tmpSum += table[i];
            queue.add(new Ad(table[i], i));
            if (tmpSum > answerScore) {
                answerScore = tmpSum;
                answerTimeStartTime = ad.index;
            }
        }
        return intToTime(answerTimeStartTime);
    }

    private static String intToTime(long answerTimeStartTime) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (answerTimeStartTime % 60 < 10) {
            stringBuilder.append("0");
            stringBuilder.append(answerTimeStartTime % 60);
        } else {
            stringBuilder.append(answerTimeStartTime % 60);
        }
        stringBuilder.insert(0, ":");
        answerTimeStartTime /= 60;
        if (answerTimeStartTime % 60 < 10) {
            stringBuilder.insert(0, answerTimeStartTime % 60);
            stringBuilder.insert(0, "0");
        } else {
            stringBuilder.insert(0, answerTimeStartTime % 60);
        }
        stringBuilder.insert(0,":");
        if (answerTimeStartTime / 60 < 10) {
            stringBuilder.insert(0, answerTimeStartTime / 60);
            stringBuilder.insert(0, "0");
        } else {
            stringBuilder.insert(0, answerTimeStartTime / 60);
        }
        return stringBuilder.toString();
    }

    private static int timeToInt(String time) {
        String[] splitTime = time.split(":");
        int HH = Integer.parseInt(splitTime[0]);
        int MM = Integer.parseInt(splitTime[1]);
        int SS = Integer.parseInt(splitTime[2]);
        return HH * 60 * 60 + MM * 60 + SS;
    }
}

class Ad {
    long value;
    int index;

    public Ad(long value, int index) {
        this.value = value;
        this.index = index;
    }
}
