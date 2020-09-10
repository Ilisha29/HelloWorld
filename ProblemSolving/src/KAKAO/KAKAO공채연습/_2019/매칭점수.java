package KAKAO.KAKAO공채연습._2019;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 매칭점수 {
    public static void main(String[] args) {
        String[] pages = {
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        };
        String[] pages2 = {
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        };
        String word = "blind";
        solution(word, pages2);
    }

    public static int solution(String word, String[] pages) {
        int answer = 0;
        for (int i = 0; i < pages.length; i++) {
            String[] splitPages = pages[i].split("\n");
            String url = "";
            for (int j = 0; j < splitPages.length; j++) {
                if (splitPages[j].contains("og:url")) {
                    String[] strings = splitPages[j].split("\"");
                    url = strings[3];
                    break;
                }
            }
            int bodyStart = 0;
            int bodyEnd = 0;
            for (int j = 0; j < splitPages.length; j++) {
                if (splitPages[j].equals("<body>")) {
                    bodyStart = j;
                } else if (splitPages[j].equals("</body>")) {
                    bodyEnd = j;
                }
            }
            ArrayList<String> bodyStrings = new ArrayList<>();
            for (int j = bodyStart + 1; j < bodyEnd; j++) {
                bodyStrings.add(splitPages[j]);
            }
            ArrayList<String> links = new ArrayList<>();
            int basicScore = 0;
            int outLinkNum = 0;
            for (int j = 0; j < bodyStrings.size(); j++) {
                Pattern pattern = Pattern.compile("<a href=\"(.*)[\">]");
                Matcher matcher = pattern.matcher(bodyStrings.get(j));
                while (matcher.find()) {
                    System.out.println(matcher.group(2));
                }
            }
        }
        return answer;
    }
}