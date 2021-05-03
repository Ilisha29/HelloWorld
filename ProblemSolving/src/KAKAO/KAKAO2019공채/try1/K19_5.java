package KAKAO.KAKAO2019공채.try1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class K19_5 {
    public static void main(String[] args) {

        String[] pages = {
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        };
        String[] page2 = {
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        };
        String[] page3 = {
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
        };
        //System.out.println(solution("blind", pages));
        System.out.println(solution("Muzi", page3));
    }

    /*
    기본점수 :해당 웹페이지의 텍스트 중, 검색어가 등장하는 횟수이다.
    외부 링크수
    링크점수
    매칭점수
     */
    public static int solution(String word, String[] pages) {
        Map<String, List<String>> map = new HashMap<>();
        word = word.toLowerCase();
        List<Page> pageList = new ArrayList<>();
        for (int i = 0; i < pages.length; i++) {
            List<String> outLinks = new ArrayList<>();
            String body = "";
            String url = "";
            String input = pages[i];

            Pattern pattern = Pattern.compile("<a href=\"([^\"]+)\"[\\s\\S]*?>*</a>");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {  // 일치하는 게 있다면
                outLinks.add(matcher.group(1));
                if (matcher.group(0) == null)
                    break;
            }
            input = input.replaceAll("<a href=\"([^\"]+)\"[\\s\\S]*?>*</a>", "");

            pattern = Pattern.compile("<body>([^\"]+)</body>");
            matcher = pattern.matcher(input);
            while (matcher.find()) {  // 일치하는 게 있다면
                body = matcher.group(1);
                if (matcher.group(0) == null)
                    break;
            }

            pattern = Pattern.compile("<meta property=\"og:url\" content=\"([^\"]+)\"/>");
            matcher = pattern.matcher(input);
            while (matcher.find()) {  // 일치하는 게 있다면
                url = matcher.group(1);
                if (matcher.group(0) == null)
                    break;
            }
            for (int j = 0; j < outLinks.size(); j++) {
                if (!map.containsKey(outLinks.get(j))) {
                    map.put(outLinks.get(j), new ArrayList<>());
                }
                map.get(outLinks.get(j)).add(url);
            }
            if (body != null) {
                body = body.toLowerCase();
            }
            String[] splitBody = body.split("");
            for (int j = 0; j < splitBody.length; j++) {
                char c = splitBody[j].charAt(0);
                if (!(c >= 'a' && c <= 'z')) {
                    splitBody[j] = " ";
                }
            }
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = 0; j < splitBody.length; j++) {
                stringBuilder.append(splitBody[j]);
            }

            body = stringBuilder.toString();
            pageList.add(new Page(i, url, body, outLinks));
        }
        calculateScore(pageList, map, word.toLowerCase());
        Collections.sort(pageList, new Comparator<Page>() {
            @Override
            public int compare(Page o1, Page o2) {
                if (o1.matchingScore == o2.matchingScore) {
                    return o1.index - o2.index;
                }
                if (o2.matchingScore > o1.matchingScore) {
                    return 1;
                }
                return -1;
            }
        });
        System.out.println(pageList.get(0).toString());
        return pageList.get(0).index;
    }

    private static void calculateScore(List<Page> pageList, Map<String, List<String>> map, String word) {
        for (int i = 0; i < pageList.size(); i++) {
            Page page = pageList.get(i);
            if (page.body.length() == 0) {
                continue;
            }
            String[] bodySplit = page.body.split(" ");
            for (int j = 0; j < bodySplit.length; j++) {
                if (bodySplit[j].equals(word)) {
                    page.basicScore++;
                }
            }
        }
        for (int i = 0; i < pageList.size(); i++) {
            Page page = pageList.get(i);
            List<Page> forLinkScore = new ArrayList<>();
            List<String> flags;
            if (map.get(page.pageURL) == null) {
                flags = new ArrayList<>();
            } else {
                flags = map.get(page.pageURL);
            }
            if (flags != null) {
                for (int j = 0; j < flags.size(); j++) {
                    String flag = flags.get(j);
                    for (int k = 0; k < pageList.size(); k++) {
                        if (pageList.get(k).pageURL.equals(flag)) {
                            forLinkScore.add(pageList.get(k));
                        }
                    }
                }
                for (int j = 0; j < forLinkScore.size(); j++) {
                    Page tmpPage = forLinkScore.get(j);
                    if (tmpPage.outLinkNum != 0)
                        page.linkScore += tmpPage.basicScore / (double) tmpPage.outLinkNum;
                }
            }
            page.matchingScore = page.linkScore + page.basicScore;
        }
    }
}

class Page {
    int index;
    int basicScore;
    int outLinkNum;
    double linkScore;
    double matchingScore;
    String pageURL;
    String body;

    public Page(int index, String pageURL, String body, List<String> outLinks) {
        this.index = index;
        this.pageURL = pageURL;
        this.body = body;
        this.basicScore = 0;
        this.outLinkNum = outLinks.size();
        this.linkScore = 0;
        this.matchingScore = 0;
    }

    @Override
    public String toString() {
        return "Page{" +
                "index=" + index +
                ", basicScore=" + basicScore +
                ", outLinkNum=" + outLinkNum +
                ", linkScore=" + linkScore +
                ", matchingScore=" + matchingScore +
                ", pageURL='" + pageURL + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}