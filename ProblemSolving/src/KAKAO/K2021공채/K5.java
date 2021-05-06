package KAKAO.K2021공채;

import java.util.Arrays;
import java.util.Comparator;

public class K5 {
    public static void main(String[] args) {
        String[] play_times = {
                "02:03:55",
                "99:59:59",
                "50:00:00"
        };
        String[] adv_times = {
                "00:14:15",
                "25:00:00",
                "50:00:00"
        };
        String[][] logs = {
                {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"},
                {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"},
                {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}
        };
        for (int i = 0; i < play_times.length; i++) {
            System.out.println(solution(play_times[i], adv_times[i], logs[i]));
        }
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        Play[] plays = new Play[logs.length];
        for (int i = 0; i < logs.length; i++) {
            String[] splitLog = logs[i].split("-");
            plays[i] = new Play(makeToInt(splitLog[0]),makeToInt(splitLog[1]));
        }
        Arrays.sort(plays, new Comparator<Play>() {
            @Override
            public int compare(Play o1, Play o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
        for (int i = 0; i < plays.length; i++) {
            System.out.println(plays[i].start + " " + plays[i].end);
        }
        return answer;
    }

    private static int makeToInt(String time) {
        String[] timeInfo = time.split(":");
        int hh = Integer.parseInt(timeInfo[0]) * 60 * 60;
        int mm = Integer.parseInt(timeInfo[1]) * 60;
        int ss = Integer.parseInt(timeInfo[2]);
        return hh + mm + ss;
    }
}

class Play {
    int start;
    int end;

    public Play(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
