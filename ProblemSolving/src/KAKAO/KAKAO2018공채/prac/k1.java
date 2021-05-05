package KAKAO.KAKAO2018공채.prac;

import java.util.ArrayList;
import java.util.List;

public class k1 {
    public static void main(String[] args) {
        String[] ms = {"ABCDEFG", "CC#BCC#BCC#BCC#B", "ABC"};
        String[][] musicinfos = {
                {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"},
                {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"},
                {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}
        };
        for (int i = 0; i < musicinfos.length; i++) {
            System.out.println(solution(ms[i], musicinfos[i]));
        }
    }


    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = makeChangeM(m);
        int answerPlayTime = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] eachMusic = musicinfos[i].split(",");
            int startTIme = makeStringTimeToIntTIme(eachMusic[0]);
            int endTime = makeStringTimeToIntTIme(eachMusic[1]);
            String title = eachMusic[2];
            String totalLyric = makeTotalLyric(eachMusic[3], endTime - startTIme);
            if (totalLyric.contains(m)) {
                if (answer.equals("(None)")) {
                    answer = title;
                    answerPlayTime = endTime - startTIme;
                } else {
                    if (answerPlayTime < endTime - startTIme) {
                        answerPlayTime = endTime - startTIme;
                        answer = title;
                    }
                }
            }
        }
        return answer;
    }

    private static String makeChangeM(String m) {
        m = m.replaceAll("C#", "H");
        m = m.replaceAll("D#", "I");
        m = m.replaceAll("F#", "J");
        m = m.replaceAll("G#", "K");
        m = m.replaceAll("A#", "L");
        return m;
    }

    private static String makeTotalLyric(String s, int i) {
        List<String> um = new ArrayList<>();
        String[] ums = s.split("");
        for (int j = 0; j < ums.length; j++) {
            String tmpUm = ums[j];
            if (j != ums.length - 1 && !ums[j].equals("#")) {
                if (ums[j + 1].equals("#")) {
                    tmpUm += ums[j + 1];
                    j++;
                }
            }
            tmpUm = sharpToOther(tmpUm);
            um.add(tmpUm);
        }
        StringBuilder totalLyric = new StringBuilder("");
        int index = 0;
        for (int j = 0; j < i; j++) {
            totalLyric.append(um.get(index++));
            if (index == um.size()) {
                index = 0;
            }
        }
        return totalLyric.toString();
    }

    private static String sharpToOther(String tmpUm) {
        if (tmpUm.equals("C#")) {
            return "H";
        } else if (tmpUm.equals("D#")) {
            return "I";
        } else if (tmpUm.equals("F#")) {
            return "J";
        } else if (tmpUm.equals("G#")) {
            return "K";
        } else if (tmpUm.equals("A#")) {
            return "L";
        }
        return tmpUm;
    }


    private static int makeStringTimeToIntTIme(String s) {
        String[] time = s.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
