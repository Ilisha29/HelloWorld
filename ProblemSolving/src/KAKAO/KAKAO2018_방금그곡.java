package KAKAO;

import java.util.ArrayList;

public class KAKAO2018_방금그곡 {
    //ABCDEFG	[12:00,12:14,HELLO,CDEFGAB, 13:00,13:05,WORLD,ABCDEF]	HELLO
    //CC#BCC#BCC#BCC#B	[03:00,03:30,FOO,CC#B, 04:00,04:08,BAR,CC#BCC#BCC#B]	FOO
    //ABC	[12:00,12:14,HELLO,C#DEFGAB, 13:00,13:05,WORLD,ABCDEF]	WORLD

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String m2 = "CC#BCC#BCC#BCC#B";
        String m3 = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}; //HELLO
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}; //FOO
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}; //WORLD
        System.out.println(solution(m2, musicinfos2));
    }

    public static String solution(String m, String[] musicinfos) {
        String[] strings = m.split("");
        String newM = "";
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("#")) {
                String next = "";
                if (i + 1 < strings.length) {
                    next += strings[i + 1];
                }
                if (next.equals("#")) {
                    newM += strings[i] + "# ";
                } else {
                    newM += strings[i] + " ";
                }
            }
        }

        ArrayList<Answer> answerStringArray = new ArrayList<>();
        int musics = musicinfos.length;
        for (int i = 0; i < musics; i++) {
            String[] strings1 = musicinfos[i].split(",");
            String[] startTime = strings1[0].split(":");
            String[] endTime = strings1[1].split(":");
            String title = strings1[2];
            String originlylic = strings1[3];
            String[] lylic = originlylic.split("");
            int lylicLength = 0;
            for (int j = 0; j < lylic.length; j++) {
                if (!lylic[j].equals("#")) {
                    lylicLength++;
                }
            }
            String[] newLyrics = new String[lylicLength];
            int index = 0;
            for (int j = 0; j < lylic.length; j++) {
                if (lylic[j].equals("#")) {
                    newLyrics[index - 1] += "#";
                } else {
                    newLyrics[index++] = lylic[j];
                }
            }
            int repeatTimeMunites = 60 * (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) + Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
            int repeatNum = repeatTimeMunites / lylicLength;
            int leftLength = repeatTimeMunites % lylicLength;
            String answerLyric = "";
            for (int j = 0; j < repeatNum; j++) {
                for (int k = 0; k < newLyrics.length; k++) {
                    answerLyric += newLyrics[k] + " ";
                }
            }
            for (int j = 0; j < leftLength; j++) {
                answerLyric += newLyrics[j] + " ";
            }
            answerStringArray.add(new Answer(title, answerLyric, repeatTimeMunites));
        }
        Answer realAnswer = null;
        for (int i = 0; i < answerStringArray.size(); i++) {
            Answer answer1 = answerStringArray.get(i);
            if (answer1.lyrics.contains(newM)) {
                if (realAnswer == null) {
                    realAnswer = answer1;
                } else {
                    if (realAnswer.playLength < answer1.playLength) {
                        realAnswer = answer1;
                    } else {
                        continue;
                    }
                }
            }
        }
        String answer = "";
        if (realAnswer == null) {
            answer = "(None)";
        } else {
            answer = realAnswer.title;
        }
        return answer;
    }
}

class Answer {
    public String title;
    public String lyrics;
    public int playLength;

    public Answer(String title, String lyrics, int playLength) {
        this.title = title;
        this.lyrics = lyrics;
        this.playLength = playLength;
    }
}

