package KAKAO.KAKAO2018공채;

import java.util.ArrayList;
import java.util.Collections;

// 10 : 30
public class KAKAO2018공채_추석_트래픽 {
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] lines1 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        String[] lines2 = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println(solution(lines));
        System.out.println(solution(lines1));
        System.out.println(solution(lines2));

    }
    //예를 들어, 로그 문자열 2016-09-15 03:10:33.020 0.011s은
    // 2016년 9월 15일 오전 3시 10분 **33.010초**부터
    // 2016년 9월 15일 오전 3시 10분 **33.020초**까지
    // **0.011초** 동안 처리된 요청을 의미한다. (처리시간은 시작시간과 끝시간을 포함)

    //서버에는 타임아웃이 3초로 적용되어 있기 때문에 처리시간은 0.001 ≦ T ≦ 3.000이다.
    public static int solution(String[] lines) {

        ArrayList<Time> timeArrayListStartTime = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String[] strings = lines[i].split(" ");
            String[] endMinutes = strings[1].split(":");
            int miliseconds = Integer.parseInt(endMinutes[0]) * 3600000 + Integer.parseInt(endMinutes[1]) * 60000 + (int) (Double.parseDouble(endMinutes[2]) * 1000);
            int spendTime = (int) (Double.parseDouble(strings[2].substring(0, strings[2].length() - 1)) * 1000);
            timeArrayListStartTime.add(new Time(miliseconds - spendTime + 1, miliseconds));
        }
        Collections.sort(timeArrayListStartTime);
        int answer = 0;

        for (int i = 0; i < timeArrayListStartTime.size(); i++) {
            int tmpAnswer = 0;
            Time time = timeArrayListStartTime.get(i);
            //Start값에서 좌로 1초
            int oneSecondsStart = time.start - 999;
            int oneSecondsEnd = time.start;
            int possibleLogLimit = time.start - 3999;
            int answer1 = 1;
            int index1 = i - 1;
            while (index1 >= 0 && timeArrayListStartTime.get(index1).start >= possibleLogLimit) {
                if (timeArrayListStartTime.get(index1--).end >= oneSecondsStart) {
                    answer1++;
                }
                index1--;
            }
            answer = answer1 > answer ? answer1 : answer;

            //Start값에서 우로 1초
            answer1 = 1;
            index1 = i - 1;
            while (index1 >= 0 && timeArrayListStartTime.get(index1).start >= time.start - 2999) {
                if (timeArrayListStartTime.get(index1).end >= time.start) {
                    answer1++;
                }
                index1--;
            }
            index1 = i + 1;
            while (index1 < timeArrayListStartTime.size() && timeArrayListStartTime.get(index1).start <= time.start + 999) {
                answer1++;
                index1++;
            }
            answer = answer1 > answer ? answer1 : answer;

            //end값 좌로 1초
            index1 = i - 1;
            answer1 = 1;
            while (index1 >= 0 && timeArrayListStartTime.get(index1).start >= time.end - 3999) {
                if (timeArrayListStartTime.get(index1).end >= time.end - 999) {
                    answer1++;
                }
                index1--;
            }
            index1 = i + 1;
            while (index1 < timeArrayListStartTime.size() && timeArrayListStartTime.get(index1).start <= time.end) {
                if ((timeArrayListStartTime.get(index1).start >= time.end - 999 && timeArrayListStartTime.get(index1).start <= time.end) || (timeArrayListStartTime.get(index1).end >= time.end - 999 && timeArrayListStartTime.get(index1).end < time.end)) {
                    answer1++;
                }
                index1++;
            }
            answer = answer1 > answer ? answer1 : answer;

            //end값 우로 1초
            index1 = i + 1;
            answer1 = 1;
            while (index1 < timeArrayListStartTime.size() && timeArrayListStartTime.get(index1).start <= (time.end + 999)) {
                if ((timeArrayListStartTime.get(index1).start >= time.end && timeArrayListStartTime.get(index1).start <= time.end + 999) || (timeArrayListStartTime.get(index1).end >= time.end && timeArrayListStartTime.get(index1).end <= time.end + 999)) {
                    answer1++;
                }
                index1++;
            }
            answer = answer1 > answer ? answer1 : answer;
        }
        return answer;
    }
}

class Time implements Comparable<Time> {
    public int start;
    public int end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.start > o.start) {
            return 1;
        } else if (this.start < o.start) {
            return -1;
        } else {
            return 0;
        }
    }
}